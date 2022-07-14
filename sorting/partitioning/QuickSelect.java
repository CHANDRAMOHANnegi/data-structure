public class QuickSelect {

    public static void main(String[] args) {
        int arr[] = new int[] { 17, 9, 3, 2, 6, 8, 5 };

        System.out.println(quickSelect(arr, 0, arr.length - 1, 1));
    }

    public static int quickSelect(int arr[], int lo, int hi, int k) {
        if (lo == hi) {
            return arr[lo];
        }
        int pivot = arr[hi];
        int pidx = partition(arr, lo, hi, pivot);

        if (k == pidx) {
            return pivot;
        } else if (k > pidx) {
            return quickSelect(arr, pidx + 1, hi, k);
        } else {
            return quickSelect(arr, lo, pidx - 1, k);
        }

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
