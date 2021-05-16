package Queue;

public class LinkedListQueue {

	QueueNode front, rear;
	int capacity;

	public LinkedListQueue(int capacity) {
		front = rear = null;
		this.capacity = capacity;
	}

	class QueueNode {
		QueueNode next;
		int data;

		public QueueNode(int data) {
			this.data = data;
		}
	}

	boolean isEmpty() {
		return (front == null);
	}

	boolean isFull() {
		int x = 1;
		QueueNode temp = front;
		while (temp != rear) {
			temp = temp.next;
			x++;
			if (x == capacity) {
				return true;
			}
		}
		return false;
	}

	void enqueue(int data) {
		QueueNode newNode = new QueueNode(data);

		if (isFull()) {
			System.out.println("queue is full");
		} else if (isEmpty()) {
			front = newNode;
			rear = newNode;
			System.out.println(data + " is enqueued");

		} else {
			rear.next = newNode;
			rear = newNode;
			System.out.println(data + " is enqueued");

		}
	}

	void dequeue() {

		if (isEmpty()) {
			System.out.println("queue is empty");
			return;
		}

		if (front == rear) {
			System.out.println(front.data + " is dequeued");
			front = rear = null;
			return;
		}
		System.out.println(front.data + " is dequeued");

		front = front.next;

	}

	void printQueue() {
		QueueNode temp = front;
		while (temp != rear.next) {
			System.out.println(temp.data);
			temp = temp.next;

		}
	}

	public static void main(String[] args) {

		LinkedListQueue q = new LinkedListQueue(3);
		q.enqueue(10);
		q.enqueue(20);
		q.dequeue();
		q.dequeue();
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);
		q.printQueue();

	}

}
