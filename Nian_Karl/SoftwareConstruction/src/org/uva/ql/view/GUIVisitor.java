package org.uva.ql.view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import org.uva.ql.ast.expression.literal.Identifier;
import org.uva.ql.ast.questionnaire.Form;
import org.uva.ql.ast.questionnaire.Questionnaire;
import org.uva.ql.ast.statement.Block;
import org.uva.ql.ast.statement.IfElseStatement;
import org.uva.ql.ast.statement.IfStatement;
import org.uva.ql.ast.statement.QuestionComputed;
import org.uva.ql.ast.statement.QuestionNormal;
import org.uva.ql.ast.statement.Statement;
import org.uva.ql.ast.type.BoolType;
import org.uva.ql.ast.type.IntType;
import org.uva.ql.ast.type.StrType;
import org.uva.ql.ast.type.UndefinedType;
import org.uva.ql.ast.value.UndefinedValue;
import org.uva.ql.view.component.ExprQuestionItem;
import org.uva.ql.view.component.QuestionItem;
import org.uva.ql.view.listener.DoneButtonListener;
import org.uva.ql.view.listener.WidgetListener;
import org.uva.ql.view.panel.IfElseQuestionPanel;
import org.uva.ql.view.panel.IfQuestionPanel;
import org.uva.ql.view.panel.Panel;
import org.uva.ql.view.widget.CheckBox;
import org.uva.ql.view.widget.NumberTextField;
import org.uva.ql.view.widget.TextField;
import org.uva.ql.view.widget.Widget;
import org.uva.ql.visitor.QuestionnaireVisitor;
import org.uva.ql.visitor.StatementVisitor;
import org.uva.ql.visitor.TypeVisitor;

public class GUIVisitor implements StatementVisitor<Object>, TypeVisitor<Object>, QuestionnaireVisitor<Object> {

	private WidgetListener widgetListener;
	private FormFrame formView;

	public GUIVisitor() {
		formView = new FormFrame();
	}

	@Override
	public IfQuestionPanel visit(IfStatement ifStatement) {
		List<Panel> questionPanels = (ArrayList<Panel>) ifStatement.getIfBlock().accept(this);
		IfQuestionPanel questionPanel = new IfQuestionPanel(questionPanels, ifStatement.getExpr());
		formView.addIfQuestionPanel(questionPanel);
		return questionPanel;
	}

	@Override
	public QuestionItem visit(QuestionNormal questionStatement) {
		Widget widget = (Widget) questionStatement.getType().accept(this);
		widget.setIdentifier(questionStatement.getIdentifier());
		Identifier identifier = questionStatement.getIdentifier();
		QuestionItem questionItem = new QuestionItem(questionStatement, widget);
		formView.addQuestionPanel(questionItem);
		widgetListener.initializeValue(identifier, new UndefinedValue());
		return questionItem;
	}

	@Override
	public ExprQuestionItem visit(QuestionComputed questionComputeStatement) {
		Identifier identifier = questionComputeStatement.getIdentifier();
		Widget widget = (Widget) questionComputeStatement.getType().accept(this);
		widget.setIdentifier(identifier);
		ExprQuestionItem quetionItem = new ExprQuestionItem(questionComputeStatement, widget);
		formView.addExprQuestionItem(quetionItem);
		widgetListener.initializeValue(identifier, new UndefinedValue());
		return quetionItem;
	}

	@Override
	public List<Panel> visit(Block blockStatement) {
		List<Panel> questionPannels = new ArrayList<Panel>();
		for (Statement statement : blockStatement.getStatements()) {
			questionPannels.add((Panel) statement.accept(this));
		}
		return questionPannels;
	}

	@Override
	public FormFrame visit(Form form) {
		widgetListener = new WidgetListener(formView);
		form.getBlock().accept(this);
		JButton button = new JButton("Done");
		formView.addDoneButton(button);
		button.addActionListener(new DoneButtonListener(widgetListener.getEvaluator()));
		formView.setFrameVisible(true);
		return formView;
	}

	@Override
	public List<FormFrame> visit(Questionnaire questionnaire) {
		List<FormFrame> formViews = new ArrayList<FormFrame>();
		for (Form form : questionnaire.getForms()) {
			formViews.add((FormFrame) form.accept(this));
		}
		return formViews;
	}

	@Override
	public Widget visit(IntType node) {
		return new NumberTextField(widgetListener);
	}

	@Override
	public Widget visit(BoolType node) {
		return new CheckBox(widgetListener);
	}

	@Override
	public Widget visit(StrType node) {
		return new TextField(widgetListener);
	}

	@Override
	public Widget visit(UndefinedType undefiendType) {
		return null;
	}

	@Override
	public IfElseQuestionPanel visit(IfElseStatement ifElseStatement) {
		List<Panel> ifQuestions = (ArrayList<Panel>) ifElseStatement.getIfBlock().accept(this);
		List<Panel> elseQuestions = (ArrayList<Panel>) ifElseStatement.getElseBLock().accept(this);
		IfElseQuestionPanel questionPanel = new IfElseQuestionPanel(ifQuestions, elseQuestions,
				ifElseStatement.getExpr());
		formView.addIfQuestionPanel(questionPanel);
		return questionPanel;
	}
}
