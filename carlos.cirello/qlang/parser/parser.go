//line parser.y:2
package parser

import __yyfmt__ "fmt"

//line parser.y:3
import (
	"strconv"
	"text/scanner"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/qlang/interpreter/ast"
)

var finalQuestionaire *ast.QuestionaireNode

//Top Ends Here

//line parser.y:19
type qlSymType struct {
	yys     int
	content string
	num     float32

	evaluatables []ast.Evaluatable
	evaluatable  ast.Evaluatable
	ifNode       *ast.IfNode
	question     *ast.QuestionNode
	questionaire *ast.QuestionaireNode
	questionType ast.Parser
	stack        []*ast.ActionNode
	termNode     *ast.TermNode

	position scanner.Position
}

const BlockBeginToken = 57346
const BlockEndToken = 57347
const FormToken = 57348
const IfToken = 57349
const ParenBeginToken = 57350
const ParenEndToken = 57351
const QuotedStringToken = 57352
const TextToken = 57353
const StringQuestionToken = 57354
const NumericQuestionToken = 57355
const BoolQuestionToken = 57356
const ComputedQuestionToken = 57357
const LessThanToken = 57358
const LessOrEqualsThanToken = 57359
const MoreThanToken = 57360
const MoreOrEqualsThanToken = 57361
const EqualsToToken = 57362
const NotEqualsToToken = 57363
const NumericToken = 57364
const ElseToken = 57365
const BoolAndToken = 57366
const BoolOrToken = 57367
const BoolTrueToken = 57368
const BoolFalseToken = 57369

var qlToknames = []string{
	"'+'",
	"'-'",
	"'*'",
	"'/'",
	"BlockBeginToken",
	"BlockEndToken",
	"FormToken",
	"IfToken",
	"ParenBeginToken",
	"ParenEndToken",
	"QuotedStringToken",
	"TextToken",
	"StringQuestionToken",
	"NumericQuestionToken",
	"BoolQuestionToken",
	"ComputedQuestionToken",
	"'('",
	"')'",
	"'!'",
	"LessThanToken",
	"LessOrEqualsThanToken",
	"MoreThanToken",
	"MoreOrEqualsThanToken",
	"EqualsToToken",
	"NotEqualsToToken",
	"NumericToken",
	"ElseToken",
	"BoolAndToken",
	"BoolOrToken",
	"BoolTrueToken",
	"BoolFalseToken",
}
var qlStatenames = []string{}

const qlEofCode = 1
const qlErrCode = 2
const qlMaxDepth = 200

//line parser.y:288

//line yacctab:1
var qlExca = []int{
	-1, 1,
	1, -1,
	-2, 0,
}

const qlNprod = 34
const qlPrivate = 57344

var qlTokenNames []string
var qlStates []string

const qlLast = 82

