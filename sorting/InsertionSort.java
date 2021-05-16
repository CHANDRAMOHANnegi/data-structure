package sorting;

public class InsertionSort {

	static public void insertionSort(int arr[]) {
		int i = 0;
		while (i < arr.length) {
			for (int j = i; j > 0; j--) {
				if (arr[j] < arr[j - 1]) {
					Sort.swap(arr, j - 1, j);
				}
			}
			i++; 
		}
	}
}
