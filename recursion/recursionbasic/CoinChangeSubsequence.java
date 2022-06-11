package recursion;

public class CoinChangeSubsequence {

	public static void main(String[] args) {
		int arr[] = new int[] { 2, 3, 5, 7 };
//		dupSolveC(arr, 10, 0, "");
		dupSolveP(arr, 10, 0, "");
	}

	private static void dupSolveC(int[] arr, int target, int idx, String ans) {

		if (idx == arr.length || target == 0) {
			if (target == 0) {
				System.out.println(ans);
				return;
			}
			return;
		}

		dupSolveC(arr, target, idx + 1, ans);
		if (target - arr[idx] >= 0)
			dupSolveC(arr, target - arr[idx], idx, ans + " " + arr[idx]);
	}

	private static void dupSolveP(int[] arr, int target, int idx, String ans) {

		if (idx == arr.length || target == 0) {
			if (target == 0) {
				System.out.println(ans);
				return;
			}
			return;
		}

		dupSolveP(arr, target, idx + 1, ans);
		if (target - arr[idx] >= 0)
			dupSolveP(arr, target - arr[idx], 0, ans + " " + arr[idx]);
	}

}
