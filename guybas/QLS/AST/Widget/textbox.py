import QLS.AST.Widget.widget_interface as w
from QL.AST.Expressions.Types import *


class Textbox(w.IWidget):
    def __init__(self):
        self._properties = {self.widget_name(): "" }

    def string_presentation(self, level=0):
        return "    " * level + "Textbox \n"

    def get_compatible(self):
        return [text_type.Text()]

    def set_settings(self, dictionary):
        for x in dictionary:
            self._properties[x] = dictionary[x]

    def get_settings(self):
        return self._properties

    def widget_name(self):
        return "textbox"
