package april24hashmap;

import java.util.HashMap;

public class XofKind {

	static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

	public static boolean solve(int[] deck) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i : deck) {
			if (map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
			} else {
				map.put(i, 1);
			}
		}
		int gcd = map.get(deck[0]);
		for (int i : map.keySet()) {
			gcd = gcd(map.get(i), gcd);
		}
		if (gcd < 2) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 1, 2, 2, 4, 4, 3, 5, 5, 3, 6, 6, 6 };
		System.out.println(solve(arr));

		
		System.out.println(3 % 11);// 3
		System.out.println(-3 % 11);// -3
		System.out.println(3 % -11);// 3
		System.out.println(11 % 3);// 2
		System.out.println(11 % -3);// 2
		System.out.println(-11 % -3);// -2
	}
}
