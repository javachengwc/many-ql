package cons.ql.ast.expression.arithmetic;

import cons.ql.ast.Expression;
import cons.ql.ast.expression.QLType;
import cons.ql.ast.expression.Unary;
import cons.ql.ast.expression.type.QLNumeric;
import cons.ql.ast.visitor.Visitor;

public class Pos extends Unary {
	public Pos(Expression operand) {
		super(operand, "+");
	}
	
	@Override
	public <T> T accept(Visitor<T> visitor) {		
		return visitor.visit(this);
	}
	
	@Override
	public QLType getType() {
		return new QLNumeric();
	}
}