package ku.util;

public class SimpleSyllableCounter {

	public int countSyllables(String word) {
		int syllables = 0;
		char letter = ' ';
		State state = State.START;
		for (int i = 0; i < word.length(); i++) {
			letter = word.charAt(i);
			switch (state) {
			case START:
				if(isVowel(letter)) {
					state = State.SINGLE_VOWEL;
				}
				else if(Character.isLetter(letter)) {
					state = State.CONSONANT;
				}
				else {
					state = State.NONWORD;
				}
				break;
				
			case SINGLE_VOWEL:
				if(isVowel(letter)) {
					state = State.MULTI_VOWEL;
					if(i == word.length() - 1) {
						syllables++;
					}
				}
				else if(Character.isLetter(letter)) {
					syllables++;
					state = State.CONSONANT;
				}
				else if(letter == '-') {
					state = State.HYPHEN;
					if(word.charAt(i - 1) != 'e') {
						syllables++;
					}
				}
				else {
					state = State.NONWORD;
				}
				break;
				
			case MULTI_VOWEL:
				if(isVowel(letter)) {
					state = State.MULTI_VOWEL;
					if(i == word.length() - 1) {
						syllables++;
					}
				}
				else if(letter == '-') {
					syllables++;
					state = State.HYPHEN;
				}
				else if(Character.isLetter(letter)){
					syllables++;
					state = State.CONSONANT;
				}
				else {
					state = State.NONWORD;
				}
				break;
				
			case CONSONANT:
				if(isVowelOrY(letter)) {
					state = State.SINGLE_VOWEL;
					if(i == word.length() - 1 && letter != 'e' ) {
						syllables++;
					}
				}
				else if(letter == '-') {
					state = State.HYPHEN;
				}
				else if(Character.isLetter(letter)){
					state = State.CONSONANT;
				}
				else {
					state = State.NONWORD;
				}
				break;
				
			case HYPHEN:
				if(letter == '-') {
					return 0;
				}
				else if(isVowel(letter)) {
					state = State.SINGLE_VOWEL;
				}
				else if(Character.isLetter(letter)) {
					state = State.CONSONANT;
				}
				else {
					state = State.NONWORD;
				}
				break;
				
			case NONWORD:
				return 0;
			}
		}
		return syllables;
	}
	
	public boolean isVowel(char letter) {
		if(letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u') {
			return true;
		}
		return false;
	}
	
	public boolean isVowelOrY(char letter) {
		if(isVowel(letter) || letter == 'y' || letter == 'Y') {
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		SimpleSyllableCounter s = new SimpleSyllableCounter();
		System.out.println(s.countSyllables("the"));
	}
}
