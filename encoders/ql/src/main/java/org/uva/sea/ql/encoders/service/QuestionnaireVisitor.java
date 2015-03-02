package org.uva.sea.ql.encoders.service;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.uva.sea.ql.encoders.EncodersQLBaseVisitor;
import org.uva.sea.ql.encoders.EncodersQLParser.AddSubContext;
import org.uva.sea.ql.encoders.EncodersQLParser.AndContext;
import org.uva.sea.ql.encoders.EncodersQLParser.BracedExpressionContext;
import org.uva.sea.ql.encoders.EncodersQLParser.ConditionalBlockContext;
import org.uva.sea.ql.encoders.EncodersQLParser.ExpressionContext;
import org.uva.sea.ql.encoders.EncodersQLParser.LtGtLeGeContext;
import org.uva.sea.ql.encoders.EncodersQLParser.MulDivContext;
import org.uva.sea.ql.encoders.EncodersQLParser.NameContext;
import org.uva.sea.ql.encoders.EncodersQLParser.NeEqContext;
import org.uva.sea.ql.encoders.EncodersQLParser.NotContext;
import org.uva.sea.ql.encoders.EncodersQLParser.OrContext;
import org.uva.sea.ql.encoders.EncodersQLParser.QuestionContext;
import org.uva.sea.ql.encoders.EncodersQLParser.QuestionnaireContext;
import org.uva.sea.ql.encoders.EncodersQLParser.StatementContext;
import org.uva.sea.ql.encoders.ast.AstNode;
import org.uva.sea.ql.encoders.ast.BracedExpression;
import org.uva.sea.ql.encoders.ast.ConditionalBlock;
import org.uva.sea.ql.encoders.ast.DataType;
import org.uva.sea.ql.encoders.ast.TypeChecker;
import org.uva.sea.ql.encoders.ast.Expression;
import org.uva.sea.ql.encoders.ast.NameExpression;
import org.uva.sea.ql.encoders.ast.OperatorExpression;
import org.uva.sea.ql.encoders.ast.Question;
import org.uva.sea.ql.encoders.ast.Questionnaire;
import org.uva.sea.ql.encoders.ast.TextLocation;
import org.uva.sea.ql.encoders.ast.TypeValidation;

public class QuestionnaireVisitor extends EncodersQLBaseVisitor<AstNode> {

	public TypeChecker expressionTypeChecker = new TypeChecker();

	@Override
	public Questionnaire visitQuestionnaire(QuestionnaireContext ctx) {
		Questionnaire questionnaire = new Questionnaire(getTextLocation(ctx));
		questionnaire.setName(ctx.formName.getText());
		List<StatementContext> statements = ctx.statement();

		for (StatementContext statementContext : statements) {
			ConditionalBlockContext conditionalBlock = statementContext.conditionalBlock();
			if (conditionalBlock != null) {
				ConditionalBlock cb = (ConditionalBlock) visit(conditionalBlock);
				questionnaire.addQuestions(cb.getQuestions());
			}
			QuestionContext questionContext = statementContext.question();
			if (questionContext != null) {
				Question question = (Question) visit(questionContext);
				questionnaire.addQuestion(question);
			}
		}
		return questionnaire;
	}

	@Override
	public ConditionalBlock visitConditionalBlock(ConditionalBlockContext ctx) {
		ConditionalBlock cb = new ConditionalBlock(getTextLocation(ctx));
		for (QuestionContext questionContext : ctx.question()) {
			Question question = (Question) visit(questionContext);
			cb.add(question);
		}
		return cb;
	}

	@Override
	public Question visitQuestion(QuestionContext ctx) {
		String questionName = ctx.questionName.getText();
		DataType dataType = DataType.valueOf(ctx.type.getText().toUpperCase());
		String questionString = ctx.questionString.getText();
		questionString = questionString.replaceAll("\"", "");

		TextLocation textLocation = getTextLocation(ctx);
		Question question = new Question(textLocation, questionName, dataType, questionString);
		if (ctx.parent instanceof ConditionalBlockContext) {
			ConditionalBlockContext parent = (ConditionalBlockContext) ctx.parent;
			Expression condition = (Expression) visit(parent.expression());
			question.setCondition(condition);
		}
		ExpressionContext computedCtx = ctx.computed;
		if (computedCtx != null) {
			Expression computed = (Expression) visit(computedCtx);
			question.setComputed(computed);
			expressionTypeChecker.testExpression(computed);
			System.out.println(computed);
		}
		super.visitChildren(ctx);
		return question;
	}

