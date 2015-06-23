import QL.Tools.exceptions as exceptions


class TypeExceptionHandling:

    def __init__(self, errors, warnings):
        self.warnings = warnings
        self.errors = errors

    def execute(self):
        if self.errors:
            message = self.make_error_string()
            raise exceptions.TypeException(message)
        if self.warnings:
            print("warnings:")
            for w in self.warnings:
                print(w)

    def make_error_string(self):
        message = "\n"
        for e in self.errors:
            message += e + "\n"
        return message
