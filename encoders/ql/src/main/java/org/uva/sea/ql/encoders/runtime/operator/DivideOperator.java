package org.uva.sea.ql.encoders.runtime.operator;

import org.uva.sea.ql.encoders.runtime.value.Value;

public class DivideOperator implements BinaryOperator {
	@Override
	public Value calculate(Value leftValue, Value rightValue) {
		return leftValue.divide(rightValue);
	}
}