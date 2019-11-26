package scramble.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import scramble.WordScrambleGame;
import scramble.element.CountdownTimer;

public class ScrambleView extends Stage {
	
	private static String scrambleViewTitle = "Word Scramble";
	
	public Scene getScrambleView() {
		this.setMaximized(true);
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		
		Text score = new Text("Score Placeholder Here");
		
		BorderPane portal = new BorderPane();
		grid.getChildren().add(portal);
		portal.setCenter(new Text("User plays here"));

		Scene scene = new Scene(grid, 800, 800);
		scene.getStylesheets().add(WordScrambleGame.class.getResource("application.css").toExternalForm());
		
		return scene;
	}
	
	public Scene getScrambleView2() {
		this.setMaximized(true);
		BorderPane pane = new BorderPane();
		
		Button timer = new Button("Timer Placeholder");
		pane.setRight(timer);
		pane.setAlignment(timer, Pos.TOP_RIGHT);
		//pane.getChildren().add(timer);
		
		Button score = new Button("Score Placeholder");
		pane.setAlignment(score, Pos.TOP_LEFT);
		pane.setLeft(score);
		
		Label scrambled = new Label("Scrambled here");
		//pane.setCenter(scrambled);
		
		TextField input = new TextField();
		//pane.setBottom(input);
		
		VBox center = new VBox();
		center.getChildren().addAll(scrambled, input);
		//pane.setAlignment(center, Pos.BOTTOM_CENTER);
		pane.setCenter(center);
		
		Scene scene = new Scene(pane, 800, 800);
		scene.getStylesheets().add(WordScrambleGame.class.getResource("application.css").toExternalForm());
		
		return scene;
		
	}
	
	public Scene getScrambleView3() {
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(25, 25, 25, 25));
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setAlignment(Pos.CENTER);

		Button timer = new Button("Timer Placeholder");
		
		grid.add(timer, 0, 0);
		Button score = new Button("Score Placeholder");
		grid.add(score, 3, 0);
		Label scrambled = new Label("Scrambled here");
		grid.add(scrambled, 1, 1, 2, 1);
		TextField input = new TextField();
		grid.add(input, 1, 3, 2, 1);
				
		Scene scene = new Scene(grid, 400, 400);
		return scene;
	}
}