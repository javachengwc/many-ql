package qls.parser

import ql.ast._
import ql.parser.{Parser => QLParser}
import qls.ast.{Question, _}

import scala.util.parsing.combinator.JavaTokenParsers

class Parser extends JavaTokenParsers {

  val qlParser = new QLParser

  // general parsers
  override val whiteSpace = qlParser.whiteSpace
  def variable: Parser[Variable] = ident ^^ Variable
  def hexadecimalColor: Parser[HexadecimalColor] = "#" ~> """([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})""".r ^^ {
    v => new HexadecimalColor(v)
  }

  // style sheet parsers
  def styleSheet: Parser[StyleSheet] = "style" ~> ident ~ stylesheetElements ^^ {
    case label ~ sss => StyleSheet(label, sss)
  }
  def stylesheetElements: Parser[List[StyleSheetElement]] = "{" ~> rep(page | defaultWidget) <~ "}"

  // page parsers
  def page: Parser[StyleSheetElement] = "page" ~> ident ~ pageElements ^^ {
    case v ~ ps => Page(v, ps)
  }
  def pageElements: Parser[List[Section]] = "{" ~> rep(section) <~ "}"

  // section parsers
  def section: Parser[Section] = "section" ~> stringLiteral ~ sectionElements ^^ {
    case t ~ ss => Section(t.substring(1, t.length - 1).replace("\\", ""), ss)
  }
  def sectionElements: Parser[List[SectionElement]] = "{" ~> rep(question | section) <~ "}"

  // question parsers
  def question: Parser[Question] = positioned(variable ~ widget ^^ {
    case v ~ w => Question(v, w)
  })
  def questionType: Parser[Type] = ("boolean" | "number" | "string") ^^ {
    case "boolean" => BooleanType()
    case "number" => NumberType()
    case "string" => StringType()
  }

  // widget parsers
  def defaultWidget: Parser[DefaultWidget] = positioned("default" ~> questionType ~ widget ^^ {
    case t ~ w => DefaultWidget(t, w)
  })
  def widget: Parser[Widget] = widgetType ~ styles ^^ {
    case widgetType ~ styles => Widget(widgetType, styles)
  }
  def widgetType: Parser[WidgetType] =
    ("spinbox" | "slider" | "textBlock" | "text" | "radio" | "checkbox" | "dropdown") ^^ {
      case "spinbox" => SpinBox()
      case "slider" => Slider()
      case "text" => Text()
      case "textBlock" => TextBlock()
      case "radio" => Radio()
      case "checkbox" => CheckBox()
      case "dropdown" => DropDown()
    }
  def styles: Parser[List[Style]] = opt("{" ~> rep(width | font | fontSize | fontColor) <~ "}") ^^ {
    case Some(styles) => styles
    case None => List()
  }

  // style parsers
  def width: Parser[Style] = "width:" ~> wholeNumber ^^ { v => Width(v.toInt) }
  def font: Parser[Style] = "font:" ~> stringLiteral ^^ {
    v => Font(v.substring(1, v.length - 1).replace("\\", ""))
  }
  def fontSize: Parser[Style] = "fontSize:" ~> wholeNumber ^^ { v => FontSize(v.toInt) }
  def fontColor: Parser[Style] = "color:" ~> hexadecimalColor ^^ { v => FontColor(v) }
}
