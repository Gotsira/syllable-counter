package OOSyllableCounter;

/**
 * State interface of WordCounter.
 * 
 * @author Sirasath Piyapootinun
 *
 */
public abstract class State {

	/**
	 * Handle a character to configure the state.
	 * 
	 * @param c
	 *            is a character to determine
	 */
	public abstract void handleChar(char c);

	/**
	 * Increases the count of syllable or reducing it depending on the state of
	 * the WordCounter.
	 */
	public abstract void enterState();

	/**
	 * Check if the character is a vowel(a,e,i,o,u).
	 * 
	 * @param c
	 *            is the character to be checked.
	 * @return true if character is a vowel, false otherwise.
	 */
	public boolean isVowel(char c) {
		if (c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u'
				|| c == 'U') {
			return true;
		}
		return false;
	}

	/**
	 * Check if the character is e.
	 * 
	 * @param c
	 *            is the character to be checked.
	 * @return true if character is e, false otherwise.
	 */
	public boolean isE(char c) {
		if (c == 'E' || c == 'e') {
			return true;
		}
		return false;
	}

	/**
	 * Check if the character is a vowel(a,e,i,o,u) or y.
	 * 
	 * @param c
	 *            is the character to be checked.
	 * @return true if character is a vowel or y, false otherwise.
	 */
	public boolean isVowelOrY(char letter) {
		if (isVowel(letter) || letter == 'y' || letter == 'Y') {
			return true;
		}
		return false;
	}
	
	/**
	 * Check if the character is a valid letter.
	 * 
	 * @param c
	 *            is the character to be checked.
	 * @return true if character is a valid letter, false otherwise.
	 */
	public boolean isLetter(char c) {
		if (Character.isLetter(c) && !isVowel(c)) {
			return true;
		}
		return false;
	}

	/**
	 * Check if the character is a hyphen.
	 * 
	 * @param c
	 *            is the character to be checked.
	 * @return true if character is a hyphen, false otherwise.
	 */
	public boolean isHyphen(char c) {
		if (c == '-') {
			return true;
		}
		return false;
	}
}
