package scramble.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import scramble.WordScrambleGame;
import scramble.model.ScrambleModel;
import scramble.view.FinalView;
import scramble.view.StartupView;

public class FinalController {
	
	private FinalView finalView;
	private ScrambleModel scrambleModel;
	
	/**
	 * Constructor for Final controller
	 * @param finalView View connected to the controller
	 * @param scrambleModel Model to pull data from to be displayed
	 */
	public FinalController(FinalView finalView, ScrambleModel scrambleModel) {
		this.finalView = finalView;
		this.scrambleModel = scrambleModel;
		initNewGameButton();
	}
	
	/**
	 * Initializes the action when pressing the new game button
	 */
	private void initNewGameButton() {
		finalView.getNewGameButton().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				newGame();
			}
		});
	}
	
	/**
	 * Launches a new game by returning to the startup screen
	 */
	private void newGame() {
		StartupView startupView = new StartupView();
		new StartupController(startupView, scrambleModel);
		WordScrambleGame.getPrimaryStage().setTitle("Welcome to Word Scramble!");
		WordScrambleGame.changeScene(startupView.getScene());
	}

}
