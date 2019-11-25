package scramble;

public enum Difficulty {
	EASY("Easy", "Good for new players with less experience"), 
	MEDIUM("Medium", "Better for intermediate players with some experience"), 
	HARD("Hard", "Hardest difficulty suited for the most experienced players");
	
	private String name;
	private String description;
	
	Difficulty(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
}
