package keep;

import java.io.*;
import java.net.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		long startTime = System.nanoTime();
		final String DICT_URL = "http://se.cpe.ku.ac.th/dictionary.txt";
		URL url = new URL(DICT_URL);
		InputStream input = url.openStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(input));
		String word = "";
		List<String> words = new ArrayList<>();
		WordCounter counter = new WordCounter();
		int count_syllable = 0;
		int count_word = 0;
		try { // try to read the file
			while(true) {
				word = reader.readLine();
				if (word == null) { // exit if null
					break;
				}
				words.add(word);
			}
		} catch (Exception e) { /*ignore*/ } 	
		for (String wordS : words) {
			int count = counter.countSyllables(wordS);
			count_syllable += count;
			if (count > 0) {
				count_word++;
			}
		}
		System.out.printf("Time: %.5f\n" , (System.nanoTime() - startTime)*1.0E-9);
		System.out.println("Syllables: " + count_syllable);
		System.out.println("Words: " + count_word);
	}
}
