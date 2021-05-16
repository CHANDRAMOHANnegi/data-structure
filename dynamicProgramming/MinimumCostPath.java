package dynamicProgramming;

public class MinimumCostPath {

	public static int solve(int sr, int sc, int dr, int dc, int[][] cost) {
		if (sr == dr && sc == dc) {
			return cost[0][0];
		}

		int mcstod = 0;
		int mcihtod = Integer.MAX_VALUE;
		int mcivtod = Integer.MAX_VALUE;

		if (sr < dr) {
			mcivtod = solve(sr + 1, sc, dr, dc, cost);
		}

		if (sc < dc) {
			mcihtod = solve(sr, sc + 1, dr, dc, cost);
		}
		mcstod = cost[sr][sc] + Math.min(mcihtod, mcivtod);

		return mcstod;
	}

	public static int solvem(int sr, int sc, int dr, int dc, int[][] cost, int q[][]) {
		if (sr == dr && sc == dc) {
			return cost[0][0];
		}

		if (q[sr][sc] != 0) {
			return q[sr][sc];
		}

		int mcstod = 0;
		int mcihtod = Integer.MAX_VALUE;
		int mcivtod = Integer.MAX_VALUE;

		if (sr < dr) {
			mcivtod = solvem(sr + 1, sc, dr, dc, cost, q);
		}

		if (sc < dc) {
			mcihtod = solvem(sr, sc + 1, dr, dc, cost, q);
		}
		mcstod = cost[sr][sc] + Math.min(mcihtod, mcivtod);
		q[sr][sc] = mcstod;
		return mcstod;
	}

	public static void solvet(int cost[][]) {

		int dr = cost.length - 1;
		int dc = cost[0].length - 1;
		int minValue[][] = new int[cost.length][cost[0].length];
		String path[][] = new String[cost.length][cost[0].length];

		for (int row = dr; row >= 0; row--) {
			for (int col = dc; col >= 0; col--) {
				if (col == dc && row == dr) {
					minValue[row][col] = cost[row][col];
					path[row][col] = ".";
				} else if (row == dr) {
					minValue[row][col] = cost[row][col] + minValue[row][col + 1];
					path[row][col] = "H" + path[row][col + 1];
				} else if (col == dc) {
					minValue[row][col] = cost[row][col] + minValue[row + 1][col];
					path[row][col] = "V" + path[row + 1][col];
				} else {
					if (cost[row + 1][col] < cost[row][col + 1]) {
						path[row][col] = "V" + path[row + 1][col];
						minValue[row][col] = cost[row][col] + minValue[row + 1][col];
					} else {
						minValue[row][col] = cost[row][col] + minValue[row][col + 1];
						path[row][col] = "H" + path[row][col + 1];
					}
				}
			}
		}

		System.out.println(minValue[0][0] + "@ " + path[0][0]);
	}

	public static void main(String[] args) {

		int cost[][] = new int[][] { { 2, 3, 0, 4 }, { 0, 6, 5, 2 }, { 8, 0, 3, 7 }, { 2, 0, 4, 2 } };

//		System.out
//				.println(solvem(0, 0, cost.length - 1, cost[0].length - 1, cost, new int[cost.length][cost[0].length]));

		solvet(cost);

	}
}
