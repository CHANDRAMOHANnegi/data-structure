package sorting;

public class BubbleSort {

	public static void bubbleSort(int arr[]) {
		int idx = 0;
		while (idx < arr.length) {
			for (int j = 0; j < arr.length - 1 - idx; j++) {
				if (arr[j] > arr[j + 1]) {
					Sort.swap(arr, j, j + 1);
				}
			}
			idx++;
		}
	}
}
