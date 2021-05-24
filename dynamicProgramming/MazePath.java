
import java.util.Arrays;

public class MazePath {

	public static int solve(int sr, int sc, int dr, int dc) {
		int cstod = 0;

		if (sr == dr || sc == dc) {
			return 1;
		}
		if (sr > dr || sc > dc) {
			return 0;
		}

		int chstod = solve(sr, sc + 1, dr, dc);
		int cvstod = solve(sr + 1, sc, dr, dc);

		cstod = cvstod + chstod;

		return cstod;
	}

	public static int solvem(int sr, int sc, int dr, int dc, int arr[][]) {
		int cstod = 0;

		if (arr[sr][sc] != 0) {
			return arr[sr][sc];
		}

		if (sr == dr || sc == dc) {
			return 1;
		}
		if (sr > dr || sc > dc) {
			return 0;
		}

		int chstod = solvem(sr, sc + 1, dr, dc, arr);
		int cvstod = solvem(sr + 1, sc, dr, dc, arr);
		arr[sr][sc] = cstod;
		cstod = cvstod + chstod;

		return cstod;
	}

	public static int solvet(int dr, int dc) {
		int[][] arr = new int[dr + 1][dc + 1];
		for (int row = dr; row >= 0; row--) {
			for (int col = dc; col >= 0; col--) {
				if (row == dr && col == dc) {
					arr[row][col] = 1;
				} else if (row == dr) {
					arr[row][col] = arr[row][col + 1];
				} else if (col == dc) {
					arr[row][col] = arr[row + 1][col];
				} else
					arr[row][col] = arr[row + 1][col] + arr[row][col + 1];
			}
		}
		return arr[0][0];
	}

	public static int solves(int dr, int dc) {

		int slider[] = new int[dc + 1];

//		for (int i = 0; i <= dc; i++) {
//			slider[i] = 1;
//		}
		
		Arrays.fill(slider, 1);

		for (int nors = 1; nors <= dr; nors++) {
			for (int i = slider.length - 2; i >= 0; i--) {
				slider[i] = slider[i] + slider[i + 1];
			}
		}

		return slider[0];

	}

	public static void main(String[] args) {
		int n = 15;
		System.out.println(solves(n, n));
		System.out.println(solvem(0, 0, n, n, new int[n + 1][n + 1]));
		System.out.println(solvet(n, n));
		System.out.println(solve(0, 0, n, n));
	}

}
