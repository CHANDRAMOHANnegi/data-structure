package implementation;

public class LinkedList {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static void addFirst(LinkedList list, int data) {
        Node temp = new Node(data);
        temp.next = list.head;
        list.head = temp;
    }

    public static void addLast(LinkedList list, int data) {
        Node new_node = new Node(data);
        new_node.next = null;
        if (list.head == null) {
            list.head = new_node;
        } else {
            Node temp = list.head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new_node;
        }
    }

    public static void removeFirst(LinkedList list) {
        if (list.head == null) {
            list.head = null;
        } else {
            Node temp = list.head;
            list.head = temp.next;
            temp.next = null;
        }
    }

    public static void removeLast(LinkedList list) {
        if (list.head == null || list.head.next == null) {
            list.head = null;
        }
        Node temp = list.head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }

    public static Node getNode(LinkedList list, int i) {
        int j = 0;
        Node temp = list.head;
        while (j < i) {
            if (temp == null) {
                return null;
            }
            temp = temp.next;
            j++;
        }
        return temp;
    }

    public static void printList(LinkedList list) {
        Node currNode = list.head;
        System.out.print("LinkedList: ");
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
    }

    public static int getSize(LinkedList list) {
        Node temp = list.head;
        int size = 0;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        return size;
    }

    /**
     * REMOVE FROM INDEX
     */

    public static LinkedList removeFromIndex(LinkedList list, int index) {
        Node prev = list.head;
        if (prev == null)
            return null;

        if (index == 0) {
            list.head = prev.next;
            return list;
        }

        if (prev.next != null) {
            Node curr = prev.next;
            int i = 1;
            while (i != index) {
                prev = prev.next;
                curr = curr.next;
                i++;
            }
            if (curr == null) {
                return list;
            } else {
                prev.next = curr.next;
                curr.next = null;
            }
        } else {
            if (index == 0) {
                list.head = prev;
                return null;
            }
        }
        return list;
    }

    /**
     * Add Last
     */

    public static void addAtIndex(LinkedList list, int index,int data) {
        int size=getSize(list);
        if(index<0||index>getSize(list)){
           System.out.println("Invalid arguements");
        } else  if(index==0){
            addFirst(list, data);
        }else if(index==getSize(list){
            addLast(list,data);
        }else{
            Node newNode=new Node(data);
            Node temp=list.head;

            for (int i = 0; i < index-1; i++) {
                temp=temp.next;
            }
            node.next=temp.next;
            temp.next=newNode;
        }

    }

    /**
     * 
     * 
     * */

    public static void main(String[] args) {
        /* Start with the empty list. */
        LinkedList list = new LinkedList();
        addLast(list, 1);
        addLast(list, 2);
        addLast(list, 3);
        addLast(list, 4);
        addLast(list, 5);

        printList(list);

        // removeLast(list);
        printList(list);
        System.out.println();
    }
}
