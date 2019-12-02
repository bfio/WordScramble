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
	
	public ScrambleModel() {
		this.currentUser = null;
		this.currentScore = new Score(this.currentUser, 0);
	}
	
	public Score getCurrentScore() {
		return currentScore;
	}

	public void setCurrentScore(Score currentScore) {
		ScrambleModel.currentScore = currentScore;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		ScrambleModel.currentUser = currentUser;
	}

	public File getCurrentDatabase() {
		return currentDatabase;
	}

	public void setCurrentDatabase(File currentDatabase) {
		ScrambleModel.currentDatabase = currentDatabase;
	}

	public Difficulty getCurrentDifficulty() {
		return currentDifficulty;
	}

	public void setCurrentDifficulty(Difficulty currentDifficulty) {
		ScrambleModel.currentDifficulty = currentDifficulty;
	}

}
