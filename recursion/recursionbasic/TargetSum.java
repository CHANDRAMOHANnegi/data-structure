package recusrion;

public class TargetSum {

	public static void targetSum(int[] arr, int target, int idx, String res) {

		if (idx == arr.length) {
			if (target == 0) {
				System.out.println(res + " ");
			}
			return;
		}
		targetSum(arr, target, idx + 1, res);
		targetSum(arr, target - arr[idx], idx + 1, res + " " + arr[idx]);
	}

	public static void main(String[] args) {
		int arr[] = { 10, 20, 30, 40, 50, 60, 70 };
		targetSum(arr, 70, 0, "");
	}
}
