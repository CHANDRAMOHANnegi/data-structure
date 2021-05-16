package heap;

import java.util.ArrayList;

public class Heap {

	public static void main(String[] args) {
		int arr[] = { 10, 20, 30, -2, -3, -4, 5, 6, 7, 8, 9, 22, 11 };
		priorityQueue pq = new priorityQueue(arr, false);
		while (pq.size() != 0) {
			System.out.println(pq.remove() + " ");
		}
	}

	public static class priorityQueue {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		boolean isMax = true;

		priorityQueue(boolean isMAx) {
			this.isMax = isMAx;
		}

		priorityQueue(int[] arr1, boolean isMAx) {
			this.isMax = isMAx;

			for (int i = 0; i < arr1.length; i++) {
				arr.add(arr1[i]);
			}
			for (int i = arr.size() - 1; i >= 0; i--) {
				downheapify(i, arr.size() - 1);
			}

		}

		public int size() {
			return arr.size();
		}

		void upheapify(int ci) {
			int pi = ci - 1 >> 1;
			if (pi >= 0 && compareTo((int) arr.get(ci), (int) arr.get(pi)) > 0) {
				swap(pi, ci);
				upheapify(pi);
			}
		}

		public int remove() {
			swap(0, arr.size() - 1);
			int remove_ele = arr.get(arr.size() - 1);
			arr.remove(arr.size() - 1);
			downheapify(0, arr.size() - 1);
			return remove_ele;
		}

		public void update(int preval, int newval) {
			int idx = -1;
			for (int i = 0; i < arr.size(); i++) {
				if (arr.get(i) == preval) {
					idx = i;
					break;
				}
			}
			if (idx == -1) {
				return;
			}
			arr.set(idx, newval);
			upheapify(idx);
			downheapify(idx, arr.size() - 1);
		}

		void downheapify(int idx, int n) {
			int maxidx = idx;
			int lci = 2 * idx + 1;
			int rci = 2 * idx + 2;

			if (lci < n && compareTo((int) arr.get(lci), (int) arr.get(maxidx)) > 0) {
				maxidx = lci;
			}
			if (rci < n && compareTo((int) arr.get(rci), (int) arr.get(maxidx)) > 0) {
				maxidx = rci;
			}
			if (maxidx != idx) {
				swap(maxidx, idx);
				downheapify(maxidx, n);
			}
		}

		private void swap(int x, int y) {
			Integer val1 = arr.get(x);
			Integer val2 = arr.get(y);

			arr.set(x, val2);
			arr.set(y, val1);
		}

		int compareTo(Integer val1, Integer val2) {
			if (isMax) {
				return val1 - val2;
			} else {
				return val2 - val1;
			}
		}

	}

}
