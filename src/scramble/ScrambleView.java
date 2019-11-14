package scramble;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ScrambleView extends Stage {
	
	public ScrambleView() {

	}
	
	public Scene getScrambleView() {
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

}
