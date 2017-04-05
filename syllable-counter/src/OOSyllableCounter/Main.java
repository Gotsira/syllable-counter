package OOSyllableCounter;

import java.io.*;
import java.net.*;

/**
 * Main class for running WordCounter.
 * 
 * @author Sirasath Piyapootinun
 *
 */
public class Main {
	private static final String DICT_URL = "http://se.cpe.ku.ac.th/dictionary.txt";

	public static void main(String[] args) throws IOException {
		long startTime = System.nanoTime();
		URL url = new URL(DICT_URL);
		InputStream input = url.openStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(input));
		String word = "";
		WordCounter counter = new WordCounter();
		int count_syllable = 0;
		int count_word = 0;
		while ((word = reader.readLine()) != null) {
			int count = counter.countSyllables(word);
			count_syllable += count;
			if (count > 0) {
				count_word++;
			}
		}
		System.out.println("Syllables: " + count_syllable);
		System.out.println("Words: " + count_word);
		System.out.printf("Time: %.5f\n", (System.nanoTime() - startTime) * 1.0E-9);
	}
}
