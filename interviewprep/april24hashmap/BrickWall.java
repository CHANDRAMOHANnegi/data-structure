package april24hashmap;

import java.util.HashMap;

public class BrickWall {

	public static void main(String[] args) {
		int arr[][] = { { 1, 2, 2, 1 }, { 3, 1, 2 }, { 1, 3, 2 }, { 2, 4 }, { 3, 1, 2 }, { 1, 3, 1, 1 } };
		int arr2[][] = { { 6, 2, 2 }, { 1, 4, 4, 1 }, { 2, 5, 3 } };

		System.out.println(solve(arr2));
	}

	private static int solve(int[][] wall) {

		if (wall.length == 0) {
			return 0;
		}

		HashMap<Integer, Integer> map = new HashMap<>();
		int ans = 0;
		for (int[] nums : wall) {
			int sum = 0;
			for (int i = 0; i < nums.length - 1; i++) {
				sum = sum + nums[i];
				if (map.containsKey(sum)) {
					map.put(sum, map.get(sum) + 1);
				} else {
					map.put(sum, 1);
				}
				if (map.get(sum) >= ans) {
					ans = map.get(sum);
				}
			}
		}

		for (int i : map.keySet()) {
			System.out.println(i + " " + map.get(i));
		}

		return wall.length - ans;
	}

}
