package uva.sc.ql.expression.unaryExpressions;

import uva.sc.ql.ast.IQLExpressionNodeVisitor;
import uva.sc.ql.expression.Expression;

@SuppressWarnings({ "rawtypes" })
public class Not extends UnaryExpression {

    public Not(Expression operand) {
	super(operand);
    }

    public String toString() {
	return "[un !]" + operand.getValue();
    }

    public Object accept(IQLExpressionNodeVisitor visitor) {
	return visitor.visit(this);
    }

}
