/**
 * 
 */
package home.ak.algo.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author kundu
 * 
 *         We are given a binary tree (with root node root), a target node, and
 *         an integer value K.
 * 
 *         Return a list of the values of all nodes that have a distance K from
 *         the target node. The answer can be returned in any order.
 * 
 *         Example 1: Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K
 *         = 2
 * 
 *         Output: [7,4,1]
 * 
 *         Explanation: The nodes that are a distance 2 from the target node
 *         (with value 5) have values 7, 4, and 1.
 *
 */
public class KDistanceNodesFromTarget {

	public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
		// Create a visited HashSet to prevent duplicate processing
		Set<TreeNode> visited = new HashSet<>();

		// Populate the mappings from node to parent
		Map<TreeNode, TreeNode> nodeToParentMap = new HashMap<>();
		populateNodeToParentMap(nodeToParentMap, root, null);

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(target);
		visited.add(target);
		int currentLevel = 0;
		while (!queue.isEmpty()) {
			// check for the level requirement
			if (currentLevel == K) {
				return extractNodeValuesFromQueue(queue);
			}

			int levelSize = queue.size();
			for (int i = 0; i < levelSize; i++) {
				TreeNode current = queue.poll();
				if (null != current.left && !visited.contains(current.left)) {
					visited.add(current.left);
					queue.add(current.left);
				}
				if (null != current.right && !visited.contains(current.right)) {
					visited.add(current.right);
					queue.add(current.right);
				}

				// Now cover the nodes from parent - undirected fashion
				TreeNode parentOfCurrentNode = nodeToParentMap.get(current);
				if (null != parentOfCurrentNode && !visited.contains(parentOfCurrentNode)) {
					visited.add(parentOfCurrentNode);
					queue.add(parentOfCurrentNode);
				}
			}
			currentLevel++;
		}
		return new ArrayList<Integer>();
	}

	private List<Integer> extractNodeValuesFromQueue(Queue<TreeNode> queue) {
		List<Integer> result = new ArrayList<>();
		while (!queue.isEmpty()) {
			result.add(queue.poll().val);
		}
		return result;
	}

	/**
	 * Utility method to populate the mapping from a node to it's parent
	 */
	private void populateNodeToParentMap(Map<TreeNode, TreeNode> nodeToParentMap, TreeNode root, TreeNode parent) {
		if (null == root) {
			return;
		}
		// Add to the map
		nodeToParentMap.put(root, parent);

		// Recursively populate the map
		populateNodeToParentMap(nodeToParentMap, root.left, root);
		populateNodeToParentMap(nodeToParentMap, root.right, root);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// [3,5,1,6,2,0,8,null,null,7,4]
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(5);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(2);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(8);
		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(4);

		System.out.println(new KDistanceNodesFromTarget().distanceK(root, root.left, 2));

	}

}
