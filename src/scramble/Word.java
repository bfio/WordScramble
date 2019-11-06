package scramble;

public class Word implements Scrambler {
	
	private String phrase;
	private String scrambledPhrase;
	private int value;
	
	/**
	 * Constructor for Word object. Sets phrase as word passed and uses parameter to set a scrambled version of it and determine its point value.
	 * @param phrase String passed in to determine both scrambled phrase and point value
	 */
	public Word(String phrase) {
		this.phrase = phrase;
		this.scrambledPhrase = this.scramblePhrase(phrase);
		this.value = this.calculateValue(phrase);
	}
	
	/**
	 * Scrambles a phrase through Scrambler interface
	 * @param phrase Word to be scrambled
	 * @return String value of the scrambled phrase
	 */
	private String scramblePhrase(String phrase) {
		return Scrambler.scrambleWord(phrase);
	}
	
	/**
	 * Calculates point value for a phrase
	 * @param phrase String used to determine value
	 * @return int value of points to be added/deducted from score
	 */
	private int calculateValue(String phrase) {
		return Scrambler.calculateValue(phrase);
	}
	
	//Getters and Setters
	protected String getPhrase() {
		return phrase;
	}
	protected void setPhrase(String phrase) {
		this.phrase = phrase;
	}
	protected String getScrambledPhrase() {
		return scrambledPhrase;
	}
	protected int getValue() {
		return value;
	}
	protected void setValue(int value) {
		this.value = value;
	}


}
