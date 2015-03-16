package nl.uva.sc.encoders.ql.ast.operator;

import nl.uva.sc.encoders.ql.visitor.BinaryOperatorVisitor;

public class AndOperator implements BinaryOperator {

	@Override
	public <T> T accept(BinaryOperatorVisitor<T> visitor) {
		return visitor.visit(this);
	}
}