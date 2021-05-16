package recursionResources;

import java.util.Arrays;

public class SumEqualTarget {

	public static void main(String[] args) {
		int target = 70;
		int nums[] = new int[] { 1, 1, 2, 2,3, 3 };
		int nums2[] = new int[] { 5 };
//		solve(nums, target, 0, "");
		System.out.println(canPartitionKSubsets(nums, 3));
//		solve2(nums, 0, 0, "", 0, "");
	}

	public static boolean search(int[] groups, int row, int[] nums, int target) {
		System.out.println();
		for (int i : groups) {
			System.out.println(i);
		}
		if (row < 0)
			return true;
		System.out.println("row " + row + " " + nums[row] + "  tar " + target);

		int v = nums[row--];
		for (int i = 0; i < groups.length; i++) {
			System.out.println("->" + groups[i] + " " + v);
			if (groups[i] + v <= target) {
				groups[i] += v;
				if (search(groups, row, nums, target))
					return true;
				System.out.println("-------------------");
				groups[i] -= v;
			}
			if (groups[i] == 0) {
				System.out.println("break");
				break;
			}
		}
		return false;
	}

	public static boolean canPartitionKSubsets(int[] nums, int k) {
		int sum = Arrays.stream(nums).sum();
		if (sum % k > 0)
			return false;
		int target = sum / k;

		Arrays.sort(nums);
		int row = nums.length - 1;
		if (nums[row] > target)
			return false;
		while (row >= 0 && nums[row] == target) {
			row--;
			k--;
		}
		return search(new int[k], row, nums, target);
	}

	private static void solve(int[] arr, int tar, int idx, String ans) {
		System.out.println("------------------------------------------");
		if (idx == arr.length) {
			System.out.println("end-->");
			if (tar == 0) {
				System.out.println("[" + ans + "]");
			}
			return;
		}
		System.out.println(">>>>>" + idx + "    " + arr[idx] + " .>" + ans + "  tar " + tar);

//		System.out.println("--->" + idx + "    " + arr[idx] + " .>" + ans + "  tar " + tar);
		solve(arr, tar, idx + 1, ans);
//		System.out.println("===========>" + idx + "    " + arr[idx] + " .>" + ans + "  tar " + tar);
		solve(arr, tar - arr[idx], idx + 1, ans + arr[idx] + ",");
//		System.out.println(">>>>>" + idx + "    " + arr[idx] + " .>" + ans + "  tar " + tar);
	}

	private static void solve2(int[] arr, int vidx, int setsum1, String str1, int setsum2, String str2) {
		if (vidx == arr.length) {
			if (setsum1 == setsum2) {
				System.out.println("[" + str1 + "        " + str2 + "]");
			}
			return;
		}
		solve2(arr, vidx + 1, setsum1 + arr[vidx], str1 + " " + arr[vidx], setsum2, str2);
		solve2(arr, vidx + 1, setsum1, str1, setsum2 + arr[vidx], str2 + " " + arr[vidx]);
	}
}
