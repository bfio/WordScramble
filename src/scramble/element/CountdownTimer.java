package scramble.element;

import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.Label;
import scramble.WordScrambleGame;

public class CountdownTimer extends Label {

	private Integer startTime;

	public CountdownTimer(Integer time) {
		super(time.toString());
	}

	public void runCountdown(Integer time) {	
		//Run timer down from time
	}

	private Integer getStartTime() {
		return startTime;
	}

	private void setStartTime() {
		switch (WordScrambleGame.getCurrentDifficulty()) {
		case EASY: {
			startTime = new Integer(60);
			break;
		}
		case MEDIUM: {
			startTime = new Integer(45);
			break;
		}
		case HARD: {
			startTime = new Integer(30);
			break;
		}
		default: {
			startTime = new Integer(60);
			break;
		}
		}
	}
}
