package nl.uva.sc.encoders.qlruntime.ui;

import java.util.List;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import nl.uva.sc.encoders.ql.validation.ValidationMessage;

public class ValidationsGridPane extends GridPane {

	private final TextArea typeCheckerMessages;

	public ValidationsGridPane() {
		setAlignment(Pos.CENTER);
		setHgap(10);
		setVgap(10);
		setPadding(new Insets(25, 25, 25, 25));
		add(new Label("Type Checker errors/warnings:"), 0, 0);

		typeCheckerMessages = new TextArea();
		typeCheckerMessages.setPrefSize(650, 500);
		typeCheckerMessages.setEditable(false);
		typeCheckerMessages.setStyle("-fx-text-fill: red;");

		add(typeCheckerMessages, 0, 1);
	}

	public void showValidations(List<? extends ValidationMessage> validationMessages) {
		typeCheckerMessages.clear();
		for (ValidationMessage validationMessage : validationMessages) {
			typeCheckerMessages.appendText(validationMessage.toString());
		}
	}
}
