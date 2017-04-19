package eg.edu.alexu.csd.datastructure.hangman.cs60;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Testing {
	public static void main(String args[]) throws FileNotFoundException {
		int flag = 1;
		Hangman z = new Hangman();
		String x[] = z.readFile();
		z.setDictionary(x);
		z.setMaxWrongGuesses(10);
		z.selectRandomSecretWord();
		String fin;
		System.out.println(z.temp);
		Scanner sc = new Scanner(System.in);
		while (flag == 1) {
			System.out.println("Enter Your guess");
			char c = sc.nextLine().charAt(0);
			fin = z.guess(c);
			System.out.println(z.thesavedSecretWord);
			if (fin == null) {
				flag = 2;
				break;
			}
			if (fin.equals(z.thehiddenSecretWord)) {
				flag = 3;
				break;
			}
		}
		sc.close();
		if (flag == 3) {
			System.out.println(z.thesavedSecretWord);
			System.out.println("You win");
		}
		if (flag == 2) {
			System.out.println("Exceeded Number ot Tries");
			System.out.println("You Lose");
		}

	}
}
