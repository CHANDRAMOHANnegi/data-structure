package arrays;

public class RemoveElements {
    public static int removeElement(int[] nums, int val) {
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[start++] = nums[i];
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int arr[] = new int[] {};
        System.out.println(removeElement(arr, 2));
    }
}
