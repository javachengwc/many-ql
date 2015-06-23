package nl.uva.sc.encoders.qlruntime.model.value;

import nl.uva.sc.encoders.ql.visitor.DataTypeVisitor;

public abstract class Value {

	public abstract Object getValue();

	@Override
	public String toString() {
		return getValue().toString();
	}

	public Value multiply(Value otherValue) {
		throw new UnsupportedOperationException();
	}

	public Value divide(Value otherValue) {
		throw new UnsupportedOperationException();
	}

	public Value add(Value otherValue) {
		throw new UnsupportedOperationException();
	}

	public Value substract(Value otherValue) {
		throw new UnsupportedOperationException();
	}

	public Value and(Value otherValue) {
		throw new UnsupportedOperationException();
	}

	public Value or(Value otherValue) {
		throw new UnsupportedOperationException();
	}

	public Value lessThan(Value otherValue) {
		throw new UnsupportedOperationException();
	}

	public Value greaterThan(Value otherValue) {
		throw new UnsupportedOperationException();
	}

	public Value lessOrEqual(Value otherValue) {
		throw new UnsupportedOperationException();
	}

	public Value greaterOrEqual(Value otherValue) {
		throw new UnsupportedOperationException();
	}

	public <T> T accept(DataTypeVisitor<T> dataTypeVisitor) {
		throw new UnsupportedOperationException();
	}

	public Value equal(Value otherValue) {
		return new BooleanValue(equals(otherValue));
	}

	public Value notEqual(Value otherValue) {
		return new BooleanValue(!equals(otherValue));
	}

	public Value not() {
		throw new UnsupportedOperationException();
	}

	@Override
	public int hashCode() {
		return getValue().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Value)) {
			return false;
		}
		return getValue().equals(((Value) obj).getValue());
	}
}
