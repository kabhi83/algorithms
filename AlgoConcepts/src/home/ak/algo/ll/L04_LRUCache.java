/**
 * 
 */
package home.ak.algo.ll;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kundu
 *
 */
public class L04_LRUCache {

	static class Node {
		Node prev, next;
		int key, value;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	static class LRUCache {

		int capacity;
		Node head = new Node(0, 0);
		Node tail = new Node(0, 0);
		Map<Integer, Node> map = new HashMap<>();

		public LRUCache(int capacity) {
			this.capacity = capacity;
			head.next = tail;
			tail.prev = head;
		}

		public int get(int key) {
			if(map.containsKey(key)) {
				Node node = map.get(key);
				remove(node);
				insert(node);
				return node.value;
			}
			return -1;
		}
		
		public void put(int key, int value) {
			if(map.containsKey(key)) {
				Node node = map.get(key);
				remove(node);
				insert(node);
			} else {
				if(capacity == map.size()) {
					remove(tail.prev);
				}
				Node temp = new Node(key, value);
				map.put(key, temp);
				insert(temp);
			}
		}

		private void insert(Node node) {
			node.next = head.next;
			node.next.prev = node;
			head.next = node;
			node.prev = head;
		}

		private void remove(Node node) {
			 node.prev.next = node.next;
			 node.next.prev = node.prev;
		}
	}

}
