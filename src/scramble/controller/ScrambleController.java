package scramble.controller;

import java.util.Timer;
import java.util.TimerTask;

import scramble.Scrambler;
import scramble.WordScrambleGame;
import scramble.element.Score;
import scramble.element.User;
import scramble.model.ScrambleModel;
import scramble.view.ScrambleView;

public class ScrambleController implements Scrambler {

	private ScrambleView scrambleView;
	private ScrambleModel scrambleModel;
	
	public ScrambleController() {
		this.setScrambleView(new ScrambleView());
		this.scrambleModel = new ScrambleModel();
	}
	
	public void checkInput(String input, String correct) {
		input = input.trim().toLowerCase();
		correct = correct.trim().toLowerCase();

		if (input.equals(correct)) {
			updateScore(input);
		} else {
			//Handle incorrect input
		}
	}

	private void updateScore(String input) {
		Score updatedScore = scrambleModel.getCurrentScore();
		updatedScore.addPoints(Scrambler.calculateValue(input, scrambleModel.getCurrentDifficulty()));
		ScrambleView.getScore().setText("Score: " + updatedScore.getPoints().toString());
	}

	public void initializeScore() {
		scrambleModel.setCurrentScore(new Score(
				scrambleModel.getCurrentUser(), 0));
	}

	public Integer initializeStartingTime() {
		switch (scrambleModel.getCurrentDifficulty()) {
		case EASY: {
			return new Integer(60);
		}
		case MEDIUM: {
			return new Integer(45);
		}
		case HARD: {
			return new Integer(30);
		}
		default: {
			return new Integer(60);
		}
		}
	}

	public void runTimer(Integer duration) {
		new Timer().schedule(new TimerTask() {

			@Override
			public void run() {
				if (duration >= 0) {
					Integer updatedTime = duration;
					updatedTime--;
					ScrambleView.getTimer().setText("Time remaining: " + duration);
					updatedTime = updatedTime.intValue() - 1;
					System.out.println("Time Left: " + duration);
					//ScrambleView.getTimer().setText(new String(timeLeft.toString())); 
					ScrambleView.setTimeRemaining(duration);
				} else {
					this.cancel();
				}
			}
		}, 0, 1000);
	}

	public String scrambleString(String scrambledString) {
		return Scrambler.scrambleWord(scrambledString);
	}

	public ScrambleView getScrambleView() {
		return scrambleView;
	}

	public void setScrambleView(ScrambleView scrambleView) {
		this.scrambleView = scrambleView;
	}



}
