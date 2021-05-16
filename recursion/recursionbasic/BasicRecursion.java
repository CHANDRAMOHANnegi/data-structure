package recursionbasic;

public class BasicRecursion {

	static void decreasing(int n) {
		if (n == 0)
			return;
		System.out.println(n);
		decreasing(n - 1);
	}

	static void increasing(int n) {
		if (n == 0)
			return;
		increasing(n - 1);
		System.out.println(n);
	}

	static int power(int n, int m) {
		if (m == 0) {
			return 1;
		}
		return power(n, m - 1) * n;
	}

	static public int max(int arr[], int idx) {
		if (idx == 0) {
			return arr[idx];
		}
		int MAX = max(arr, idx - 1);
		return Math.max(MAX, arr[idx]);

	}

	public static void main(String[] args) {
		int[] arr = { 000, 545, 675, 70000 };
		System.out.println(BasicRecursion.max(arr, arr.length - 1));

//		BasicRecursion.decreasing(5);
//		BasicRecursion.increasing(5);
//		System.out.println(BasicRecursion.power(2, 3));

	}
}
