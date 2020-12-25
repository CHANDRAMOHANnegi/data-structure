package recursion_on_the_way_up;

public class KeypathPad {

	public static void main(String[] args) {

		String[] codes = { ".", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };

		kpc(codes, "78", "");
	}

	public static void kpc(String[] codes, String str, String ans) {
		if (str.length() == 0) {
			System.out.println(ans);
			return;
		}

		char c = str.charAt(0);
		String ros = str.substring(1);

		String alph = codes[c - '0'];

		for (int i = 0; i < alph.length(); i++) {
			kpc(codes, ros, ans + alph.charAt(i));
		}
	}
}
