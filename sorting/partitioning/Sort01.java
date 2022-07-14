public class Sort01 {

    public static void main(String[] args) {
        int arr[] = new int[] { 1, 0, 1, 1, 0, 1, 1 };
        int arr0123[] = new int[] { 1, 1, 2, 2, 0, 1, 1, 0, 2, 2 };
        sort012(arr0123);
        for (int i : arr0123) {
            System.out.println(i);
        }
    }

    public static void sort01(int arr[]) {
        int i = 0;
        int j = 0;

        while (i < arr.length) {
            if (arr[i] == 1) {
                i++;
            } else {
                swap(arr, i, j);
                i++;
                j++;
            }
        }
    }

    public static void sort012(int arr[]) {
        int i = 0;
        int j = 0;
        int k = arr.length - 1;

        while (i <= k) {
            if (arr[i] == 1) {
                i++;
            } else if (arr[i] == 2) {
                swap(arr, i, k);
                k--;
            } else {
                swap(arr, i, j);
                i++;
                j++;
            }
        }
    }

    public static void swap(int[] nums, int i, int n) {
        int temp = nums[n];
        nums[n] = nums[i];
        nums[i] = temp;
    }

}
