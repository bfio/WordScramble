package scramble.element;

import scramble.WordScrambleGame;

public class Score {
	
	private User user;
	private Integer points;
	
	public Score(User user, Integer points) {
		this.user = user;
		this.points = points;
	}
	
	public Score(Integer points) {
		this(WordScrambleGame.getCurrentUser(), points);
	}

	public Integer getPoints() {
		return points;
	}

	protected void setPoints(Integer points) {
		this.points = points;
	}
	
	public void addPoints(Integer toAdd) {
		this.setPoints(this.getPoints() + 100);;
	}
	
	

}
