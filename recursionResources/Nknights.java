package recursionResources;

public class Nknights {
	static int count = 0;

	public static void nknights(boolean chess[][], int kpsf, int box, String ans) {

		if (kpsf == chess.length) {
			count++;
			System.out.println(count + ". " + ans);
			return;
		}
		if (box >= chess.length * chess.length) {
			return;
		}
		nknights(chess, kpsf, box + 1, ans);

		int row = box / chess.length;
		int col = box % chess[0].length;

		if (!chess[row][col]) {
			if (isknightSafe(chess, row, col)) {
				chess[row][col] = true;
				nknights(chess, kpsf + 1, box + 1, ans + "q" + (kpsf + 1) + "b" + box + " ");
				chess[row][col] = false;
			}
		}
	}

	private static boolean isknightSafe(boolean chess[][], int row, int col) {

		int[][] dirs = new int[][] {
				{ +2, +1 }, // East
				{ -2, -1 }, // West
				{ +1, -2 }, // North
				{ -1, +2 }, // South
				{ +2, -1 }, // NE
				{ +1, +2 }, // SE
				{ -2, -1 }, // SW
				{ -1, -2 }, // NW
		};

		for (int i = 0; i < dirs.length; i++) {
			int ekrow = row + dirs[i][1];
			int ekcol = col + dirs[i][0];
			if (ekcol < 0 || ekrow < 0 || ekcol >= chess[0].length || ekrow >= chess.length) {
				continue;
			}
			if (chess[ekrow][ekcol]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		boolean[][] chess = new boolean[4][4];
		nknights(chess, 0, 0, "");
	}
}
