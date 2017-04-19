package eg.edu.alexu.csd.datastructure.hangman.cs60;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import java.util.Random;
import java.util.Scanner;

import eg.edu.alexu.csd.datastructure.hangman.IHangman;

public class Hangman implements IHangman {
	private String words[];
	private Random secretWord = new Random();
	public String thehiddenSecretWord;
	public String thesavedSecretWord;
	int maxNumGuesses = 0;
	int numofGuesses = 0;
	public StringBuffer temp;

	@Override
	public void setDictionary(String[] words) {
		// TODO Auto-generated method stub
		this.words = words;
	}

	@Override
	public String selectRandomSecretWord() {
		// TODO Auto-generated method stub
		if (words != null) {
			thehiddenSecretWord = words[secretWord.nextInt(words.length)];
			temp = new StringBuffer(thehiddenSecretWord);
			for (int i = 0; i < thehiddenSecretWord.length(); i++) {
				temp.setCharAt(i, '-');
			}
			return (thehiddenSecretWord);
		}
		return null;
	}

	@Override
	public String guess(Character c) {
		// TODO Auto-generated method stub
		int flag = -1;
		if (numofGuesses == maxNumGuesses) {
			return null;
		}
		thesavedSecretWord = temp.toString();
		for (int i = 0; i < thehiddenSecretWord.length(); i++) {
			if (c.toLowerCase(c) == thehiddenSecretWord.toLowerCase().charAt(i)) {
				temp.setCharAt(i, thehiddenSecretWord.charAt(i));
				flag = 1;
			}
		}
		if (flag == 1) {
			thesavedSecretWord = temp.toString();
			return thesavedSecretWord;
		}
		numofGuesses++;
		if (numofGuesses == maxNumGuesses) {
			return null;
		}
		return thesavedSecretWord;
	}

	@Override
	public void setMaxWrongGuesses(Integer max) {
		// TODO Auto-generated method stub
		maxNumGuesses = max;

	}

	public String[] readFile() throws FileNotFoundException {
		Scanner sc = new Scanner(new File("Dic.txt"));
		List<String> lines = new ArrayList<String>();
		while (sc.hasNextLine()) {
			lines.add(sc.nextLine());
		}

		String[] dicTable = lines.toArray(new String[0]);
		sc.close();
		return dicTable;
	}
}
