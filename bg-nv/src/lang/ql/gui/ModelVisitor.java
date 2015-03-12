package lang.ql.gui;

import lang.ql.gui.canvas.Canvas;
import lang.ql.gui.input.*;
import lang.ql.gui.input.expression.*;
import lang.ql.gui.input.regular.*;
import lang.ql.gui.label.Label;
import lang.ql.gui.section.ConditionalSection;
import lang.ql.gui.section.LineSection;
import lang.ql.gui.section.Section;

/**
 * Created by Nik on 23-2-15.
 */
public interface ModelVisitor<T>
{
    public T visit(Canvas c);

    public T visit(ConditionalSection section);
    public T visit(LineSection lineSection);

    public T visit(Label label);

    public T visit(BoolInput input);
    public T visit(DateInput input);
    public T visit(DecInput input);
    public T visit(IntInput input);
    public T visit(StrInput input);

    public T visit(BoolExprInput input);
    public T visit(DateExprInput input);
    public T visit(DecExprInput input);
    public T visit(IntExprInput input);
    public T visit(StrExprInput input);
}