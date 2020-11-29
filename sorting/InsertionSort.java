
class InsertionSort {

    public static void swap(int[] nums, int i, int n) {
        int temp = nums[n];
        nums[n] = nums[i];
        nums[i] = temp;
    }

    public static void sort(int nums[]) {
        for (int i = 1; i < nums.length - 1; i++) {
            int value = nums[i];
            int j = i;
            while (value > nums[j]) {
                j--;
                swap(nums, j, j + 1);
            }
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
