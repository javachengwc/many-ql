package ql.gui.control;

import javafx.beans.value.ChangeListener;
import javafx.scene.Node;
import ql.semantics.values.*;

import java.math.BigDecimal;

/**
 * Created by Nik on 10-3-15.
 */
public class TextField extends ControlElement implements IntControl, DecControl, StrControl
{
    private final static UndefValue undefValue = new UndefValue();
    private final javafx.scene.control.TextInputControl textField;

    public TextField()
    {
        this.textField = new javafx.scene.control.TextField();
    }

    @Override
    public void setValue(Value value)
    {
        value.accept(this);
    }

    @Override
    public void setDisabled(Boolean disabled)
    {
        this.textField.setDisable(disabled);
    }

    @Override
    public Node getControlNode()
    {
        return this.textField;
    }


    @Override
    public void addListener(ChangeListener listener)
    {
        this.textField.textProperty().addListener(listener);
    }

    private void setText(String text)
    {
        this.textField.setText(text);
    }

    @Override
    public Void visit(DecValue val)
    {
        this.setText(val.getValue().toString());
        return null;
    }

    @Override
    public Void visit(IntValue val)
    {
        this.setText(val.getValue().toString());
        return null;
    }

    @Override
    public Void visit(StrValue val)
    {
        this.setText(val.getValue());
        return null;
    }

    @Override
    public Void visit(UndefValue val)
    {
        this.setText("");
        return null;
    }

    @Override
    public Value getIntValue()
    {
        String userInput = this.textField.getText();
        userInput = userInput.trim();
        Value value;
        try
        {
            Integer intValue = Integer.parseInt(userInput);
            value = new IntValue(intValue);
        }
        catch (NumberFormatException e)
        {
            value = undefValue;
        }

        return value;
    }

    @Override
    public Value getDecValue()
    {
        Value value;
        try
        {
            BigDecimal decValue = new BigDecimal(this.textField.getText());
            value = new DecValue(decValue);
        }
        catch (NumberFormatException e)
        {
            value = undefValue;
        }
        return value;
    }

    @Override
    public Value getStrValue()
    {
        return new StrValue(this.textField.getText());
    }
}
