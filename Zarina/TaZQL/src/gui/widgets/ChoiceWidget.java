package gui.widgets;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JComponent;

import ast.type.Type;
import evaluator.BooleanValue;
import evaluator.Value;
import evaluator.ValueRepository;
import gui.listeners.EvaluateExpression;

public class ChoiceWidget implements IWidgetComponent {
	private final String id;
	private final Type widgetType;
	private JCheckBox widget;
	private final ValueRepository valueRepository;
	private BooleanValue value;
		
	public ChoiceWidget(String id, Type widgetType, ValueRepository valueRepository) {
		this.id = id;
		this.valueRepository = valueRepository;
		this.widgetType = widgetType;
		this.widget = new JCheckBox();
	}

	@Override
	public JComponent getWidget() {
		return widget;
	}

	@Override
	public String getIdWidget() {
		return id;
	}

	@Override
	public Type getWidgetType() {
		return widgetType;
	}


	@Override
	public void addDocListener(final EvaluateExpression evaluator) {
		widget.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				valueRepository.putValue(getIdWidget().toString(), getValue());	
				evaluator.setValueInGUI();
			}
		});
	}

	@Override
	public void setEnabled(boolean isEnabled) {}
	
	@Override
	public BooleanValue getValue() {
		this.value = new BooleanValue(widget.isSelected());
		return value;
	}

	@Override
	public void setValue(Value value) {
		this.value = (BooleanValue) value;
		boolean selected = (Boolean) value.getValue();
		
		this.widget.setSelected(selected);
	}
	
	@Override
	public void setVisible(boolean visibility) {
		widget.setVisible(visibility);
	}
}
