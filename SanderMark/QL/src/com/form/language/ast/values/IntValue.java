package com.form.language.ast.values;


public class IntValue extends GenericValue {
    private final Integer value;
    private final static Integer DEFAULT = 0;

    public IntValue(int value) {
	this.value = value;
    }

    public IntValue() {
	this.value = DEFAULT;
    }
    
    public int getValue() {
	return value;
    }

    @Override
    public String toString() {
	return Integer.toString(value);

    }

    @Override
    public boolean equals(Object o) {
	if(o == this){
	    return true;
	}
	if (!(o instanceof IntValue)){
	    return false;
	}
	IntValue castO = (IntValue) o;
	if(value == null){
	    return castO.value == null;
	} else {
	    return value.equals(castO.value);
	}
    }

    @Override
    public int hashCode() {
	return value;
    }
}
