/**
 * 
 */
package home.ak.algo.kwaymerge;

import java.util.PriorityQueue;

/**
 * @author kundu
 * 
 *         Given an array of ‘K’ sorted LinkedLists, merge them into one sorted
 *         list.
 * 
 *         Input: L1=[2, 6, 8], L2=[3, 6, 7], L3=[1, 3, 4]
 * 
 *         Output: [1, 2, 3, 3, 4, 6, 6, 7, 8]
 *
 */
public class MergeKSortedLists {

	static class ListNode {
		int value;
		ListNode next;

		ListNode(int value) {
			this.value = value;
		}
	}

	public static ListNode merge(ListNode[] lists) {
		// Basic validation
		if (lists.length == 0) {
			return null;
		}

		// Initialize the Priority Queue - Min heap
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (a - b));
		for(ListNode head: lists) {
			while(null != head) {
				pq.add(head.value);
				head = head.next;
			}
			
		}
		ListNode dummy = new ListNode(-1);
		ListNode head = dummy;
		while(!pq.isEmpty()) {
			head.next = new ListNode(pq.remove());
			head = head.next;
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(6);
		l1.next.next = new ListNode(8);

		ListNode l2 = new ListNode(3);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(7);

		ListNode l3 = new ListNode(1);
		l3.next = new ListNode(3);
		l3.next.next = new ListNode(4);

		ListNode result = MergeKSortedLists.merge(new ListNode[] { l1, l2, l3 });
		System.out.print("Here are the elements form the merged list: ");
		while (result != null) {
			System.out.print(result.value + " ");
			result = result.next;
		}
	}

}
