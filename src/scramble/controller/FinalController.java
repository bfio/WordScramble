package scramble.controller;

import scramble.model.ScrambleModel;

public class FinalController {
	
	private static ScrambleModel scrambleModel;
	
	public FinalController(ScrambleModel scrambleModel) {
		this.scrambleModel = scrambleModel;
	}
	
	public static String getFinalScoreString() {
		return scrambleModel.getCurrentScore().getPoints().toString();
	}

	public static String getUserString() {
		return scrambleModel.getCurrentUser().getInitialsString();
	}
	
	public static String getDifficultyString() {
		return scrambleModel.getCurrentDifficulty().toString();
	}

}
