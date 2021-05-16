import java.util.ArrayList;

public class Heap {

    public static class PriorityQueue {
        ArrayList<Integer> data;

        public PriorityQueue() {
            data = new ArrayList<>();
            for (int val : arr) {
                data.add(val);
            }

            for (int i = data.size() / 2 - 1; i >= 0; i--) {
                downHeapify(i);
            }
        }

        public void add(int val) {
            data.add(val);
            upheapify(data.size() - 1);
        }

        public void upHeapify(int i) {
            int pi = (i - 1) / 2;
            if (data.get(pi) < data.get(i)) {
                swap(i, pi);
                upHeapify(pi);
            }
        }

        public int remove() {
            if (this.getSize() == 0) {
                System.out.println("Underflow");
                return -1;
            }
            swap(0, data.size() - 1);
            int val = data.size() - 1;
            downHeapify(0);
            return val;
        }

        public void downHeapify(int pi) {

            int mini = pi;

            int li = 2 * pi + 1;

            if (li < data.size() && data.get(li) < data.get(mini)) {
                mini = li;
            }

            int ri = 2 * pi + 2;
            if (ri < data.size() && data.get(ri) < data.get(mini)) {
                mini = ri;
            }

            if (mini != pi) {
                swap(mini, pi);
                downHeapify(mini);
            }
        }

        public void swap(int i, int j) {
            int ith = data.get(i);
            data.set(i, data.get(j));
            data.set(j, ith);
        }

        public int getSize() {
            return data.size();
        }

    }

    public static void main(String[] args) {

    }

}
