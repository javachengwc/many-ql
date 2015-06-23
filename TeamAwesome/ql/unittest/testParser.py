import sys
sys.path.append('..')

import unittest

from ql.core.QLTypes import *
from ql.core.QLOperators import QLEquals, QLUnaryMinus

from ql.ast.Nodes import *
from ql.parser.ANTLR import Parser



class BadSyntax(unittest.TestCase):
    def test(self):
        parseResult = Parser("parserTestFiles/badSyntax.ql")
        self.assertEqual(1, len(parseResult.errors))



class NoQuestions(unittest.TestCase):
    def test(self):
        parseResult = Parser("parserTestFiles/noQuestions.ql")
        self.assertEqual(0, len(parseResult.errors))

        form = parseResult.questionnaire.statements[0]
        self.assertEqual(0, len(form.statements))



class OneQuestion(unittest.TestCase):
    def test(self):
        parseResult = Parser("parserTestFiles/oneQuestion.ql")
        self.assertEqual(0, len(parseResult.errors))
        
        form = parseResult.questionnaire.statements[0]
        self.assertEqual(1, len(form.statements))

        question = form.statements[0]
        self.assertEqual(type(question), QuestionStatement)

        self.assertEqual("question1_text", question.text)

        self.assertEqual(QLBoolean, question.type)

        self.assertEqual(QLIdentifier("question1"), question.identifier.value)



class OneValueQuestion(unittest.TestCase):
    def test(self):
        parseResult = Parser("parserTestFiles/oneValueQuestion.ql")
        self.assertEqual(0, len(parseResult.errors))

        form = parseResult.questionnaire.statements[0]
        self.assertEqual(1, len(form.statements))

        question = form.statements[0]
        self.assertEqual(type(question), QuestionStatement)

        valueExpression = question.expression
        self.assertEqual(type(valueExpression), UnaryExpression)
        self.assertEqual(valueExpression.operator, QLUnaryMinus)
        self.assertEqual(QLInteger(3), valueExpression.expression.value)



class OneConditionalQuestion(unittest.TestCase):
    def test(self):
        parseResult = Parser("parserTestFiles/oneConditionalQuestion.ql")
        self.assertEqual(0, len(parseResult.errors))

        form = parseResult.questionnaire.statements[0]
        self.assertEqual(1, len(form.statements))

        ifStatement = form.statements[0]
        self.assertEqual(type(ifStatement), IfStatement)
        self.assertEqual(1, len(ifStatement.statements))

        expression = ifStatement.expression
        self.assertEqual(type(expression), BinaryExpression)
        self.assertEqual(QLBoolean(True), expression.left.value)
        self.assertEqual(expression.operator, QLEquals)
        self.assertEqual(QLBoolean(False), expression.right.value)

        question = ifStatement.statements[0]
        self.assertEqual(type(question), QuestionStatement)