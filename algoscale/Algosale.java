
public class Algosale {

	public static int[] addTwo(int arr[], int n) {

		int f = -1;
		int s = -1;

		for (int i = 0; i < arr.length - 1; i++) {
			int rem = Math.abs(arr[i] - n);

//			s = find(arr, rem, 0);
			f = i;
			if (s != -1)
				break;
		}
		if (s != -1) {
			return new int[] { f, s };
		} else {
			return null;
		}
	}

	static public int find(String arr[], String n, int idx) {
		if (idx == arr.length - 1) {
			return -1;
		}

		if (arr[idx] == n)
			return idx;
		else
			return find(arr, n, idx + 1);

	}

	public static String findIncomplete(String[] participant, String[] completion) {
		String s = "";

		for (int i = 0; i < completion.length; i++) {
			int found = find(completion, participant[i], 0);
			if (found == -1) {
				s = participant[i];
				break;
			}
		}
		return s;
	}

	public static void main(String[] args) {

		int[] arr = { 2, 7, 11, 15 };

		String[] p = { "leo", "kiki", "eden" };
		String[] c = { "leo", "kiki" };

		System.out.println(Algosale.findIncomplete(p, c));

//		int[] res = Algosale.addTwo(arr, 18);
//		for (int x : res) {
//			System.out.println(x);
//		}

	}

}
