package org.uva.sea.ql.encoders.runtime;

import java.util.List;

import org.uva.sea.ql.encoders.ast.BaseAstVisitor;
import org.uva.sea.ql.encoders.ast.expression.BinaryExpression;
import org.uva.sea.ql.encoders.ast.expression.BooleanExpression;
import org.uva.sea.ql.encoders.ast.expression.BracedExpression;
import org.uva.sea.ql.encoders.ast.expression.Expression;
import org.uva.sea.ql.encoders.ast.expression.IntegerExpression;
import org.uva.sea.ql.encoders.ast.expression.NameExpression;
import org.uva.sea.ql.encoders.ast.expression.StringExpression;
import org.uva.sea.ql.encoders.ast.expression.UnaryExpression;
import org.uva.sea.ql.encoders.runtime.operator.BinaryOperator;
import org.uva.sea.ql.encoders.runtime.operator.UnaryOperator;
import org.uva.sea.ql.encoders.runtime.value.BooleanValue;
import org.uva.sea.ql.encoders.runtime.value.IntegerValue;
import org.uva.sea.ql.encoders.runtime.value.StringValue;
import org.uva.sea.ql.encoders.runtime.value.Value;
import org.uva.sea.ql.encoders.service.OperatorTable;
import org.uva.sea.ql.encoders.service.QuestionByName;

public class ComputedEvaluatorVisitor extends BaseAstVisitor<Value> {

	private final List<RuntimeQuestion> questions;

	private final OperatorTable operatorTable;

	public ComputedEvaluatorVisitor(List<RuntimeQuestion> questions, OperatorTable operatorTable) {
		this.questions = questions;
		this.operatorTable = operatorTable;
	}

	@Override
	public Value visit(BracedExpression bracedExpression) {
		Expression expression = bracedExpression.getExpression();
		return expression.accept(this);
	}

	@Override
	public Value visit(BinaryExpression binaryExpression) {
		Expression leftHand = binaryExpression.getLeftHand();
		Expression rightHand = binaryExpression.getRightHand();
		Value leftValue = leftHand.accept(this);
		Value rightValue = rightHand.accept(this);

		BinaryOperator operator = operatorTable.getBinaryOperator(binaryExpression.getOperator());
		return operator.calculate(leftValue, rightValue);
	}

	@Override
	public Value visit(UnaryExpression unaryExpression) {
		Expression expression = unaryExpression.getExpression();
		UnaryOperator operator = operatorTable.getUnaryOperator(unaryExpression.getOperator());
		Value value = expression.accept(this);
		return operator.calculate(value);
	}

	@Override
	public Value visit(NameExpression nameExpression) {
		String name = nameExpression.getName();
		QuestionByName questionByName = new QuestionByName();
		RuntimeQuestion runtimeQuestion = questionByName.getRuntimeQuestion(name, questions);
		return runtimeQuestion.getValue();
	}

	@Override
	public Value visit(BooleanExpression booleanExpression) {
		return new BooleanValue(booleanExpression.getBooleanLiteral());
	}

	@Override
	public Value visit(IntegerExpression integerExpression) {
		return new IntegerValue(integerExpression.getIntegerLiteral());
	}

	@Override
	public Value visit(StringExpression stringExpression) {
		return new StringValue(stringExpression.getStringLiteral());
	}
}
