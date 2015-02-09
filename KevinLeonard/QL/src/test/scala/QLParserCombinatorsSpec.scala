package test.scala

import main.scala.QLParserCombinators
import org.specs2.matcher.ParserMatchers
import org.specs2.mutable.Specification

class QLParserCombinatorsSpec extends Specification with ParserMatchers {
  val parsers = new QLParserCombinators
  import parsers._

  "form" should {
    "succeed to recognize forms with a question" in {
      form must succeedOn("form TaxForm {\n\n    question hasSoldHouse2 \"How many houses did you sell in 2014?\"\n    answer integer\n}")
        .withResult(equalTo("(TaxForm~List(((hasSoldHouse2~\"How many houses did you sell in 2014?\")~integer)))"))
    }
  }

}
