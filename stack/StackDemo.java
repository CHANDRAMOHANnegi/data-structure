package stack;

class Stack {
	int capacity = 454;
	int top;
	int stack[];

	Stack() {
		stack = new int[capacity];
		top = -1;
	}

	boolean isEmpty() {
		return (top < 0);
	}

	boolean push(int n) {

		if (top >= (capacity - 1)) {
			System.out.println("stack overflow");
			return false;
		} else {
			stack[++top] = n;
			System.out.println(n + " pushed into stack");
			return true;
		}
	}

	int pop() {

		if (isEmpty()) {
			System.out.println("stack is empty");
			return 0;
		} else {
			int x = stack[top--];
			return x;

		}
	}

	int peek() {
		if (top < 0) {
			System.out.println("Stack Underflow");
			return 0;
		} else {
			int x = stack[top];
			return x;
		}
	}
}

public class StackDemo {

	public static void main(String[] args) {

		Stack s = new Stack();
		s.push(10);
		s.push(20);
		s.push(30);
		System.out.println(s.pop() + " Popped from stack");
	}

}
