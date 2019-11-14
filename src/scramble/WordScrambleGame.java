package scramble;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class WordScrambleGame extends Application {
	
	public static Stage mainStage = null;
	
	@Override
	public void start(Stage primaryStage) {
		StartupView s = new StartupView();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
