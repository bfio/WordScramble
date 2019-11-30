package scramble;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import scramble.element.Difficulty;
import scramble.element.Score;
import scramble.element.User;
import scramble.view.StartupView;

public class WordScrambleGame extends Application {

	private static Stage primaryStage;
	private static Difficulty currentDifficulty;
	private static User currentUser;
	private static Score currentScore;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		WordScrambleGame.primaryStage = primaryStage;
		primaryStage.setScene(new StartupView().getStartupScene());
		primaryStage.setTitle(StartupView.getStartupViewTitle());
		primaryStage.show();
	}

	/**
	 * Used to change to a different scene anywhere in the application.
	 * 
	 * @param scene The scene to change to.
	 */
	public static void changeScene(Scene scene) {
		WordScrambleGame.primaryStage.setScene(scene);
	}
	
	public static Difficulty getCurrentDifficulty() {
		return WordScrambleGame.currentDifficulty;
	}

	public static void setCurrentDifficulty(Difficulty difficulty) {
		WordScrambleGame.currentDifficulty = difficulty;
	}

	public static User getCurrentUser() {
		return currentUser;
	}

	public static void setCurrentUser(User currentUser) {
		WordScrambleGame.currentUser = currentUser;
	}

	public static Score getCurrentScore() {
		return currentScore;
	}

	public static void setCurrentScore(Score currentScore) {
		WordScrambleGame.currentScore = currentScore;
	}
}

