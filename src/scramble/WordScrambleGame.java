package scramble;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

public class WordScrambleGame extends Application {

	private static Stage primaryStage;
	private static Difficulty currentDifficulty;
	private static User currentUser;

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

	protected static void setCurrentDifficulty(Difficulty difficulty) {
		WordScrambleGame.currentDifficulty = difficulty;
	}

	public static User getCurrentUser() {
		return currentUser;
	}

	public static void setCurrentUser(User currentUser) {
		WordScrambleGame.currentUser = currentUser;
	}
}

