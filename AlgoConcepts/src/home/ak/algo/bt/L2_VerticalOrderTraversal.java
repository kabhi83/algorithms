/**
 * 
 */
package home.ak.algo.bt;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import home.ak.algo.bt.BinaryTree.Node;

/**
 * @author kundu
 *
 */
public class L2_VerticalOrderTraversal {

	static class Pair<K, V> {
		K key;
		V value;

		public Pair(K key, V value) {
			this.key = key;
			this.value = value;
		}

		public K getKey() {
			return key;
		}

		public V getValue() {
			return value;
		}
	}

	public static List<List<Integer>> verticalOrderTraversal(Node node) {
		if (null == node) {
			return null;
		}
		Map<Integer, List<Integer>> map = new TreeMap<>();
		List<List<Integer>> result = new ArrayList<>();
		// Level Order traversal
		Queue<Pair<Node, Integer>> queue = new LinkedList<>();
		queue.add(new Pair(node, 0));
		while (!queue.isEmpty()) {
			Pair<Node, Integer> currPair = queue.poll();
			Node temp = currPair.getKey();
			int hd = currPair.getValue(); // Horizontal distance
			if (!map.containsKey(hd)) {
				map.put(hd, new ArrayList<>());
			}
			map.get(hd).add(temp.data);

			// Add the children
			if (null != temp.left)
				queue.add(new Pair(temp.left, hd - 1));
			if (null != temp.right) {
				queue.add(new Pair(temp.right, hd + 1));
			}
		}

		for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
			result.add(entry.getValue());
		}
		return result;
	}
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.add(8);
		tree.add(3);
		tree.add(6);
		tree.add(10);
		tree.add(4);
		tree.add(7);
		tree.add(1);
		tree.add(14);
		tree.add(13);
		
		System.out.println(verticalOrderTraversal(tree.root));
	}

}
