/**
 *
 * 
 */
class Solution {
    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode pointer = new ListNode(0);
        pointer.next = head;
        head = pointer.next.next;

        while (pointer.next != null) {
            ListNode first = pointer.next;

            if (first.next == null) {
                return head;
            }
            ListNode second = first.next;
            ListNode temp = second.next;

            second.next = first;
            first.next = temp;

            pointer.next = second;
            pointer = first;
        }
        return head;
    }
}