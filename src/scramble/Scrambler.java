package scramble;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import scramble.element.Difficulty;


public interface Scrambler {
	
	public static String scrambleWord(String toScramble) {

		String[] scrambleArray = toScramble.split("");
        List<String> letters = Arrays.asList(scrambleArray);
        Collections.shuffle(letters);
        StringBuilder sb = new StringBuilder(toScramble.length());
        for (String c : letters) {
            sb.append(c);
        }
        return sb.toString();
		
	}

	public static int calculateValue(String phrase, Difficulty difficulty) {
		
		switch(difficulty) {
			
		case EASY:
			int easyLength = phrase.length();
			easyLength = easyLength * 25;
			return easyLength;
		case MEDIUM:
			int mediumLength = phrase.length();
			mediumLength = mediumLength * 65;
			return mediumLength;
		case HARD:
			int hardLength = phrase.length();
			hardLength = hardLength * 120;
			return hardLength;
		default:
			return phrase.length() * 2;
		}
		
		
	}

}
