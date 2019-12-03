package scramble;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import scramble.controller.StartupController;
import scramble.element.Difficulty;
import scramble.element.Score;
import scramble.element.User;
import scramble.model.ScrambleModel;
import scramble.view.StartupView;

public class WordScrambleGame extends Application {

	private static Stage primaryStage;
	private static ScrambleModel scrambleModel;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		StartupView startupView = new StartupView();
		scrambleModel = new ScrambleModel();
		new StartupController(startupView, scrambleModel);
		WordScrambleGame.primaryStage = startupView;
		WordScrambleGame.primaryStage.show();
	}

	/**
	 * Used to change to a different scene anywhere in the application.
	 * 
	 * @param scene The scene to change to.
	 */
	public static void changeScene(Scene scene) {
		WordScrambleGame.primaryStage.setScene(scene);
	}
	
	public static Stage getPrimaryStage() {
		return primaryStage;
	}
}

