package eg.edu.alexu.csd.datastructure.iceHockey.cs60;

import java.awt.Point;

public class Tests {
	public static void main(String[] args) {
		IceHockey test = new IceHockey();
		String[] array = { "11111", "1AAA1", "1A1A1", "1AAA1", "11111" };
		Point m[] = test.findPlayers(array, 1, 3);
		for (int i = 0; i < m.length; i++) {
			System.out.print(m[i].getLocation());
			System.out.println();
		}
	}
}
