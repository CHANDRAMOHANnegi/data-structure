package recursionResources;

import java.util.ArrayList;

public class KeyPadPattern {

	public static ArrayList<String> pattern(String arr[], String str) {

		if (str.length() ==0) {
			ArrayList<String> br = new ArrayList<String>();
//			for (int i = 0; i < arr[Integer.parseInt(str)].length(); i++) {
//				br.add(arr[Integer.parseInt(str)].charAt(i) + "");
//			}
			br.add("");
			return br;
		}

		char f = str.charAt(0);
		String rem = str.substring(1);

		ArrayList<String> pat = pattern(arr, rem);
		ArrayList<String> res = new ArrayList<String>();

		for (String s : pat) {
			for (int i = 0; i < arr[Integer.parseInt(String.valueOf(f))].length(); i++) {
				res.add(arr[Integer.parseInt(String.valueOf(f))].charAt(i) + s);
			}
		}
		return res;
	}

	public static void main(String[] args) {

		String[] arr = { ".", "abc", "def", "ghi", "jkl", "mno", "pqr", "st", "uvwx", "yz" };
		String nm = "179";
		System.out.println(KeyPadPattern.pattern(arr, nm));

	}
}
