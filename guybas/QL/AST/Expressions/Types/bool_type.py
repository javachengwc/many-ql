import QL.AST.Expressions.Types.type_interface as type_interface


class Bool(type_interface.Type):
    def __init__(self):
        self._name = "bool"