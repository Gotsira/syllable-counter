package OOSyllableCounter;

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

	public void setState(State newstate) {
		this.state = newstate;
	}
	
	public static void main(String[] args) {
		WordCounter w = new WordCounter();
		System.out.println(w.countSyllables("home-brew"));
	}
	
	public int countSyllables(String word) {
		setState(START);
		syllableCount = 0;
		this.word = word;
		for(int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if(c == '\'') {
				continue;
			}
			pointer = i;
			this.state.handleChar(c);
			if(state == NONWORD) {
				return 0;
			}
		}
		return syllableCount;
	}
	class StartState extends State {
		
		@Override
		public void handleChar(char c) {
			if(isVowel(c)) {
				if(pointer == word.length() - 1) {
					enterState();
				}
				setState(SINGLEVOWEL);
			}
			else if(isLetter(c)) {
				setState(CONSONANT);
			}
			else {
				setState(NONWORD);
			}
		}
		
		@Override
		public void enterState() {
			syllableCount++;
		}
		
	}

	class SingleVowelState extends State {

		@Override
		public void handleChar(char c) {
			if (isVowel(c)) {
				if(pointer == word.length() - 1) {
					enterState();
				}
				setState(MULTIVOWEL);
			}
			else if (isLetter(c)) {
				enterState();
				setState(CONSONANT);
			}
			else if (isHyphen(c)) {
				if(!isE(word.charAt(pointer - 1))) {
					enterState();
				}
				setState(HYPHEN);
			}
			else {
				setState(NONWORD);
			}
		}

		@Override
		public void enterState() {
			syllableCount++;
		}

	}
	
	
	class MultiVowelState extends State {

		@Override
		public void handleChar(char c) {
			if(isVowel(c)) {
				if(pointer == word.length() - 1) {
					enterState();
				}
			}
			else if(isHyphen(c)) {
				enterState();
				setState(HYPHEN);
			}
			else if(isLetter(c)) {
				enterState();
				setState(CONSONANT);
			}
			else {
				setState(NONWORD);
			}
		}

		@Override
		public void enterState() {
			syllableCount++;
		}
		
	}
	
	class ConsonantState extends State {

		@Override
		public void handleChar(char c) {
			if(isVowelOrY(c)) {
				if(pointer == word.length() - 1 && !isE(c)) {
					enterState();
				}
				else if(pointer == word.length() - 1 && isE(c) && syllableCount == 0) {
					enterState();
				}
				setState(SINGLEVOWEL);
			}
			else if(isHyphen(c)) {
				setState(HYPHEN);
			}
			else if(isLetter(c)) {	}
			else {
				setState(NONWORD);
			}
		}

		@Override
		public void enterState() {
			syllableCount++;
		}
		
	}
	
	class HyphenState extends State {

		@Override
		public void handleChar(char c) {
			if(isHyphen(c)) {
				enterState();
				setState(NONWORD);
			}
			else if(isVowel(c)) {
				setState(SINGLEVOWEL);
			}
			else if(isLetter(c)) {
				setState(CONSONANT);
			}
			else {
				setState(NONWORD);
			}
		}

		@Override
		public void enterState() {
			syllableCount = 0;
		}
		
	}
	
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
