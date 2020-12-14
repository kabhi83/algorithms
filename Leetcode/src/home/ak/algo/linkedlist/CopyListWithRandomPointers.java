/**
 * 
 */
package home.ak.algo.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kundu
 * 
 *         A linked list is given such that each node contains an additional
 *         random pointer which could point to any node in the list or null.
 * 
 *         Return a deep copy of the list.
 * 
 *         The Linked List is represented in the input/output as a list of n
 *         nodes. Each node is represented as a pair of [val, random_index]
 *         where:
 * 
 *         val: an integer representing Node.val
 * 
 *         random_index: the index of the node (range from 0 to n-1) where
 *         random pointer points to, or null if it does not point to any node.
 * 
 *         Example: Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 
 *         Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
 *
 */
public class CopyListWithRandomPointers {

	static class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}

	public Node copyRandomList(Node head) {
		if (null == head) {
			return null;
		}

		// Build the clone map - original to clone node
		Map<Node, Node> cloneMap = new HashMap<>();

		// Populate the map
		Node curr = head;
		while (curr != null) {
			cloneMap.put(curr, new Node(curr.val));
			curr = curr.next;
		}

		/*
		 * Reset the curr pointer to the head of the original list. Give all clones
		 * their next and random pointer assignments. Our cloneMap lets us reach an
		 * original node's clone in O(1) time.
		 */
		curr = head;
		while (curr != null) {
			Node cloneNode = cloneMap.get(curr);
			cloneNode.next = cloneMap.get(curr.next);
			cloneNode.random = cloneMap.get(curr.random);
			curr = curr.next;
		}

		// Return the clone node of the head as this points to new cloned linked list
		return cloneMap.get(head);
	}

	public static void main(String[] args) {
		Node head = new Node(7);
		head.next = new Node(13); 
		head.next.next = new Node(11);
		head.next.next.next = new Node(10);
		head.next.next.next.next = new Node(1);
		head.random = null;
		head.next.random = head;
		head.next.next.random = head.next.next.next.next;
		head.next.next.next.random = head.next.next;
		head.next.next.next.next.random = head;
		Node newHead = new CopyListWithRandomPointers().copyRandomList(head);
		
		while(newHead != null) {
			System.out.println(newHead.val);
			newHead = newHead.next;
		}
	}

}
