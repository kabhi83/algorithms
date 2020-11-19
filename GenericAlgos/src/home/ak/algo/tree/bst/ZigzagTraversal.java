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
 *         Given a binary tree, populate an array to represent its zigzag level
 *         order traversal. You should populate the values of all nodes of the
 *         first level from left to right, then right to left for the next level
 *         and keep alternating in the same manner for the following levels.
 *
 */
public class ZigzagTraversal {

	static class TreeNode {
		int val;
		TreeNode left, right;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	public static List<List<Integer>> traverse(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (null == root) {
			return result;
		}

		// Initialize the queue
		Queue<TreeNode> queue = new LinkedList<>();
		// Add the root node - at odd level
		queue.add(root);

		// Set the left-right traversal
		boolean leftToRight = true;
		while (!queue.isEmpty()) {
			int levelSize = queue.size();
			List<Integer> currentLevel = new ArrayList<>();
			for (int i = 0; i < levelSize; i++) {
				TreeNode current = queue.poll();
				// Add to the current level based on the direction
				if (leftToRight) {
					currentLevel.add(current.val);
				} else {
					// Add to the first of the linked list
					currentLevel.add(0, current.val);
				}

				// insert the children of current node in the queue
				if (null != current.left) {
					queue.add(current.left);
				}
				if (null != current.right) {
					queue.add(current.right);
				}
			}
			result.add(currentLevel);
			// reverse the traversal direction
			leftToRight = !leftToRight;
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
		root.right.left.left = new TreeNode(20);
		root.right.left.right = new TreeNode(17);
		List<List<Integer>> result = ZigzagTraversal.traverse(root);
		System.out.println("Zigzag traversal: " + result);
	}

}
