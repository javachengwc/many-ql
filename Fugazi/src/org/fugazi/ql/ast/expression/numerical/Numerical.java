package org.fugazi.ql.ast.expression.numerical;

import org.fugazi.ql.ast.expression.Binary;
import org.fugazi.ql.ast.expression.Expression;

public abstract class Numerical extends Binary {
    
    public Numerical(Expression _left, Expression _right) {
        super(_left, _right);
    }
}