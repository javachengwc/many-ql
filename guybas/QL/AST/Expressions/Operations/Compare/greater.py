import QL.AST.Expressions.Operations.Compare.equal as e


class Greater(e.Equal):

    def set_string_operator(self):
        return ">"

    def concrete_eval(self, x, y):
        return x > y