/**
 * 
 */
package home.ak.algo.linkedlist;

import java.util.PriorityQueue;

/**
 * @author user
 * 
 *         You are given an array of k linked-lists lists, each linked-list is
 *         sorted in ascending order.
 * 
 *         Merge all the linked-lists into one sorted linked-list and return it.
 * 
 *         Example 1: Input: lists = [[1,4,5],[1,3,4],[2,6]]
 *         Output:[1,1,2,3,4,4,5,6]
 * 
 *         Explanation: The linked-lists are: [ 1->4->5, 1->3->4, 2->6 ] merging
 *         them into one sorted list: 1->1->2->3->4->4->5->6
 *
 */
public class MergeKSortedLists {

	public ListNode mergeKLists(ListNode[] lists) {
		// Base case check
		if (null == lists || lists.length == 0) {
			return null;
		}

		// Initialize Min Heap
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for (ListNode node : lists) {
			while (node != null) {
				minHeap.add(node.val);
				node = node.next;
			}
		}
		ListNode dummy = new ListNode(-1);
		ListNode current = dummy;
		while (minHeap.size() > 0) {
			current.next = new ListNode(minHeap.remove());
			current = current.next;
		}
		return dummy.next;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		node1.next = new ListNode(4);
		node1.next.next = new ListNode(5);

		ListNode node2 = new ListNode(1);
		node2.next = new ListNode(3);
		node2.next.next = new ListNode(4);

		ListNode node3 = new ListNode(2);
		node3.next = new ListNode(6);

		ListNode[] lists = { node1, node2, node3 };

		ListNode result = new MergeKSortedLists().mergeKLists(lists);
		while (result != null) {
			System.out.print(result.val);
			result = result.next;
		}

	}

}
