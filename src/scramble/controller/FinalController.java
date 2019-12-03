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
	
	public FinalController(FinalView finalView, ScrambleModel scrambleModel) {
		this.finalView = finalView;
		this.scrambleModel = scrambleModel;
		initNewGameButton();
	}
	
	private void initNewGameButton() {
		finalView.getNewGameButton().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				newGame();
			}
		});
	}
	
	public void newGame() {
		StartupView startupView = new StartupView();
		new StartupController(startupView, scrambleModel);
		WordScrambleGame.getPrimaryStage().setTitle("Welcome to Word Scramble!");
		WordScrambleGame.changeScene(startupView.getScene());
	}

}
