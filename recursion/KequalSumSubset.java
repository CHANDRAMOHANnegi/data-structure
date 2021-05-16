package recursion;

import java.util.*;

public class KequalSumSubset {
	public boolean canPartitionKSubsets(int[] nums, int k) {
		System.out.println("k--->=" + k);
		if (k < 2) {
			return true;
		}
		if (k > nums.length) {
			return false;
		}
		Arrays.sort(nums);
		int sum = 0;
		for (int i : nums) {
			if (i > 0) {
				sum += i;
			}
		}

		if (sum % k != 0) {

			return false;
		}
		boolean answer = false;
		int equal = sum / k;
		outer: for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] > 0) {
				if (nums[i] == equal) {
					nums[i] = -1;
					answer = canPartitionKSubsets(nums, --k);
					continue;
				} else {
					int isum = nums[i];
					inner: for (int j = i - 1; j >= 0; j--) {
						if (nums[j] > 0) {
							if (isum + nums[j] == equal) {
								nums[i] = -1;
								nums[j] = -1;
								answer = canPartitionKSubsets(nums, --k);
								break inner;
							} else if (isum + nums[j] < equal) {
								isum += nums[j];
								continue;
							} else {
								continue;
							}
						}
					}
				}
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(new KequalSumSubset().canPartitionKSubsets(
				new int[] { 123, 146, 181, 269, 304, 312, 407, 515, 521, 922, 1932, 2512, 2646, 3522, 3871, 4037 }, 5));
	}
}