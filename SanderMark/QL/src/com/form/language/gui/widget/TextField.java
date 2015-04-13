package com.form.language.gui.widget;

import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.form.language.ast.statement.question.Question;
import com.form.language.ast.values.GenericValue;
import com.form.language.ast.values.StringValue;
import com.form.language.memory.Context;

public class TextField extends Widget { 
    private JTextField textfield;

    //TODO: Waarom hier ook nog eens een Question terwel questioncomponent al een question heeft?
    public TextField(Question question, Context context) {
	super(question,context);
	this.textfield = new JTextField();	

	this.textfield.setName(question.getId());	
	this.textfield.setMaximumSize(new Dimension(200, 20));		
	TextFieldListener textfieldListener = new TextFieldListener();
	this.textfield.getDocument().addDocumentListener(textfieldListener);
	setContextValue(new StringValue());
    }

    public JTextField getTextField()
    {
	return textfield;
    }

    private class TextFieldListener implements DocumentListener {
	public void actionPerformed(DocumentEvent e) {
	    setContextValue(new StringValue(textfield.getText()));
	    checkComputedQuestion();
	    checkDependencyVisibility();
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
	    actionPerformed(e);			
	}

	@Override
	public void removeUpdate(DocumentEvent e) { 		
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
	}
    }

    @Override
    public void displayComputedValue(GenericValue value) {
	textfield.setText(value.toString());
	textfield.setEnabled(false);
    }
    
    public String toString(){
	return "IntegerTextField: " + textfield.getText();
    }
}
