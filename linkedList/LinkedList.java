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

    public static LinkedList insert(LinkedList list, int data) {
        Node new_node = new Node(data);
        new_node.next = null;
        if (list.head == null) {
            list.head = new_node;
        } else {
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new_node;
        }
        return list;
    }

    public static Node getNode(LinkedList list, int i) {
        int j = 0;
        Node temp = list.head;

        while (j < i) {
            if (temp == null)
                return null;
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
     * 
     * REVERSE LINKED LIST DATA ITERATIVE only reverse data not node
     * 
     */

    public static LinkedList reversLinkedListDataIterative(LinkedList list) {
        int size = getSize(list);
        int j = 0;
        int i = 0;
        Node iThNode = list.head;
        Node jThNode = list.head;
        while (j < size - 1) {
            j++;
            jThNode = jThNode.next;
        }
        while (i < j) {
            int temp = iThNode.data;

            iThNode.data = jThNode.data;
            jThNode.data = temp;

            jThNode = getNode(list, --j);
            iThNode = iThNode.next;
            i++;
        }
        return list;
    }

    /**
     * REVERSE LINKED LIST POINTER ITERATIVE
     */

    public static LinkedList reversLinkedListPointerIterative(LinkedList list) {
        Node prev = null;
        Node curr = list.head;
        while (curr != null) {
            Node nextCurr = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextCurr;
            System.out.println(prev.data);
        }

        list.head = prev;
        return list;
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
     * GET kth node from last
     */

    public static int kThFromLast(LinkedList list, int k) {
        Node temp = list.head;
        Node ktemp = list.head;

        for (int l = 0; l <= k; l++) {
            if (ktemp == null) {
                return -1;
            }
            ktemp = ktemp.next;
        }

        while (ktemp != null) {
            ktemp = ktemp.next;
            temp = temp.next;
        }
        return temp.data;
    }

    /**
     * Mid node
     */

    public static int midNode(LinkedList list) {
        Node fast = list.head;
        Node slow = list.head;

        while (fast != null && fast.next != null && slow != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.data;
    }

    /**
     * Merge Two sorted list
     */

    public static LinkedList mergeSortedList(LinkedList first, LinkedList second) {
        LinkedList newList = new LinkedList();

        Node firstTemp = first.head;
        Node secondTemp = second.head;
        // Node listTemp = newList.head;

        while (firstTemp != null && secondTemp != null) {
            // Node newNode;
            // if (firstTemp == null) {
            // newNode = new Node(secondTemp.data);
            // } else if (secondTemp == null) {
            // newNode = new Node(firstTemp.data);
            // } else {
            // if (firstTemp.data <= secondTemp.data) {
            // newNode.data = firstTemp.data;
            // } else {
            // newNode.data = secondTemp.data;
            // }
            // }
            // listTemp.next = newNode;
            // listTemp = listTemp.next;
        }
        return newList;
    }

    public static void main(String[] args) {
        /* Start with the empty list. */
        LinkedList list = new LinkedList();

        // Insert the values
        list = insert(list, 1);
        list = insert(list, 2);
        // list = insert(list, 3);
        // list = insert(list, 4);
        // list = insert(list, 5);
        // LinkedList list2 = new LinkedList();
        // Insert the values
        // list2 = insert(list2, 1);
        // list2 = insert(list2, 3);
        // list2 = insert(list2, 5);
        // list2 = insert(list2, 7);
        printList(list);
        // printList(list2);
        System.out.println();
        // System.out.println(midNode(list));
        // System.out.println(kThFromLast(list, 8));
        // Print the LinkedList
        // reversLinkedListDataIterative(list);
        // reversLinkedListPointerIterative(list);
        // removeFromIndex(list, 8);
        // LinkedList list4 = AddTwoNumbers.addTwoNumbers(list.head, list2.head);
        // LinkedList list4 = RemoveNthFromEnd.removeNthFromEnd(list.head, 2);
        LinkedList list4 = SwapNodesInPairs.swapPairs(list.head);
        printList(list4);
    }
}
