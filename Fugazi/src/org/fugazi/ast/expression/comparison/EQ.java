package org.fugazi.ast.expression.comparison;

import org.fugazi.ast.expression.Expression;
import org.fugazi.ast.expression.IExpressionVisitor;
import org.fugazi.ast.type.BoolType;
import org.fugazi.ast.type.IntType;
import org.fugazi.ast.type.Type;

import java.util.ArrayList;
import java.util.List;

public class EQ extends Comparison {

    private final List<Type> supportedTypes;

    public EQ(Expression _left, Expression _right) {
        super(_left, _right);
        this.supportedTypes = new ArrayList<Type>();
        this.supportedTypes.add(new IntType());
        this.supportedTypes.add(new BoolType());
    }

    @Override
    public String toString() {
        return this.left.toString() + "==" + this.right.toString();
    }

    @Override
    public List<Type> getSupportedTypes() {
        return this.supportedTypes;
    }

    public <T> T accept(IExpressionVisitor<T> visitor) {
        return visitor.visitEQ(this);
    }
}