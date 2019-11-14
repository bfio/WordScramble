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
	private static Difficulty difficulty;

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

	/**
	 * An animated clock in the title bar of the main window.
	 */
	private void initClock() {
		Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd h:mm:ss a");
			primaryStage.setTitle("CPS 240 Bank - " + LocalDateTime.now().format(formatter));
		}), new KeyFrame(Duration.seconds(1)));
		clock.setCycleCount(Animation.INDEFINITE);
		clock.play();
	}

	private static void setDifficulty(Difficulty difficulty) {
		WordScrambleGame.difficulty = difficulty;
	}
}

