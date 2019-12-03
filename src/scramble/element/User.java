package scramble.element;

public class User {
	
	private String initials;
	
	public User(String initials) {
		this.initials = initials.substring(0, 3).toUpperCase();
	}

	protected String getInitials() {
		return initials;
	}
	
	protected void setInitials(String name) {
		this.initials = name.substring(0, 3);
	}
	
	public String getInitialsString() {
		return this.initials.toString().toUpperCase();
	}
	
	@Override
	public String toString() {
		return this.initials.substring(0, 3);
	}
	
	
	

}
