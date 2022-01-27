/**
 * 
 */
package home.ak.algo.bt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import home.ak.algo.bt.BinaryTree.Node;

/**
 * @author kundu
 *
 */
public class L9_KDistanceNodesFromTarget {

	public static List<Integer> findKDistanceNodesFromTarget(Node root, Node target, int k) {

		// Find the parent of each node
		Map<Node, Node> nodeParents = new HashMap<>();
		populateNodeParents(root, null, nodeParents);

		// Create a visited HashSet to prevent duplicate processing
		Set<Node> visited = new HashSet<>();
		Queue<Node> queue = new LinkedList<>();
		// Process the target node
		queue.add(target);
		visited.add(target);
		int currentLevel = 0;
		while (!queue.isEmpty()) {
			if (currentLevel == k) {
				// Extract the remaining nodes from the queue
				return extractRemainingQueueNodes(queue);
			}
			// Track all the non-visited nodes reachable from the current node
			int levelSize = queue.size();
			for (int i = 0; i < levelSize; i++) {
				Node curr = queue.poll();
				if (null != curr.left && !visited.contains(curr.left)) {
					queue.add(curr.left);
					visited.add(curr.left);
				}
				if (null != curr.right && !visited.contains(curr.right)) {
					queue.add(curr.right);
					visited.add(curr.right);
				}

				// Process the nodes from parent - undirected way
				Node currParent = nodeParents.get(curr);
				if (null != currParent && !visited.contains(currParent)) {
					queue.add(currParent);
					visited.add(currParent);
				}
			}
			currentLevel++;
		}
		return Collections.emptyList();
	}

	/**
	 * Nodes remaining in the queue after level match are the nodes at k distance
	 * away from target
	 */
	private static List<Integer> extractRemainingQueueNodes(Queue<Node> queue) {
		List<Integer> result = new ArrayList<>();
		while (!queue.isEmpty()) {
			result.add(queue.poll().data);
		}
		return result;
	}

	private static void populateNodeParents(Node node, Node parent, Map<Node, Node> nodeParents) {
		if (null == node) {
			return;
		}
		// add the parent' information
		nodeParents.put(node, parent);

		populateNodeParents(node.left, node, nodeParents);
		populateNodeParents(node.right, node, nodeParents);
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
		
		System.out.println(findKDistanceNodesFromTarget(tree.root, tree.root.left, 2));
	}
}
