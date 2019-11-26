package scramble.view;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import scramble.WordScrambleGame;
import scramble.controller.StartupController;
import scramble.element.Difficulty;
import scramble.element.User;

public class StartupView {

	private static String startupViewTitle = "Welcome to Word Scramble!";
	private static List<Difficulty> diffList;
	
	public Scene getStartupScene() {
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		Label initialsLabel = new Label("Enter your initials:");
		grid.add(initialsLabel, 0, 1);

		TextField userTextField = new TextField();
		userTextField.setMaxWidth(50);
		grid.add(userTextField, 1, 1);
		
		userTextField.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				StartupController.setCurrentUser(new User(userTextField.getText().substring(0, 2).toCharArray()));
			}
		});
		
		Label difficultyLabel = new Label("Select Difficulty:");
		grid.add(difficultyLabel, 0, 2);
		
		addDifficulties();
		
		ComboBox<Difficulty> difficultyDropdown = new ComboBox();
		difficultyDropdown.getItems().addAll(diffList);
		grid.add(difficultyDropdown, 1, 2);
		
		difficultyDropdown.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				StartupController.setCurrentDifficulty(difficultyDropdown.getValue());
			}
		});

		Button btn = new Button("Begin Game");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		grid.add(hbBtn, 1, 3);
		
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				WordScrambleGame.changeScene(new ScrambleView().getScrambleView3());
			}
		});

		Scene scene = new Scene(grid, 400, 400);
		scene.getStylesheets().add(WordScrambleGame.class.getResource("application.css").toExternalForm());
		
		return scene;
	}
	
	public static String getStartupViewTitle() {
		return startupViewTitle;
	}
	
	private void addDifficulties() {
		diffList = new ArrayList<Difficulty>();
		diffList.add(Difficulty.EASY);
		diffList.add(Difficulty.MEDIUM);
		diffList.add(Difficulty.HARD);
	}
}
