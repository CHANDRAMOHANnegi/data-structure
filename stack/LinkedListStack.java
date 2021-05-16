package stack;

public class LinkedListStack {

	StackNode head;

	class StackNode {
		int data;
		StackNode next;

		StackNode(int data) {
			this.data = data;
		}
	}

	boolean isEmpty() {
		return (head == null);
	}

	void push(int data) {
		StackNode newNode = new StackNode(data);
		if (isEmpty()) {
			head = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
		System.out.println(data + " pushed to stack");
	}

	int pop() {
		int poped = 0;
		if (isEmpty()) {
			System.out.println("stack is empty");
		} else {
			poped = head.data;
			head = head.next;
		}
		return poped;
	}

	public static void main(String[] args) {

		LinkedListStack sll = new LinkedListStack();

		sll.push(10);
		sll.push(20);
		sll.push(3);

		System.out.println(sll.pop() + " popped from stack");

	}

}