	@Override
	public Expression visitNeEq(NeEqContext ctx) {
		String operator = ctx.operator.getText();
		Expression leftHand = (Expression) visit(ctx.leftHand);
		Expression rightHand = (Expression) visit(ctx.rightHand);
		TextLocation textLocation = getTextLocation(ctx);
		return new OperatorExpression(textLocation, leftHand, rightHand, operator);
	}

	@Override
	public Expression visitMulDiv(MulDivContext ctx) {
		String operator = ctx.operator.getText();
		Expression leftHand = (Expression) visit(ctx.leftHand);
		Expression rightHand = (Expression) visit(ctx.rightHand);
		TextLocation textLocation = getTextLocation(ctx);
		return new OperatorExpression(textLocation, leftHand, rightHand, operator);
	}

	@Override
	public Expression visitLtGtLeGe(LtGtLeGeContext ctx) {
		String operator = ctx.operator.getText();
		Expression leftHand = (Expression) visit(ctx.leftHand);
		Expression rightHand = (Expression) visit(ctx.rightHand);
		TextLocation textLocation = getTextLocation(ctx);
		return new OperatorExpression(textLocation, leftHand, rightHand, operator);
	}

	@Override
	public Expression visitNot(NotContext ctx) {
		String operator = ctx.operator.getText();
		Expression leftHand = (Expression) visit(ctx.leftHand);
		Expression rightHand = (Expression) visit(ctx.rightHand);
		TextLocation textLocation = getTextLocation(ctx);
		return new OperatorExpression(textLocation, leftHand, rightHand, operator);
	}

	@Override
	public Expression visitOr(OrContext ctx) {
		String operator = ctx.operator.getText();
		Expression leftHand = (Expression) visit(ctx.leftHand);
		Expression rightHand = (Expression) visit(ctx.rightHand);
		TextLocation textLocation = getTextLocation(ctx);
		return new OperatorExpression(textLocation, leftHand, rightHand, operator);
	}

	@Override
	public Expression visitAddSub(AddSubContext ctx) {
		String operator = ctx.operator.getText();
		Expression leftHand = (Expression) visit(ctx.leftHand);
		Expression rightHand = (Expression) visit(ctx.rightHand);
		TextLocation textLocation = getTextLocation(ctx);
		return new OperatorExpression(textLocation, leftHand, rightHand, operator);
	}

	@Override
	public Expression visitAnd(AndContext ctx) {
		String operator = ctx.operator.getText();
		Expression leftHand = (Expression) visit(ctx.leftHand);
		Expression rightHand = (Expression) visit(ctx.rightHand);
		TextLocation textLocation = getTextLocation(ctx);
		return new OperatorExpression(textLocation, leftHand, rightHand, operator);
	}

	@Override
	public Expression visitBracedExpression(BracedExpressionContext ctx) {
		Expression expression = (Expression) visit(ctx.expression());
		TextLocation textLocation = getTextLocation(ctx);
		return new BracedExpression(textLocation, expression);
	}

	@Override
	public Expression visitName(NameContext ctx) {
		TextLocation textLocation = getTextLocation(ctx);
		String text = ctx.name.getText();
		return new NameExpression(textLocation, text);
	}

	private TextLocation getTextLocation(ParserRuleContext ctx) {
		Token start = ctx.getStart();
		int line = start.getLine();
		int charPositionInLine = start.getCharPositionInLine();
		return new TextLocation(line, charPositionInLine);
	}

	public List<TypeValidation> getTypeErrors() {
		List<TypeValidation> typeValidations = new ArrayList<TypeValidation>();
		typeValidations = expressionTypeChecker.getTypeErrors();
		return typeValidations;
	}
}