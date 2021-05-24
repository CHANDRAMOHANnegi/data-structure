
public class PositionInSortedArray {
    public static int[] searchBinary(int nums[], int target) {
        if (nums.length == 0) {
            return new int[] { -1, -1 };
        }
        return findTarget(nums, target, 0, nums.length - 1);
    }

    public static int[] getIndex(int nums[], int target, int index) {
        int start = index;
        int end = index;
        while (start > 0 && nums[start - 1] == target) {
            start--;
        }
        while (end < nums.length-1 && nums[end + 1] == target) {
            end++;
        }
        return new int[] { start, end };
    }

    public static int[] findTarget(int[] nums, int target, int left, int right) {
        if (left == right) {
            if (nums[left] != target) {
                return new int[] { -1, -1 };
            } else {
                return new int[] { left, left };
            }
        }
        int mid = left + (right - left) / 2;

        if (nums[mid] == target) {
            return getIndex(nums, target, mid);
        }
        if (mid == 0) {
            if (nums[mid + 1] != target) {
                return new int[] { -1, -1 };
            } else
                return new int[] { mid + 1, mid + 1 };
        }
        if (nums[mid] > target) {
            return findTarget(nums, target, left, mid - 1);
        } else {
            return findTarget(nums, target, mid + 1, right);
        }
    }

    public static void main(String[] args) {
        int nums[] = new int[] { 2, 2 };
        int[] ans = searchBinary(nums, 2);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}
