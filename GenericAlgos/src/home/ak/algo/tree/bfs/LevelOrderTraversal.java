/**
 * 
 */
package home.ak.algo.tree.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author kundu
 * 
 *         Given a binary tree, populate an array to represent its
 *         level-by-level traversal. You should populate the values of all nodes
 *         of each level from left to right in separate sub-arrays.
 *
 */
public class LevelOrderTraversal {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static List<List<Integer>> traverse(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if (null == root) {
			return result;
		}

		// Initialize the queue
		Queue<TreeNode> queue = new LinkedList<>();

		// add the root
		queue.add(root);
		while (!queue.isEmpty()) {
			// Track the number of nodes in each level
			// Don't use queue.size() directly as the value changes in for loop
			int levelSize = queue.size();

			List<Integer> currentLevel = new ArrayList<>(levelSize);

			for (int i = 0; i < levelSize; i++) {
				TreeNode current = queue.poll();
				// add the node to the current level
				currentLevel.add(current.val);
				// insert the children of current node in the queue
				if (null != current.left) {
					queue.add(current.left);
				}
				if (null != current.right) {
					queue.add(current.right);
				}
			}
			result.add(currentLevel);

		}
		return result;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		List<List<Integer>> result = LevelOrderTraversal.traverse(root);
		System.out.println("Level order traversal: " + result);
	}

}
