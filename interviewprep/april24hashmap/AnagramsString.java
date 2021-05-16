package april24hashmap;

import java.util.HashMap;

public class AnagramsString {

	public static void main(String[] args) {
		String str = "cbaebabacd";
		String ptr = "abc";
		System.out.println(solve(str, ptr));
	}

	private static int solve(String str, String ptr) {
		HashMap<Character, Integer> map = new HashMap<>();
		HashMap<Character, Integer> requiredmap = new HashMap<>();
		int count = 0;
		int matchcount = 0;

		return count;
	}
}
