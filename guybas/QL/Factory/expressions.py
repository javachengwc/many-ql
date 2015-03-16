# Factory for creating Expression elements out of parsed tokens

import QL.AST.Expressions.Elements.variable as variable
import QL.AST.Expressions.Elements.bool as boolean
import QL.AST.Expressions.Elements.number as number
import QL.AST.Expressions.Elements.text as text
import QL.Factory.forms as form
import QL.AST.Expressions.expression as expression
import QL.AST.Expressions.sub_expression as ce
import QL.AST.Expressions.Elements.element as el
import pyparsing as pp
from QL.AST.Expressions.Operations import *


#
# Types
#

def make_variable(tokens):
    v = tokens[0]
    return variable.Variable(v)


def make_number(tokens):
    n = int(tokens[0])
    return number.Number(n)


def make_bool(tokens):
    value = tokens[0]
    if value == "True":
        return boolean.Bool(True)
    else:
        return boolean.Bool(False)


def make_text(tokens):
    t = form.make_sentence(tokens)
    return text.Text(t)


#
# Operations
#

def make_add_min_expression(tokens):
    tokens = tokens[0]
    x = tokens[0]
    for i in range(1, len(tokens)-1, 2):
        if tokens[i] == "+":
            x = add.Add(x, tokens[i + 1])
        else:
            x = minus.Minus(x, tokens[i + 1])
    return x


def make_mul_expression(tokens):
    tokens = tokens[0]
    x = tokens[0]
    for i in range(1, len(tokens)-1, 2):
        if tokens[i] == "*":
            x = multiplication.Multiplication(x, tokens[i + 1])
        else:
            x = division.Division(x, tokens[i + 1])
    return x


# unfortunately, as it is not possible to give the same precedence level in pyparsing
# it needs to be checked here manually
def make_compare(tokens):
    tokens = tokens[0]
    x = tokens[0]
    for i in range(1, len(tokens)-1, 2):
        if tokens[i] == ">":
            x = greater.Greater(x, tokens[i + 1])
        elif tokens[i] == "<":
            x = less.Less(x, tokens[i + 1])
        elif tokens[i] == ">=":
            x = greater_equal.GreaterEqual(x, tokens[i + 1])
        elif tokens[i] == "<=":
            return less_equal.LessEqual(x, tokens[i + 1])
        elif tokens[i] == "==":
            x = equal.Equal(x, tokens[i + 1])
        else:
            raise Exception("make_compare got wrong input")
    return x


def make_extra(tokens):
    tokens = tokens[0]
    if tokens[1] == "and":
        return and_op.And(tokens[0], tokens[2])
    else:
        return or_op.Or(tokens[0], tokens[2])


def make_not(tokens):
    tokens = tokens[0]
    return not_op.Not(tokens[1])


#
# Final expression
#


def make_expression(tokens):
    return make_expression_sub(tokens)


def make_expression_sub(tokens):
    l = []
    for x in tokens:
        if type(x) == pp.ParseResults:
            l.append(expression.Expression(make_expression_sub(x)))
        elif isinstance(x, el.Element):
            l.append(x)
        else:
            l.append(ce.SubExpression(x))
    return l


