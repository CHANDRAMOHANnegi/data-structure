
public class Sort {

	public static void swap(int arr[], int x, int y) {

		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;

	}

	public static void sort(int[] arr, int n) {

		if (n <= 0) {
			return;
		}

		for (int i = 0; i <= n; i++) {
			if (arr[i] < arr[n]) {
				swap(arr, i, n);
			}
		}
		sort(arr, n - 1);

	}

	static void sort_element(int arr[], int n) {
		int i;
		if (n > 0) {
			for (i = 0; i < n; i++) {
				if (arr[i] >= arr[n - 1]) {
					swap(arr, i, n - 1);
				}
			}
			sort_element(arr, n - 1);
		}
	}

	public static void main(String[] args) {
		int arr[] = { 10, 40, 50, 12, 20, 60, 30, 70 };
		sort(arr, arr.length - 1);
		// sort_element(arr, arr.length - 1);

		for (int i : arr) {
			System.out.println(i + " ");
		}
	}
}
