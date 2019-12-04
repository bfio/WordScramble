package scramble.model;

import java.util.List;

import scramble.element.Difficulty;
import scramble.element.Score;
import scramble.element.User;

public class ScrambleModel {
	
	private static Score currentScore;
	private static User currentUser;
	private static Difficulty currentDifficulty;
	private static List<String> currentScrambleList;
	private static int currentTime;
	private static int currentIteration = 0;
	
	/**
	 * Constructor for the model that stores the application's accessible data
	 */
	public ScrambleModel() {
		ScrambleModel.currentScore = new Score(ScrambleModel.currentUser, 0);
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

	public static List<String> getCurrentScrambleList() {
		return currentScrambleList;
	}

	public static void setCurrentScrambleList(List<String> currentScrambleList) {
		ScrambleModel.currentScrambleList = currentScrambleList;
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

	public static int getCurrentIteration() {
		return currentIteration;
	}

	public static void setCurrentIteration(int currentIteration) {
		ScrambleModel.currentIteration = currentIteration;
	}

}
