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
	
	private void initNewGameButton() {
		newGameButton = new Button("New Game");
		newGameButton.setAlignment(Pos.CENTER);
		grid.add(newGameButton, 0, 4, 2, 2);
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

	private void initGrid() {
		grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
	}
	
	public Button getNewGameButton() {
		return newGameButton;
	}

	
}
