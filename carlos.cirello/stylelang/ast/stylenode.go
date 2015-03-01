package ast

type StyleNode struct {
	label string
	stack []*ActionNode
}

func NewStyleNode(label string, stack []*ActionNode) *StyleNode {
	return &StyleNode{label, stack}
}

func (s *StyleNode) Label() string {
	return s.label
}

func (s *StyleNode) Stack() []*ActionNode {
	return s.stack
}
