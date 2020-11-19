/**
 * 
 */
package home.ak.algo.tree.bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author kundu
 * 
 *         Given a binary tree, populate an array to represent its
 *         level-by-level traversal in reverse order, i.e., the lowest level
 *         comes first. You should populate the values of all nodes in each
 *         level from left to right in separate sub-arrays.
 *
 */
public class ReverseLevelOrderTraversal {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	};

	public static List<List<Integer>> traverse(TreeNode root) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		if (null == root) {
			return result;
		}

		// initialize the queue
		Queue<TreeNode> queue = new LinkedList<>();
		// Add the root
		queue.add(root);
		while (!queue.isEmpty()) {
			// track the nodes at any level
			int levelSize = queue.size();

			List<Integer> currentLevel = new ArrayList<>();
			for (int i = 0; i < levelSize; i++) {
				// Poll the top element of the queue and add to list
				TreeNode current = queue.poll();
				currentLevel.add(current.val);

				// Add left and right child if present
				if (null != current.left) {
					queue.add(current.left);
				}
				if (null != current.right) {
					queue.add(current.right);
				}
			}
			// append the current level at the beginning
			result.add(0, currentLevel);
		}

		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		List<List<Integer>> result = ReverseLevelOrderTraversal.traverse(root);
		System.out.println("Reverse level order traversal: " + result);
	}

}
