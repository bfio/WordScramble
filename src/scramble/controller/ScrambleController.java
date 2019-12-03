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

	private void initializeScrambled() {
		scrambleView.getGrid().getChildren().remove(scrambleView.getScrambled());
		scrambleView.replaceScrambled(Scrambler.scrambleWord((ScrambleModel.getCurrentScrambleList().get(ScrambleModel.getCurrentIteration()))));
	}

	private void initializeScrambledList() {
		try {
			ScrambleModel.setCurrentScrambleList(new DatabaseDAO(scrambleModel).retrieveScrambleList());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void initializeFinish() {
		scrambleView.getFinishGameButton().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				System.out.println("Ending game");
				finishGame();
			}
		});
	}

	public void checkInput(String input, String correct) {
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
		} else {
			//Handle incorrect input
		}
	}

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

	private void recordScore() throws IOException {
		ScoreDAO scoreDAO = new ScoreDAO();
		scoreDAO.writeScore(ScrambleModel.getCurrentScore());
	}

	private void updateScore(String input) {
		Score updatedScore = ScrambleModel.getCurrentScore();
		updatedScore.addPoints(Scrambler.calculateValue(input, ScrambleModel.getCurrentDifficulty()));
		scrambleView.getScore().setText("Score: " + updatedScore.getPoints().toString());
	}

	public void initializeScore() {
		ScrambleModel.getCurrentScore();
		System.out.println("Intializing score");
	}

	public void initializeInput() {
		System.out.println("Initializing input");
		scrambleView.getInput().setOnKeyPressed((final KeyEvent keyEvent) -> {
			if (keyEvent.getCode() == KeyCode.ENTER) {
				checkInput(scrambleView.getInput().getText(), ScrambleModel.getCurrentScrambleList().get(ScrambleModel.getCurrentIteration()));
				((TextInputControl) scrambleView.getInput()).clear();
			}
		});
	}

	public void initializeStartingTime() {
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
	
	

	public void runTimer() {
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

	public ScrambleView getScrambleView() {
		return scrambleView;
	}



}
