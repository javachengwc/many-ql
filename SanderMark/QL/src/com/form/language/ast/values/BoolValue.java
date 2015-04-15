package com.form.language.ast.values;


public class BoolValue extends GenericValue {
    private final Boolean value;
    private final static boolean DEFAULT = false;
    
    public BoolValue(boolean value) {
	this.value = value;
    }
    
    public BoolValue(){
    	this.value = DEFAULT;
    }

    public Boolean getValue() {
	return value;
    }

    @Override
    public String toString() {
	return Boolean.toString(value);

    }

    @Override
    public boolean equals(Object o) {
	if(o == this){
	    return true;
	}
	if (!(o instanceof BoolValue)){
	    return false;
	}
	BoolValue castO = (BoolValue) o;
	if(value == null){
	    return castO.value == null;
	} else {
	    return value.equals(castO.value);
	}
    }

    @Override
    public int hashCode() {
	return (value? 1 : 0);
    }
}
