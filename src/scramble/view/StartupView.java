package scramble.view;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import scramble.WordScrambleGame;
import scramble.controller.StartupController;
import scramble.element.Difficulty;
import scramble.element.User;

public class StartupView extends Stage {

	private static String startupViewTitle = "Welcome to Word Scramble!";
	private static List<Difficulty> difficultyList;
	private static Label initialsLabel;
	private static TextField userTextField;
	private static Label difficultyLabel;
	private static ComboBox<Difficulty> difficultyDropdown;
	private static GridPane grid;
	private static Button beginButton;

	public StartupView() {
		super.setTitle(startupViewTitle);
		initGrid();
		initIntials();
		initUserText();
		initDifficultyLabel();
		initDifficultyDropdown();
		initBegin();

		Scene scene = new Scene(grid, 400, 400);
		scene.getStylesheets().add(WordScrambleGame.class.getResource("application.css").toExternalForm());
		
		super.setScene(scene);
	}

	private void initBegin() {
		beginButton = new Button("Begin Game");
		grid.add(beginButton, 1, 3);

		beginButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				StartupController.startGame();
			}
		});
	}

	private void initDifficultyDropdown() {
		addDifficulties();
		difficultyDropdown = new ComboBox<Difficulty>();
		difficultyDropdown.getItems().addAll(difficultyList);
		grid.add(difficultyDropdown, 1, 2);
	}

	private void initDifficultyLabel() {
		difficultyLabel = new Label("Select Difficulty:");
		grid.add(difficultyLabel, 0, 2);
	}

	private void initUserText() {
		userTextField = new TextField();
		userTextField.setMaxWidth(50);
		grid.add(userTextField, 1, 1);
	}

	private void initIntials() {
		initialsLabel = new Label("Enter your initials:");
		grid.add(initialsLabel, 0, 1);
	}

	private void initGrid() {
		grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
	}

	protected List<Difficulty> getDiffList() {
		return difficultyList;
	}

	protected void setDiffList(List<Difficulty> diffList) {
		StartupView.difficultyList = diffList;
	}

	protected Label getInitialsLabel() {
		return initialsLabel;
	}

	protected void setInitialsLabel(Label initialsLabel) {
		StartupView.initialsLabel = initialsLabel;
	}

	public TextField getUserTextField() {
		return userTextField;
	}

	protected void setUserTextField(TextField userTextField) {
		StartupView.userTextField = userTextField;
	}

	protected Label getDifficultyLabel() {
		return difficultyLabel;
	}

	protected void setDifficultyLabel(Label difficultyLabel) {
		StartupView.difficultyLabel = difficultyLabel;
	}

	public ComboBox<Difficulty> getDifficultyDropdown() {
		return difficultyDropdown;
	}

	protected void setDifficultyDropdown(ComboBox<Difficulty> difficultyDropdown) {
		StartupView.difficultyDropdown = difficultyDropdown;
	}

	protected void setStartupViewTitle(String startupViewTitle) {
		StartupView.startupViewTitle = startupViewTitle;
	}

	public String getStartupViewTitle() {
		return startupViewTitle;
	}

	private void addDifficulties() {
		difficultyList = new ArrayList<Difficulty>();
		difficultyList.add(Difficulty.EASY);
		difficultyList.add(Difficulty.MEDIUM);
		difficultyList.add(Difficulty.HARD);
	}
}
