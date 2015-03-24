import QL.AST.Expressions.Primitives.primitive as e
import QL.Grammar.constants as constants


class Number(e.Primitive):
    def __init__(self, number):
        self.__number = number

    def string_presentation(self):
        return str(self.__number)  # since it is a real integer

    def return_type_string(self, type_dict):
        return constants.NUMBER

    # just the int value
    def eval_expression(self, type_map):
        return self.__number