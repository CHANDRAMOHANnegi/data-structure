package sotingbyrecursion;

public class Sort {

	static public void bs(int[] arr, int si, int li) {

		if (li == 0) {
			System.out.println("li"+" == "+"0");
			return;
		}
		if (si == li) {
			System.out.println(si+" "+li);
			bs(arr, 0, li - 1);
			System.out.println(si+"     "+li);
			return;
		}
		if (arr[si] > arr[si + 1]) {
			int temp = arr[si];
			arr[si] = arr[si + 1];
			arr[si + 1] = temp;
		}
		System.out.println("si "+si+" li "+li);
		bs(arr, si + 1, li);
	}

	public static void main(String[] args) {

		int[] arr = { 3, 2, 6, 5, 1, 8 };
		Sort.bs(arr, 0, arr.length - 1);
//		for (int i : arr) {
//			System.out.println(i);
//
//		}
	}
}
