package scramble;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class StartupView extends Stage {
	
	private static Button continueButton = new Button("Continue");
	private static TextField initialsField = new TextField();
	private static Label initialsLabel = new Label("Enter your initials: ");
	
	public StartupView() {
		super.setTitle("Startup Screen");
		super.setMaximized(false);
		
		BorderPane root = new BorderPane();
		Scene startupScene = new Scene(root,400,400);
		startupScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		//Continue button
		root.setBottom(getContinueButton());
		root.setAlignment(getContinueButton(), Pos.CENTER);
		root.setPadding(new Insets(20));
		
		//TODO: Implement event handler for new scene
		initialsField.setOnAction(null);
		
		//Text Area
		root.setCenter(getInitialsField());
		//TODO: Add label to text field
		
		
		
		
		
		this.setScene(startupScene);
		
		this.show();
	}
	
	private static void nextPage() {
		//TODO: Implement logic for moving to next page
	}

	protected static Button getContinueButton() {
		return continueButton;
	}
	
	protected static TextField getInitialsField() {
		return initialsField;
	}
}
