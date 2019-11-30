package scramble.controller;

import scramble.WordScrambleGame;

public class FinalController {
	
	public static String getFinalScoreString() {
		return WordScrambleGame.getCurrentScore().getPoints().toString();
	}

	public static String getUserString() {
		return WordScrambleGame.getCurrentUser().getInitialsString();
	}
	
	public static String getDifficultyString() {
		return WordScrambleGame.getCurrentDifficulty().toString();
	}

}
