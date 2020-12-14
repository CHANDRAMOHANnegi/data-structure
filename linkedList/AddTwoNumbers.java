public class AddTwoNumbers extends LinkedList {

    public static LinkedList addTwoNumbers(Node l1, Node l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        int carry = 0;
        Node finalNode = new Node(0);
        while (l1 != null || l2 != null) {
            int sum = l1.data + l2.data + carry;
            int num = sum%10;
            if (sum > 9) {
                carry = 1;
                num = num % 10;
            }
            Node newNode = new Node(num);
            if (finalNode == null) {
                finalNode = newNode;
            } else {
                Node temp = finalNode;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNode;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        LinkedList finalList = new LinkedList();
        finalList.head = finalNode;
        return finalList;
    }
}