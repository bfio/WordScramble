package scramble.view;

import java.util.Timer;
import java.util.TimerTask;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import scramble.WordScrambleGame;
import scramble.controller.ScrambleController;
import scramble.element.CountdownTimer;
import scramble.element.Score;

public class ScrambleView extends Stage {
	
	private static Label timer;
	private static Label score;
	private static Label scrambled;
	private static TextField input;
	private static Button finishGameButton;
	private static String scoreString;
	private static Integer startingTime;
	private static Integer timeRemaining;
	
	public Scene getScrambleView() {
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(25, 25, 25, 25));
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setAlignment(Pos.CENTER);

		timer = new Label();
		timer.setPrefWidth(75);
		timeRemaining = ScrambleController.initializeStartingTime();
		ScrambleController.runTimer(ScrambleView.getStartingTime());
		timer.setText(ScrambleView.getTimeRemaining().toString());
		grid.add(timer, 0, 0);
		
		ScrambleController.initializeScore();
		setScoreString(WordScrambleGame.getCurrentScore().getPoints().toString());
		score = new Label("Score: " + scoreString);
		score.setPrefWidth(75);
		score.alignmentProperty().set(Pos.CENTER);
		grid.add(score, 3, 0);
		
		scrambled = new Label("Scrambled");
		scrambled.setAlignment(Pos.CENTER);
		grid.add(scrambled, 1, 1, 2, 1);
		
		input = new TextField();
		input.setOnKeyPressed((final KeyEvent keyEvent) -> {
	        if (keyEvent.getCode() == KeyCode.ENTER) {
	        		ScrambleController.checkInput(input.getText(), scrambled.getText());
	        		input.clear();
	        }
		});
		
		grid.add(input, 1, 3, 2, 1);
		
		finishGameButton = new Button("Finish game");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_CENTER);
		hbBtn.getChildren().add(finishGameButton);
		grid.add(hbBtn, 1, 4);
		
		finishGameButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				WordScrambleGame.changeScene(new FinalView().getScene());
			}
		});
				
		Scene scene = new Scene(grid, 400, 400);
		return scene;
	}

	public static Label getTimer() {
		return timer;
	}

	public static void setTimer(Label timer) {
		ScrambleView.timer = timer;
	}

	public static Label getScore() {
		return score;
	}

	public static void setScore(Label score) {
		ScrambleView.score = score;
	}

	public static Label getScrambled() {
		return scrambled;
	}

	public static void setScrambled(Label scrambled) {
		ScrambleView.scrambled = scrambled;
	}

	public static TextField getInput() {
		return input;
	}

	public static void setInput(TextField input) {
		ScrambleView.input = input;
	}

	public static Button getFinishGameButton() {
		return finishGameButton;
	}

	public static void setFinishGameButton(Button finishGameButton) {
		ScrambleView.finishGameButton = finishGameButton;
	}

	public static String getScoreString() {
		return scoreString;
	}

	public static void setScoreString(String scoreString) {
		ScrambleView.scoreString = scoreString;
	}

	public static Integer getStartingTime() {
		return startingTime;
	}

	public static void setStartingTime(Integer startingTime) {
		ScrambleView.startingTime = startingTime;
	}

	public static Integer getTimeRemaining() {
		return timeRemaining;
	}

	public static void setTimeRemaining(Integer timeRemaining) {
		ScrambleView.timeRemaining = timeRemaining;
	}
}