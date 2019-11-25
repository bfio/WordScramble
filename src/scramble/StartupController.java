package scramble;

public class StartupController {
	
	public static void setCurrentDifficulty(Difficulty selectedDifficulty) {
		WordScrambleGame.setCurrentDifficulty(selectedDifficulty);
	}
	
	public static void setCurrentUser(User user) {
		WordScrambleGame.setCurrentUser(user);
	}

}
