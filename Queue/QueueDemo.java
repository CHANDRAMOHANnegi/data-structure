package Queue;

class Queue {
	int rear, front, capacity;
	int queue[];

	Queue(int capacity) {
		this.capacity = capacity;
		front = rear = -1;
		queue = new int[capacity];
	}

	boolean isFull() {
		return (rear == capacity - 1);
	}

	boolean isEmpty() {
		return (rear == -1 || front > rear);
	}

	void enqueue(int n) {
		if (isFull()) {
			System.out.println("queue is full");
			return;
		} else if (isEmpty()) {
			front++;
			rear++;
			queue[front] = n;
			System.out.println(n + " enqueued to queue");
		} else {
			rear++;
			queue[rear] = n;
			System.out.println(n + " enqueued to queue");
		}
	}

	int dequeue() {
		if (isEmpty()) {
			System.out.println("queue is empty");
			return Integer.MIN_VALUE;
		} else {
			int x = queue[front];
			front++;
			System.out.println(x + "is dequeued");
			return x;
		}
	}

	int front() {
		if (isEmpty()) {
			System.out.println("queue is empty");
			return Integer.MIN_VALUE;
		}
		return queue[front];
	}

	int rear() {
		if (isEmpty()) {
			System.out.println("queue is empty");
			return Integer.MIN_VALUE;
		}
		return queue[rear];
	}
}

public class QueueDemo {

	public static void main(String[] args) {
		Queue queue = new Queue(1000);

		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
//		queue.dequeue();
//		queue.dequeue();
		System.out.println(queue.front() + " front");
		System.out.println(queue.rear() + " rear");
	}
}
