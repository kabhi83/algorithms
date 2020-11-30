/**
 * 
 */
package home.ak.algo.inplacereversal;

/**
 * @author kundu
 *
 */
public class ReverseLinkedList {

	static class ListNode {
		int value = 0;
		ListNode next;

		ListNode(int value) {
			this.value = value;
		}
	}

	public static ListNode reverse(ListNode head) {
		if (null == head) {
			return null;
		}

		// Initialize 3 variables
		ListNode next = null, current = head, previous = null;
		while(current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		return previous;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode head = new ListNode(2);
		head.next = new ListNode(3);
		head.next.next = new ListNode(5);
		head.next.next.next = new ListNode(7);
		head.next.next.next.next = new ListNode(9);
		
		head = reverse(head);
		while(head!= null) {
			System.out.print(head.value + " ");
			head = head.next;
		}

	}

}
