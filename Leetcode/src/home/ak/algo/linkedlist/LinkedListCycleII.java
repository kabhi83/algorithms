/**
 * 
 */
package home.ak.algo.linkedlist;

/**
 * @author kundu
 * 
 *         Given a linked list, return the node where the cycle begins. If there
 *         is no cycle, return null.
 * 
 *         There is a cycle in a linked list if there is some node in the list
 *         that can be reached again by continuously following the next pointer.
 *         Internally, pos is used to denote the index of the node that tail's
 *         next pointer is connected to. Note that pos is not passed as a
 *         parameter.
 * 
 *         Notice that you should not modify the linked list.
 *
 */
public class LinkedListCycleII {

	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null) {
			return null;
		}

		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(fast == slow) {
				//Cycle detected - reset the pointers
				slow = head;
				while(slow != fast) {
					slow = slow.next;
					fast = fast.next;
				}
				return slow;
			}
		}

		// no cycle
		return null;
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
		
		ListNode result = new LinkedListCycleII().detectCycle(node);
		System.out.println(result.val);
	}

}