var qlAct = []int{

	6, 9, 19, 25, 24, 11, 25, 24, 10, 21,
	28, 20, 21, 45, 5, 30, 31, 61, 23, 58,
	29, 23, 26, 27, 11, 26, 27, 10, 13, 11,
	65, 44, 10, 11, 18, 48, 49, 50, 51, 52,
	53, 54, 55, 56, 57, 17, 59, 12, 4, 60,
	38, 39, 40, 41, 7, 42, 15, 63, 3, 22,
	16, 40, 41, 62, 64, 46, 47, 43, 14, 35,
	37, 34, 36, 32, 33, 38, 39, 40, 41, 8,
	2, 1,
}
var qlPact = []int{

	48, -1000, -1000, 33, -21, -1000, 18, -1000, -1000, -1000,
	32, 8, 41, -11, -1000, -1000, -27, -1, -16, 46,
	-11, -11, -1000, -1000, -1000, -1000, -1000, -1000, -8, -22,
	-11, -11, -8, -8, -8, -8, -8, -8, -8, -8,
	-8, -8, -1000, -2, 71, -1000, -1000, -1000, 71, 71,
	71, 71, 71, 71, 55, 55, -1000, -1000, -1000, 13,
	-13, 22, -1000, -1000, -6, -1000,
}
var qlPgo = []int{

	0, 81, 80, 0, 79, 1, 68, 2, 45, 34,
	59,
}
var qlR1 = []int{

	0, 1, 2, 3, 3, 3, 4, 6, 6, 5,
	5, 5, 8, 8, 8, 9, 9, 9, 9, 9,
	9, 9, 9, 7, 7, 7, 7, 7, 7, 10,
	10, 10, 10, 10,
}
var qlR2 = []int{

	0, 1, 5, 0, 2, 2, 3, 1, 3, 7,
	9, 11, 3, 3, 1, 3, 3, 3, 3, 3,
	3, 2, 1, 3, 3, 3, 3, 3, 1, 1,
	1, 1, 1, 1,
}
var qlChk = []int{

	-1000, -1, -2, 10, 15, 35, -3, 36, -4, -5,
	14, 11, 15, 20, -6, 15, 19, -8, -9, -7,
	22, 20, -10, 29, 15, 14, 33, 34, 37, 21,
	31, 32, 27, 28, 25, 23, 26, 24, 4, 5,
	6, 7, -9, -8, -7, 35, -9, -9, -7, -7,
	-7, -7, -7, -7, -7, -7, -7, -7, 21, -3,
	36, 30, -5, 35, -3, 36,
}
var qlDef = []int{

	0, -2, 1, 0, 0, 3, 0, 2, 4, 5,
	0, 0, 0, 0, 6, 7, 0, 0, 14, 22,
	0, 0, 28, 29, 30, 31, 32, 33, 0, 0,
	0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
	0, 0, 21, 0, 8, 3, 12, 13, 15, 16,
	17, 18, 19, 20, 23, 24, 25, 26, 27, 0,
	9, 0, 10, 3, 0, 11,
}
var qlTok1 = []int{

	1, 3, 3, 3, 3, 3, 3, 3, 3, 3,
	3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
	3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
	3, 3, 3, 22, 3, 3, 3, 3, 3, 3,
	20, 21, 6, 4, 3, 5, 3, 7, 3, 3,
	3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
	3, 37, 3, 3, 3, 3, 3, 3, 3, 3,
	3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
	3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
	3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
	3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
	3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
	3, 3, 3, 35, 3, 36,
}
var qlTok2 = []int{

	2, 3, 8, 9, 10, 11, 12, 13, 14, 15,
	16, 17, 18, 19, 23, 24, 25, 26, 27, 28,
	29, 30, 31, 32, 33, 34,
}
var qlTok3 = []int{
	0,
}

//line yaccpar:1

/*	parser for yacc output	*/

var qlDebug = 0

type qlLexer interface {
	Lex(lval *qlSymType) int
	Error(s string)
}

const qlFlag = -1000

func qlTokname(c int) string {
	// 4 is TOKSTART above
	if c >= 4 && c-4 < len(qlToknames) {
		if qlToknames[c-4] != "" {
			return qlToknames[c-4]
		}
	}
	return __yyfmt__.Sprintf("tok-%v", c)
}

func qlStatname(s int) string {
	if s >= 0 && s < len(qlStatenames) {
		if qlStatenames[s] != "" {
			return qlStatenames[s]
		}
	}
	return __yyfmt__.Sprintf("state-%v", s)
}

func qllex1(lex qlLexer, lval *qlSymType) int {
	c := 0
	char := lex.Lex(lval)
	if char <= 0 {
		c = qlTok1[0]
		goto out
	}
	if char < len(qlTok1) {
		c = qlTok1[char]
		goto out
	}
	if char >= qlPrivate {
		if char < qlPrivate+len(qlTok2) {
			c = qlTok2[char-qlPrivate]
			goto out
		}
	}
	for i := 0; i < len(qlTok3); i += 2 {
		c = qlTok3[i+0]
		if c == char {
			c = qlTok3[i+1]
			goto out
		}
	}

out:
	if c == 0 {
		c = qlTok2[1] /* unknown char */
	}
	if qlDebug >= 3 {
		__yyfmt__.Printf("lex %s(%d)\n", qlTokname(c), uint(char))
	}
	return c
}

