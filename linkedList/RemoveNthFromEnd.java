
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        for (int i = 0; i < n; i++) {
            if (first.next != null) {
                first = first.next;
            } else {

                /**
                 * if either n is greater than length of
                 * arraylist  or if length of arraylist is 1
                 */

                if (n == 1) {
                    /**
                     * this case will run if length of arraylist is 1 and n is 1
                     */
                    head = null;
                    return head;
                }

                if (first != head) {
                    /*
                     * this case will run if n is greater than length of arraylist
                     * 
                     */

                    head = head.next;
                    return head;
                }
            }
        }
        ListNode second = head;
        while (first.next != null) {
            /**
             * Here pointer first will move to end of linkedList
             */
            first = first.next;
            second = second.next;
        }

        /**
         * Here pointer second will move to one before the nth node
         */

        first = second.next;
        second.next = second.next.next;
        first.next = null;

        /**
         * Here we removed nth node
         */

        return head;
    }
}