package com.form.language.memory;

import java.util.HashMap;
import java.util.Map;

import com.form.language.ast.expression.Expression;

public class ComputedQuestionValues {

    private Map<String, Expression> values;

    public ComputedQuestionValues() {
	this.values = new HashMap<String, Expression>();
    }

    public Expression get(String key) {
    	if (values.containsKey(key)) {
    		return values.get(key);
    	}
    	return null;
    }
    
    public void put(String idName, Expression value) {
	values.put(idName, value);
    }

    public String toString() {
	String result = "\nMemory:\n";
	for (String key : values.keySet()) {
	    result += key + ":" + values.get(key) + "\n";
	}
	return result;
    }
}
