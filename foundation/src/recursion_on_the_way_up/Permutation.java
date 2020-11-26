
package recursion_on_the_way_up;

public class Permutation {

	public static void main(String[] args) {

		permutation("abc");
	}

	static private void permutationRec(String str, String asf) {
		if (str.length() == 0) {
			System.out.println(asf);
		}

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			String lp = str.substring(0, i);
			String rp = str.substring(i + 1);

			permutationRec(lp + rp, asf + c);

		}
	}

	static private void permutation(String str) {

		for (int i = 0; i < str.length(); i++) {

		}
	}
}
