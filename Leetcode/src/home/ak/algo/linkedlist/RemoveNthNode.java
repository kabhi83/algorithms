/**
 * 
 */
package home.ak.algo.linkedlist;

/**
 * @author kundu
 * 
 *         Given the head of a linked list, remove the nth node from the end of
 *         the list and return its head.
 * 
 *         Follow up: Could you do this in one pass?
 *
 */
public class RemoveNthNode {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (null == head) {
			return null;
		}

		// Initialize the dummy node
		ListNode dummy = new ListNode(-1);
		dummy.next = head;

		// initialize two pointers
		ListNode slow = dummy, fast = dummy;

		// Move fast node by n distance
		while (fast.next != null) {
			fast = fast.next;
			if (n-- <= 0) {
				slow = slow.next;
			}
		}

		// assign slow.next to slow.next.next
		slow.next = slow.next.next;
		return dummy.next;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		head = new RemoveNthNode().removeNthFromEnd(head, 2);
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}

}
