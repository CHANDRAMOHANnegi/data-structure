package sorting;

public class SelectionSort {

	static public void selectionSort(int arr[]) {

		int idx = 0;
		while (idx < arr.length) {
			int min = idx;
			for (int ptr = idx + 1; ptr < arr.length; ptr++) {
				if (arr[ptr] < arr[min]) {
					min = ptr;
				}
			}
			swap(arr, min, idx);
			idx++;
		}
	}

	static public void swap(int arr[], int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 3, 4, 2, 1, 6, 7, 0 };
		selectionSort(arr);
		for (int i : arr) {
			System.out.println(i);
		}
	}
}
