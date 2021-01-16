
import java.io.*;
import java.util.*;

// Next greater element to the right
// Not greatest
public class NGETR {

	public static void main(String[] args) {
		int arr[] = { 1, 4, 2, 12, 3, 6, 8, 7 };
		int[] res = solveReverse(arr);
//		int[] res = solve(arr);
		for (int i : res) {
			System.out.println(i);
		}
	}

	public static int[] solveReverse(int arr[]) {
		Stack<Integer> stack = new Stack<>();
		int res[] = new int[arr.length];
		res[arr.length - 1] = -1;
		stack.push(arr[arr.length - 1]);

		for (int i = arr.length - 2; i >= 0; i--) {
			while (stack.size() > 0 && arr[i] >= stack.peek()) {
				stack.pop();
			}

			if (stack.size() == 0) {
				res[i] = -1;
			} else {
				res[i] = stack.peek();
			}
			stack.push(arr[i]);
		}
		return res;
	}

	public static int[] solve(int arr[]) {
		Stack<Integer> stack = new Stack<>();
		int res[] = new int[arr.length];

		res[0] = arr[0];
		stack.push(0);

		for (int i = 1; i < arr.length - 1; i++) {
			while (stack.size() > 0 && arr[i] >= arr[stack.peek()]) {
				res[stack.peek()]=arr[i];
				stack.pop();
			}
			stack.push(i);
		}
		
		while (stack.size()>0) {
			res[stack.peek()]=-1;
			stack.pop();
		}
		return res;
	}

}
