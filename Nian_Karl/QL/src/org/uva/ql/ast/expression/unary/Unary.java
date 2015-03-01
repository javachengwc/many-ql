package org.uva.ql.ast.expression.unary;

import org.uva.ql.ast.builder.CodePosition;
import org.uva.ql.ast.expression.Expression;

public abstract class Unary extends Expression {

	protected final Expression expr;
	
	public Unary(Expression expr,CodePosition pos) {
		super(pos);
		this.expr = expr;
	}
	
	public Expression getExpression() {
		return expr;
	}

}