/**
 * 
 */
package home.ak.algo.ll;

/**
 * @author kundu
 * 
 *         Given head, the head of a linked list, determine if the linked list
 *         has a cycle in it.
 * 
 *         There is a cycle in a linked list if there is some node in the list
 *         that can be reached again by continuously following the next pointer.
 *         Internally, pos is used to denote the index of the node that tail's
 *         next pointer is connected to. Note that pos is not passed as a
 *         parameter.
 * 
 *         Return true if there is a cycle in the linked list. Otherwise, return
 *         false.
 *
 */
public class L02_LinkedListCycle {

	public boolean hasCycle(ListNode head) {

		if (head == null) {
			return false;
		}

		// Initialize two pointers
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			//Increment fast by 2 nodes and slow by 1 node
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode node = new ListNode(3);
		node.next = new ListNode(2);
		node.next.next = new ListNode(0);
		node.next.next.next = new ListNode(-4);
		node.next.next.next = node.next;
		
		boolean result = new L02_LinkedListCycle().hasCycle(node);
		System.out.println(result);
	}

}
