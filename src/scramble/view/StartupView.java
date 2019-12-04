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

	/**
	 * Constructor for view at the start of the game
	 */
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

	/**
	 * Initializes the begin button that starts the game
	 */
	private void initBegin() {
		System.out.println("Initializing begin button");
		beginButton = new Button("Begin Game");
		grid.add(beginButton, 1, 3);
	}
	
	/**
	 * Initializes the dropdown for difficulty selection
	 */
	private void initDifficultyDropdown() {
		System.out.println("Initializing difficulty dropdown");
		addDifficulties();
		difficultyDropdown = new ComboBox<Difficulty>();
		difficultyDropdown.getItems().addAll(difficultyList);
		grid.add(difficultyDropdown, 1, 2);
	}

	/**
	 * Initializes the difficulty label
	 */
	private void initDifficultyLabel() {
		System.out.println("Initializing difficulty label");
		difficultyLabel = new Label("Select Difficulty:");
		grid.add(difficultyLabel, 0, 2);
	}

	/**
	 * Initializes the input for the user's initials
	 */
	private void initUserText() {
		System.out.println("Initializing user text field");
		userTextField = new TextField();
		userTextField.setMaxWidth(50);
		grid.add(userTextField, 1, 1);
	}

	/**
	 * Initializes label asking for initials
	 */
	private void initIntials() {
		System.out.println("Initializing initials label");
		initialsLabel = new Label("Enter your initials:");
		grid.add(initialsLabel, 0, 1);
	}

	/**
	 * Initializes the grid that holds page node elements
	 */
	private void initGrid() {
		grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
	}

	/**
	 * Adds difficulties to be available to the user for selection
	 */
	private void addDifficulties() {
		difficultyList = new ArrayList<Difficulty>();
		difficultyList.add(Difficulty.EASY);
		difficultyList.add(Difficulty.MEDIUM);
		difficultyList.add(Difficulty.HARD);
	}
	
	public Button getBeginButton() {
		return beginButton;
	}

	public TextField getUserTextField() {
		return userTextField;
	}

	public ComboBox<Difficulty> getDifficultyDropdown() {
		return difficultyDropdown;
	}
}
