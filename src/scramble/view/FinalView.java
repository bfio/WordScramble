package scramble.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import scramble.WordScrambleGame;
import scramble.controller.StartupController;
import scramble.model.ScrambleModel;

public class FinalView extends Stage {
	
	private static GridPane grid;
	private static Label userLabel;
	private static Label difficultyLabel;
	private static Label finalScoreLabel;
	private static Button newGameButton;

	public FinalView() {
		super.setTitle("Final Results");
		initGrid();
		initUserLabel();
		initDifficultyLabel();
		initFinalScoreLabel();
		initNewGameButton();

		Scene scene = new Scene(grid, 400, 400);
		scene.getStylesheets().add(WordScrambleGame.class.getResource("application.css").toExternalForm());
		
		super.setScene(scene);
	}
	
	private void initNewGameButton() {
		newGameButton = new Button("New Game");
		grid.add(newGameButton, 0, 3);
	}

	private void initFinalScoreLabel() {
		finalScoreLabel = new Label("Final Score: " + ScrambleModel.getCurrentScore().toString());
		grid.add(finalScoreLabel, 0, 2);
	}

	private void initDifficultyLabel() {
		difficultyLabel = new Label("Difficulty: " + ScrambleModel.getCurrentDifficulty());
		grid.add(difficultyLabel, 0, 1);
	}

	private void initUserLabel() {
		userLabel = new Label("User: " + ScrambleModel.getCurrentUser().toString());
		grid.add(userLabel, 0, 0);
	}

	private void initGrid() {
		grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
	}
	
	public static Button getNewGameButton() {
		return newGameButton;
	}

	
}
