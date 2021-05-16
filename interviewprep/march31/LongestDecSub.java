package march31;

public class LongestDecSub {

	public static int solve(int[] arr) {
		if (arr.length == 0)
			return 0;
		int tab[] = new int[arr.length];
		tab[0] = 1;
		int max = 1;
		for (int i = 1; i < arr.length; i++) {
			tab[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[i] && tab[j] >= tab[i]) {
					tab[i] = tab[j] + 1;
					if (tab[i] > max) {
						max = tab[i];
						break;
					}
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int arr[] = new int[] { 10, 9, 2, 5, 3, 7, 101, 19 };
		System.out.println(solve(arr));
	}
}
