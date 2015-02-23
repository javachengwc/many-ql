package parser.nodes.expression;

import parser.Visitor;
import parser.nodes.AbstractNode;

/**
 * Created by Steven Kok on 21/02/2015.
 */
public class GreaterOrEqual extends BinaryExpression {
    public GreaterOrEqual(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public AbstractNode accept(Visitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public boolean isConditional() {
        return false;
    }
}
