package scramble.controller;

import java.io.IOException;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;
import scramble.Scrambler;
import scramble.WordScrambleGame;
import scramble.DAO.DatabaseDAO;
import scramble.DAO.ScoreDAO;
import scramble.element.Score;
import scramble.model.ScrambleModel;
import scramble.view.FinalView;
import scramble.view.ScrambleView;

public class ScrambleController implements Scrambler {

	private ScrambleView scrambleView;
	private ScrambleModel scrambleModel;

	/**
	 * Constructor for the controller
	 * @param scrambleView View to be controlled
	 * @param scrambleModel Model to take data from
	 */
	public ScrambleController(ScrambleView scrambleView, ScrambleModel scrambleModel) {
		this.scrambleView = scrambleView;
		this.scrambleModel = scrambleModel;
		initializeScore();
		initializeInput();
		initializeScrambledList();
		initializeScrambled();
		initializeFinish();
		runTimer();
	}
	
	/**
	 * Checks the input against a correct term and handles it accordingly through a comparison
	 * @param input The user String to be checked
	 * @param correct The correct String the user is attempting to match
	 */
	private void checkInput(String input, String correct) {
		input = input.trim().toLowerCase();
		correct = correct.trim().toLowerCase();
		System.out.println("Checking input " + input + " against correct");

		if (ScrambleModel.getCurrentTime() <= 0) {
			scrambleView.getGrid().getChildren().remove(scrambleView.getInput());
			scrambleView.getGrid().getChildren().add(new Label("Game over!"));
			finishGame();
		}
		
		if (input.equals(correct)) {
			updateScore(input);
			ScrambleModel.setCurrentIteration(ScrambleModel.getCurrentIteration() + 1);
			scrambleView.getGrid().getChildren().remove(scrambleView.getScrambled());
			scrambleView.replaceScrambled(Scrambler.scrambleWord(ScrambleModel.getCurrentScrambleList().get(ScrambleModel.getCurrentIteration())));
		}
	}
	
	/**
	 * Records the score and sends the program to the final view
	 */
	private void finishGame() {
		try {
			recordScore();
		} catch (IOException e) {
			e.printStackTrace();
		}
		FinalView finalView = new FinalView();
		new FinalController(finalView, scrambleModel);
		WordScrambleGame.changeScene(finalView.getScene());
	}

	/**
	 * Records the score of the current game to the score database using a DAO
	 * @throws IOException Thrown if database is not found
	 */
	private void recordScore() throws IOException {
		ScoreDAO scoreDAO = new ScoreDAO();
		scoreDAO.writeScore(ScrambleModel.getCurrentScore());
	}

	/**
	 * Updates the score of the current game
	 * @param input String used to calculate points earned
	 */
	private void updateScore(String input) {
		Score updatedScore = ScrambleModel.getCurrentScore();
		updatedScore.addPoints(Scrambler.calculateValue(input, ScrambleModel.getCurrentDifficulty()));
		scrambleView.getScore().setText("Score: " + updatedScore.getPoints().toString());
	}
	
	/**
	 * Runs the timer that counts down to zero
	 */
	private void runTimer() {
		initializeStartingTime();
		int startTime = ScrambleModel.getCurrentTime();
		final Timeline timeline = new Timeline();
		timeline.setCycleCount(startTime + 1);
		timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1), ev -> {
			//System.out.println("Time Left: " + ScrambleModel.getCurrentTime());
			scrambleView.getGrid().getChildren().remove(scrambleView.getTimer());
			Label newTimer = new Label("" + ScrambleModel.getCurrentTime());
			scrambleView.setTimer(newTimer);
			scrambleView.getGrid().getChildren().add(scrambleView.getTimer());
			ScrambleModel.setCurrentTime(ScrambleModel.getCurrentTime() - 1);
			
			if (ScrambleModel.getCurrentTime() < 0) {
				scrambleView.getGrid().getChildren().remove(scrambleView.getInput());
				scrambleView.replaceInput();
			}
			
		}));
		timeline.play();
	}

	/**
	 * Initializes the scrambled string presented to the user
	 */
	private void initializeScrambled() {
		scrambleView.getGrid().getChildren().remove(scrambleView.getScrambled());
		scrambleView.replaceScrambled(Scrambler.scrambleWord((ScrambleModel.getCurrentScrambleList().get(ScrambleModel.getCurrentIteration()))));
	}

	/**
	 * Initializes the scrambled list that words are pulled from
	 */
	private void initializeScrambledList() {
		try {
			ScrambleModel.setCurrentScrambleList(new DatabaseDAO(scrambleModel).retrieveScrambleList());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Initializes the finish game button used to end the game
	 */
	private void initializeFinish() {
		scrambleView.getFinishGameButton().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				System.out.println("Ending game");
				finishGame();
			}
		});
	}

	/**
	 * Initializes the score displayed to the user
	 */
	private void initializeScore() {
		ScrambleModel.getCurrentScore();
		System.out.println("Intializing score");
	}

	/**
	 * Initializes the user input text field and the action for a press of enter
	 */
	private void initializeInput() {
		System.out.println("Initializing input");
		scrambleView.getInput().setOnKeyPressed((final KeyEvent keyEvent) -> {
			if (keyEvent.getCode() == KeyCode.ENTER) {
				checkInput(scrambleView.getInput().getText(), ScrambleModel.getCurrentScrambleList().get(ScrambleModel.getCurrentIteration()));
				((TextInputControl) scrambleView.getInput()).clear();
			}
		});
	}

	/**
	 * Initializes the starting time based on the selected difficulty
	 */
	private void initializeStartingTime() {
		switch (ScrambleModel.getCurrentDifficulty()) {
		case EASY: {
			ScrambleModel.setCurrentTime(60);
			break;
		}
		case MEDIUM: {
			ScrambleModel.setCurrentTime(45);
			break;
		}
		case HARD: {
			ScrambleModel.setCurrentTime(30);
			break;
		}
		default: {
			ScrambleModel.setCurrentTime(60);
			break;
		}
		}
	}

	/**
	 * Retrieves the current view for the scramble game
	 * @return The view and its child elements
	 */
	public ScrambleView getScrambleView() {
		return scrambleView;
	}
}
