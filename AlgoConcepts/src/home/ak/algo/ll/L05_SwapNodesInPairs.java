/**
 * 
 */
package home.ak.algo.ll;

/**
 * @author kundu
 * 
 *         Given a linked list, swap every two adjacent nodes and return its
 *         head. You must solve the problem without modifying the values in the
 *         list's nodes (i.e., only nodes themselves may be changed.)
 *
 */
public class L05_SwapNodesInPairs {

	public static ListNode swapPairs(ListNode head) {
		ListNode dummy = new ListNode(0, head);
		ListNode prev = dummy, curr = head;
		while (null != curr && null != curr.next) {
			ListNode nextPair = curr.next.next;
			ListNode nextNode = curr.next;

			// Reverse the current pair
			nextNode.next = curr;
			curr.next = nextPair;
			prev.next = nextNode;

			// update pointers for swapping next pair
			prev = curr;
			curr = nextPair;
		}

		return dummy.next;
	}

	// Recursive solution
	public static ListNode swapPairsRecursive(ListNode head) {
		if (null == head) {
			return null;
		}
		if (null == head.next) {
			return head;
		}
		
		ListNode temp = head.next;
		
		/**** Swap starts ****/
		head.next = swapPairsRecursive(temp.next);
		temp.next = head;
		/**** Swap ends ****/
		
		return temp;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
