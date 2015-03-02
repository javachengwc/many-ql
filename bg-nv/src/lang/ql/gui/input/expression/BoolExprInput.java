package lang.ql.gui.input.expression;

import lang.ql.ast.expression.BoolExpr;
import lang.ql.ast.expression.Expr;
import lang.ql.gui.GuiVisitor;

/**
 * Created by Nik on 28-02-2015
 */
public class BoolExprInput extends ExprInput
{
    public BoolExprInput(String id, Expr expression)
    {
        super(id, expression);
    }

    public BoolExprInput(String id, Expr expression, Boolean visible)
    {
        super(id, expression, visible);
    }

    @Override
    public <T> T accept(GuiVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}