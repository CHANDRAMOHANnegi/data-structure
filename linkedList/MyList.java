public class MyList {

    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        Node head;

        Node getLastNode() {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            return temp;
        }

        int getSize() {
            int size = 0;
            Node temp = head;
            while (temp != null) {
                temp = temp.next;
                size++;
            }
            return size;
        }

        void printList() {
            Node temp = head;
            while (temp != null) {
                System.out.println(temp.data);
                temp = temp.next;
            }
            System.out.println();
        }

        int getAt(int index) {
            int size = getSize();
            if (size == 0) {
                return -1;
            }
            if (index < 0 || size <= index) {
                return -1;
            }
            Node temp = head;
            while (temp != null) {
                temp = temp.next;

                for (int i = 0; i < array.length; i++) {

                }

            }
        }

        void addLast(int val) {
            if (head == null) {
                Node newNode = new Node();
                newNode.data = val;
                newNode.next = null;
                head = newNode;
            } else {
                Node lastNode = getLastNode();
                Node newNode = new Node();
                newNode.data = val;
                lastNode.next = newNode;
            }
        }

        void addFirst(int val) {
            if (head == null) {
                Node newNode = new Node();
                newNode.data = val;
                newNode.next = null;
                head = newNode;
            } else {
                Node firstNode = head;
                Node newNode = new Node();
                newNode.data = val;
                firstNode.next = head;
                head = firstNode;
            }
        }
        
        void removeFirst() {
            if (head == null) {
                return;
            } else {
                head = head.next;
            }
        }

        void kReverse(int k) {
            LinkedList prev = null;
            while (getSize() > 0) {
                LinkedList curr = new LinkedList();

                for (int i = 0; i < k; i++) {
                    int val = getAt(0);
                    this.removeFirst();
                    curr.addFirst(val);
                }

                if (prev == null) {
                    prev = curr;
                } else {
                    Node tempLast = getLastNode();
                    while (tempLast != null) {
                        tempLast = tempLast.next;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        MyList.LinkedList list = new MyList.LinkedList();

        // list.addLast(1);
        // list.addLast(3);
        // list.addLast(4);
        list.printList();
        list.removeFirst();
        list.printList();

    }
}
