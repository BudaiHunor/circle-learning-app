package client.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public enum Language {
	ENGLISH, ROMANIAN, HUNGARIAN;

	public final List<String> WORDS = this.allWords();

	private final List<String> allWords() {
		String fileName = this.toString().toUpperCase() + ".txt";
		File file = new File(fileName);

		List<String> words = new ArrayList<String>();
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
			for (; scanner.hasNextLine();) {
				String line = scanner.nextLine();
				words.add(line);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return words;
	}

	public String toString() {
		String lower = super.toString().toLowerCase();
		return (char) (lower.charAt(0) - 'a' + 'A') + lower.substring(1, lower.length());
	}

	public static Language stringToLanguage(String language) {
		if (language == null) {
			return null;
		}
		switch (language.toUpperCase()) {
		case "ENGLISH":
			return Language.ENGLISH;
		case "ROMANIAN":
			return Language.ROMANIAN;
		case "HUNGARIAN":
			return Language.HUNGARIAN;
		default:
			return null;
		}
	}

	public String translated(String word) {
		int index = Language.ENGLISH.WORDS.indexOf(word);
		if (index == -1) {
			return word;
		}
		return this.WORDS.get(index);
	}

	public static String[] names() {
		return Arrays.asList(Language.values()).stream().map(language -> language.toString()).toArray(String[]::new);
	}
}
