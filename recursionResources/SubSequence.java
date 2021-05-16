package recursionResources;

import java.util.ArrayList;

public class SubSequence {

	public static ArrayList<String> subsequence(String str) {

		if (str.length() == 0) {
			ArrayList<String> list = new ArrayList<String>();
			list.add("");
			return list;
		}

		char first = str.charAt(0);
		String rem = str.substring(1);

		ArrayList<String> sub = subsequence(rem);
		ArrayList<String> result = new ArrayList<String>();

		for (String string : sub) {
			result.add(string + first);
			result.add(string);
		}
		return result;
	}

	public static ArrayList<String> subsequenceASCII(String str) {

		if (str.length() == 0) {
			ArrayList<String> list = new ArrayList<String>();
			list.add("");
			return list;
		}

		char first = str.charAt(0);
		String rem = str.substring(1);

		ArrayList<String> sub = subsequenceASCII(rem);
		ArrayList<String> result = new ArrayList<String>();

		for (String s : sub) {
			result.add(s);
			result.add(s + first);
			result.add((int) first + s);
		}
		return result;

	}

	public static void subS(String ques, String asf) {

		if (ques.length() == 0) {
			System.out.println(asf);
			return;
		}

		char c = ques.charAt(0);
		String rem = ques.substring(1);

		subS(rem, asf);
		subS(rem, asf + c);

	}

	public static void main(String[] args) {
		String str = "ab";
		subS(str, "");
//		System.out.println(SubSequence.subsequence(str));	
//		System.out.println(SubSequence.subsequenceASCII(str));

	}
}
