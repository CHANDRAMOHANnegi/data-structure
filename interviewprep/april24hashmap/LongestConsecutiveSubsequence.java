package april24hashmap;

import java.util.HashMap;

public class LongestConsecutiveSubsequence {

	public static void main(String[] args) {
		int[] arr = { 4, 0, -4, -2, 2, 5, 2, 0, -8, -8, -8, -8, -1, 7, 4, 5, 5, -4, 6, 6, -3 };
		System.out.println(solve(arr));
	}

	private static int solve(int[] arr) {
		if (arr.length == 0)
			return 0;

		HashMap<Integer, Integer> map = new HashMap<>();
		int max = 1;

		for (int i = 0; i < arr.length; i++) {
			int length = 0;
			int key = arr[i];
			boolean smaller = map.containsKey(key - 1);
			boolean bigger = map.containsKey(key + 1);
			int sp = key;
			int ep = key;
			if (map.containsKey(key)) {
				continue;
			}
			if (smaller && bigger) {
				sp = key - map.get(key - 1);
				ep = key + map.get(key + 1);
				map.put(key, -1);
			} else if (smaller && !bigger) {
				sp = key - map.get(key - 1);
				ep = key;
			} else if (!smaller && bigger) {
				ep = key + map.get(key + 1);
				sp = key;
			} else {
				map.put(key, 1);
			}
			length = ep - sp + 1;
			map.put(sp, length);
			map.put(ep, length);
			if (length > max)
				max = length;
		}
		return max;
	}

}
