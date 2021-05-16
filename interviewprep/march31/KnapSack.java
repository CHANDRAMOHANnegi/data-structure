package march31;

public class KnapSack {

	public static int solve(int prices[], int weights[], int capacity, int idx, String ans) {
		if (capacity == 0 || idx == weights.length) {
			return 0;
		}
		if (weights[idx] > capacity)
			return solve(prices, weights, capacity, idx + 1, "");

		int rmax = prices[idx] + solve(prices, weights, capacity - weights[idx], idx + 1, ans + " " + weights[idx]);
		int lmax = solve(prices, weights, capacity - weights[idx], idx + 1, ans + " " + weights[idx]);
		return Math.max(lmax, rmax);
	}

	private static int solveT(int[] prices, int[] weights, int capacity) {
		int[][] arr = new int[weights.length][capacity];
		for (int i = 0; i < prices.length; i++) {
			for (int w = 0; w < capacity; w++) {
				if (i == 0 || w == 0) {
					arr[i][w] = 0;
				} else {
					if (w - weights[i] >= 0)
						arr[i][w] = Math.max(arr[i - 1][w], arr[i - 1][w - weights[i]] + prices[i]);
				}
			}
		}
		for (int[] is : arr) {
			System.out.println();
			for (int i : is) {
				System.out.print(" " + i);
			}
		}
		return arr[prices.length - 1][capacity - 1];
	}

	public static void main(String[] args) {

		int weights[] = new int[] { 2, 5, 1, 3, 4 };
		int[] prices = new int[] { 15, 14, 10, 45, 30 };
//		System.out.println(solve(prices, weights, 10, 0, ""));
		System.out.print(" --> " + solveT(prices, weights, 7));

	}
}
