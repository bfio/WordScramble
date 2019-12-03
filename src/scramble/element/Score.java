package scramble.element;

public class Score implements Comparable<Score> {
	
	private User user;
	private Integer points;
	
	public Score(User user, Integer points) {
		this.user = user;
		this.points = points;
	}

	public Integer getPoints() {
		return points;
	}

	protected void setPoints(Integer points) {
		this.points = points;
	}
	
	public void addPoints(Integer toAdd) {
		this.setPoints(this.getPoints() + toAdd);;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		return points.toString();
	}

	@Override
	public int compareTo(Score o) {
		if (this.points > o.points) {
			return 1;
		} else if (this.points == o.points) {
			return 0;
		} else {
			return -1;
		}
	}

	
	

}
