package heap;

public class HeapSort {

	public static void main(String[] args) {
		int arr[] = { 1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17 };
		heapsort(arr, false);
	}

	public static void heapsort(int arr[], boolean isMax) {
		for (int i = arr.length / 2 - 1; i >= 0; i--) {
			downheapify(arr, i, arr.length, isMax);
		}
		for (int i = arr.length - 1; i > 0; i--) {
			swap(arr, 0, i);
			downheapify(arr, 0, i, isMax);
		}
	}

	public static void downheapify(int arr[], int idx, int n, boolean isMax) {
		int maxidx = idx;
		int lci = 2 * idx + 1;
		int rci = 2 * idx + 2;

		if (lci < n && compareTo((int) arr[lci], (int) arr[maxidx], isMax) > 0) {
			maxidx = lci;
		}
		if (rci < n && compareTo((int) arr[rci], (int) arr[maxidx], isMax) > 0) {
			maxidx = rci;
		}
		if (maxidx != idx) {
			swap(arr, maxidx, idx);
			downheapify(arr, maxidx, n, isMax);
		}
	}

	private static void swap(int arr[], int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}

	public static int compareTo(int val1, int val2, boolean isMax) {
		if (isMax)
			return val1 - val2;
		else
			return val2 - val1;
	}
}
