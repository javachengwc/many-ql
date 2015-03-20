package qls.gui.widget.input.field;

import javax.swing.event.CaretListener;

import ql.value.IntegerValue;
import qls.ast.statement.widget.styling.StyleProperties;
import qls.gui.widget.input.Field;

public class IntegerField extends Field<IntegerValue> implements CaretListener {	
	public IntegerField () {
		super();
	}
	public IntegerField (IntegerValue value) {
		super();		
    	textField.setText(value.getValue().toString());	
	}

	@Override
	public IntegerValue getValue() {
		return new IntegerValue(Integer.parseInt(textField.getText()));
	}
	
	@Override
	public void setValue(IntegerValue value) {
		textField.setText(value.toString());		
	}
	
	@Override
	public void setStyle(StyleProperties properties) {
		stylizer.setStyle(textField, properties);
	}
}
