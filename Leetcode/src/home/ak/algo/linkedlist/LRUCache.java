/**
 * 
 */
package home.ak.algo.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kundu
 * 
 *         Design a data structure that follows the constraints of a Least
 *         Recently Used (LRU) cache.
 * 
 *         Implement the LRUCache class:
 * 
 *         1. LRUCache(int capacity) Initialize the LRU cache with positive size
 *         capacity.
 * 
 *         2. int get(int key) Return the value of the key if the key exists,
 *         otherwise return -1.
 * 
 *         3. void put(int key, int value) Update the value of the key if the
 *         key exists. Otherwise, add the key-value pair to the cache.
 * 
 *         If the number of keys exceeds the capacity from this operation, evict
 *         the least recently used key.
 *
 */
public class LRUCache {

	/**
	 * Node for Doubly Linked List
	 */
	private static class Node {
		int data;
		int key;
		Node prev, next;

		public Node(int key, int data) {
			this.key = key;
			this.data = data;
			this.prev = null;
			this.next = null;
		}

	}

	private int capacity;
	private Node dummyHead, dummyTail;
	Map<Integer, Node> map;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		map = new HashMap<>();
		dummyHead = new Node(0, 0);
		dummyTail = new Node(0, 0);
		dummyHead.next = dummyTail;
		dummyTail.prev = dummyHead;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			Node node = map.get(key);
			moveToHead(node);
			return node.data;
		}
		return -1;
	}

	public void put(int key, int value) {
		Node node = map.containsKey(key) ? map.get(key) : new Node(key, value);
		map.put(key, node);
		moveToHead(node);
		if (map.size() > capacity) { // drop the tail node
			Node last = dummyTail.prev;
			last.prev.next = dummyTail;
			dummyTail.prev = last.prev;
			map.remove(last.key);
		}

	}

	/**
	 * Utility function to remove the node (if exists) and add to the first
	 */
	private void moveToHead(Node node) {
		if (node.next != null) {
			// New node
			node.prev.next = node.next;
			node.next.prev = node.prev;
			// Now the node is removed
		}
		// Add the node to the front
		node.next = dummyHead.next;
		dummyHead.next.prev = node;
		dummyHead.next = node;
		node.prev = dummyHead;
	}
}
