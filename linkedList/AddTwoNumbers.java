public class AddTwoNumbers extends LinkedList {

    public static LinkedList addTwoNumbers(Node l1, Node l2) {
        LinkedList finalList = new LinkedList();

        if (l1 == null)
            return null;
        if (l2 == null)
            return null;

        int carry = 0;
        Node finalNode = new Node(0);
        Node temp = finalNode;

        while (l1 != null || l2 != null) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.data;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.data;
                l2 = l2.next;
            }
            temp.next = new Node(sum % 10);
            temp = temp.next;

            carry = sum / 10;
        }

        if(carry!=0){
            temp.next=new Node(carry);
        }

        finalList.head = finalNode.next;
        return finalList;
    }
}