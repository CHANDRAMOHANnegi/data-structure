package dynamicProgramming;

public class BoardPath {
	static int count = 0;

	public static void solve(int start, int end, String path) {

		if (start == end) {
			count++;
			System.out.println(count + ". " + path);
		}

		for (int dice = 1; dice <= 6; dice++) {
			if ((start + dice) <= end) {
				int newStart = start + dice;
				solve(newStart, end, path + "" + dice);
			}
		}
	}

	public static int solvem(int start, int end, int arr[]) {

		if (start == end) {
			return 1;
		}

		if (arr[start] != 0) {
			return arr[start];
		}

		int cstod = 0;

		for (int dice = 1; dice <= 6; dice++) {
			if ((start + dice) <= end) {
				int newStart = start + dice;
				int citod = solvem(newStart, end, arr);
				cstod += citod;
				arr[newStart] = citod;
			}
		}
		return cstod;
	}

	public static int solves(int d) {

		int slider[] = new int[6];
		slider[0] = 1;
		for (int i = 1; i <= d; i++) {
			int nv = slider[0] + slider[1] + slider[2] + slider[3] + slider[4] + slider[5];
			slider[5] = slider[4];
			slider[4] = slider[3];
			slider[3] = slider[2];
			slider[2] = slider[1];
			slider[1] = slider[0];
			slider[0] = nv;
		}

		return slider[0];
	}

	public static int solvet(int start, int end) {

		int[] arr = new int[end - start + 1];
		arr[end] = 1;

		for (int x = end - 1; x >= 0; x--) {
			for (int dice = 1; dice <= 6; dice++) {
				if ((x + dice) <= end) {
					arr[x] += arr[x + dice];
				}
			}
		}

		return arr[0];
	}

	public static void main(String[] args) {
		int n = 10;
//		solve(0, n, "");
//		System.out.println(solvem(0, n, new int[n + 1]));
//		System.out.println(solvet(0, n));
		System.out.println(solves( n));
	}
}
