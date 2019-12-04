package scramble.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import scramble.WordScrambleGame;
import scramble.model.ScrambleModel;

public class ScrambleView extends Stage {

	private static Label timer;
	private static Label score;
	private static Label scrambled;
	private static String scrambledString;
	private static TextField input;
	private static Button finishGameButton;
	private static GridPane grid;

	/**
	 * Constructor for the view used for the game
	 */
	public ScrambleView() {
		WordScrambleGame.getPrimaryStage().setTitle("Word Scramble");
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

	/**
	 * Initializes the button to finish the game
	 */
	private void initFinish() {
		System.out.println("Initializing finish button");
		finishGameButton = new Button("Finish game");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_CENTER);
		hbBtn.getChildren().add(finishGameButton);
		grid.add(hbBtn, 1, 4);
	}

	/**
	 * Initializes the user input text field
	 */
	private void initInput() {
		System.out.println("Initializing input");
		input = new TextField();
		grid.add(input, 1, 3);
	}
	
	/**
	 * Replaces the user input text field with one that displays a game over message and removes its action
	 */
	public void replaceInput() {
		input = new TextField("Game over!");
		input.setOnAction(null);
		grid.add(input, 1, 3);
	}

	/**
	 * Initializes the scrambled phrase displayed to the user
	 */
	private void initScrambled() {
		System.out.println("Initializing scrambled phrase");
		scrambled = new Label();
		scrambled.setPrefWidth(100);
		scrambled.setAlignment(Pos.CENTER);
		grid.add(scrambled, 1, 1);
	}
	
	/**
	 * Replaces the scrambled phrase displayed
	 * @param replaced New String to display
	 */
	public void replaceScrambled(String replaced) {
		scrambled = new Label(replaced);
		scrambled.setPrefWidth(100);
		scrambled.setAlignment(Pos.CENTER);
		grid.add(scrambled, 1, 1);
	}

	/**
	 * Initializes the displayed score
	 */
	private void initScore() {
		System.out.println("Initializing score");
		score = new Label("Score: " + ScrambleModel.getCurrentScore().toString());
		score.setPrefWidth(75);
		score.alignmentProperty().set(Pos.CENTER);
		grid.add(score, 3, 0);
	}

	/**
	 * Initializes the grid pane that holds page nodes
	 */
	private void initGrid() {
		System.out.println("Initializing grid");
		grid = new GridPane();
		grid.setPadding(new Insets(25, 25, 25, 25));
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setAlignment(Pos.CENTER);
	}

	/**
	 * Retrieves the timer element
	 * @return Timer counting down time remaining
	 */
	public Label getTimer() {
		return timer;
	}

	/**
	 * Sets the timer element
	 * @param timer New timer label to be displayed
	 */
	public void setTimer(Label timer) {
		ScrambleView.timer = timer;
	}
	
	/**
	 * Initializes the timer element
	 */
	private void initTimer() {
		System.out.println("Initializing timer");
		timer = new Label("Timer starting!");
		timer.setPrefWidth(100);
		timer.setPadding(new Insets(15));
		grid.add(timer, 0, 0);
	}

	public GridPane getGrid() {
		return grid;
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

	public TextField getInput() {
		return input;
	}

	public void setInput(TextField input) {
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
}