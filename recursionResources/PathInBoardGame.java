package recursionResources;

public class PathInBoardGame {

	static int counter = 0;

	public static void path(int s, int des, String pathsofar) {

		if (s == des) {
			counter++;
			System.out.println(counter + "---->" + pathsofar);
			return;
		}
		for (int dice = 1; dice <= 6; dice++) {
			int newsrc = s + dice;
			if (newsrc <= des) {
				path(newsrc, des, pathsofar + dice);
			}
		}

	}

	public static void pathStartWith1and6(int s, int des, String pathsofar) {

		if (s == des) {
			counter++;
			System.out.println(counter + "---->" + pathsofar);
			return;
		}

		if (s == 0) {
			pathStartWith1and6(1, des, pathsofar + 1);
			pathStartWith1and6(1, des, pathsofar + 6);
		} else {
			for (int dice = 1; dice <= 6; dice++) {
				int newsrc = s + dice;
				if (newsrc <= des)
					pathStartWith1and6(newsrc, des, pathsofar + dice);
			}
		}
	}

	public static void pathStartWith1and6WithLadders(int s, int des, int[] ladder, String pathsofar) {

		if (s == des) {
			counter++;
			System.out.println(counter + "---->" + pathsofar);
			return;
		}

		if (s == 0) {
			pathStartWith1and6WithLadders(1, des, ladder, pathsofar + 1);
			pathStartWith1and6WithLadders(1, des, ladder, pathsofar + 6);
		} else if (ladder[s] != 0) {
			pathStartWith1and6WithLadders(ladder[s], des, ladder, pathsofar + "[" + s + "->" + ladder[s] + "]");
		} else {
			for (int dice = 1; dice <= 6; dice++) {
				int newsrc = s + dice;
				if (newsrc <= des)
					pathStartWith1and6WithLadders(newsrc, des, ladder, pathsofar + dice);
			}
		}
	}

	public static void pathStartWith1and6WithSnakeLadder(int src, int dest, int[] snl, int[] moves, int mvidx) {

		if (src == dest) {
			System.out.println("you won ");
			return;
		}

		if (moves.length == mvidx) {
			System.out.println("moves over " + src);
			return;
		}

		if (src == 0) {
			if (moves[mvidx] == 1 || moves[mvidx] == 6) {
				pathStartWith1and6WithSnakeLadder(1, dest, snl, moves, mvidx + 1);
			} else {
				pathStartWith1and6WithSnakeLadder(src, dest, snl, moves, mvidx + 1);
			}
		} else {
			if (snl[src] != 0) {
				pathStartWith1and6WithSnakeLadder(snl[src], dest, snl, moves, mvidx);
			} else {
				if (src + moves[mvidx] <= dest) {
					pathStartWith1and6WithSnakeLadder(src + moves[mvidx], dest, snl, moves, mvidx + 1);
				} else {
					pathStartWith1and6WithSnakeLadder(src, dest, snl, moves, mvidx + 1);
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] snl = new int[21];

		snl[3] = 17;
		snl[7] = 11;
		snl[13] = 5;
		snl[19] = 2;

		int moves[] = { 2, 5, 3, 4, 6, 3, 4, 3, 5, 1, 2, 3 };
		int moves2[] = { 2, 5, 3, 4, 6, 3, 4, 3, 5, 1 };

//		PathInBoardGame.path(0, 6, "");
//		PathInBoardGame.pathStartWith1and6(0, 10, "");
//		PathInBoardGame.pathStartWith1and6WithLadders(0, 16, ladder, "");
		pathStartWith1and6WithSnakeLadder(0, 20, snl, moves, 0);

	}
}
