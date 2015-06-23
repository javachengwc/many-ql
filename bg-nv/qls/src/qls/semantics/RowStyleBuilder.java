package qls.semantics;

import ql.gui.control.CheckBox;
import ql.gui.control.Control;
import ql.gui.control.Radio;
import ql.gui.control.TextField;
import ql.gui.segment.RowStyle;
import qls.ast.rule.*;
import qls.ast.rule.widget.*;

/**
 * Created by bore on 10/03/15.
 */
public class RowStyleBuilder implements RuleVisitor<Void>, WidgetVisitor<Control>
{
    private RowStyle rowStyle;

    public static RowStyle build(Rules rs)
    {
        RowStyleBuilder visitor = new RowStyleBuilder();
        for (Rule r : rs)
        {
            r.accept(visitor);
        }

        return visitor.rowStyle;
    }

    private RowStyleBuilder()
    {
        this.rowStyle = new RowStyle();
    }

    @Override
    public Void visit(Width r)
    {
        this.rowStyle.setWidth(r.getValue());
        return null;
    }

    @Override
    public Void visit(Font r)
    {
        this.rowStyle.setFontName(r.getValue());
        return null;
    }

    @Override
    public Void visit(FontSize r)
    {
        this.rowStyle.setFontSize(r.getValue());
        return null;
    }

    @Override
    public Void visit(BackColor r)
    {
        this.rowStyle.setBackColor(r.getValue().getColor());
        return null;
    }

    @Override
    public Void visit(ForeColor r)
    {
        this.rowStyle.setForeColor(r.getValue().getColor());
        return null;
    }

    @Override
    public Void visit(Widget r)
    {
        Control c = r.getValue().accept(this);
        this.rowStyle.setWidget(c);
        return null;
    }

    @Override
    public Control visit(Checkbox w)
    {
        return new CheckBox();
    }

    @Override
    public Control visit(Dropdown w)
    {
        return new ql.gui.control.Dropdown(w.getYesLabel(), w.getNoLabel());
    }

    @Override
    public Control visit(qls.ast.rule.widget.Radio w)
    {
        return new Radio(w.getYesLabel(), w.getNoLabel());
    }

    @Override
    public Control visit(DecSlider w)
    {
        return new ql.gui.control.Slider(w.getMin(), w.getMax(), w.getStep());
    }

    @Override
    public Control visit(IntSlider w)
    {
        return new ql.gui.control.Slider(w.getMin(), w.getMax(), w.getStep());
    }

    @Override
    public Control visit(Textbox w)
    {
        return new TextField();
    }
}
