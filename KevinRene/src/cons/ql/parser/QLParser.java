// Output created by jacc on Mon Feb 09 22:03:18 CET 2015

package cons.ql.parser;

import cons.ql.ast.*;
import cons.ql.ast.expr.*;
import cons.ql.ast.expr.unary.*;
import cons.ql.ast.expr.binary.*;

class QLParser implements QLTokens {
    private int yyss = 100;
    private int yytok;
    private int yysp = 0;
    private int[] yyst;
    protected int yyerrno = (-1);
    private cons.ql.ast.ASTNode[] yysv;
    private cons.ql.ast.ASTNode yyrv;

    public boolean parse() {
        int yyn = 0;
        yysp = 0;
        yyst = new int[yyss];
        yysv = new cons.ql.ast.ASTNode[yyss];
        yytok = (lexer.getToken()
                 );
    loop:
        for (;;) {
            switch (yyn) {
                case 0:
                    yyst[yysp] = 0;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 81:
                    yyn = yys0();
                    continue;

                case 1:
                    yyst[yysp] = 1;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 82:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = 162;
                            continue;
                    }
                    yyn = 165;
                    continue;

                case 2:
                    yyst[yysp] = 2;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 83:
                    yyn = yys2();
                    continue;

                case 3:
                    yyst[yysp] = 3;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 84:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr2();
                            continue;
                    }
                    yyn = 165;
                    continue;

                case 4:
                    yyst[yysp] = 4;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 85:
                    yyn = yys4();
                    continue;

                case 5:
                    yyst[yysp] = 5;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 86:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr1();
                            continue;
                    }
                    yyn = 165;
                    continue;

                case 6:
                    yyst[yysp] = 6;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 87:
                    switch (yytok) {
                        case IF:
                        case ENDINPUT:
                        case '}':
                        case IDENT:
                            yyn = yyr8();
                            continue;
                    }
                    yyn = 165;
                    continue;

                case 7:
                    yyst[yysp] = 7;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 88:
                    yyn = yys7();
                    continue;

