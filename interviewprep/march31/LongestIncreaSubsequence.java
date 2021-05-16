package march31;

import java.util.ArrayList;
import java.util.HashMap;

public class LongestIncreaSubsequence {

	public static void main(String[] args) {

		int arr1[] = new int[] { 10, 9, 2, 5, 3, 7, 101, 19 };
		int arr2[] = new int[] { 4 };
		HashMap<Integer, Integer> dp = new HashMap<>();
		dp.put(1, arr2[0]);

//		System.out.println(solve(arr1, Integer.MIN_VALUE, 0));
		System.out.println(solveT(arr2));
//		System.out.println(solveM(arr2, dp));
	}

	private static int solveM(int nums[], HashMap<Integer, Integer> dp) {
		if (nums.length == 0) {
			return 0;
		}
		int lastkey = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j : dp.keySet()) {
				if (nums[i] <= dp.get(j)) {
					dp.put(j, nums[i]);
					if (j == dp.size()) {
						lastkey = j;
					}
					break;
				}
				if (j == dp.size() && nums[i] > dp.get(j)) {
					dp.put(j + 1, nums[i]);
					lastkey = j + 1;
				}
			}
		}
		return lastkey;
	}

	private static int solveT(int[] arr) {
		if (arr.length == 0)
			return 0;
		ArrayList<Integer> ans = new ArrayList<Integer>();
		ans.add(arr[arr.length - 1]);
		int res[] = new int[arr.length];
		res[arr.length - 1] = 1;
		int max = 1;
		for (int i = arr.length - 1; i >= 0; i--) {
			res[i] = 1;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] > arr[i] && res[j] >= res[i]) {
					res[i] = res[j] + 1;
				}
				if (res[i] > max) {
					ans.add(arr[i]);
					max = res[i];
					break;
				}
			}
		}
		if (ans.size() > 1 && ans.get(0) < ans.get(1)) {
			ans.remove(0);
		}
		return max;
	}

	// 10, 9, 2, 5, 3, 7, 101, 18
	public static int solve(int[] nums, int prev, int curpos) {
		if (curpos == nums.length) {
			return 0;
		}
		int taken = 0;
		if (nums[curpos] > prev) {
			taken = 1 + solve(nums, nums[curpos], curpos + 1);
		}
		int nottaken = solve(nums, prev, curpos + 1);
		return Math.max(taken, nottaken);
	}
}
