package linkedlist;

public class OddEvenLinkedList {

	static boolean going = true;
 
	public static void main(String[] args) {
		OddEvenLinkedList list = new OddEvenLinkedList();
		ListNode head = new ListNode(2);
		ListNode second = new ListNode(1);
		ListNode third = new ListNode(3);
		ListNode fourth = new ListNode(5);
		ListNode fifth = new ListNode(6);
		ListNode sixth = new ListNode(4);
		ListNode seventh = new ListNode(7);

		head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		fifth.next = sixth;
		sixth.next = seventh;

		printList(head);
		list.oddEvenList(head);
		printList(head);
	}

	public static void printList(ListNode head) {
		ListNode n = head;
		while (n != null) {
			System.out.print(n.val + " ");
			n = n.next;
		}
		System.out.println();
	}

	public static void rotate(ListNode start, int n) {
		ListNode temp = start;
		int tempdata = temp.val;
		while (going && temp != null && n > 0) {
			int d = tempdata;
			temp = temp.next;
			if ((temp.next == null)) {
				going = false;
				if (n > 1) {
					break;
				}
			}
			tempdata = temp.val;
			temp.val = d;
			n--;
		}
		start.val = tempdata;
	}

	public ListNode oddEvenList(ListNode head) {
		int odd = 1;
		ListNode start = head.next;
		while (going) {
			rotate(start, odd);
			start = start.next;
			odd++;
		}
		return head;
	}
}
