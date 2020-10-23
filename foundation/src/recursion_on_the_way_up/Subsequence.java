package recursion_on_the_way_up;

import java.util.ArrayList;

public class Subsequence {

	public static void main(String[] args) throws Exception {
//		System.out.println(getSub("abc"));
		printSub("ab", "");
	}

	public static ArrayList<String> getSub(String str) {

		if (str.length() == 0) {
			ArrayList<String> myans = new ArrayList<>();
			myans.add("");
			return myans;
		}

		char c = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> ans = getSub(ros);
		ArrayList<String> myans = new ArrayList<>();

		for (String s : ans) {
			myans.add(s + c);
			myans.add(s);
		}
		return myans;
	}

	public static void printSub(String str, String ans) {
		if (str.length() == 0) {
			System.out.println(ans);
			return;
		}

		char c = str.charAt(0);
		String ros = str.substring(1);

		printSub(ros, ans + "");
		printSub(ros, ans + c);

	}

}
