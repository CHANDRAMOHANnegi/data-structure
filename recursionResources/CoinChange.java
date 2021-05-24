public class CoinChange {

	public static void main(String[] args) {

		int arr[] = { 2, 3, 5, 7 };
		int target = 10;

		System.out.println("combination dup");
		dupSolveC(arr, target, 0, "");

		System.out.println("combination no dup");
		noDupSolveC(arr, target, 0, "");

		System.out.println("permutation");
		dupSolveP(arr, target, "");

		System.out.println("permutation no dup");
		noDupSolveP(arr, new boolean[4], target, "");

	}

	private static void noDupSolveC(int[] arr, int target, int idx, String ans) {
		if (target == 0) {
			System.out.println(ans);
			return;
		}

		for (int i = idx; i < arr.length; i++) {
			if (target - arr[i] >= 0) {
				noDupSolveC(arr, target - arr[i], i + 1, ans + " " + arr[i]);
			}
		}
	}

	private static void noDupSolveP(int[] arr, boolean[] isDone, int target, String ans) {
		if (target == 0) {
			System.out.println(ans);
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if (target - arr[i] >= 0 && !isDone[i]) {
				isDone[i] = true;
				noDupSolveP(arr, isDone, target - arr[i], ans + " " + arr[i]);
				isDone[i] = false;
			}
		}
	}

	public static void dupSolveC(int arr[], int target, int idx, String ans) {
		if (target == 0) {
			System.out.println(ans);
			return;
		}
		for (int i = idx; i < arr.length; i++) {
			if (target - arr[i] >= 0) {
				dupSolveC(arr, target - arr[i], i, ans + " " + arr[i]);
				idx++;
			}
		}
	}

	public static void dupSolveP(int arr[], int target, String ans) {
		if (target == 0) {
			System.out.println(ans);
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if (target - arr[i] >= 0) {
				dupSolveP(arr, target - arr[i], ans + " " + arr[i]);
			}
		}

	}

}
