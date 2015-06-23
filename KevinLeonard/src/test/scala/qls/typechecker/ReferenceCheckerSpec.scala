package qls.typechecker

import org.specs2.mutable.Specification
import ql.ast.{BooleanType, Variable}
import ql.typechecker.Error
import qls.ast.{Question, Section, Text, Widget}
import types.TypeEnvironment

import scala.util.parsing.input.NoPosition

class ReferenceCheckerSpec extends Specification {
  val checker = new ReferenceChecker

  val AnySectionName = "section"
  val EmptyEnvironment: TypeEnvironment = Map()

  "reference checker for sections" should {
    "return empty list if a correct widget is used for a question" in {
      val question = Question(Variable("x"), Widget(Text(), List()))
      val environmentWithQuestion = Map("x" -> BooleanType())

      checker.check(question, environmentWithQuestion) must beEmpty
    }

    "return list with two errors if two questions with incorrect widget are used" in {
      val sectionWithMultipleQuestion = Section("section",
        List(Question(Variable("x"), Widget(Text(), List())), Question(Variable("x"), Widget(Text(), List()))))
      val errors = List(
        Error("Question x is not defined in your QL program", Some(NoPosition)),
        Error("Question x is not defined in your QL program", Some(NoPosition))
      )

      checker.check(sectionWithMultipleQuestion, EmptyEnvironment) must beEqualTo(errors)
    }
  }

  "reference checker for questions" should {
    "return no error, if question is defined in QL program" in {
      val question = Question(Variable("x"), Widget(Text(), List()))
      val environmentWithQuestion = Map("x" -> BooleanType())

      checker.check(question, environmentWithQuestion) must beNone
    }

    "return error, if question is not defined in QL program" in {
      val question = Question(Variable("x"), Widget(Text(), List()))
      val error = Error("Question x is not defined in your QL program", Some(NoPosition))

      checker.check(question, EmptyEnvironment) must beSome(error)
    }
  }
}
