package sorting;

public class Sort {

	static public void swap(int arr[], int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 3, 4, 2, 1, 6, 7, 0 };
		int[] arr1 = new int[] { 0, 4, 2, 1, 6, 7, 3 };
		int[] arr2 = new int[] { 3, 4, 2, 1, 0, 6, 7 };
		int[] arr3 = new int[] { 4, 3, 2, 1, 6, 7, 0 };

//      SelectionSort.selectionSort(arr);
//		InsertionSort.insertionSort(arr3);
//		int sorted[]=MergeSort.mergeSort(arr1, 0, arr1.length-1);
		BubbleSort.bubbleSort(arr);
		for (int i : arr) {
			System.out.println(i);
		}
	}
}
