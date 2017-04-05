package keep;

public abstract class State {
	public abstract void handleChar(char c);
	public abstract void enterState();
	
	public boolean isVowel(char c) {
		if (c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u'
				|| c == 'U') {
			return true;
		}
		return false;
	}

	public boolean isE(char c) {
		if(c == 'E' || c == 'e') {
			return true;
		}
		return false;
	}
	
	public boolean isVowelOrY(char letter) {
		if (isVowel(letter) || letter == 'y' || letter == 'Y') {
			return true;
		}
		return false;
	}

	public boolean isLetter(char c) {
		if(Character.isLetter(c) && !isVowel(c)) {
			return true;
		}
		return false;
	}
	
	public boolean isHyphen(char c) {
		if(c == '-') {
			return true;
		}
		return false;
	}
}
