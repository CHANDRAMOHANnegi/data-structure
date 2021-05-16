package sorting;

public class BubbleSort {

	public static void bubbleSort(int arr[]) {
		int i = 0;
		while (i < arr.length) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					Sort.swap(arr, j, j + 1);
				}
			}
			i++;
		}
	}
}
