package org.fugazi.qls.ast.widget;

import org.fugazi.ql.ast.type.StringType;
import org.fugazi.ql.ast.type.Type;
import org.fugazi.ql.evaluator.expression_value.ExpressionValue;
import org.fugazi.ql.evaluator.expression_value.StringValue;
import org.fugazi.ql.gui.widgets.WidgetsEventListener;
import org.fugazi.qls.ast.IQLSASTVisitor;
import org.fugazi.qls.ast.style.Style;
import org.fugazi.qls.ast.style.style_property.Width;
import org.fugazi.qls.ast.widget.widget_types.TextBoxType;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QLSTextBox extends AbstractQLSWidget {

    public final static int DEFAULT_WIDTH = 7;

    private JTextField input;

    public QLSTextBox() {
        this("");
    }

    public QLSTextBox(String _label) {
        this.input = new JTextField();
        this.componentLabel.setText(_label);
        this.component.add(componentLabel);
        this.component.add(input);

        this.type = new TextBoxType();
    }

    @Override
    public void setLabel(String _label) {
        this.componentLabel.setText(_label);
    }

    @Override
    public void applyStyle(Style _style) {
        _style.inheriteFromStyle(this.getDefaultStyle());

        Font font = new Font(
                _style.getFont(this.getDefaultFont().getValue()), 0,
                _style.getFontSize(this.getDefaultFontSize().getValue())
        );
        this.componentLabel.setFont(font);

        Color color = _style.getColor(this.getDefaultColor().getValue());
        this.componentLabel.setForeground(color);
        this.input.setColumns(this.getDefaultWidth().getValue());
    }

    @Override
    public void addEventListener(WidgetsEventListener _listener) {

        this.input.getDocument().addDocumentListener(
                new DocumentListener() {
                    public void insertUpdate(DocumentEvent e) {
                        _listener.stateChanged();
                    }
                    public void removeUpdate(DocumentEvent e) {}
                    public void changedUpdate(DocumentEvent e) {}
                }
        );
    }

    @Override
    public StringValue getWidgetValue() {
        return new StringValue(this.input.getText());
    }

    @Override
    public void setWidgetValue(ExpressionValue _value) {
        StringValue value = (StringValue) _value;
        this.input.setText(value.getValue());
    }

    @Override
    public void setReadOnly(boolean _isReadonly) {
        this.input.setEnabled(false);
    }
    
    @Override
    public Width getDefaultWidth() {
        return new Width(DEFAULT_WIDTH);
    }

    public List<Type> getSupportedQuestionTypes() {
        List<Type> supportedTypes = new ArrayList<>(
                Arrays.asList(new StringType())
        );
        return supportedTypes;
    }

    public <T> T accept(IQLSASTVisitor<T> _visitor) {
        return _visitor.visitTextBox(this);
    }
}