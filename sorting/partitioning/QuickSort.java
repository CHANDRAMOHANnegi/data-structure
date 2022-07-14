public class QuickSort {

    public static void main(String[] args) {
        int arr[] = new int[] { 17, 9, 3, 2, 6, 8, 5 };

        quickSort(arr, 0, arr.length - 1);

        for (int i : arr) {
            System.out.println(i);
        }

    }

    public static void quickSort(int arr[], int lo, int hi) {
        if (lo > hi) {
            return;
        }

        int pivot = arr[hi];
        int pidx = partition(arr, lo, hi, pivot);

        quickSort(arr, pidx + 1, hi);
        quickSort(arr, lo, pidx - 1);
    }

    public static int partition(int arr[], int lo, int hi, int pivot) {

        int i = 0;
        int j = 0;

        while (i < arr.length) {
            if (arr[i] > pivot) {
                i++;
            } else {
                swap(arr, i, j);
                i++;
                j++;
            }
        }
        return j - 1;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
