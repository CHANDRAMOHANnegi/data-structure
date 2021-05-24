
public class Heap {

	int size;
	int maxSize;
	int heap[];
	boolean isMax;

	public Heap(int maxSize, boolean isMax) {
		this.heap = new int[maxSize];
		this.isMax = isMax;
		this.maxSize = maxSize;
	}

	public void swap(int x, int y) {
		int temp = heap[x];
		heap[x] = heap[y];
		heap[y] = temp;
	}

	public void downHeapify(int idx) {
		int maxidx = idx;

		int left = idx * 2 + 1;
		int right = idx * 2 + 2;

		if (left < heap.length && compare(heap[left], heap[maxidx]) > 0)
			maxidx = left;
		if (right < heap.length && compare(heap[right], heap[maxidx]) > 0)
			maxidx = right;

		if (maxidx != idx) {
			swap(maxidx, idx);
			downHeapify(maxidx);
		}

	}

	public int compare(int a, int b) {
		if (isMax)
			return a - b;
		return b - a;
	}

	public void upHeapify(int idx) {
		int parent = (idx - 1) / 2;
		if (parent >= 0 && compare(heap[parent], heap[idx]) < 0) {
			swap(parent, idx);
			upHeapify(parent);
		}
	}

	public void insert(int n) {
		heap[size] = n;
		System.out.println("-->" + size);
		for (int i : heap) {
			System.out.print(" " + i);
		}
		upHeapify(size);
		size++;
	}

	public int remove() {
		int poped = heap[0];
		heap[0] = heap[--size];
		downHeapify(0);
		return poped;
	}

	public void print() {
		for (int i = 0; i <= size / 2; i++) {
			System.out.print(
					" PARENT : " + heap[i] + " LEFT CHILD : " + heap[2 * i + 1] + " RIGHT CHILD :" + heap[2 * i + 2]);
			System.out.println();
		}
	}

	public static void main(String[] args) {
		System.out.println("The Max Heap is ");
		boolean ismax = false;
		Heap maxHeap = new Heap(15, ismax);
		maxHeap.insert(5);
		maxHeap.insert(3);
		maxHeap.insert(17);
		maxHeap.insert(10);
		maxHeap.insert(84);
		maxHeap.insert(19);
		maxHeap.insert(6);
		maxHeap.insert(22);
		maxHeap.insert(9);
		System.out.println();
		maxHeap.print();
		for (int i : maxHeap.heap) {
			System.out.print(" " + i);
		}
		System.out.println("The " + (ismax == true ? "max" : "min") + " val is " + maxHeap.remove());
	}

}
