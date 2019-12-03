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

	private static List<Difficulty> difficultyList;
	private static Label initialsLabel;
	private static TextField userTextField;
	private static Label difficultyLabel;
	private static ComboBox<Difficulty> difficultyDropdown;
	private static GridPane grid;
	private static Button beginButton;

	public StartupView() {
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
		System.out.println("Initializing begin button");
		beginButton = new Button("Begin Game");
		grid.add(beginButton, 1, 3);
	}

	public Button getBeginButton() {
		return beginButton;
	}

	protected void setBeginButton(Button beginButton) {
		StartupView.beginButton = beginButton;
	}

	private void initDifficultyDropdown() {
		System.out.println("Initializing difficulty dropdown");
		addDifficulties();
		difficultyDropdown = new ComboBox<Difficulty>();
		difficultyDropdown.getItems().addAll(difficultyList);
		grid.add(difficultyDropdown, 1, 2);
	}

	private void initDifficultyLabel() {
		System.out.println("Initializing difficulty label");
		difficultyLabel = new Label("Select Difficulty:");
		grid.add(difficultyLabel, 0, 2);
	}

	private void initUserText() {
		System.out.println("Initializing user text field");
		userTextField = new TextField();
		userTextField.setMaxWidth(50);
		grid.add(userTextField, 1, 1);
	}

	private void initIntials() {
		System.out.println("Initializing initials label");
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

	private void addDifficulties() {
		difficultyList = new ArrayList<Difficulty>();
		difficultyList.add(Difficulty.EASY);
		difficultyList.add(Difficulty.MEDIUM);
		difficultyList.add(Difficulty.HARD);
	}

	public TextField getUserTextField() {
		return userTextField;
	}

	public ComboBox<Difficulty> getDifficultyDropdown() {
		return difficultyDropdown;
	}
}
