package april23Hashmap;

import java.util.HashSet;

public class ArithmeticProgression {

	public static void main(String[] args) {
		int arr[] = { 2,  4, 10, 6 };
		System.out.println(solve(arr));
	}

	private static boolean solve(int[] arr) {
		int min = Integer.MAX_VALUE;
		int secmin = Integer.MAX_VALUE;
		HashSet<Integer> map = new HashSet<>();

		for (int j = 0; j < arr.length; j++) {
			if (arr[j] < min) {
				secmin = min;
				min = arr[j];
			} else if (arr[j] < secmin && arr[j] != min) {
				secmin = arr[j];
			}
			map.add(arr[j]);
		}
		map.remove(min);
		map.remove(secmin);
		int cd = secmin - min;
		while (!map.isEmpty()) {
			secmin = secmin + cd;
 			boolean key = map.contains(secmin);
			if (key) {
 				map.remove(secmin);
			} else {
				return false;
			}
		}
		return true;
	}




}



