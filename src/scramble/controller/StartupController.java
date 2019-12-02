package scramble.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import scramble.WordScrambleGame;
import scramble.element.Difficulty;
import scramble.element.User;
import scramble.model.ScrambleModel;
import scramble.view.ScrambleView;
import scramble.view.StartupView;

public class StartupController {
	
	private static StartupView startupView;
	private static ScrambleModel scrambleModel;
	
	public StartupController(StartupView startupView, ScrambleModel scrambleModel) {
		this.startupView = startupView;
		this.scrambleModel = scrambleModel;
	}

	public static void setCurrentDifficulty(Difficulty selectedDifficulty) {
		startupView.getDifficultyDropdown().setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				scrambleModel.setCurrentDifficulty(startupView.getDifficultyDropdown().getValue());
			}
		});
	}

	public static void setCurrentUser(User user) {
		startupView.getUserTextField().setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				scrambleModel.setCurrentUser(new User(startupView.getUserTextField().getText()));
			}
		});
	}

	public static void startGame() {
		if ((startupView.getUserTextField().getLength() != 3) || (startupView.getDifficultyDropdown().getValue() == null)) {
			Alert errorAlert = new Alert(AlertType.ERROR);
			errorAlert.setHeaderText("Startup Info Errors");
			errorAlert.setContentText("Make sure initials are correct and difficulty is selected before beginning the game");
			errorAlert.showAndWait();
		} else {
			scrambleModel.setCurrentUser(new User(
					startupView.getUserTextField().getText().substring(0,3)));
			scrambleModel.setCurrentDifficulty(
					startupView.getDifficultyDropdown().getValue());
			WordScrambleGame.changeScene(new ScrambleView().getScrambleView());
		}
	}
}
