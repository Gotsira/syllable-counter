package OOSyllableCounter;

/**
 * WordCounter class for counting syllable in a word using State Design Pattern
 * (Object-Oriented).
 * 
 * @author Sirasath Piyapootinun
 *
 */
public class WordCounter {
	private final State START = new StartState();
	private final State SINGLEVOWEL = new SingleVowelState();
	private final State MULTIVOWEL = new MultiVowelState();
	private final State CONSONANT = new ConsonantState();
	private final State HYPHEN = new HyphenState();
	private final State NONWORD = new NonWordState();
	private State state;
	private String word;
	private int pointer;
	private int syllableCount = 0;

	/**
	 * Sets the state of the WordCounter.
	 * 
	 * @param newstate
	 *            is the state to be set.
	 */
	public void setState(State newstate) {
		this.state = newstate;
	}

	/**
	 * Return the total number of syllables counted in a word.
	 * 
	 * @param word
	 *            is the word to be counted.
	 * @return the number of syllables in a word.
	 */
	public int countSyllables(String word) {
		setState(START);
		syllableCount = 0;
		this.word = word;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (c == '\'') {
				continue;
			}
			pointer = i;
			this.state.handleChar(c);
			if (state == NONWORD) {
				return 0;
			}
		}
		return syllableCount;
	}

	/**
	 * Starting state of the WordCounter.
	 * 
	 * @author Sirasath Piyapootinun
	 *
	 */
	class StartState extends State {

		@Override
		public void handleChar(char c) {
			if (isVowel(c)) {
				if (pointer == word.length() - 1) {
					enterState();
				}
				setState(SINGLEVOWEL);
			} else if (isLetter(c)) {
				setState(CONSONANT);
			} else {
				setState(NONWORD);
			}
		}

		@Override
		public void enterState() {
			syllableCount++;
		}

	}

	/**
	 * Single vowel state of the WordCounter.
	 * 
	 * @author Sirasath Piyapootinun
	 *
	 */
	class SingleVowelState extends State {

		@Override
		public void handleChar(char c) {
			if (isVowel(c)) {
				if (pointer == word.length() - 1) {
					enterState();
				}
				setState(MULTIVOWEL);
			} else if (isLetter(c)) {
				enterState();
				setState(CONSONANT);
			} else if (isHyphen(c)) {
				if (!isE(word.charAt(pointer - 1))) {
					enterState();
				}
				setState(HYPHEN);
			} else {
				setState(NONWORD);
			}
		}

		@Override
		public void enterState() {
			syllableCount++;
		}
		
	}

	/**
	 * Multiple state of the WordCounter.
	 * 
	 * @author Sirasath Piyapootinun
	 *
	 */
	class MultiVowelState extends State {

		@Override
		public void handleChar(char c) {
			if (isVowel(c)) {
				if (pointer == word.length() - 1) {
					enterState();
				}
			} else if (isHyphen(c)) {
				enterState();
				setState(HYPHEN);
			} else if (isLetter(c)) {
				enterState();
				setState(CONSONANT);
			} else {
				setState(NONWORD);
			}
		}

		@Override
		public void enterState() {
			syllableCount++;
		}

	}

	/**
	 * Consonant state of the WordCounter.
	 * 
	 * @author Sirasath Piyapootinun
	 *
	 */
	class ConsonantState extends State {

		@Override
		public void handleChar(char c) {
			if (isVowelOrY(c)) {
				if (pointer == word.length() - 1 && !isE(c)) {
					enterState();
				} else if (pointer == word.length() - 1 && isE(c) && syllableCount == 0) {
					enterState();
				}
				setState(SINGLEVOWEL);
			} else if (isHyphen(c)) {
				setState(HYPHEN);
			} else if (isLetter(c)) {
			} else {
				setState(NONWORD);
			}
		}

		@Override
		public void enterState() {
			syllableCount++;
		}

	}
	
	/**
	 * Hyphen state of the WordCounter.
	 * 
	 * @author Sirasath Piyapootinun
	 *
	 */
	class HyphenState extends State {

		@Override
		public void handleChar(char c) {
			if (isHyphen(c)) {
				enterState();
				setState(NONWORD);
			} else if (isVowel(c)) {
				setState(SINGLEVOWEL);
			} else if (isLetter(c)) {
				setState(CONSONANT);
			} else {
				setState(NONWORD);
			}
		}

		@Override
		public void enterState() {
			syllableCount = 0;
		}

	}
	
	/**
	 * Non word state of the WordCounter.
	 * 
	 * @author Sirasath Piyapootinun
	 *
	 */
	class NonWordState extends State {

		@Override
		public void handleChar(char c) {
			enterState();
		}

		@Override
		public void enterState() {
			syllableCount = 0;
		}

	}
}
