package com.form.language.memory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.form.language.ast.expression.Expression;
import com.form.language.ast.expression.variable.Reference;
import com.form.language.ast.expression.variable.ReferenceCollection;

public class QuestionReferences {
    private Map<String, List<Expression>> referenceMap;

    public QuestionReferences() {
	this.referenceMap = new HashMap<String, List<Expression>>();
    }

    public List<Expression> get(String key) {
	if (referenceMap.containsKey(key)) {
	    return referenceMap.get(key);
	} else {
	    return new ArrayList<Expression>();
	}
    }

    public void put(String idName, List<Expression> dependencies) {
	referenceMap.put(idName, dependencies);
    }

    // Adds the dependency of value on the given keys to all of the keys
    public void putAll(ReferenceCollection keyCollection, Expression value) {
	for(Reference l : keyCollection){

	    List<Expression> tempList;

	    if (referenceMap.containsKey(l.getName())) {
		tempList = referenceMap.get(l.getName());
	    } else {
		tempList = new ArrayList<Expression>();
	    }

	    tempList.add(value);
	    referenceMap.put(l.getName(), tempList);
	}
    }
}
