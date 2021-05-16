package recursionResources;

public class Nqueens {

	static int count = 0;

	public static void nqueens(boolean[][] chess, int qpsf, String asf, int lqpb) {

		if (qpsf == chess.length) {
			count++;
			if (chessBoardIsValid(chess)) {
				System.out.println(count + ". " + asf);
			}
			return;
		}
		for (int i = lqpb + 1; i < chess.length * chess.length; i++) {
			int row = i / chess.length;
			int col = i % chess.length;
			if (chess[row][col] == false) {
				chess[row][col] = true;
				nqueens(chess, qpsf + 1, asf + " q" + (qpsf + 1) + "b" + i, i);
				chess[row][col] = false;
			}
		}
	}

	public static void nqueensProactive(boolean[][] chess, int qpsf, String asf, int lqpb) {
		if (qpsf == chess.length) {
			count++;
			System.out.println(count + ". " + asf);
			return;
		}
		for (int i = lqpb + 1; i < chess.length * chess.length; i++) {
			int row = i / chess.length;
			int col = i % chess.length;
			if (chess[row][col] == false) {
				if (queenIsSafe(chess, row, col)) {
					chess[row][col] = true;
					nqueensProactive(chess, qpsf + 1, asf + " q" + (qpsf + 1) + "b" + i, i);
					chess[row][col] = false;
				}
			}
		}
	}

	public static void nqueensSS(boolean[][] chess, int box, int qpsf, String asf) {
		if (qpsf == chess.length) {
			count++;
			if (chessBoardIsValid(chess)) {
				System.out.println(count + ". " + asf);
			}
			return;
		}
		nqueensSS(chess, qpsf + 1, box + 1, asf + " q" + (qpsf + 1) + "b");
		int row = box / chess.length;
		int col = box % chess.length;
		if (chess[row][col] == false) {
			if (queenIsSafe(chess, row, col)) {
				chess[row][col] = true;
				nqueensSS(chess, qpsf + 1, box + 1, asf + " q" + (qpsf + 1) + "b");
				chess[row][col] = false;
			}
		}
	}

	private static boolean chessBoardIsValid(boolean[][] chess) {
		for (int row = 0; row < chess.length; row++) {
			for (int col = 0; col < chess[row].length; col++) {
				if (chess[row][col] == true) {
					if (queenIsSafe(chess, row, col) == false) {
						return false;
					}
				}
			}
		}
		return true;
	}

	private static boolean queenIsSafe(boolean[][] chess, int row, int col) {
		int dirs[][] = { { 0, -1 }, // North
				{ +1, -1 }, // NE
				{ +1, 0 }, // East
				{ +1, +1 }, // SE
				{ 0, +1 }, // South
				{ -1, +1 }, // SW
				{ -1, 0 }, // West
				{ -1, -1 },// NW
		};

		for (int di = 0; di < dirs.length; di++) {
			for (int dist = 1; true; dist++) {
				int eqcol = col + dist * dirs[di][0];
				int eqrow = row + dist * dirs[di][1];
				if (eqcol < 0 || eqrow < 0 || eqcol >= chess[0].length || eqrow >= chess.length) {
					break;
				}
				if (chess[eqrow][eqcol] == true) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int n = 4;
		nqueens(new boolean[n][n], 0, "", -1);
//		count=0;
//		nqueensProactive(new boolean[n][n], 0, "", -1);
	}
}
