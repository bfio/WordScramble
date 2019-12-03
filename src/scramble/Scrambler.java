package scramble;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import scramble.element.Difficulty;


public interface Scrambler {
	
	/**
	 * Method takes in a word and scrambles it
	 * @param toScramble word going in to be scrambled
	 * @return scrambled up word
	 */
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

	/**
	 * Method calculates score based on length of the word and the difficulty chosen
	 * @param phrase Word being passed through to calculate score
	 * @param difficulty determines the difficulty of the game and gives points accordingly
	 * @return The amount of points earned
	 */
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