                case 8:
                    yyst[yysp] = 8;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 89:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr3();
                            continue;
                    }
                    yyn = 165;
                    continue;

                case 9:
                    yyst[yysp] = 9;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 90:
                    yyn = yys9();
                    continue;

                case 10:
                    yyst[yysp] = 10;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 91:
                    yyn = yys10();
                    continue;

                case 11:
                    yyst[yysp] = 11;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 92:
                    yyn = yys11();
                    continue;

                case 12:
                    yyst[yysp] = 12;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 93:
                    switch (yytok) {
                        case IDENT:
                            yyn = 33;
                            continue;
                    }
                    yyn = 165;
                    continue;

                case 13:
                    yyst[yysp] = 13;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 94:
                    switch (yytok) {
                        case ':':
                            yyn = 34;
                            continue;
                    }
                    yyn = 165;
                    continue;

                case 14:
                    yyst[yysp] = 14;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 95:
                    switch (yytok) {
                        case '(':
                            yyn = 35;
                            continue;
                    }
                    yyn = 165;
                    continue;

                case 15:
                    yyst[yysp] = 15;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 96:
                    yyn = yys15();
                    continue;

                case 16:
                    yyst[yysp] = 16;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 97:
                    yyn = yys16();
                    continue;

                case 17:
                    yyst[yysp] = 17;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 98:
                    yyn = yys17();
                    continue;

                case 18:
                    yyst[yysp] = 18;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 99:
                    yyn = yys18();
                    continue;

                case 19:
                    yyst[yysp] = 19;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 100:
                    yyn = yys19();
                    continue;

                case 20:
                    yyst[yysp] = 20;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 101:
                    yyn = yys20();
                    continue;

                case 21:
                    yyst[yysp] = 21;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 102:
                    yyn = yys21();
                    continue;

                case 22:
                    yyst[yysp] = 22;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 103:
                    yyn = yys22();
                    continue;

                case 23:
                    yyst[yysp] = 23;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 104:
                    yyn = yys23();
                    continue;

                case 24:
                    yyst[yysp] = 24;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 105:
                    yyn = yys24();
                    continue;

                case 25:
                    yyst[yysp] = 25;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 106:
                    yyn = yys25();
                    continue;

                case 26:
                    yyst[yysp] = 26;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 107:
                    yyn = yys26();
                    continue;

                case 27:
                    yyst[yysp] = 27;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 108:
                    yyn = yys27();
                    continue;

                case 28:
                    yyst[yysp] = 28;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 109:
                    yyn = yys28();
                    continue;

                case 29:
                    yyst[yysp] = 29;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 110:
                    yyn = yys29();
                    continue;

                case 30:
                    yyst[yysp] = 30;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 111:
                    yyn = yys30();
                    continue;

                case 31:
                    yyst[yysp] = 31;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 112:
                    yyn = yys31();
                    continue;

                case 32:
                    yyst[yysp] = 32;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 113:
                    yyn = yys32();
                    continue;

                case 33:
                    yyst[yysp] = 33;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 114:
                    switch (yytok) {
                        case '{':
                            yyn = 52;
                            continue;
                    }
                    yyn = 165;
                    continue;

                case 34:
                    yyst[yysp] = 34;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 115:
                    switch (yytok) {
                        case BOOLEAN:
                            yyn = 54;
                            continue;
                        case INT:
                            yyn = 55;
                            continue;
                        case MONEY:
                            yyn = 56;
                            continue;
                    }
                    yyn = 165;
                    continue;

                case 35:
                    yyst[yysp] = 35;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 116:
                    yyn = yys35();
                    continue;

                case 36:
                    yyst[yysp] = 36;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 117:
                    yyn = yys36();
                    continue;

                case 37:
                    yyst[yysp] = 37;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 118:
                    yyn = yys37();
                    continue;

                case 38:
                    yyst[yysp] = 38;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 119:
                    yyn = yys38();
                    continue;

                case 39:
                    yyst[yysp] = 39;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 120:
                    yyn = yys39();
                    continue;

                case 40:
                    yyst[yysp] = 40;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 121:
                    yyn = yys40();
                    continue;

                case 41:
                    yyst[yysp] = 41;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 122:
                    yyn = yys41();
                    continue;

                case 42:
                    yyst[yysp] = 42;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 123:
                    yyn = yys42();
                    continue;

                case 43:
                    yyst[yysp] = 43;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 124:
                    yyn = yys43();
                    continue;

                case 44:
                    yyst[yysp] = 44;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 125:
                    yyn = yys44();
                    continue;

                case 45:
                    yyst[yysp] = 45;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 126:
                    yyn = yys45();
                    continue;

                case 46:
                    yyst[yysp] = 46;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 127:
                    yyn = yys46();
                    continue;

                case 47:
                    yyst[yysp] = 47;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 128:
                    yyn = yys47();
                    continue;

                case 48:
                    yyst[yysp] = 48;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 129:
                    yyn = yys48();
                    continue;

                case 49:
                    yyst[yysp] = 49;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 130:
                    yyn = yys49();
                    continue;

                case 50:
                    yyst[yysp] = 50;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 131:
                    yyn = yys50();
                    continue;

                case 51:
                    yyst[yysp] = 51;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 132:
                    yyn = yys51();
                    continue;

                case 52:
                    yyst[yysp] = 52;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 133:
                    switch (yytok) {
                        case IDENT:
                            yyn = 13;
                            continue;
                        case IF:
                            yyn = 14;
                            continue;
                    }
                    yyn = 165;
                    continue;

                case 53:
                    yyst[yysp] = 53;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 134:
                    switch (yytok) {
                        case '{':
                            yyn = 62;
                            continue;
                    }
                    yyn = 165;
                    continue;

                case 54:
                    yyst[yysp] = 54;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 135:
                    switch (yytok) {
                        case '{':
                            yyn = yyr14();
                            continue;
                    }
                    yyn = 165;
                    continue;

                case 55:
                    yyst[yysp] = 55;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 136:
                    switch (yytok) {
                        case '{':
                            yyn = yyr16();
                            continue;
                    }
                    yyn = 165;
                    continue;

                case 56:
                    yyst[yysp] = 56;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 137:
                    switch (yytok) {
                        case '{':
                            yyn = yyr15();
                            continue;
                    }
                    yyn = 165;
                    continue;

                case 57:
                    yyst[yysp] = 57;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 138:
                    yyn = yys57();
                    continue;

                case 58:
                    yyst[yysp] = 58;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 139:
                    yyn = yys58();
                    continue;

                case 59:
                    yyst[yysp] = 59;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 140:
                    yyn = yys59();
                    continue;

                case 60:
                    yyst[yysp] = 60;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 141:
                    switch (yytok) {
                        case IDENT:
                            yyn = 13;
                            continue;
                        case IF:
                            yyn = 14;
                            continue;
                        case '}':
                            yyn = yyr7();
                            continue;
                    }
                    yyn = 165;
                    continue;

                case 61:
                    yyst[yysp] = 61;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 142:
                    switch (yytok) {
                        case '}':
                            yyn = 65;
                            continue;
                    }
                    yyn = 165;
                    continue;

                case 62:
                    yyst[yysp] = 62;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 143:
                    switch (yytok) {
                        case STRING:
                            yyn = 66;
                            continue;
                    }
                    yyn = 165;
                    continue;

                case 63:
                    yyst[yysp] = 63;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 144:
                    switch (yytok) {
                        case '{':
                            yyn = 67;
                            continue;
                    }
                    yyn = 165;
                    continue;

                case 64:
                    yyst[yysp] = 64;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 145:
                    switch (yytok) {
                        case '}':
                            yyn = yyr6();
                            continue;
                    }
                    yyn = 165;
                    continue;

                case 65:
                    yyst[yysp] = 65;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 146:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr5();
                            continue;
                    }
                    yyn = 165;
                    continue;

                case 66:
                    yyst[yysp] = 66;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 147:
                    switch (yytok) {
                        case '(':
                            yyn = 69;
                            continue;
                        case '}':
                            yyn = 70;
                            continue;
                    }
                    yyn = 165;
                    continue;

                case 67:
                    yyst[yysp] = 67;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 148:
                    switch (yytok) {
                        case IDENT:
                            yyn = 13;
                            continue;
                        case IF:
                            yyn = 14;
                            continue;
                    }
                    yyn = 165;
                    continue;

                case 68:
                    yyst[yysp] = 68;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 149:
                    switch (yytok) {
                        case '}':
                            yyn = 72;
                            continue;
                    }
                    yyn = 165;
                    continue;

                case 69:
                    yyst[yysp] = 69;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 150:
                    yyn = yys69();
                    continue;

                case 70:
                    yyst[yysp] = 70;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 151:
                    switch (yytok) {
                        case IF:
                        case ENDINPUT:
                        case '}':
                        case IDENT:
                            yyn = yyr12();
                            continue;
                    }
                    yyn = 165;
                    continue;

                case 71:
                    yyst[yysp] = 71;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 152:
                    switch (yytok) {
                        case '}':
                            yyn = 74;
                            continue;
                    }
                    yyn = 165;
                    continue;

                case 72:
                    yyst[yysp] = 72;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 153:
                    switch (yytok) {
                        case IF:
                        case ENDINPUT:
                        case '}':
                        case IDENT:
                            yyn = yyr13();
                            continue;
                    }
                    yyn = 165;
                    continue;

                case 73:
                    yyst[yysp] = 73;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 154:
                    yyn = yys73();
                    continue;

                case 74:
                    yyst[yysp] = 74;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 155:
                    switch (yytok) {
                        case ELSE:
                            yyn = 77;
                            continue;
                        case IF:
                        case ENDINPUT:
                        case '}':
                        case IDENT:
                            yyn = yyr11();
                            continue;
                    }
                    yyn = 165;
                    continue;

                case 75:
                    yyst[yysp] = 75;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 156:
                    switch (yytok) {
                        case '}':
                            yyn = yyr17();
                            continue;
                    }
                    yyn = 165;
                    continue;

                case 76:
                    yyst[yysp] = 76;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 157:
                    switch (yytok) {
                        case IF:
                        case ENDINPUT:
                        case '}':
                        case IDENT:
                            yyn = yyr9();
                            continue;
                    }
                    yyn = 165;
                    continue;

                case 77:
                    yyst[yysp] = 77;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 158:
                    switch (yytok) {
                        case '{':
                            yyn = 78;
                            continue;
                    }
                    yyn = 165;
                    continue;

                case 78:
                    yyst[yysp] = 78;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 159:
                    switch (yytok) {
                        case IDENT:
                            yyn = 13;
                            continue;
                        case IF:
                            yyn = 14;
                            continue;
                    }
                    yyn = 165;
                    continue;

                case 79:
                    yyst[yysp] = 79;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 160:
                    switch (yytok) {
                        case '}':
                            yyn = 80;
                            continue;
                    }
                    yyn = 165;
                    continue;

                case 80:
                    yyst[yysp] = 80;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 161:
                    switch (yytok) {
                        case IF:
                        case ENDINPUT:
                        case '}':
                        case IDENT:
                            yyn = yyr10();
                            continue;
                    }
                    yyn = 165;
                    continue;

                case 162:
                    return true;
                case 163:
                    yyerror("stack overflow");
                case 164:
                    return false;
                case 165:
                    yyerror("syntax error");
                    return false;
            }
        }
    }

    protected void yyexpand() {
        int[] newyyst = new int[2*yyst.length];
        cons.ql.ast.ASTNode[] newyysv = new cons.ql.ast.ASTNode[2*yyst.length];
        for (int i=0; i<yyst.length; i++) {
            newyyst[i] = yyst[i];
            newyysv[i] = yysv[i];
        }
        yyst = newyyst;
        yysv = newyysv;
    }

    private int yys0() {
        switch (yytok) {
            case BOOLEAN:
                return 10;
            case FLOAT:
                return 11;
            case FORM:
                return 12;
            case IDENT:
                return 13;
            case IF:
                return 14;
            case INT:
                return 15;
            case MONEY:
                return 16;
            case '!':
                return 17;
            case '(':
                return 18;
            case '+':
                return 19;
            case '-':
                return 20;
        }
        return 165;
    }

    private int yys2() {
        switch (yytok) {
            case AND:
                return 21;
            case EQ:
                return 22;
            case GEQ:
                return 23;
            case LEQ:
                return 24;
            case NEQ:
                return 25;
            case OR:
                return 26;
            case '*':
                return 27;
            case '+':
                return 28;
            case '-':
                return 29;
            case '/':
                return 30;
            case '<':
                return 31;
            case '>':
                return 32;
            case ENDINPUT:
                return yyr4();
        }
        return 165;
    }

    private int yys4() {
        switch (yytok) {
            case '>':
            case OR:
            case GEQ:
            case '-':
            case NEQ:
            case '+':
            case '/':
            case '*':
            case '<':
            case ')':
            case LEQ:
            case ENDINPUT:
            case EQ:
            case AND:
                return yyr20();
        }
        return 165;
    }

    private int yys7() {
        switch (yytok) {
            case '>':
            case OR:
            case GEQ:
            case '-':
            case NEQ:
            case '+':
            case '/':
            case '*':
            case '<':
            case ')':
            case LEQ:
            case ENDINPUT:
            case EQ:
            case AND:
                return yyr19();
        }
        return 165;
    }

    private int yys9() {
        switch (yytok) {
            case '>':
            case OR:
            case GEQ:
            case '-':
            case NEQ:
            case '+':
            case '/':
            case '*':
            case '<':
            case ')':
            case LEQ:
            case ENDINPUT:
            case EQ:
            case AND:
                return yyr18();
        }
        return 165;
    }

    private int yys10() {
        switch (yytok) {
            case '>':
            case OR:
            case GEQ:
            case '-':
            case NEQ:
            case '+':
            case '/':
            case '*':
            case '<':
            case ')':
            case LEQ:
            case ENDINPUT:
            case EQ:
            case AND:
                return yyr40();
        }
        return 165;
    }

    private int yys11() {
        switch (yytok) {
            case '>':
            case OR:
            case GEQ:
            case '-':
            case NEQ:
            case '+':
            case '/':
            case '*':
            case '<':
            case ')':
            case LEQ:
            case ENDINPUT:
            case EQ:
            case AND:
                return yyr39();
        }
        return 165;
    }

    private int yys15() {
        switch (yytok) {
            case '>':
            case OR:
            case GEQ:
            case '-':
            case NEQ:
            case '+':
            case '/':
            case '*':
            case '<':
            case ')':
            case LEQ:
            case ENDINPUT:
            case EQ:
            case AND:
                return yyr37();
        }
        return 165;
    }

    private int yys16() {
        switch (yytok) {
            case '>':
            case OR:
            case GEQ:
            case '-':
            case NEQ:
            case '+':
            case '/':
            case '*':
            case '<':
            case ')':
            case LEQ:
            case ENDINPUT:
            case EQ:
            case AND:
                return yyr38();
        }
        return 165;
    }

    private int yys17() {
        switch (yytok) {
            case BOOLEAN:
                return 10;
            case FLOAT:
                return 11;
            case INT:
                return 15;
            case MONEY:
                return 16;
            case '!':
                return 17;
            case '(':
                return 18;
            case '+':
                return 19;
            case '-':
                return 20;
        }
        return 165;
    }

    private int yys18() {
        switch (yytok) {
            case BOOLEAN:
                return 10;
            case FLOAT:
                return 11;
            case INT:
                return 15;
            case MONEY:
                return 16;
            case '!':
                return 17;
            case '(':
                return 18;
            case '+':
                return 19;
            case '-':
                return 20;
        }
        return 165;
    }

    private int yys19() {
        switch (yytok) {
            case BOOLEAN:
                return 10;
            case FLOAT:
                return 11;
            case INT:
                return 15;
            case MONEY:
                return 16;
            case '!':
                return 17;
            case '(':
                return 18;
            case '+':
                return 19;
            case '-':
                return 20;
        }
        return 165;
    }

    private int yys20() {
        switch (yytok) {
            case BOOLEAN:
                return 10;
            case FLOAT:
                return 11;
            case INT:
                return 15;
            case MONEY:
                return 16;
            case '!':
                return 17;
            case '(':
                return 18;
            case '+':
                return 19;
            case '-':
                return 20;
        }
        return 165;
    }

    private int yys21() {
        switch (yytok) {
            case BOOLEAN:
                return 10;
            case FLOAT:
                return 11;
            case INT:
                return 15;
            case MONEY:
                return 16;
            case '!':
                return 17;
            case '(':
                return 18;
            case '+':
                return 19;
            case '-':
                return 20;
        }
        return 165;
    }

    private int yys22() {
        switch (yytok) {
            case BOOLEAN:
                return 10;
            case FLOAT:
                return 11;
            case INT:
                return 15;
            case MONEY:
                return 16;
            case '!':
                return 17;
            case '(':
                return 18;
            case '+':
                return 19;
            case '-':
                return 20;
        }
        return 165;
    }

    private int yys23() {
        switch (yytok) {
            case BOOLEAN:
                return 10;
            case FLOAT:
                return 11;
            case INT:
                return 15;
            case MONEY:
                return 16;
            case '!':
                return 17;
            case '(':
                return 18;
            case '+':
                return 19;
            case '-':
                return 20;
        }
        return 165;
    }

    private int yys24() {
        switch (yytok) {
            case BOOLEAN:
                return 10;
            case FLOAT:
                return 11;
            case INT:
                return 15;
            case MONEY:
                return 16;
            case '!':
                return 17;
            case '(':
                return 18;
            case '+':
                return 19;
            case '-':
                return 20;
        }
        return 165;
    }

    private int yys25() {
        switch (yytok) {
            case BOOLEAN:
                return 10;
            case FLOAT:
                return 11;
            case INT:
                return 15;
            case MONEY:
                return 16;
            case '!':
                return 17;
            case '(':
                return 18;
            case '+':
                return 19;
            case '-':
                return 20;
        }
        return 165;
    }

    private int yys26() {
        switch (yytok) {
            case BOOLEAN:
                return 10;
            case FLOAT:
                return 11;
            case INT:
                return 15;
            case MONEY:
                return 16;
            case '!':
                return 17;
            case '(':
                return 18;
            case '+':
                return 19;
            case '-':
                return 20;
        }
        return 165;
    }

    private int yys27() {
        switch (yytok) {
            case BOOLEAN:
                return 10;
            case FLOAT:
                return 11;
            case INT:
                return 15;
            case MONEY:
                return 16;
            case '!':
                return 17;
            case '(':
                return 18;
            case '+':
                return 19;
            case '-':
                return 20;
        }
        return 165;
    }

    private int yys28() {
        switch (yytok) {
            case BOOLEAN:
                return 10;
            case FLOAT:
                return 11;
            case INT:
                return 15;
            case MONEY:
                return 16;
            case '!':
                return 17;
            case '(':
                return 18;
            case '+':
                return 19;
            case '-':
                return 20;
        }
        return 165;
    }

    private int yys29() {
        switch (yytok) {
            case BOOLEAN:
                return 10;
            case FLOAT:
                return 11;
            case INT:
                return 15;
            case MONEY:
                return 16;
            case '!':
                return 17;
            case '(':
                return 18;
            case '+':
                return 19;
            case '-':
                return 20;
        }
        return 165;
    }

    private int yys30() {
        switch (yytok) {
            case BOOLEAN:
                return 10;
            case FLOAT:
                return 11;
            case INT:
                return 15;
            case MONEY:
                return 16;
            case '!':
                return 17;
            case '(':
                return 18;
            case '+':
                return 19;
            case '-':
                return 20;
        }
        return 165;
    }

    private int yys31() {
        switch (yytok) {
            case BOOLEAN:
                return 10;
            case FLOAT:
                return 11;
            case INT:
                return 15;
            case MONEY:
                return 16;
            case '!':
                return 17;
            case '(':
                return 18;
            case '+':
                return 19;
            case '-':
                return 20;
        }
        return 165;
    }

    private int yys32() {
        switch (yytok) {
            case BOOLEAN:
                return 10;
            case FLOAT:
                return 11;
            case INT:
                return 15;
            case MONEY:
                return 16;
            case '!':
                return 17;
            case '(':
                return 18;
            case '+':
                return 19;
            case '-':
                return 20;
        }
        return 165;
    }

    private int yys35() {
        switch (yytok) {
            case BOOLEAN:
                return 10;
            case FLOAT:
                return 11;
            case INT:
                return 15;
            case MONEY:
                return 16;
            case '!':
                return 17;
            case '(':
                return 18;
            case '+':
                return 19;
            case '-':
                return 20;
        }
        return 165;
    }

    private int yys36() {
        switch (yytok) {
            case '>':
            case OR:
            case GEQ:
            case '-':
            case NEQ:
            case '+':
            case '/':
            case '*':
            case '<':
            case ')':
            case LEQ:
            case ENDINPUT:
            case EQ:
            case AND:
                return yyr28();
        }
        return 165;
    }

    private int yys37() {
        switch (yytok) {
            case AND:
                return 21;
            case EQ:
                return 22;
            case GEQ:
                return 23;
            case LEQ:
                return 24;
            case NEQ:
                return 25;
            case OR:
                return 26;
            case '*':
                return 27;
            case '+':
                return 28;
            case '-':
                return 29;
            case '/':
                return 30;
            case '<':
                return 31;
            case '>':
                return 32;
            case ')':
                return 59;
        }
        return 165;
    }

    private int yys38() {
        switch (yytok) {
            case '>':
            case OR:
            case GEQ:
            case '-':
            case NEQ:
            case '+':
            case '/':
            case '*':
            case '<':
            case ')':
            case LEQ:
            case ENDINPUT:
            case EQ:
            case AND:
                return yyr22();
        }
        return 165;
    }

    private int yys39() {
        switch (yytok) {
            case '>':
            case OR:
            case GEQ:
            case '-':
            case NEQ:
            case '+':
            case '/':
            case '*':
            case '<':
            case ')':
            case LEQ:
            case ENDINPUT:
            case EQ:
            case AND:
                return yyr23();
        }
        return 165;
    }

    private int yys40() {
        switch (yytok) {
            case EQ:
                return 22;
            case GEQ:
                return 23;
            case LEQ:
                return 24;
            case NEQ:
                return 25;
            case '*':
                return 27;
            case '+':
                return 28;
            case '-':
                return 29;
            case '/':
                return 30;
            case '<':
                return 31;
            case '>':
                return 32;
            case OR:
            case ')':
            case ENDINPUT:
            case AND:
                return yyr35();
        }
        return 165;
    }

    private int yys41() {
        switch (yytok) {
            case '*':
                return 27;
            case '+':
                return 28;
            case '-':
                return 29;
            case '/':
                return 30;
            case '>':
            case OR:
            case GEQ:
            case NEQ:
            case '<':
            case ')':
            case LEQ:
            case ENDINPUT:
            case EQ:
            case AND:
                return yyr29();
        }
        return 165;
    }

    private int yys42() {
        switch (yytok) {
            case '*':
                return 27;
            case '+':
                return 28;
            case '-':
                return 29;
            case '/':
                return 30;
            case '>':
            case OR:
            case GEQ:
            case NEQ:
            case '<':
            case ')':
            case LEQ:
            case ENDINPUT:
            case EQ:
            case AND:
                return yyr33();
        }
        return 165;
    }

    private int yys43() {
        switch (yytok) {
            case '*':
                return 27;
            case '+':
                return 28;
            case '-':
                return 29;
            case '/':
                return 30;
            case '>':
            case OR:
            case GEQ:
            case NEQ:
            case '<':
            case ')':
            case LEQ:
            case ENDINPUT:
            case EQ:
            case AND:
                return yyr34();
        }
        return 165;
    }

    private int yys44() {
        switch (yytok) {
            case '*':
                return 27;
            case '+':
                return 28;
            case '-':
                return 29;
            case '/':
                return 30;
            case '>':
            case OR:
            case GEQ:
            case NEQ:
            case '<':
            case ')':
            case LEQ:
            case ENDINPUT:
            case EQ:
            case AND:
                return yyr30();
        }
        return 165;
    }

    private int yys45() {
        switch (yytok) {
            case AND:
                return 21;
            case EQ:
                return 22;
            case GEQ:
                return 23;
            case LEQ:
                return 24;
            case NEQ:
                return 25;
            case '*':
                return 27;
            case '+':
                return 28;
            case '-':
                return 29;
            case '/':
                return 30;
            case '<':
                return 31;
            case '>':
                return 32;
            case OR:
            case ')':
            case ENDINPUT:
                return yyr36();
        }
        return 165;
    }

    private int yys46() {
        switch (yytok) {
            case '>':
            case OR:
            case GEQ:
            case '-':
            case NEQ:
            case '+':
            case '/':
            case '*':
            case '<':
            case ')':
            case LEQ:
            case ENDINPUT:
            case EQ:
            case AND:
                return yyr24();
        }
        return 165;
    }

    private int yys47() {
        switch (yytok) {
            case '*':
                return 27;
            case '/':
                return 30;
            case '>':
            case OR:
            case GEQ:
            case '-':
            case NEQ:
            case '+':
            case '<':
            case ')':
            case LEQ:
            case ENDINPUT:
            case EQ:
            case AND:
                return yyr26();
        }
        return 165;
    }

    private int yys48() {
        switch (yytok) {
            case '*':
                return 27;
            case '/':
                return 30;
            case '>':
            case OR:
            case GEQ:
            case '-':
            case NEQ:
            case '+':
            case '<':
            case ')':
            case LEQ:
            case ENDINPUT:
            case EQ:
            case AND:
                return yyr27();
        }
        return 165;
    }

    private int yys49() {
        switch (yytok) {
            case '>':
            case OR:
            case GEQ:
            case '-':
            case NEQ:
            case '+':
            case '/':
            case '*':
            case '<':
            case ')':
            case LEQ:
            case ENDINPUT:
            case EQ:
            case AND:
                return yyr25();
        }
        return 165;
    }

    private int yys50() {
        switch (yytok) {
            case '*':
                return 27;
            case '+':
                return 28;
            case '-':
                return 29;
            case '/':
                return 30;
            case '>':
            case OR:
            case GEQ:
            case NEQ:
            case '<':
            case ')':
            case LEQ:
            case ENDINPUT:
            case EQ:
            case AND:
                return yyr32();
        }
        return 165;
    }

    private int yys51() {
        switch (yytok) {
            case '*':
                return 27;
            case '+':
                return 28;
            case '-':
                return 29;
            case '/':
                return 30;
            case '>':
            case OR:
            case GEQ:
            case NEQ:
            case '<':
            case ')':
            case LEQ:
            case ENDINPUT:
            case EQ:
            case AND:
                return yyr31();
        }
        return 165;
    }

    private int yys57() {
        switch (yytok) {
            case AND:
                return 21;
            case EQ:
                return 22;
            case GEQ:
                return 23;
            case LEQ:
                return 24;
            case NEQ:
                return 25;
            case OR:
                return 26;
            case '*':
                return 27;
            case '+':
                return 28;
            case '-':
                return 29;
            case '/':
                return 30;
            case '<':
                return 31;
            case '>':
                return 32;
        }
        return 165;
    }

    private int yys58() {
        switch (yytok) {
            case ')':
                return 63;
            case '>':
            case OR:
            case GEQ:
            case '/':
            case '-':
            case NEQ:
            case '<':
            case '+':
            case '*':
            case LEQ:
            case EQ:
            case AND:
                return yyr19();
        }
        return 165;
    }

    private int yys59() {
        switch (yytok) {
            case '>':
            case OR:
            case GEQ:
            case '-':
            case NEQ:
            case '+':
            case '/':
            case '*':
            case '<':
            case ')':
            case LEQ:
            case ENDINPUT:
            case EQ:
            case AND:
                return yyr21();
        }
        return 165;
    }

    private int yys69() {
        switch (yytok) {
            case BOOLEAN:
                return 10;
            case FLOAT:
                return 11;
            case INT:
                return 15;
            case MONEY:
                return 16;
            case '!':
                return 17;
            case '(':
                return 18;
            case '+':
                return 19;
            case '-':
                return 20;
        }
        return 165;
    }

    private int yys73() {
        switch (yytok) {
            case AND:
                return 21;
            case EQ:
                return 22;
            case GEQ:
                return 23;
            case LEQ:
                return 24;
            case NEQ:
                return 25;
            case OR:
                return 26;
            case '*':
                return 27;
            case '+':
                return 28;
            case '-':
                return 29;
            case '/':
                return 30;
            case '<':
                return 31;
            case '>':
                return 32;
            case ')':
                return 75;
        }
        return 165;
    }

    private int yyr1() { // top : node
        { result = yysv[yysp-1]; }
        yysv[yysp-=1] = yyrv;
        return 1;
    }

    private int yyr17() { // assignment : '(' expr ')'
        yysp -= 3;
        return 68;
    }

    private int yyr10() { // elseBranch : ELSE '{' statements '}'
        yysp -= 4;
        return 76;
    }

    private int yyr11() { // elseBranch : /* empty */
        return 76;
    }

    private int yyr18() { // expr : arithexpr
        yysp -= 1;
        return yypexpr();
    }

    private int yyr19() { // expr : relexpr
        yysp -= 1;
        return yypexpr();
    }

    private int yyr20() { // expr : literal
        yysp -= 1;
        return yypexpr();
    }

    private int yyr21() { // expr : '(' expr ')'
        { yyrv = ((Expr)yysv[yysp-2]); }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yypexpr() {
        switch (yyst[yysp-1]) {
            case 35: return 57;
            case 32: return 51;
            case 31: return 50;
            case 30: return 49;
            case 29: return 48;
            case 28: return 47;
            case 27: return 46;
            case 26: return 45;
            case 25: return 44;
            case 24: return 43;
            case 23: return 42;
            case 22: return 41;
            case 21: return 40;
            case 20: return 39;
            case 19: return 38;
            case 18: return 37;
            case 17: return 36;
            case 0: return 2;
            default: return 73;
        }
    }

    private int yyr5() { // form : FORM IDENT '{' statements '}'
        { yyrv = new Form(((QLIdent)yysv[yysp-4]), yysv[yysp-2]); }
        yysv[yysp-=5] = yyrv;
        return 3;
    }

    private int yyr37() { // literal : INT
        yysp -= 1;
        return 4;
    }

    private int yyr38() { // literal : MONEY
        yysp -= 1;
        return 4;
    }

    private int yyr39() { // literal : FLOAT
        yysp -= 1;
        return 4;
    }

    private int yyr40() { // literal : BOOLEAN
        yysp -= 1;
        return 4;
    }

    private int yyr2() { // node : form
        yysp -= 1;
        return 5;
    }

    private int yyr3() { // node : statement
        yysp -= 1;
        return 5;
    }

    private int yyr4() { // node : expr
        yysp -= 1;
        return 5;
    }

    private int yyr12() { // question : IDENT ':' questionType '{' STRING '}'
        yysp -= 6;
        return 6;
    }

    private int yyr13() { // question : IDENT ':' questionType '{' STRING assignment '}'
        yysp -= 7;
        return 6;
    }

    private int yyr14() { // questionType : BOOLEAN
        yysp -= 1;
        return 53;
    }

    private int yyr15() { // questionType : MONEY
        yysp -= 1;
        return 53;
    }

    private int yyr16() { // questionType : INT
        yysp -= 1;
        return 53;
    }

    private int yyr28() { // relexpr : '!' expr
        { yyrv = new Not(((Expr)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return yyprelexpr();
    }

    private int yyr29() { // relexpr : expr EQ expr
        { yyrv = new Eq(((Expr)yysv[yysp-3]), ((Expr)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yyprelexpr();
    }

    private int yyr30() { // relexpr : expr NEQ expr
        { yyrv = new NEq(((Expr)yysv[yysp-3]), ((Expr)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yyprelexpr();
    }

    private int yyr31() { // relexpr : expr '>' expr
        { yyrv = new GT(((Expr)yysv[yysp-3]), ((Expr)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yyprelexpr();
    }

    private int yyr32() { // relexpr : expr '<' expr
        { yyrv = new LT(((Expr)yysv[yysp-3]), ((Expr)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yyprelexpr();
    }

    private int yyr33() { // relexpr : expr GEQ expr
        { yyrv = new GEq(((Expr)yysv[yysp-3]), ((Expr)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yyprelexpr();
    }

    private int yyr34() { // relexpr : expr LEQ expr
        { yyrv = new LEq(((Expr)yysv[yysp-3]), ((Expr)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yyprelexpr();
    }

    private int yyr35() { // relexpr : expr AND expr
        { yyrv = new And(((Expr)yysv[yysp-3]), ((Expr)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yyprelexpr();
    }

    private int yyr36() { // relexpr : expr OR expr
        { yyrv = new Or(((Expr)yysv[yysp-3]), ((Expr)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return yyprelexpr();
    }

    private int yyprelexpr() {
        switch (yyst[yysp-1]) {
            case 35: return 58;
            default: return 7;
        }
    }

    private int yyr8() { // statement : question
        yysp -= 1;
        return yypstatement();
    }

    private int yyr9() { // statement : IF '(' relexpr ')' '{' statements '}' elseBranch
        yysp -= 8;
        return yypstatement();
    }

    private int yypstatement() {
        switch (yyst[yysp-1]) {
            case 0: return 8;
            default: return 60;
        }
    }

    private int yyr6() { // statements : statement statements
        yysp -= 2;
        return yypstatements();
    }

    private int yyr7() { // statements : statement
        yysp -= 1;
        return yypstatements();
    }

    private int yypstatements() {
        switch (yyst[yysp-1]) {
            case 67: return 71;
            case 60: return 64;
            case 52: return 61;
            default: return 79;
        }
    }

    private int yyr22() { // arithexpr : '+' expr
        { yyrv = new Pos(((Expr)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return 9;
    }

    private int yyr23() { // arithexpr : '-' expr
        { yyrv = new Neg(((Expr)yysv[yysp-1])); }
        yysv[yysp-=2] = yyrv;
        return 9;
    }

    private int yyr24() { // arithexpr : expr '*' expr
        { yyrv = new Mul(((Expr)yysv[yysp-3]), ((Expr)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return 9;
    }

    private int yyr25() { // arithexpr : expr '/' expr
        { yyrv = new Div(((Expr)yysv[yysp-3]), ((Expr)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return 9;
    }

    private int yyr26() { // arithexpr : expr '+' expr
        { yyrv = new Add(((Expr)yysv[yysp-3]), ((Expr)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return 9;
    }

    private int yyr27() { // arithexpr : expr '-' expr
        { yyrv = new Sub(((Expr)yysv[yysp-3]), ((Expr)yysv[yysp-1])); }
        yysv[yysp-=3] = yyrv;
        return 9;
    }

    protected String[] yyerrmsgs = {
    };

private QLLexer lexer; 

private ASTNode result;

public ASTNode getResult() {
  return result;
}

public QLParser(QLLexer lexer) { 
  this.lexer = lexer; 
}

private void yyerror(String msg) { 
  System.err.println(yyerrno<0 ? msg : yyerrmsgs[yyerrno]);
}

}