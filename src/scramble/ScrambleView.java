package scramble;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ScrambleView extends Stage {
	
	public ScrambleView() {
		super.setTitle("Startup Screen");
		super.setMaximized(false);
		
		BorderPane root = new BorderPane();
		Scene scrambleScene = new Scene(root,400,400);
		scrambleScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		this.setScene(scrambleScene);
		this.show();
	}

}
