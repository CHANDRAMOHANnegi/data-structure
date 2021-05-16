package may4array;

public class KConcatenationMaxSum {

	public static int kConcatenationMaxSum(int[] nums, int k) {

		if (nums.length == 0)
			return 0;

		int MOD = 1000000007;
		int twoConcatenatedArray[] = new int[nums.length * 2];

		int pos = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < nums.length; j++) {
				twoConcatenatedArray[pos] = nums[j];
				pos++;
			}
		}

		int currentMax = 0;
		int overallMax = 0;

		for (int i = 1; i < twoConcatenatedArray.length; i++) {
			if (currentMax < 0) {
				currentMax = twoConcatenatedArray[i];
			} else {
				currentMax = currentMax + twoConcatenatedArray[i];
			}
			if (currentMax > overallMax) {
				overallMax = currentMax;
			}
		}

		int sum = 0;
		for (int i : nums) {
			sum += i;
		}
		if (sum >= 0) {
			overallMax += sum * (k - 2);
		}
		return (int) (overallMax % MOD);
	}

	public static void main(String[] args) {
		int nums[] = { -2, 1, 3 };
		System.out.println(kConcatenationMaxSum(nums, 3));
	}
}