func qlParse(qllex qlLexer) int {
	var qln int
	var qllval qlSymType
	var qlVAL qlSymType
	qlS := make([]qlSymType, qlMaxDepth)

	Nerrs := 0   /* number of errors */
	Errflag := 0 /* error recovery flag */
	qlstate := 0
	qlchar := -1
	qlp := -1
	goto qlstack

ret0:
	return 0

ret1:
	return 1

qlstack:
	/* put a state and value onto the stack */
	if qlDebug >= 4 {
		__yyfmt__.Printf("char %v in %v\n", qlTokname(qlchar), qlStatname(qlstate))
	}

	qlp++
	if qlp >= len(qlS) {
		nyys := make([]qlSymType, len(qlS)*2)
		copy(nyys, qlS)
		qlS = nyys
	}
	qlS[qlp] = qlVAL
	qlS[qlp].yys = qlstate

qlnewstate:
	qln = qlPact[qlstate]
	if qln <= qlFlag {
		goto qldefault /* simple state */
	}
	if qlchar < 0 {
		qlchar = qllex1(qllex, &qllval)
	}
	qln += qlchar
	if qln < 0 || qln >= qlLast {
		goto qldefault
	}
	qln = qlAct[qln]
	if qlChk[qln] == qlchar { /* valid shift */
		qlchar = -1
		qlVAL = qllval
		qlstate = qln
		if Errflag > 0 {
			Errflag--
		}
		goto qlstack
	}

qldefault:
	/* default state action */
	qln = qlDef[qlstate]
	if qln == -2 {
		if qlchar < 0 {
			qlchar = qllex1(qllex, &qllval)
		}

		/* look through exception table */
		xi := 0
		for {
			if qlExca[xi+0] == -1 && qlExca[xi+1] == qlstate {
				break
			}
			xi += 2
		}
		for xi += 2; ; xi += 2 {
			qln = qlExca[xi+0]
			if qln < 0 || qln == qlchar {
				break
			}
		}
		qln = qlExca[xi+1]
		if qln < 0 {
			goto ret0
		}
	}
	if qln == 0 {
		/* error ... attempt to resume parsing */
		switch Errflag {
		case 0: /* brand new error */
			qllex.Error("syntax error")
			Nerrs++
			if qlDebug >= 1 {
				__yyfmt__.Printf("%s", qlStatname(qlstate))
				__yyfmt__.Printf(" saw %s\n", qlTokname(qlchar))
			}
			fallthrough

		case 1, 2: /* incompletely recovered error ... try again */
			Errflag = 3

			/* find a state where "error" is a legal shift action */
			for qlp >= 0 {
				qln = qlPact[qlS[qlp].yys] + qlErrCode
				if qln >= 0 && qln < qlLast {
					qlstate = qlAct[qln] /* simulate a shift of "error" */
					if qlChk[qlstate] == qlErrCode {
						goto qlstack
					}
				}

				/* the current p has no shift on "error", pop stack */
				if qlDebug >= 2 {
					__yyfmt__.Printf("error recovery pops state %d\n", qlS[qlp].yys)
				}
				qlp--
			}
			/* there is no state on the stack with an error shift ... abort */
			goto ret1

		case 3: /* no shift yet; clobber input char */
			if qlDebug >= 2 {
				__yyfmt__.Printf("error recovery discards %s\n", qlTokname(qlchar))
			}
			if qlchar == qlEofCode {
				goto ret1
			}
			qlchar = -1
			goto qlnewstate /* try again in the same state */
		}
	}

	/* reduction by production qln */
	if qlDebug >= 2 {
		__yyfmt__.Printf("reduce %v in:\n\t%v\n", qln, qlStatname(qlstate))
	}

	qlnt := qln
	qlpt := qlp
	_ = qlpt // guard against "declared and not used"

	qlp -= qlR2[qln]
	qlVAL = qlS[qlp+1]

	/* consult goto table to find next state */
	qln = qlR1[qln]
	qlg := qlPgo[qln]
	qlj := qlg + qlS[qlp].yys + 1

	if qlj >= qlLast {
		qlstate = qlAct[qlg]
	} else {
		qlstate = qlAct[qlj]
		if qlChk[qlstate] != -qln {
			qlstate = qlAct[qlg]
		}
	}
	// dummy call; replaced with literal code
	switch qlnt {

	case 1:
		//line parser.y:69
		{
			finalQuestionaire = qlS[qlpt-0].questionaire
		}
	case 2:
		//line parser.y:76
		{
			qlVAL.questionaire = ast.NewQuestionaireNode(qlS[qlpt-3].content, qlS[qlpt-1].stack, qlS[qlpt-3].position)
		}
	case 4:
		//line parser.y:83
		{
			q := qlS[qlpt-0].question
			qs := qlVAL.stack
			action := ast.NewActionNode(q, qlS[qlpt-0].position)
			qs = append(qs, action)
			qlVAL.stack = qs
		}
	case 5:
		//line parser.y:91
		{
			ifNode := qlS[qlpt-0].ifNode
			qs := qlVAL.stack
			action := ast.NewActionNode(ifNode, qlS[qlpt-0].position)
			qs = append(qs, action)
			qlVAL.stack = qs
		}
	case 6:
		//line parser.y:102
		{
			qlVAL.question = ast.NewQuestionNode(qlS[qlpt-2].content, qlS[qlpt-1].content, qlS[qlpt-0].questionType, qlS[qlpt-2].position)
		}
	case 7:
		//line parser.y:110
		{
			qlVAL.questionType = ast.NewScalarQuestion(qlS[qlpt-0].content, qlS[qlpt-0].position)
		}
	case 8:
		//line parser.y:114
		{
			qlVAL.questionType = ast.NewComputedQuestion(qlS[qlpt-0].evaluatable, qlS[qlpt-0].position)
		}
	case 9:
		//line parser.y:121
		{
			qlVAL.ifNode = ast.NewIfNode(qlS[qlpt-4].evaluatable, qlS[qlpt-1].stack, nil, qlS[qlpt-6].position)

			qlVAL.evaluatable = new(ast.Evaluatable)
			qlVAL.stack = []*ast.ActionNode{}
			qlS[qlpt-4].evaluatable = new(ast.Evaluatable)
			qlS[qlpt-1].stack = []*ast.ActionNode{}
		}
	case 10:
		//line parser.y:130
		{
			qlVAL.ifNode = ast.NewIfNode(qlS[qlpt-6].evaluatable, qlS[qlpt-3].stack, qlS[qlpt-0].ifNode, qlS[qlpt-8].position)

			qlVAL.evaluatable = new(ast.Evaluatable)
			qlVAL.stack = []*ast.ActionNode{}
			qlS[qlpt-6].evaluatable = new(ast.Evaluatable)
			qlS[qlpt-3].stack = []*ast.ActionNode{}
			qlS[qlpt-0].ifNode = nil
		}
	case 11:
		//line parser.y:140
		{
			elseNode := ast.NewIfNode(
				ast.NewTermNode(ast.NumericConstantNodeType, 1, "", "", qlS[qlpt-3].position),
				qlS[qlpt-1].stack,
				nil,
				qlS[qlpt-3].position,
			)
			qlVAL.ifNode = ast.NewIfNode(qlS[qlpt-8].evaluatable, qlS[qlpt-5].stack, elseNode, qlS[qlpt-10].position)

			qlVAL.evaluatable = new(ast.Evaluatable)
			qlVAL.stack = []*ast.ActionNode{}
			qlS[qlpt-8].evaluatable = new(ast.Evaluatable)
			qlS[qlpt-5].stack = []*ast.ActionNode{}
			qlS[qlpt-1].stack = []*ast.ActionNode{}
		}
	case 12:
		//line parser.y:159
		{
			qlVAL.evaluatable = ast.NewBoolAndNode(qlS[qlpt-2].evaluatable, qlS[qlpt-0].evaluatable, qlS[qlpt-1].position)
		}
	case 13:
		//line parser.y:163
		{
			qlVAL.evaluatable = ast.NewBoolOrNode(qlS[qlpt-2].evaluatable, qlS[qlpt-0].evaluatable, qlS[qlpt-1].position)
		}
	case 15:
		//line parser.y:171
		{
			qlVAL.evaluatable = ast.NewEqualsNode(qlS[qlpt-2].evaluatable, qlS[qlpt-0].evaluatable, qlS[qlpt-1].position)
		}
	case 16:
		//line parser.y:175
		{
			qlVAL.evaluatable = ast.NewNotEqualsNode(qlS[qlpt-2].evaluatable, qlS[qlpt-0].evaluatable, qlS[qlpt-1].position)
		}
	case 17:
		//line parser.y:179
		{
			qlVAL.evaluatable = ast.NewMoreThanNode(qlS[qlpt-2].evaluatable, qlS[qlpt-0].evaluatable, qlS[qlpt-1].position)
		}
	case 18:
		//line parser.y:183
		{
			qlVAL.evaluatable = ast.NewLessThanNode(qlS[qlpt-2].evaluatable, qlS[qlpt-0].evaluatable, qlS[qlpt-1].position)
		}
	case 19:
		//line parser.y:187
		{
			qlVAL.evaluatable = ast.NewMoreOrEqualsThanNode(qlS[qlpt-2].evaluatable, qlS[qlpt-0].evaluatable, qlS[qlpt-1].position)
		}
	case 20:
		//line parser.y:191
		{
			qlVAL.evaluatable = ast.NewLessOrEqualsThanNode(qlS[qlpt-2].evaluatable, qlS[qlpt-0].evaluatable, qlS[qlpt-1].position)
		}
	case 21:
		//line parser.y:195
		{
			qlVAL.evaluatable = ast.NewBoolNegNode(qlS[qlpt-0].evaluatable, qlS[qlpt-1].position)
		}
	case 23:
		//line parser.y:203
		{
			qlVAL.evaluatable = ast.NewMathAddNode(qlS[qlpt-2].evaluatable, qlS[qlpt-0].evaluatable, qlS[qlpt-1].position)
		}
	case 24:
		//line parser.y:207
		{
			qlVAL.evaluatable = ast.NewMathSubNode(qlS[qlpt-2].evaluatable, qlS[qlpt-0].evaluatable, qlS[qlpt-1].position)
		}
	case 25:
		//line parser.y:211
		{
			qlVAL.evaluatable = ast.NewMathMulNode(qlS[qlpt-2].evaluatable, qlS[qlpt-0].evaluatable, qlS[qlpt-1].position)
		}
	case 26:
		//line parser.y:215
		{
			qlVAL.evaluatable = ast.NewMathDivNode(qlS[qlpt-2].evaluatable, qlS[qlpt-0].evaluatable, qlS[qlpt-1].position)
		}
	case 27:
		//line parser.y:219
		{
			qlVAL = qlS[qlpt-1]
		}
	case 28:
		//line parser.y:223
		{
			qlVAL.evaluatable = qlS[qlpt-0].termNode
			qlVAL.position = qlS[qlpt-0].position
		}
	case 29:
		//line parser.y:231
		{
			num, _ := strconv.ParseFloat(qlS[qlpt-0].content, 32)
			qlVAL.num = float32(num)
			termNode := ast.NewTermNode(
				ast.NumericConstantNodeType,
				qlVAL.num,
				"",
				"",
				qlS[qlpt-0].position,
			)
			qlVAL.termNode = termNode
		}
	case 30:
		//line parser.y:244
		{
			termNode := ast.NewTermNode(
				ast.IdentifierReferenceNodeType,
				qlVAL.num,
				"",
				qlS[qlpt-0].content,
				qlS[qlpt-0].position,
			)
			qlVAL.termNode = termNode
		}
	case 31:
		//line parser.y:255
		{
			termNode := ast.NewTermNode(
				ast.StringConstantNodeType,
				qlVAL.num,
				qlS[qlpt-0].content,
				"",
				qlS[qlpt-0].position,
			)
			qlVAL.termNode = termNode
		}
	case 32:
		//line parser.y:266
		{
			termNode := ast.NewTermNode(
				ast.NumericConstantNodeType,
				1,
				"",
				"",
				qlS[qlpt-0].position,
			)
			qlVAL.termNode = termNode
		}
	case 33:
		//line parser.y:277
		{
			termNode := ast.NewTermNode(
				ast.NumericConstantNodeType,
				0,
				"",
				"",
				qlS[qlpt-0].position,
			)
			qlVAL.termNode = termNode
		}
	}
	goto qlstack /* stack new state and value */
}
