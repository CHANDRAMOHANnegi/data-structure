package recursion_on_the_way_up;

import java.util.ArrayList;

public class StairPath {

	public static void main(String[] args) {

		int n = 3;

		System.out.println(getStairPath(n));
		printStairPath(n, "");
	}

	public static ArrayList<String> getStairPath(int n) {

		if (n == 0) {
			ArrayList<String> base = new ArrayList<>();
			base.add("");
			return base;
		} else if (n < 0) {

			// if n is less than 0 then there is no path

			ArrayList<String> base = new ArrayList<>();
			return base;
		}

		ArrayList<String> prev1 = getStairPath(n - 1);
		ArrayList<String> prev2 = getStairPath(n - 2);
		ArrayList<String> prev3 = getStairPath(n - 3);
		ArrayList<String> finalList = new ArrayList<>();

		for (String s : prev3) {
			finalList.add(s + 3);
		}
		for (String s : prev2) {
			finalList.add(s + 2);
		}

		for (String s : prev1) {
			finalList.add(s + 1);
		}

		return finalList;
	}

	public static void printStairPath(int n, String ans) {

		if (n == 0) {
			System.out.println(ans);
		} else if (n < 0) {
			return;
		}

		printStairPath(n - 1, ans + "1");
		printStairPath(n - 2, ans + "2");
		printStairPath(n - 3, ans + "3");

	}

}
