package nl.uva.sc.encoders.ql.ast.operator;

import nl.uva.sc.encoders.ql.ast.type.BooleanType;
import nl.uva.sc.encoders.ql.ast.type.DataType;
import nl.uva.sc.encoders.ql.ast.type.IntegerType;
import nl.uva.sc.encoders.ql.visitor.BinaryOperatorVisitor;

public class LessOrEqualOperator implements BinaryOperator {
	private String stringRepresentation;

	public LessOrEqualOperator(String stringRepresentation) {
		this.stringRepresentation = stringRepresentation;
	}

	@Override
	public String toString() {
		return stringRepresentation.toString();
	}

	@Override
	public <T> T accept(BinaryOperatorVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public boolean supports(DataType leftHandType, DataType rightHandType) {
		if (!leftHandType.equals(rightHandType)) {
			return false;
		}
		if (!(leftHandType instanceof IntegerType)) {
			return false;
		}
		return true;
	}

	@Override
	public DataType getType(DataType leftHandType, DataType rightHandType) {
		return new BooleanType();
	}
}
