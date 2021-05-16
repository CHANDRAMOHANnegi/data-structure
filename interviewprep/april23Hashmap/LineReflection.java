package april23Hashmap;

import java.util.HashMap;
import java.util.HashSet;

public class LineReflection {

	public static void main(String[] args) {

		int arr1[][] = { { 1, 4 }, { 5, 4 }, { 2, 3 }, { 4, 3 }, { 1, 1 }, { 3, 1 }, { 5, 1 } };
		int arr2[][] = { { -1, 1 }, { 1, 2 } };
		System.out.println(solve(arr1));

	}

	private static boolean solve(int[][] arr) {
		HashMap<String, Boolean> map = new HashMap<>();
		int maxX = Integer.MIN_VALUE;
		int minX = Integer.MAX_VALUE;
		for (int[] nums : arr) {
			if (nums[0] > maxX) {
				maxX = nums[0];
			}
			if (nums[0] < minX) {
				minX = nums[0];
			}
			map.put(nums[0] + "," + nums[1], false);
		}
		int midX = (maxX + minX) / 2;
		for (int[] arr1 : arr) {
			int x1 = arr1[0];
			int y1 = arr1[1];
			int x2 = 2 * midX - x1;
			if (!map.get(x1 + "," + y1)) {
				if (map.containsKey(x2 + "," + y1)) {
					map.put(x1 + "," + y1, true);
					map.remove(x2 + "," + y1, true);
				} else {
					return false;
				}
			}
		}
		return true;
	}
}
