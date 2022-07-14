import java.util.Arrays;

public class TargetSumPair {

    public static void main(String[] args) {
        targetSumPair(new int[] { 18, 5, 4, 20, 7, 22, 19, 25 }, 25);
    }

    public static void targetSumPair(int[] nums, int tar) {

        Arrays.sort(nums); // nlogn

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            if (nums[left] + nums[right] > tar) {
                right--;
            } else if (nums[left] + nums[right] < tar) {
                left++;
            } else {
                System.out.println(nums[left] + " " + nums[right]);
                left++;
                right--;
            }
        }
    }

}
