public class SelectionSort {
    public static void swap(int[] nums, int i, int n) {
        int temp = nums[n];
        nums[n] = nums[i];
        nums[i] = temp;
    }

    public static void sort(int nums[]) {
        for (int i = 0; i < nums.length - 1; i++) {
            int min = i;
            for (int j = i; j < nums.length - 1; j++) {
                if (nums[min] > nums[j]) {
                    min = j;
                }
            }
            swap(nums, i, min);
        }
    }

    public static void main(String[] args) {
        int nums[] = new int[] { 1, 3, 4, 3, 5 };
        sort(nums);
        for (int i : nums) {
            System.out.print(i);
        }
    }
}


// O(n^2)
