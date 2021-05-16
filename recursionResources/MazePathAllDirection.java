package recursionResources;

public class MazePathAllDirection {

	public static void mazePath(int sc, int sr, int[][] maze, boolean[][] visited, String pathsofar) {

		if (sc == maze[0].length - 1 && sr == maze.length - 1) {
			System.out.println("==>" + pathsofar);
			return;
		}

		if (sc > maze[0].length - 1 || sr > maze.length - 1) {
			return;
		} else if (sr < 0 || sc < 0) {
			return;
		} else if (visited[sr][sc] == true) {
			return;
		} else if (maze[sr][sc] == 0) {
			return;
		}

		visited[sr][sc] = true;
		mazePath(sc + 1, sr, maze, visited, pathsofar + "R");
		mazePath(sc - 1, sr, maze, visited, pathsofar + "L");
		mazePath(sc, sr + 1, maze, visited, pathsofar + "D");
		mazePath(sc, sr - 1, maze, visited, pathsofar + "T");
		visited[sr][sc] = false;

	}

	public static void main(String[] args) {
		int maze[][] = { { 1, 0, 1, 1 }, { 1, 1, 1, 1 }, { 1, 0, 1, 1 }, { 1, 1, 0, 1 } };
		boolean[][] visited = new boolean[maze.length][maze[0].length];
		MazePathAllDirection.mazePath(0, 0, maze, visited, "");

	}
}
