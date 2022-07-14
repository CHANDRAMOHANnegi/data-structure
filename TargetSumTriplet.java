import java.util.Arrays;

public class TargetSumTriplet {
    public static void main(String[] args) {
        targetSumTriplet(new int[] { 18, 5, 4, 20, 7, 22, 19, 25 }, 25);
    }

    public static void targetSumTriplet(int[] nums, int tar) {

        Arrays.sort(nums); // nlogn
        // meet in the middle
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                if (nums[left] + nums[right] > tar) {
                    right--;
                } else if (nums[left] + nums[right] < tar) {
                    left++;
                } else {
                    System.out.println(nums[i] + " " + nums[left] + " " + nums[right]);
                    left++;
                    right--;
                }
            }
        }
    }

}
