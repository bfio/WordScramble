package scramble.controller;

public class ScrambleController {
	
	public static void checkInput(String input, String correct) {
		input.trim();
		input.toLowerCase();
		correct.trim();
		correct.toLowerCase();
		
		if (input.equals(correct)) {
			//Add points
		} else {
			//Handle incorrect input
		}
	}

}
