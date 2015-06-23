import unittest

# import folders
from QL.AST.Expressions.Operations.Compare import *
from QL.AST.Expressions.Primitives import *
from QL.AST.Expressions.Types import *

# import files
import QL.Grammar.grammar as grammar
import QL.Runtime.answers_map as mapper
import QL.Runtime.question as question
import QL.AST.Statements.question as question2


class Tests(unittest.TestCase):

    def test_expression_bool(self):
        result = grammar.expr.parseString(" statement_id == True")
        self.assertIsInstance(result[0], equal.Equal)

    def test_calc_expression(self):
        result = grammar.expr.parseString("4 / 2 + (3 - 1) * 4")
        self.assertEquals(result[0].__str__(), "((4 / 2) + ((3 - 1) * 4))")

    @unittest.expectedFailure
    def test_expression_fail(self):
        result = grammar.expr.parseString("4 * - 1")
        self.assertEquals(result[0].__str__(), "4 * - 1")

    def test_expression_malformed(self):
        result = grammar.expr.parseString("4 / 2 == True")
        self.assertEquals(result[0].__str__(), "((4 / 2) == True)")

    def test_expression_primitive(self):
        result = grammar.expr.parseString("1")
        self.assertIsInstance(result[0], number.Number)

    def test_expression_calc_eval(self):
        result = grammar.expr.parseString("5 * 3 - 2 * (1 + 1)")
        self.assertEquals(result[0].eval_expression({}), 11)

    def test_expression_bool_eval(self):
        result = grammar.expr.parseString("6 * 3 - (1 + 2) == 15")
        self.assertEquals(result[0].eval_expression({}), True)

    def test_expression_variable_eval(self):
        m = mapper.AnswersMap()
        result = grammar.expr.parseString("1 + grade == 9")
        self.assertEquals(result[0].eval_expression(m), None)

    def test_expression_known_variable_eval(self):
        m = mapper.AnswersMap()
        q = question.Question(question2.Question("grade", number_type.Number(), "something!"), 0, None)
        q2 = question.Question(question2.Question("hummus",bool_type.Bool(), "another?"), 0, None)
        m.update(q.get_id(), 8)
        m.update(q2.get_id(), True)
        result = grammar.expr.parseString("1 + grade == 9 and hummus == True")
        self.assertEquals(result[0].eval_expression(m), True)

    def test_expression_dependencies(self):
        result = grammar.expr.parseString("cool + awesome && 1 == True")
        self.assertEqual(result[0].get_variables(), ["cool", "awesome"])