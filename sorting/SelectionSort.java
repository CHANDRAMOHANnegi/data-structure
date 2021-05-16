package sorting;

public class SelectionSort {

	static public void selectionSort(int arr[]) {

		int i = 0;
		while (i < arr.length) {
			int min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			swap(arr, min, i);
			i++;
		}
	}

	static public void swap(int arr[], int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 3, 4, 2, 1, 6, 7, 0 };
		SelectionSort.selectionSort(arr);
		for (int i : arr) {
			System.out.println(i);
		}
	}
}
