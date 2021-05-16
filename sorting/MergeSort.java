package sorting;

public class MergeSort {

	static public int[] merge(int arr1[], int arr2[]) {

		int[] merge = new int[arr1.length + arr2.length];
		int i = 0;
		int j = 0;
		int k = 0;

		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] < arr2[j]) {
				merge[k] = arr1[i];
				i++;
			} else {
				merge[k] = arr2[j];
				j++;
			}
			k++;
		}
		while (i < arr1.length) {
			merge[k] = arr1[i];
			i++;
			k++;
		}
		while (j < arr2.length) {
			merge[k] = arr2[j];
			j++;
			k++;
		}

		return merge;
	}

	public static int[] mergeSort(int arr[], int low, int high) {
		if (low == high) {
			int[] barr = new int[1];
			barr[0] = arr[low];
			return barr;
		}

		int mid = (low + high) / 2;
		int[] fhalf = mergeSort(arr, low, mid);
		int[] shalf = mergeSort(arr, mid + 1, high);
		int sorted[] = merge(fhalf, shalf);
		return sorted;
	}
}
