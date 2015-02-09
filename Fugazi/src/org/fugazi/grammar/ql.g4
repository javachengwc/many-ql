grammar ql;

/*
Form keyword
form name
form opening / closing
new variable, variable type / name / display question / derived value
*/

// complete form - topmost node
form:   stat+ ;

// statement
stat:   expr NEWLINE+                // printExpr
    |   NEWLINE                     // blank
    ;

// single expression form
bool x("dsdasdas") 5;
expr: type varName display ';'
    | type varName display ASSIGN newValue ';';

type: 'bool'
    | INT;
varName: ID;

// finishes with questoin mark or
display: OPEN WORD CLOSE;

MUL :   '*' ;
DIV :   '/' ;
ADD :   '+' ;
SUB :   '-' ;
ASSIGN: '=' ;
OPEN: '(';
CLOSE: ')';
QUOTE: '"';
ID  :   [a-zA-Z]+;      // match identifiers

WORD :  '"' (ESC | ~["\\])* '"' ;

fragment ESC :   '\\' (["\\/bfnrt] | UNICODE) ;
fragment UNICODE : 'u' HEX HEX HEX HEX ;
fragment HEX : [0-9a-fA-F] ;

INT :   [0-9]+ ;         // match integers
NEWLINE :'\r'? '\n' ;     // return newlines to parser (is end-statement signal)
CLEAR : 'clear';

COMMENT
    :   '/*' .*? '*/'    -> channel(HIDDEN) // match anything between /* and */
    ;

WS  :   [ \r\t\u000C\n]+ -> channel(HIDDEN)
    ;

LINE_COMMENT
    : '//' ~[\r\n]* '\r'? '\n' -> channel(HIDDEN)
    ;