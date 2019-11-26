package scramble.model;

import scramble.element.User;

public class ScrambleModel {
	
	private static int currentScore;
	private User currentUser;

	public ScrambleModel(User user) {
		this.currentUser = user;
		this.currentScore = 0;
	}
	
	public static int getCurrentScore() {
		return currentScore;
	}

	public static void setCurrentScore(int currentScore) {
		ScrambleModel.currentScore = currentScore;
	}

}
