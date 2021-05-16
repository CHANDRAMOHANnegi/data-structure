package march31;

public class MinNoofIncresSub {

	public static void main(String[] args) {

		int arr[] = new int[] { 1, 3, 2, 4 };
		solve(arr, 0);

	}

	public static int lds(int arr[], int idx) {

		if (idx == arr.length)
			return 1;

		int nottaken = lds(arr, idx + 1);
		
		int taken = lds(arr, idx + 1);

		return arr.length;
	}

	private static void solve(int[] arr, int i) {

	}
}
