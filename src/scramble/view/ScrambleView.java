package scramble.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import scramble.WordScrambleGame;
import scramble.model.ScrambleModel;

public class ScrambleView extends Stage {

	private static Label timer;
	private static Label score;
	private static Label scrambled;
	private static String scrambledString;
	private static Node input;
	private static Button finishGameButton;
	private static GridPane grid;

	public ScrambleView() {
		super.setTitle("Word Scramble");
		initGrid();
		initScore();
		initScrambled();
		initInput();
		initFinish();
		initTimer();
		Scene scene = new Scene(grid, 400, 400);
		scene.getStylesheets().add(WordScrambleGame.class.getResource("application.css").toExternalForm());
		
		super.setScene(scene);
	}

	private void initFinish() {
		System.out.println("Initializing finish button");
		finishGameButton = new Button("Finish game");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_CENTER);
		hbBtn.getChildren().add(finishGameButton);
		grid.add(hbBtn, 1, 4);
	}

	private void initInput() {
		System.out.println("Initializing input");
		input = new TextField();
		grid.add(input, 1, 3);
	}
	
	public void replaceInput() {
		input = new Label("Game over!");
		grid.add(input, 1, 3);
	}

	private void initScrambled() {
		System.out.println("Initializing scrambled phrase");
		scrambled = new Label("Scrambled");
		scrambled.setPrefWidth(100);
		scrambled.setAlignment(Pos.CENTER);
		grid.add(scrambled, 1, 1);
	}

	private void initScore() {
		System.out.println("Initializing score");
		score = new Label("Score: " + ScrambleModel.getCurrentScore().toString());
		score.setPrefWidth(75);
		score.alignmentProperty().set(Pos.CENTER);
		grid.add(score, 3, 0);
	}

	private void initGrid() {
		System.out.println("Initializing grid");
		grid = new GridPane();
		grid.setPadding(new Insets(25, 25, 25, 25));
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setAlignment(Pos.CENTER);
	}

	public Label getTimer() {
		return timer;
	}

	public void setTimer(Label timer) {
		ScrambleView.timer = timer;
	}

	public GridPane getGrid() {
		return grid;
	}

	private void initTimer() {
		System.out.println("Initializing timer");
		timer = new Label("Timer starting!");
		timer.setPrefWidth(100);
		timer.setPadding(new Insets(15));
		grid.add(timer, 0, 0);
	}

	public Label getScore() {
		return score;
	}

	public void setScore(Label score) {
		ScrambleView.score = score;
	}

	public Label getScrambled() {
		return scrambled;
	}

	public void setScrambled(Label scrambled) {
		ScrambleView.scrambled = scrambled;
	}

	public Node getInput() {
		return input;
	}

	public void setInput(Node input) {
		ScrambleView.input = input;
	}

	public Button getFinishGameButton() {
		return finishGameButton;
	}

	public void setFinishGameButton(Button finishGameButton) {
		ScrambleView.finishGameButton = finishGameButton;
	}

	public String getScrambledString() {
		return scrambledString;
	}

	public void setScrambledString(String scrambledString) {
		//ScrambleView.scrambledString = ScrambleController.scrambleString(scrambledString);
	}
}