package scramble.element;

public class User {
	
	private String initials;
	
	public User(String initials) {
		this.initials = initials.substring(0, 3).toUpperCase();
	}
	
	@Override
	public String toString() {
		return this.initials.substring(0, 3).toUpperCase();
	}
	
	
	

}
