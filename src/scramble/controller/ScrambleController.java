package scramble.controller;

import scramble.Scrambler;
import scramble.WordScrambleGame;
import scramble.element.Score;

public class ScrambleController implements Scrambler {
	
	public static void checkInput(String input, String correct) {
		input.trim();
		input.toLowerCase();
		correct.trim();
		correct.toLowerCase();
		
		if (input.equals(correct)) {
			updateScore(input);
		} else {
			//Handle incorrect input
		}
	}
	
	private static void updateScore(String input) {
		WordScrambleGame.getCurrentScore().addPoints(Scrambler.calculateValue(input));
	}

	public static void initializeScore() {
		WordScrambleGame.setCurrentScore(new Score(
				WordScrambleGame.getCurrentUser(), 0));
	}
	
	public static void setScrambleScore() {
		Score temp = new Score(WordScrambleGame.getCurrentScore().getPoints());
		temp.addPoints(100);
		WordScrambleGame.setCurrentScore(temp);
	}

}
