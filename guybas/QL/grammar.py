# Grammar

from pyparsing import *
from exceptions import *
from factory import *
from gui import *


class BasicTypes:
    # endSign = . | ? | !
    endSign         = oneOf(". ? !")
    endSignEsc      = Suppress("\\") + endSign
    
    # words = [0-9a-zA-Z()[]{},@#$%^&*-+=/\'\"`~_] | endSign
    characters      = Word("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890()[]{},@#$%^&*-+=/\'\"`~_")
    word            = endSignEsc | characters  
    
    # sentence = word+ endSign
    sentence        = (OneOrMore(word) + endSign).setParseAction(make_sentence)
    
    # sentences = sentence+
    sentences       = OneOrMore(sentence)
    comment         = Literal("//") + restOfLine | cStyleComment


class Expressions: 
    # Possible answers values
    bool            = Literal("True") | Literal("False")
    integer         = Word(nums)
    text            = BasicTypes.sentences
    
    # Expressions
    value           = bool | integer | text
    compare         = oneOf("> >= < <= ==")
    operators       = oneOf('+ - / *')
    
    # atom = value | (expr)
    # expr = atom (operator expr)*
    expr            = Forward()
    atom            = value | Group(Suppress("(") + expr + Suppress(")"))
    expr            << atom + ZeroOrMore(operators + expr)
    
    # condition = expr compare value
    condition       = Group(expr + compare + value) 


class FormFormat:
    id              = BasicTypes.characters
    label           = BasicTypes.sentence
    
    # possible answer types
    answerR         = Literal("bool") | Literal("integer") | Literal("text")
    
    # question = Question id (answerR) : label 
    question        = (Suppress("Question") + id + Suppress("(") + answerR + Suppress(")") + Suppress(":") + label
                       ).setParseAction(ASTReady.make_question)
    questions       = OneOrMore(question)
    
    # pIf       = if (condition) { questions }
    aQuestions      = Forward()
    condition       = Expressions.condition.setParseAction(ASTReady.make_expression)
    pIf             = (Suppress("if" + Literal("(")) + condition + Suppress(")") + Suppress("{") +
                       OneOrMore(aQuestions) + Suppress("}"))
                       
    # pIfElse   = if (condition) { questions } else { questions }
    pIfElse         = (Suppress("if" + Literal("(")) + condition + Suppress(")") + Suppress("{") +
                       OneOrMore(aQuestions) + Suppress("}")) + Literal("else") + Suppress("{") + aQuestions + Suppress("}")
    
    # aQuestions    = pIf | pIfElse | questions
    aQuestions      <<= OneOrMore(
                          (pIfElse.setParseAction(ASTReady.make_else))
                        | (pIf).setParseAction(ASTReady.make_if)
                        | questions)
                      
    # form = id introduction? aQuestions+
    introduction    = Group(Suppress("Introduction" + Literal(":") + BasicTypes.sentences))
    form            = id + Optional(introduction) + aQuestions