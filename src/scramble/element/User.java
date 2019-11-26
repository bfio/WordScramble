package scramble.element;

import java.util.ArrayList;
import java.util.List;

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
	
	
	
	

}
