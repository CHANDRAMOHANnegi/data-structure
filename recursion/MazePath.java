
public class MazePath {

	static int count = 0;
	static int counter = 0;

	public static void main(String[] args) {
		int n = 2;
		int maze[][] = new int[n][n];
//		solveHV(maze, 0, 0, n, n, "");
		solveHVmultipleSteps(maze, 0, 0, n, n, "");
	}

	private static void solveHV(int[][] maze, int sc, int sr, int dc, int dr, String ans) {

		if (sr == dr && sc == dc) {
			System.out.println(ans);
			return;
		}

		if (sc > dc || sr > dr) {
			return;
		}

		solveHV(maze, sc + 1, sr, dc, dr, ans + "H");// horizontal call

		solveHV(maze, sc, sr + 1, dc, dr, ans + "V");// vertical call

	}

	private static void solveHVmultipleSteps(int[][] maze, int sc, int sr, int dc, int dr, String ans) {
		if (sr == dr && sc == dc) {
			counter++;
			System.out.println(counter + ". " + ans);
			return;
		}

		if (sc > dc || sr > dr) {
			return;
		}

		for (int i = 1; i + sc <= dc; i++) {
			solveHVmultipleSteps(maze, sc + i, sr, dc, dr, ans + i + "H");// horizontal call
		}

		for (int i = 1; i + sr <= dr; i++) {
			solveHVmultipleSteps(maze, sc, sr + i, dc, dr, ans + i + "V");// vertical call
		}
	}

}
