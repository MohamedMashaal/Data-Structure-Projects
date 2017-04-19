package eg.edu.alexu.csd.datastructure.iceHockey.cs60;

import java.awt.Point;

import eg.edu.alexu.csd.datastructure.iceHockey.IPlayersFinder;

public class IceHockey implements IPlayersFinder {
	int counter = 0, Xr = 0, Xl = 0, Yu = 0, Yd = 0;
	int visited[][];

	@Override
	public Point[] findPlayers(String[] photo, int team, int threshold) {
		// TODO Auto-generated method stub
		int pointCounter = 0;
		int m = photo.length, n = photo[0].length();
		char theArray[][] = new char[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				theArray[i][j] = photo[i].charAt(j);
			}
		}
		visited = new int[m][n];
		arrayInitiliaze(visited, m, n);
		Point points[] = new Point[100];
		for (int index = 0; index < points.length; index++) {
			points[index] = new Point(0, 0);
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j] == 1) {
					continue;
				}
				if (theArray[i][j] != (char) (team + 48)) {
					continue;
				}
				counter++;
				visited[i][j] = 1;
				Xr = j;
				Xl = j;
				Yu = i;
				Yd = i;
				checkSpot(i, j, team, theArray, m, n);
				if (((counter * 4) / threshold) >= 1) {
					points[pointCounter].x = Xr + Xl + 1;
					points[pointCounter].y = Yu + Yd + 1;
					pointCounter++;
				}
				resetCounters();

			}
		}
		Point finals[] = new Point[pointCounter];
		for (int i = 0; i < finals.length; i++) {
			finals[i] = new Point(0, 0);
		}

		for (int i = 0; i < pointCounter; i++) {
			finals[i] = points[i];
		}

		// Arrays.sort(Finals, new Comparator<Point>() { public int
		// compare(Point a, Point b) { int xComp = Integer.compare(a.x, b.x);
		// if(xComp == 0) return Integer.compare(a.y, b.y); else return xComp; }
		// });
		sort(finals);
		return finals;
	}

	public void sort(Point[] finals) {
		Point temp = new Point();
		for (int i = 0; i < finals.length; i++) {
			for (int j = 0; j < finals.length - 1 - i; j++) {
				if (finals[j].x >= finals[j + 1].x)
					if (finals[j].x == finals[j + 1].x) {
						if (finals[j].y > finals[j + 1].y) {
							temp = finals[j + 1];
							finals[j + 1] = finals[j];
							finals[j] = temp;
						}
					} else {
						temp = finals[j + 1];
						finals[j + 1] = finals[j];
						finals[j] = temp;
					}
			}
		}
	}

	public void arrayInitiliaze(int[][] array, int m, int n) {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				array[i][j] = 0;
			}
		}
	}

	public void resetCounters() {
		counter = 0;
		Xr = 0;
		Xl = 0;
		Yu = 0;
		Yd = 0;
	}

	public void checkSpot(int x, int y, int team, char[][] thearray, int m, int n) {
		for (int i = x - 1; i <= x + 1; i++) {
			for (int j = y - 1; j <= y + 1; j++) {
				if (i < 0 | j < 0 | i >= m | j >= n | ((i == x - 1) & (j == y - 1)) | ((i == x - 1) & (j == y + 1))
						| ((i == x + 1) & (j == y - 1)) | ((i == x + 1) & (j == y + 1))) {
					continue;
				}
				if (visited[i][j] == 1) {
					continue;
				}
				if (thearray[i][j] == (char) (team + 48)) {
					counter++;
					visited[i][j] = 1;
					if (j < Xr) {
						Xr = j;
					}
					if (j > Xl) {
						Xl = j;
					}
					if (i > Yu) {
						Yu = i;
					}
					if (i < Yd) {
						Yd = i;
					}
					checkSpot(i, j, team, thearray, m, n);
				}
			}
		}
	}
}
