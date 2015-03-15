import QL.AST.Expressions.Elements.element as e
import QL.Grammar.constants as constants


class Number(e.Element):
    def __init__(self, number):
        self.number = number

    def return_type_string(self, type_dict):
        return constants.GrammarConstants.NUMBER

    def pretty_print(self):
        return str(self.number)

    def get_dependencies(self):
        return []

    def as_list(self):
        return [self.number]