package scramble.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import scramble.WordScrambleGame;
import scramble.controller.FinalController;

public class FinalView {
	
	public Scene getScene() {
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		
		Label user = new Label("User: " + FinalController.getUserString());
		grid.add(user, 0, 0);
		
		Label difficulty = new Label("Difficulty: " + FinalController.getDifficultyString());
		grid.add(difficulty, 0, 1);
		
		Label finalScore = new Label("Final Score: " + FinalController.getFinalScoreString());
		grid.add(finalScore, 0, 2);
		
		Button newGame = new Button("New Game");
		newGame.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				WordScrambleGame.changeScene(new StartupView().getStartupScene());;
			}
		});
		grid.add(newGame, 0, 3);

		Scene scene = new Scene(grid, 400, 400);
		scene.getStylesheets().add(WordScrambleGame.class.getResource("application.css").toExternalForm());
		
		return scene;
	}
	
}
