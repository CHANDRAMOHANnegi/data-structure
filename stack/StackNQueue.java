package stack;

import java.util.Stack;

public class StackNQueue {

	private static boolean isOperator(char c) {
		return (c == '+' || c == '-' || c == '/' || c == '*' || c == '^');
	}

	private static int priority(char c) {
		if (c == '+' || c == '-')
			return 0;
		else if (c == '*' || c == '/')
			return 1;
		else if (c == '^')
			return 2;
		return -1;
	}

	private static int performOperation(Stack<Integer> numbers, Stack<Character> operations) {
		int a = numbers.pop();
		int b = numbers.pop();
		char operation = operations.pop();
		switch (operation) {
		case '+':
			return a + b;
		case '-':
			return b - a;
		case '*':
			return a * b;
		case '/':
			if (a == 0)
				throw new UnsupportedOperationException("Cannot divide by zero");
			return b / a;
		}
		return 0;
	}

	public static int infixEval(String str) {
		Stack<Integer> numStack = new Stack<>();
		Stack<Character> opStack = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (Character.isDigit(c)) {
				numStack.push(c - '0');
			} else if (c == '(') {
				opStack.push(c);
			} else if (c == ')') {
				while (opStack.peek() != '(') {
					int ans = performOperation(numStack, opStack);
					numStack.push(ans);
				}
				opStack.pop();
			} else if (isOperator(c)) {
				if (opStack.size() > 0 && priority(c) < priority(opStack.peek())) {
					while (opStack.size() > 0 && priority(c) <= priority(opStack.peek())) {
						int ans = performOperation(numStack, opStack);
						numStack.push(ans);
					}
				}
				opStack.push(c);
			}
		}

		while (opStack.size() != 0) {
			int ans = performOperation(numStack, opStack);
			numStack.push(ans);
		}

		return numStack.pop();
	}

	public static void main(String[] args) {
		String infixExpression = "2 * (5 *(3+6))/5-2";
		System.out.println(infixEval(infixExpression));
	}
}
