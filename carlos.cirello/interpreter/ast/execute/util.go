package execute

import (
	"fmt"
	"log"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter/ast"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter/symboltable"
)

func (exec Execute) resolveBothExpressions(n ast.DoubleTermNode) (left, right string) {
	lt := n.LeftTerm()
	rt := n.RightTerm()

	left = exec.resolveExpression(lt)
	right = exec.resolveExpression(rt)

	return left, right
}

func (exec Execute) resolveExpression(n interface{}) string {
	switch n.(type) {
	case *ast.ConcatNode:
		return exec.resolveStringNode(n)
	case *ast.TermNode:
		return exec.resolveTermNode(n).(string)
	default:
		return fmt.Sprintf("%f", exec.resolveMathNode(n))
	}
}

func (exec Execute) resolveBothMathNodes(n ast.DoubleTermNode) (left,
	right float32) {
	lt := n.LeftTerm()
	rt := n.RightTerm()

	left = exec.resolveMathNode(lt)
	right = exec.resolveMathNode(rt)

	return left, right
}

func (exec Execute) resolveMathNode(n interface{}) float32 {
	switch t := n.(type) {
	default:
		pos := n.(ast.Positionable).Pos()
		log.Fatalf("%s:runtime error: Unknown type while resolving node %T", pos, t)
	case *ast.MathAddNode:
		return exec.MathAddNode(n.(*ast.MathAddNode))
	case *ast.MathSubNode:
		return exec.MathSubNode(n.(*ast.MathSubNode))
	case *ast.MathMulNode:
		return exec.MathMulNode(n.(*ast.MathMulNode))
	case *ast.MathDivNode:
		return exec.MathDivNode(n.(*ast.MathDivNode))
	case *ast.TermNode:
		return exec.MathTermNode(n.(*ast.TermNode))
	}
	return 0
}

func (exec *Execute) resolveNumeric(n *ast.TermNode) float32 {
	node := exec.resolveTermNode(n)
	var nodeVal float32
	switch t := node.(type) {
	default:
		pos := n.Pos()
		log.Fatalf("%s:runtime error: Type impossible to execute comparison. got: %T", pos, t)
	case int:
		nodeVal = float32(node.(int))
	case float32:
		nodeVal = node.(float32)
	}
	return nodeVal
}

func (exec *Execute) resolveTermNode(t interface{}) interface{} {
	identifier := t.(*ast.TermNode).IdentifierReference()
	if identifier != "" {
		q := exec.symboltable.Read(identifier)

		if q == nil {
			return nil
		}

		return q.(symboltable.ValueLoader).Value()
	}
	switch t.(*ast.TermNode).Type() {
	case ast.NumericConstantNodeType:
		return t.(*ast.TermNode).NumericConstant()
	case ast.StringConstantNodeType:
		return t.(*ast.TermNode).StringConstant()
	}
	return nil
}
