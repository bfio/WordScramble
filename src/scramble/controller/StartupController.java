package scramble.controller;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import scramble.WordScrambleGame;
import scramble.element.Difficulty;
import scramble.element.User;
import scramble.view.ScrambleView;
import scramble.view.StartupView;

public class StartupController {

	public static void setCurrentDifficulty(Difficulty selectedDifficulty) {
		WordScrambleGame.setCurrentDifficulty(selectedDifficulty);
	}

	public static void setCurrentUser(User user) {
		WordScrambleGame.setCurrentUser(user);
	}

	public static void startGame() {
		if ((StartupView.getUserTextField().getLength() != 3) || (StartupView.getDifficultyDropdown().getValue() == null)) {
			Alert errorAlert = new Alert(AlertType.ERROR);
			errorAlert.setHeaderText("Startup Info Errors");
			errorAlert.setContentText("Make sure initials are correct and difficulty is selected before beginning the game");
			errorAlert.showAndWait();
		} else {
			StartupController.setCurrentUser(new User(
					StartupView.getUserTextField().getText().substring(0,3)));
			StartupController.setCurrentDifficulty(
					StartupView.getDifficultyDropdown().getValue());
			WordScrambleGame.changeScene(new ScrambleView().getScrambleView());
		}
		/*
		try {
			WordScrambleGame.changeScene(new ScrambleView().getScrambleView3());
		} catch (Exception e) {
			Alert errorAlert = new Alert(AlertType.ERROR);
			errorAlert.setHeaderText("Startup Info Errors");
			errorAlert.setContentText("Make sure initials and difficulty are selected before beginning game");
			errorAlert.showAndWait();
		}
		 */

	}

}
