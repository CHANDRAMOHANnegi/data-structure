public class SortEvenOdd {

    public static void main(String[] args) {
        int arr[] = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        sortEvenOdd(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void sortEvenOdd(int arr[]) {
        int i = 0;
        int j = 1;

        while (j < arr.length) {
            if (arr[j] % 2 == 0) {
                swap(arr, i, j);
                i++;
                j++;
            } else {
                if (arr[i] % 2 == 1) {
                    j++;
                } else {
                    i++;
                }
            }
        }
    }

    public static void swap(int[] nums, int i, int n) {
        int temp = nums[n];
        nums[n] = nums[i];
        nums[i] = temp;
    }

}
