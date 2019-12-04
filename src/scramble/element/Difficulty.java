package scramble.element;

public enum Difficulty {
	EASY("Easy", "Good for new players with less experience"), 
	MEDIUM("Medium", "Better for intermediate players with some experience"), 
	HARD("Hard", "Hardest difficulty suited for the most experienced players");
	
	private String name;
	private String description;
	
	/**
	 * Constructor for Difficulty
	 * @param name Short name for difficulty setting
	 * @param description Detailed explanation of difficulty
	 */
	Difficulty(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
}
