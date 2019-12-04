package scramble.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import scramble.WordScrambleGame;
import scramble.element.Difficulty;
import scramble.element.Score;
import scramble.element.User;
import scramble.model.ScrambleModel;
import scramble.view.ScrambleView;
import scramble.view.StartupView;

public class StartupController {
	
	private StartupView startupView;
	private ScrambleModel scrambleModel;
	
	/**
	 * Constructor for controller for starting the game
	 * @param startupView View to be controlled
	 * @param scrambleModel Model to manipulate data
	 */
	public StartupController(StartupView startupView, ScrambleModel scrambleModel) {
		this.startupView = startupView;
		this.scrambleModel = scrambleModel;
		initializeBeginButton();
	}

	/**
	 * Starts the game when startup information is completed and valid
	 */
	private void startGame() {
		if ((this.startupView.getUserTextField().getLength() != 3) || (startupView.getDifficultyDropdown().getValue() == null)) {
			Alert errorAlert = new Alert(AlertType.ERROR);
			errorAlert.setHeaderText("Startup Info Errors");
			errorAlert.setContentText("Make sure initials are correct and difficulty is selected before beginning the game");
			errorAlert.showAndWait();
		} else {
			scrambleModel.setCurrentUser(new User(startupView.getUserTextField().getText().substring(0,3)));
			scrambleModel.setCurrentScore(new Score(ScrambleModel.getCurrentUser(), 0));
			scrambleModel.setCurrentDifficulty(startupView.getDifficultyDropdown().getValue());
			ScrambleView scrambleView = new ScrambleView();
			new ScrambleController(scrambleView, scrambleModel);
			WordScrambleGame.changeScene(scrambleView.getScene());
		}
	}
	
	/**
	 * Initializes button to begin the game
	 */
	private void initializeBeginButton() {
		startupView.getBeginButton().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				startGame();
			}
		});
		System.out.println("Initializing begin button");
	}
}
