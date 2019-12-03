package scramble.model;

import java.io.File;

import scramble.element.Difficulty;
import scramble.element.Score;
import scramble.element.User;

public class ScrambleModel {
	
	private static Score currentScore;
	private static User currentUser;
	private static Difficulty currentDifficulty;
	private static File currentDatabase;
	private static int currentTime;
	
	public ScrambleModel() {
		this.currentUser = null;
		this.currentScore = new Score(this.currentUser, 0);
	}
	
	public static Score getCurrentScore() {
		return currentScore;
	}

	public void setCurrentScore(Score currentScore) {
		ScrambleModel.currentScore = currentScore;
		System.out.println("Setting current score: " + currentScore.toString());
	}

	public static User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		ScrambleModel.currentUser = currentUser;
		System.out.println("Setting current user: " + currentUser.toString());
	}

	public static File getCurrentDatabase() {
		return currentDatabase;
	}

	public void setCurrentDatabase(File currentDatabase) {
		ScrambleModel.currentDatabase = currentDatabase;
		System.out.println("Setting current database: " + currentDatabase.getName());
	}

	public static Difficulty getCurrentDifficulty() {
		return currentDifficulty;
	}

	public void setCurrentDifficulty(Difficulty currentDifficulty) {
		ScrambleModel.currentDifficulty = currentDifficulty;
		System.out.println("Setting current difficulty: " + currentDifficulty.toString());
	}

	public static int getCurrentTime() {
		return currentTime;
	}

	public static void setCurrentTime(int currentTime) {
		ScrambleModel.currentTime = currentTime;
	}

}
