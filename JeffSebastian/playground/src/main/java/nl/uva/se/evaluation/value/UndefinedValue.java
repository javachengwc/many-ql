package nl.uva.se.evaluation.value;

public class UndefinedValue extends Value<Void> {

	public UndefinedValue() {
		super(null);
	}

	@Override
	public boolean isUndefined() {
		return true;
	}

}