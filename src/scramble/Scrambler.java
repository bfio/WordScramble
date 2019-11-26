package scramble;

public interface Scrambler {
	
	public static String scrambleWord(String toScramble) {

		char [] temp = toScramble.toCharArray();
		return toScramble + " but scrambled";
	}

	public static int calculateValue(String phrase) {
		
		//TODO Algorithm to determine a words value
		
		return phrase.length() * 100;
	}

}
