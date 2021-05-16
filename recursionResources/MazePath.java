package recursionResources;

public class MazePath {

	public static void mazePath(int sr, int sc, int dr, int dc, String path) {

		if (sc == dc && sr == dr) {
			System.out.println(path);
			return;
		}

		if (sr <= dr) {
			mazePath(sr + 1, sc, dr, dc, path + "H");
		}
		if (sc <= dc) {
			mazePath(sr, sc + 1, dr, dc, path + "V");
		}
//		if (sc <= dc && sr <= dr) {
//			mazePath(sr + 1, sc + 1, dr, dc, path + "d");
//		}

	}

	public static void mazePathRecover(int sr, int sc, int dr, int dc, String path) {

		if (sc == dc && sr == dr) {
			System.out.println(path);
			return;
		}

		if (sr > dr || sc > dc) {
			return;
		}

		// vertical
		mazePathRecover(sr + 1, sc, dr, dc, path + "H");

		// horizontal
		mazePathRecover(sr, sc + 1, dr, dc, path + "V");

	}

	public static void mazePathDiagonal(int sr, int sc, int dr, int dc, String path) {

		if (sc == dc && sr == dr) {
			System.out.println(path);
			return;
		}

		if (sr > dr || sc > dc) {
			return;
		}

		// vertical
		mazePathDiagonal(sr + 1, sc, dr, dc, path + "H");

		// horizontal
		mazePathDiagonal(sr, sc + 1, dr, dc, path + "V");

		// diagonal
		mazePathDiagonal(sr + 1, sc + 1, dr, dc, path + "D");

	}

	public static void mazePathMultipleSteps(int sr, int sc, int dr, int dc, String path) {

		if (sc == dc && sr == dr) {
			System.out.println(path);
			return;
		}

		for (int i = 1; i <= dc - sc; i++) {
			mazePathMultipleSteps(sr, sc + 1, dr, dc, path + i + "H");
		}
		for (int j = 1; j <= dr - sr; j++) {
			mazePathMultipleSteps(sr + j, sc, dr, dc, path + j + "V");
		}
		for (int k = 1; k <= (dc - sc) && k <= (dr - sr); k++) {
			mazePathMultipleSteps(sr + k, sc + k, dr, dc, path + k + "D");
		}

	}

	public static void main(String[] args) {

//		MazePath.mazePath(0, 0, 2, 2, "");
//		MazePath.mazePathRecover(0, 0, 2, 2, "");
//		MazePath.mazePathDiagonal(0, 0, 2, 2, "");

		MazePath.mazePathMultipleSteps(0, 0, 3, 3, "");

	}
}
