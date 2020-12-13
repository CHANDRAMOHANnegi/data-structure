package arrays;

public class SearchInSortedArray {
    // https://leetcode.com/problems/search-in-rotated-sorted-array/discuss/948170/Easy-to-understand-Java-Solution
    public static int searchLinearSearch(int nums[], int n) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == n) {
                return i;
            }
        }
        return -1;
    }

    public static int findTarget(int[] nums, int target, int left, int right) {

        if (left > right)
            return -1;

        int mid = left + (right - left) / 2;

        if (nums[mid] == target)
            return mid;

        // Left side is sorted
        if (nums[left] < nums[mid]) {
            if (nums[left] <= target && target <= nums[mid]) {
                return findTarget(nums, target, left, mid - 1);
            } else {
                return findTarget(nums, target, mid + 1, right);
            }
        }

        // Left right is sorted
        if (nums[mid] < nums[right]) {
            if (nums[mid] <= target && target <= nums[right]) {
                return findTarget(nums, target, mid + 1, right);
            } else {
                return findTarget(nums, target, left, mid - 1);
            }
        }

        return -1;
    }

    public static int searchBinary(int nums[], int target) {
        return findTarget(nums, target, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        int nums[] = new int[] { 4, 5, 6, 7, 0, 1, 2 };
        // System.out.println(searchLinearSearch(nums, 0));
        System.out.println(searchBinary(nums, 5));
    }
}
