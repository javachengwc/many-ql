package nl.uva.se.ql.gui.widgets.panes;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import nl.uva.se.ql.ast.form.Form;
import nl.uva.se.ql.ast.statement.CalculatedQuestion;
import nl.uva.se.ql.ast.statement.Condition;
import nl.uva.se.ql.ast.statement.Question;
import nl.uva.se.ql.gui.mediators.IMediator;
import nl.uva.se.ql.gui.widgets.boxes.ConditionBox;
import nl.uva.se.ql.gui.widgets.boxes.QuestionBox;

public class QuestionPane extends BorderPane {

	private VBox vbox;
	private final Form form;	
	private final IMediator mediator;

	public QuestionPane(Form form, IMediator mediator) {
		this.form = form;
		this.mediator = mediator;
		vbox = new VBox();		
		this.setLeft(vbox);			
	}

	public void addCondition(Condition condition) {
		ConditionBox conditionBox = new ConditionBox(condition);		
		vbox.getChildren().add(conditionBox);
	}

	public void addConditionBox(ConditionBox conditionBox) {
		conditionBox.managedProperty().bind(conditionBox.visibleProperty()); 
		conditionBox.setVisible(false);
		mediator.registerCondition(conditionBox);
		vbox.getChildren().add(conditionBox);
	}

	public void addQuestion(Question question) {
		QuestionBox questionBox = new QuestionBox(question, mediator);		
		vbox.getChildren().add(questionBox);
	}
	
	public void addQuestion(CalculatedQuestion question){
		QuestionBox questionBox = new QuestionBox(question, mediator);		
		vbox.getChildren().add(questionBox);
	}

	public void addQuestionBox(QuestionBox questionBox) {
		vbox.getChildren().add(questionBox);
	}	
	
	public Form getForm() {
		return this.form;
	}
}