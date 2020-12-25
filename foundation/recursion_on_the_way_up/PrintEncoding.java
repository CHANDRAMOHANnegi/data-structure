package recursion_on_the_way_up;

public class PrintEncoding {

	public static void main(String[] args) {
		printencoding("12302", "");
	}

	public static void printencoding(String str, String asf) {
		if (str.length() == 0) {
			System.out.println(asf);
			return;
		} else {
			char ch = str.charAt(0);

			System.out.println(ch);
			if (ch == '0') {
				return;
			}

			int n = ch - '0';
			char code = (char) ('a' + n - 1);

			if (str.length() == 1) {
				System.out.println(asf + code);
			} else {
				printencoding(str.substring(1), asf + code);
				String ch2 = str.substring(0, 2);
				int n2 = Integer.parseInt(ch2);
				if (n2 <= 26) {
					char code2 = (char) ('a' + n2 - 1);
					printencoding(str.substring(2), asf + code2);
				}
			}
		}
	}
}
