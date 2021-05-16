package dynamicProgramming;

public class MazSizeSquare {
	static int maxsize = 0;
	static int maxrow = -1;
	static int maxcol = -1;

	public static void main(String[] args) {
		int maze[][] = { { 1, 1, 0, 0, 1, 1 }, { 0, 0, 1, 0, 1, 1 }, { 1, 1, 1, 1, 1, 0 }, { 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1 }, { 0, 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 1, 1 } };
//		solveT(maze);
		solveM(maze, 0, 0);
		System.out.println(" " + maxsize + "@[" + maxrow + " " + maxcol + " }");
	}

	private static void solveT(int[][] maze) {
		int maxSize = 0;
		int maxRow = -1;
		int maxCol = -1;

		for (int row = maze.length - 2; row >= 0; row--) {
			for (int col = maze[0].length - 2; col >= 0; col--) {
				maze[row][col] = maze[row][col]
						+ Math.min(maze[row + 1][col], Math.min(maze[row][col + 1], maze[row + 1][col + 1]));
				if (maze[row][col] > maxSize) {
					maxCol = col;
					maxRow = row;
					maxSize = maze[row][col];
				}
			}
		}
		System.out.println(maxSize + " row " + maxRow + " col " + maxCol);
	}

	private static int solveM(int[][] maze, int sr, int sc) {

		int dr = maze.length - 1;
		int dc = maze[0].length - 1;

		if (sr == dr || sc == dc) {
//			System.out.println("===>----");
			return maze[sr][sc];
		} else if (maze[sr][sc] == 0) {
//			System.out.println("===>======");
			return 0;
		} else {
			int h = solveM(maze, sr, sc + 1);
			int v = solveM(maze, sr + 1, sc);
			int d = solveM(maze, sr + 1, sc + 1);

			if (sr == 2 && sc == 1) {
				System.out.println("-----------------");
			}

			int res = 1 + Math.min(v, Math.min(h, d));
			System.out.println(" row " + sr + " col " + sc);
			if (res > maxsize) {
				maxsize = res;
				maxcol = sc;
				maxrow = sr;
			}
			return res;
		}
	}
}
