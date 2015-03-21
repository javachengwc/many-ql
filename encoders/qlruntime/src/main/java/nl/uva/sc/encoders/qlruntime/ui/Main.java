package nl.uva.sc.encoders.qlruntime.ui;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import nl.uva.sc.encoders.qlruntime.ui.handler.ChooseInputButtonHandler;
import nl.uva.sc.encoders.qlruntime.ui.handler.ParseButtonHandler;
import nl.uva.sc.encoders.qlruntime.ui.handler.ParseButtonHandler.InputFileTextCallback;
import nl.uva.sc.encoders.qlruntime.ui.handler.ParseButtonHandler.ShowwNodeCallback;

public class Main extends Application {

	public static final String DEFAULT_INPUT_FILE_DIRECTORY = "ql/";

	public static final String DEFAULT_INPUT_FILE_NAME = "input_form.ql";

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Questionnaire");
		primaryStage.getIcons().add(new Image("questionnaire.png"));
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		String defaultLocation = DEFAULT_INPUT_FILE_DIRECTORY + DEFAULT_INPUT_FILE_NAME;
		final TextField inputFileTextField = new TextField(defaultLocation);
		Button chooseInputButton = new Button("Choose input file...");
		Button parseButton = new Button("Parse");
		grid.add(inputFileTextField, 0, 0);
		grid.add(chooseInputButton, 1, 0);
		grid.add(parseButton, 2, 0);

		chooseInputButton.setOnAction(new ChooseInputButtonHandler(inputFileTextField, defaultLocation));

		StackPane stackPane = new StackPane();
		InputFileTextCallback inputFileTextCallback = () -> inputFileTextField.getText();
		ShowwNodeCallback showwNodeCallback = nodeToShow -> showNode(stackPane, nodeToShow);
		parseButton.setOnAction(new ParseButtonHandler(inputFileTextCallback, showwNodeCallback));

		grid.add(stackPane, 0, 1, 3, 1);

		Scene scene = new Scene(grid, 750, 600);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void showNode(StackPane stackPane, Node nodeToShow) {
		ObservableList<Node> stackPaneChildren = stackPane.getChildren();
		stackPaneChildren.clear();
		stackPaneChildren.add(nodeToShow);
	}
}