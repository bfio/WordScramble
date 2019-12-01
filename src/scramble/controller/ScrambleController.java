package scramble.controller;

import java.util.Timer;
import java.util.TimerTask;

import scramble.Scrambler;
import scramble.WordScrambleGame;
import scramble.element.Score;
import scramble.view.ScrambleView;

public class ScrambleController implements Scrambler {

	public static void checkInput(String input, String correct) {
		input = input.trim().toLowerCase();
		correct = correct.trim().toLowerCase();

		if (input.equals(correct)) {
			updateScore(input);
		} else {
			//Handle incorrect input
		}
	}

	private static void updateScore(String input) {
		Score updatedScore = WordScrambleGame.getCurrentScore();
		updatedScore.addPoints(Scrambler.calculateValue(input));
		ScrambleView.getScore().setText("Score: " + updatedScore.getPoints().toString());
	}

	public static void initializeScore() {
		WordScrambleGame.setCurrentScore(new Score(
				WordScrambleGame.getCurrentUser(), 0));
	}

	public static Integer initializeStartingTime() {
		switch (WordScrambleGame.getCurrentDifficulty()) {
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

	public static void runTimer(Integer duration) {
		new Timer().schedule(new TimerTask() {

			@Override
			public void run() {
				if (duration >= 0) {
					Integer updatedTime = duration;
					updatedTime--;
					ScrambleView.getTimer().setText("Time remaining: " + duration);
					
					
					duration = duration.intValue() - 1;
					System.out.println("Time Left: " + duration);
					//ScrambleView.getTimer().setText(new String(timeLeft.toString())); 
					ScrambleView.setTimeRemaining(duration);
				} else {
					this.cancel();
				}
			}
		}, 0, 1000);
	}



}
