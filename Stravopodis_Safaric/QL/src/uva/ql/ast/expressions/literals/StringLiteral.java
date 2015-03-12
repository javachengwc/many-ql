package uva.ql.ast.expressions.literals;

import uva.ql.ast.CodeLines;
import uva.ql.ast.value.StringValue;
import uva.ql.ast.visitor.ExpressionVisitorInterface;

public class StringLiteral extends Literal{
	
	private String value;
	
	public StringLiteral(CodeLines _codeLines) {
		super(_codeLines);
	}
	public StringLiteral(String _value, CodeLines _codeLines){
		super(_codeLines);
		this.value = _value;
	}
	
	@Override
	public StringValue evaluate() {
		return new StringValue(this.value);
	}
	
	@Override
	public <T> T accept(ExpressionVisitorInterface<T> visitor) {
		return visitor.visitStringLiteral(this);	
	}
	
	@Override
	public String evaluateType() {
		return StringLiteral.class.getName();
	}
	
	@Override
	public String toString(){
		if (this.value != null) return "StringLiteral(" + this.value + ")";
		else return "StringLiteral()";
	}
}