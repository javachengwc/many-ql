package qls.gui.widgets

import ql.ast.{BooleanValue, Expression, Question, Value}
import qls.ast.Style
import types.{EvalEnvironment, VariableName}

import scalafx.scene.control.RadioButton

class RadioQuestionWidget(q: Question, visibilityExpressions: List[Expression], env: EvalEnvironment, styles: List[Style])
  extends QuestionWidget(q: Question, visibilityExpressions: List[Expression], env: EvalEnvironment, styles: List[Style]) {

  val value = eval()
  val radioButtonYes = new RadioButton() {
    text = "True"
    selected = value
    selected.onChange((_, _, newValue) => updateEnvironment(BooleanValue(newValue)))
  }
  val radioButtonNo = new RadioButton() {
    text = "False"
    selected = !value
    selected.onChange((_, _, newValue) => updateEnvironment(BooleanValue(!newValue)))
  }
  updateEnvironment(BooleanValue(value))
  children.add(radioButtonYes)
  children.add(radioButtonNo)

  // Methods
  override def updateValue(updatedVariable: VariableName, becameVisible: Boolean): Unit = {
    if (valueDependencies contains updatedVariable) {
      radioButtonYes.selected = eval()
      radioButtonNo.selected = !eval()
    }

    // Needed in order to keep multiple questions with the same key in sync
    if (isQuestionWithSameKey(updatedVariable) || becameVisible) {
      val value = env.getOrElse(q.variable.name, BooleanValue())
      radioButtonYes.selected = extract(value)
      radioButtonNo.selected = !extract(value)
    }
  }

  def eval(): Boolean = {
    val value = q.expression match {
      case Some(e) => evaluator.eval(e, env)
      case None => BooleanValue()
    }
    extract(value)
  }

  def extract(value: Value): Boolean = {
    value match {
      case BooleanValue(v) => v
      case _ => throw new AssertionError(s"Error in type checker. Variable ${q.variable.name} not of type Boolean.")
    }
  }
}
