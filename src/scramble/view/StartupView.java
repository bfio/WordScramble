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
import scramble.WordScrambleGame;
import scramble.controller.StartupController;
import scramble.element.Difficulty;
import scramble.element.User;

public class StartupView {

	private static String startupViewTitle = "Welcome to Word Scramble!";
	private static List<Difficulty> difficultyList;
	private static Label initialsLabel;
	private static TextField userTextField;
	private static Label difficultyLabel;
	private static ComboBox<Difficulty> difficultyDropdown;
	private static GridPane grid;
	private static Button beginButton;

	public Scene getStartupScene() {
		grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		initialsLabel = new Label("Enter your initials:");
		grid.add(initialsLabel, 0, 1);

		userTextField = new TextField();
		userTextField.setMaxWidth(50);
		grid.add(userTextField, 1, 1);

		userTextField.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				StartupController.setCurrentUser(new User(userTextField.getText()));
			}
		});

		difficultyLabel = new Label("Select Difficulty:");
		grid.add(difficultyLabel, 0, 2);

		addDifficulties();

		difficultyDropdown = new ComboBox<Difficulty>();
		difficultyDropdown.getItems().addAll(difficultyList);
		grid.add(difficultyDropdown, 1, 2);

		difficultyDropdown.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				StartupController.setCurrentDifficulty(difficultyDropdown.getValue());
			}
		});

		beginButton = new Button("Begin Game");
		grid.add(beginButton, 1, 3);

		beginButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				StartupController.startGame();
			}
		});

		Scene scene = new Scene(grid, 400, 400);
		scene.getStylesheets().add(WordScrambleGame.class.getResource("application.css").toExternalForm());

		return scene;
	}

	protected static List<Difficulty> getDiffList() {
		return difficultyList;
	}

	protected static void setDiffList(List<Difficulty> diffList) {
		StartupView.difficultyList = diffList;
	}

	protected static Label getInitialsLabel() {
		return initialsLabel;
	}

	protected static void setInitialsLabel(Label initialsLabel) {
		StartupView.initialsLabel = initialsLabel;
	}

	public static TextField getUserTextField() {
		return userTextField;
	}

	protected static void setUserTextField(TextField userTextField) {
		StartupView.userTextField = userTextField;
	}

	protected static Label getDifficultyLabel() {
		return difficultyLabel;
	}

	protected static void setDifficultyLabel(Label difficultyLabel) {
		StartupView.difficultyLabel = difficultyLabel;
	}

	public static ComboBox<Difficulty> getDifficultyDropdown() {
		return difficultyDropdown;
	}

	protected static void setDifficultyDropdown(ComboBox<Difficulty> difficultyDropdown) {
		StartupView.difficultyDropdown = difficultyDropdown;
	}

	protected static void setStartupViewTitle(String startupViewTitle) {
		StartupView.startupViewTitle = startupViewTitle;
	}

	public static String getStartupViewTitle() {
		return startupViewTitle;
	}

	private void addDifficulties() {
		difficultyList = new ArrayList<Difficulty>();
		difficultyList.add(Difficulty.EASY);
		difficultyList.add(Difficulty.MEDIUM);
		difficultyList.add(Difficulty.HARD);
	}
}
