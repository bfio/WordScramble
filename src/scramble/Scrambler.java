package scramble;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public interface Scrambler {
	
	public static String scrambleWord(String toScramble) {

		String[] scrambleArray = toScramble.split("");
        List<String> letters = Arrays.asList(scrambleArray);
        Collections.shuffle(letters);
        StringBuilder sb = new StringBuilder(toScramble.length());
        for (String c : letters) {
            sb.append(c);
        }
        return sb.toString() + " but scrambled";
		
	}

	public static int calculateValue(String phrase) {
		
		//TODO Algorithm to determine a words value
		
		return phrase.length() * 100;
	}

}
