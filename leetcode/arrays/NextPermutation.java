package arrays;

public class NextPermutation {
    public static void swap(int[] nums, int i, int n) {
        int temp = nums[n];
        nums[n] = nums[i];
        nums[i] = temp;
    }

    public static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

    public static int[] nextPermutation(int nums[]) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1, nums.length - 1);
        return nums;
    }

    public static void main(String[] args) {
        int arr[] = new int[] { 1, 3, 2 };
        int ans[] = nextPermutation(arr);
        for (int k : ans) {
            System.out.print(" " + k);
        }
    }
}
