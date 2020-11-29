
class BubbleSort {//inPlace stable

    public static void swap(int[] nums, int i, int n) {
        int temp = nums[n];
        nums[n] = nums[i];
        nums[i] = temp;
    }

    public static void sort(int nums[]) {
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = 0; j < nums.length - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
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
