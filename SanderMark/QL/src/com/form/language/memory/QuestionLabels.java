package com.form.language.memory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QuestionLabels implements Iterable<String> {
    
    private List<String> labels;
    
    public QuestionLabels(){
	this.labels = new ArrayList<String>();
    }
    
    public void add(String s){
	labels.add(s);
    }

    public boolean contains(String s){
	return labels.contains(s);
    }
    
    @Override
    public Iterator<String> iterator() {
	return labels.iterator();
    }
}