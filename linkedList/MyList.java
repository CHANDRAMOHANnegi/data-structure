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

    }

    public static void main(String[] args) {
        MyList.LinkedList list = new MyList.LinkedList();

        list.addLast(1);
        list.addLast(3);
        list.addLast(4);
        list.printList();

    }
}
