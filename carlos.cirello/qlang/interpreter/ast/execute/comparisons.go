package execute

//todo(carlos): refactor bool nodes into visitor

import (
	"fmt"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/qlang/interpreter/ast"
)

// EqualsNode is the visitor for Equals comparison operation
func (exec Execute) EqualsNode(n *ast.EqualsNode) bool {
	lt, ltOk := n.LeftTerm().(*ast.TermNode)
	rt, rtOk := n.RightTerm().(*ast.TermNode)
	if ltOk && rtOk {
		vl := exec.TermNode(lt)
		vr := exec.TermNode(rt)
		return vl == vr
	}

	left, right := exec.resolveBothMathNodes(n.DoubleTermNode)
	return left == right
}

// NotEqualsNode is the visitor for not equals comparison operation
func (exec Execute) NotEqualsNode(n *ast.NotEqualsNode) bool {
	lt, ltOk := n.LeftTerm().(*ast.TermNode)
	rt, rtOk := n.RightTerm().(*ast.TermNode)
	if ltOk && rtOk {
		vl := exec.resolveTermNode(lt)
		vr := exec.resolveTermNode(rt)
		return vl != vr
	}

	left, right := exec.resolveBothMathNodes(n.DoubleTermNode)
	return left != right
}

// MoreThanNode is the visitor for More Than comparison operation
func (exec Execute) MoreThanNode(n *ast.MoreThanNode) bool {
	left, right := exec.resolveBothMathNodes(n.DoubleTermNode)
	return left > right
}

// LessThanNode is the visitor for Less Than comparison operation
func (exec Execute) LessThanNode(n *ast.LessThanNode) bool {
	left, right := exec.resolveBothMathNodes(n.DoubleTermNode)
	return left < right
}

// MoreOrEqualsThanNode is the visitor for More Or Equals Than comparison operation
func (exec Execute) MoreOrEqualsThanNode(n *ast.MoreOrEqualsThanNode) bool {
	left, right := exec.resolveBothMathNodes(n.DoubleTermNode)
	return left >= right
}

// LessOrEqualsThanNode is the visitor for Less Or Equals Than comparison operation
func (exec Execute) LessOrEqualsThanNode(n *ast.LessOrEqualsThanNode) bool {
	left, right := exec.resolveBothMathNodes(n.DoubleTermNode)
	return left <= right
}

// TermNode is the visitor for Term comparison operation
func (exec Execute) TermNode(s *ast.TermNode) bool {
	value := exec.resolveTermNode(s)

	switch value.(type) {
	case bool:
		return value.(bool)
	case int:
		return value.(int) != 0
	case float32:
		return value.(float32) != 0
	case string:
		return value.(string) != ""
	}

	return false
}

// BoolAndNode is the visitor for "and" comparison operation
func (exec Execute) BoolAndNode(n *ast.BoolAndNode) bool {
	left := exec.ResolveComparisonNode(n.DoubleTermNode.LeftTerm())
	right := exec.ResolveComparisonNode(n.DoubleTermNode.RightTerm())
	return left && right
}

// BoolOrNode is the visitor for "or" comparison operation
func (exec Execute) BoolOrNode(n *ast.BoolOrNode) bool {
	left := exec.ResolveComparisonNode(n.DoubleTermNode.LeftTerm())
	right := exec.ResolveComparisonNode(n.DoubleTermNode.RightTerm())
	return left || right
}

// BoolNegNode is the visitor for negation comparison operation
func (exec Execute) BoolNegNode(n *ast.BoolNegNode) bool {
	return !exec.ResolveComparisonNode(n.Term())
}

// ResolveComparisonNode is the helper function to process all comparison
// operations
func (exec *Execute) ResolveComparisonNode(n interface{}) bool {
	conditionState := true

	switch t := n.(type) {
	default:
		pos := n.(ast.Positionable).Pos()
		panic(fmt.Sprintf("%s:runtime error: impossible condition type. got: %T", pos, t))

	case *ast.TermNode:
		conditionState = exec.TermNode(n.(*ast.TermNode))

	case *ast.NotEqualsNode:
		conditionState = exec.NotEqualsNode(n.(*ast.NotEqualsNode))

	case *ast.EqualsNode:
		conditionState = exec.EqualsNode(n.(*ast.EqualsNode))

	case *ast.MoreThanNode:
		conditionState = exec.MoreThanNode(n.(*ast.MoreThanNode))

	case *ast.LessThanNode:
		conditionState = exec.LessThanNode(n.(*ast.LessThanNode))

	case *ast.MoreOrEqualsThanNode:
		conditionState = exec.MoreOrEqualsThanNode(n.(*ast.MoreOrEqualsThanNode))

	case *ast.LessOrEqualsThanNode:
		conditionState = exec.LessOrEqualsThanNode(n.(*ast.LessOrEqualsThanNode))

	case *ast.BoolAndNode:
		conditionState = exec.BoolAndNode(n.(*ast.BoolAndNode))

	case *ast.BoolOrNode:
		conditionState = exec.BoolOrNode(n.(*ast.BoolOrNode))

	case *ast.BoolNegNode:
		conditionState = exec.BoolNegNode(n.(*ast.BoolNegNode))

	}

	return conditionState
}
