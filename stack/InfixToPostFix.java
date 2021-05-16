package stack;

import java.util.Stack;

public class InfixToPostFix {

	private static int priority(char c) {
		if (c == '+' || c == '-')
			return 0;
		else if (c == '*' || c == '/')
			return 1;
		else if (c == '^')
			return 2;
		return -1;
	}

	public static String solve(String str) {
		StringBuilder sb = new StringBuilder();
		Stack<Character> opStack = new Stack<>();
		for (int i = 0; i < str.length(); ++i) {
			char c = str.charAt(i);
			if (Character.isLetterOrDigit(c))
				sb.append(c);
			else if (c == '(')
				opStack.push(c);
			else if (c == ')') {
				while (!opStack.isEmpty() && opStack.peek() != '(') {
					sb.append(opStack.pop());
				}
				opStack.pop();
			} else {
				while (!opStack.isEmpty() && (priority(c) <= priority(opStack.peek()))) {
					if (opStack.peek() != '(')
						sb.append(opStack.pop());
				}
				opStack.push(c);
			}
		}
		while (!opStack.isEmpty()) {
			sb.append(opStack.pop());
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String exp = "a+b-(c^d-e)+g*h-i";
		System.out.println(solve(exp));
	}
}
