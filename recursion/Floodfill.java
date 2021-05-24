
public class Floodfill {
	int count = 0;

	public static void main(String[] args) {
		int n = 3;
		boolean[][] maze = new boolean[n][n];
		solve(maze, 0, 0, 2, 2, "");
	}

	public static boolean isValidLocation(boolean[][] maze, int x, int y) {
		if (x < 0 || y < 0 || x >= maze.length || y >= maze[0].length || maze[x][y] == true) {
			return false;
		}
		return true;
	}

	private static void solve(boolean[][] maze, int sr, int sc, int dr, int dc, String ans) {

		if (sr == dr && sc == dc) {
			System.out.println(ans);
			return;
		}

//		String[] ds = { "R", "L", "U", "D" };
		String[] ds = { "R", "L", "U", "D", "a", "a", "b", "c", "d" };

//		int dirs[][] = { { 0, 1 }, // R
//				{ 0, -1 }, // L
//				{ -1, 0 }, // U
//				{ 1, 0 },// D
//		};

		int dirs[][] = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 }, { -1, -1 }, { 1, -1 }, { -1, 1 }, { 1, 1 } };
		maze[sr][sc] = true;

		for (int d = 0; d < dirs.length; d++) {
			int x = sr + dirs[d][0];
			int y = sc + dirs[d][1];
			if (isValidLocation(maze, x, y)) {
				solve(maze, x, y, dr, dc, ans + ds[d]);
			}
		}
		maze[sr][sc] = false;
	}
}
