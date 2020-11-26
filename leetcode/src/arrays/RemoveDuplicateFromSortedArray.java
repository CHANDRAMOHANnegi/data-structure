package arrays;

public class RemoveDuplicateFromSortedArray {
	public static int removeDuplicates(int[] nums) {
		int start = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i - 1]) {
				nums[start++] = nums[i];
			}
		}
		return start;
	}

	public static void main(String[] args) {
		int arr[] = new int[] { 0, 1, };
		System.out.println(removeDuplicates(arr));
	}
}

// { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 }