package scramble.controller;

import scramble.WordScrambleGame;
import scramble.element.Difficulty;
import scramble.element.User;

public class StartupController {
	
	public static void setCurrentDifficulty(Difficulty selectedDifficulty) {
		WordScrambleGame.setCurrentDifficulty(selectedDifficulty);
	}
	
	public static void setCurrentUser(User user) {
		WordScrambleGame.setCurrentUser(user);
	}

}
