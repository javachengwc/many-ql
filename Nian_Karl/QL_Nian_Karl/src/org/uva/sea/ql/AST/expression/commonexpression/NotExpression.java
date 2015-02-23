package org.uva.sea.ql.AST.expression.commonexpression;

import org.uva.sea.ql.AST.expression.DataTypeExpression;
import org.uva.sea.ql.AST.literal.AbstractLiteral;
import org.uva.sea.ql.AST.literal.BooleanLiteral;
import org.uva.sea.ql.AST.value.BooleanValue;

public class NotExpression extends DataTypeExpression{
	
	private BooleanLiteral booleanLiteral; 
	public NotExpression(AbstractLiteral literal) {
		super(literal);
		this.booleanLiteral = (BooleanLiteral) literal;
	}

	@Override
	public BooleanValue interpretExpression() {
		return booleanLiteral.interpretExpression();
	}
}