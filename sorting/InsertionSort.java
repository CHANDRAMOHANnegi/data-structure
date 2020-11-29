
class InsertionSort {

    public static void sort(int nums[]) {
        for (int i = 1; i < nums.length - 1; i++) {
            int value = nums[i];
            int j = i;
            while (j > 0 && value < nums[j - 1]) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = value;
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
