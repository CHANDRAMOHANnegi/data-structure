
public class Encoding {

	public static void main(String[] args) {
		String str = "110028";
		solve(str, "");
	}

	private static void solve(String str, String ans) {

		if (str.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = str.charAt(0);
		String rem = str.substring(1);

		if (ch == '0') {
			solve(rem, ans);
		} else {
			solve(rem, ans + "" + (char) (ch - '1' + 'a'));
			if ((ch - '0') < 3 && str.length() > 1) {
				char ch1 = rem.charAt(0);
				int num = (ch - '0') * 10 + (ch1 - '0');
				if (num <= 26)
					solve(str.substring(2), ans + "" + (char) (num + 'a' - 1));
			}
		}
	}
}
