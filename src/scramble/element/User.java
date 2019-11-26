package scramble.element;

public class User {
	
	private char[] initials;
	
	public User(char[] initials) {
		this.initials[0] = initials[0];
		this.initials[1] = initials[1];
		this.initials[2] = initials[2];
	}

	protected char[] getInitials() {
		return initials;
	}

	protected void setInitials(char[] initials) {
		this.initials = initials;
	}
	
	protected void setInitials(String name) {
		this.setInitials(name.substring(0, 3).toCharArray());
	}
	
	
	
	

}
