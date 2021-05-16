package march31;

public class MinimumPathSum {

	public static int minPathSum(int[][] grid) {
		return solve(grid, 0, 0);
	}
	
//	recursive solution   -->  giving time limit exceed
	
	public static int solve(int grid[][], int row, int col) {
		if (row == grid.length - 1 && col == grid[0].length - 1) {
			return grid[row][col];
		}
		if (row >= grid.length || col >= grid[0].length) {
			return Integer.MAX_VALUE;
		}
		return Math.min(solve(grid, row, col + 1), solve(grid, row + 1, col)) + grid[row][col];
	}

	/// Tabulation --->best
	
	public static int solveT(int grid[][]) {
		for (int row = grid.length - 1; row >= 0; row--) {
			for (int col = grid[0].length - 1; col >= 0; col--) {
				if (row == grid.length - 1 && col == grid[0].length - 1) {
					grid[row][col] = grid[row][col];
				} else if (row == grid.length - 1)
					grid[row][col] = grid[row][col + 1] + grid[row][col];
				else if (col == grid[0].length - 1)
					grid[row][col] = grid[row + 1][col] + grid[row][col];
				else
					grid[row][col] = Math.min(grid[row + 1][col], grid[row][col + 1]) + grid[row][col];
			}
		}
		return grid[0][0];
	}

	public static void main(String[] args) {

		int[][] grid = new int[][] {
			
				{ 1, 3, 1 },
				{ 1, 5, 1 }, 
				{ 4, 2, 1 }
		};
//		System.out.println(solveT(grid));
		System.out.println(minPathSum(grid));
	}

}