public class SwapNodesInPairs extends LinkedList {
    public static LinkedList swapPairs(Node head) {
        LinkedList finalList = new LinkedList();
        if (head.next == null) {
            finalList.head = head;
            return finalList;
        }
        Node pointer = new Node(0);
        pointer.next = head;
        finalList.head = pointer.next.next;

        while (pointer.next != null) {
            Node first = pointer.next;

            if (first.next == null) {
                return finalList;
            }
            Node second = first.next;
            System.out.println(pointer.data + " " + first.data + " " + second.data);
            Node temp = second.next;

            second.next = first;

            first.next = temp;
            pointer.next = second;
            pointer = first;
            System.out.println(first.data + " " + second.data);
        }
        return finalList;
    }
}
