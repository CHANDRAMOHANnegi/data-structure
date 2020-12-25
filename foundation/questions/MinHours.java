
import java.util.*;
import java.io.*;
import java.math.*;

class Outcome {
	public static int givemin(int n) {
		System.out.println(n);

		if (n == 0) {
			return 0;
		}

		int step = 0;

		for (int i = 5; i > 0; i--) {
			if (n < i)
				continue;
			System.out.println(n + "   " + i);

			if (n - i == 0) {
				step = 1;
				break;
			}

			if (n - i >= 1) {
				step = givemin(n - i) + 1;
				break;
			}
		}
		return step;
	}

	public static int solve(int n) {
		int ans = givemin(n);
		return ans;
	}
}

public class MinHours {
	public static void main(String[] args) throws IOException {
		int outcome = Outcome.solve(7);
		System.out.println(outcome);
	}
}
