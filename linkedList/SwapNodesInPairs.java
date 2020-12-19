public class SwapNodesInPairs extends LinkedList {

    public static LinkedList swapPairs(Node head) {
        LinkedList finalList = new LinkedList();

        Node pointer = new Node(0);
        Node first = head;
        Node second = head.next;

        Node temp = second.next;

        second.next = first;

        first.next = temp;
        finalList.head = second;

        return finalList;
    }
}
