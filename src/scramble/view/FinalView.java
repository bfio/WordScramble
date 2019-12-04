package scramble.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import scramble.WordScrambleGame;
import scramble.model.ScrambleModel;

public class FinalView extends Stage {
	
	private static GridPane grid;
	private static Label userLabel;
	private static Label difficultyLabel;
	private static Label finalScoreLabel;
	private static Button newGameButton;

	/**
	 * Constructor for the game's end screen
	 */
	public FinalView() {
		WordScrambleGame.getPrimaryStage().setTitle("Final Results");
		initGrid();
		initUserLabel();
		initDifficultyLabel();
		initFinalScoreLabel();
		initNewGameButton();
		//initLeaderboard();

		Scene scene = new Scene(grid, 400, 400);
		scene.getStylesheets().add(WordScrambleGame.class.getResource("application.css").toExternalForm());
		
		super.setScene(scene);
	}
	
	/**
	 * Initializes the button that starts a new game
	 */
	private void initNewGameButton() {
		newGameButton = new Button("New Game");
		newGameButton.setAlignment(Pos.CENTER);
		grid.add(newGameButton, 0, 4, 2, 2);
	}

	/**
	 * Initializes the label that displays the final score
	 */
	private void initFinalScoreLabel() {
		finalScoreLabel = new Label("Final Score: " + ScrambleModel.getCurrentScore().toString());
		grid.add(finalScoreLabel, 0, 2);
	}

	/**
	 * Initializes the label that displays the game's difficulty
	 */
	private void initDifficultyLabel() {
		difficultyLabel = new Label("Difficulty: " + ScrambleModel.getCurrentDifficulty());
		grid.add(difficultyLabel, 0, 1);
	}

	/**
	 * Initializes the label that displays the user that completed the game
	 */
	private void initUserLabel() {
		userLabel = new Label("User: " + ScrambleModel.getCurrentUser().toString());
		grid.add(userLabel, 0, 0);
	}
	
	/**
	 * Intializes the leaderboard placeholders. Currently deprecated, not fully implemented.
	 */
	@Deprecated
	private void initLeaderboard() {
		Label leaderboard = new Label("Leaderboard");
		grid.add(leaderboard, 2, 0);
		Label leaderA = new Label("Leader A");
		grid.add(leaderA, 2, 1);
		Label leaderB = new Label("Leader B");
		grid.add(leaderB, 2, 2);
		Label leaderC = new Label("Leader C");
		grid.add(leaderC, 2, 3);
	}

	/**
	 * Initializes the grid pane that holds node elements
	 */
	private void initGrid() {
		grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
	}
	
	/**
	 * Retrieves the new game button
	 * @return New game button
	 */
	public Button getNewGameButton() {
		return newGameButton;
	}

	
}
