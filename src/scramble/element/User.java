package scramble.element;

public class User {
	
	private String initials;
	
	public User(String initials) {
		this.initials = initials.substring(0, 3);
		/*
		this.initials[0] = initials[0];
		this.initials[1] = initials[1];
		this.initials[2] = initials[2];
		*/
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
	
	
	

}
