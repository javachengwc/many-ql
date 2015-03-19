import QL.Grammar.constants as constants
import QL.AST.Expressions.Operations.binary_expression as b


class Add(b.BinaryExpression):

    def set_operator(self):
        return " + "

    # get the return _type of the _expression
    def return_type_string(self, type_map):
        return constants.NUMBER

    def eval(self, x, y):
        return x + y