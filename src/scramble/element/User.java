package scramble.element;

public class User {
	
	private String initials;
	
	/**
	 * Constructor for a User
	 * @param initials Three characters to represent the user
	 */
	public User(String initials) {
		this.initials = initials.substring(0, 3).toUpperCase();
	}
	
	@Override
	public String toString() {
		return this.initials.substring(0, 3).toUpperCase();
	}
	
	
	

}
