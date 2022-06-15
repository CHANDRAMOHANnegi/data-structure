
package recursionbasic;

public class TOH {

	public static void toh(int n, String s, String e, String h) {
		if (n == 0)
			return;
		toh(n - 1, s, h, e);
		System.out.println("move " + n + " from " + s + " " + e);
		toh(n - 1, h, e, s);
	}

	public static void main(String[] args) {
		TOH.toh(3, "A", "B", "C");
	}

}
