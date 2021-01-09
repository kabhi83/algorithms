/**
 * 
 */
package home.ak.algo.tree.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author kundu
 *
 *         Find the minimum depth of a binary tree. The minimum depth is the
 *         number of nodes along the shortest path from the root node to the
 *         nearest leaf node.
 */
public class BinaryTreeMinDepth {

	static class TreeNode {
		int val;
		TreeNode left, right;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	public static int findDepth(TreeNode root) {
		if (null == root) {
			return 0;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int minDepth = 0;
		while (!queue.isEmpty()) {
			// increment the depth at level
			minDepth++;
			int levelSize = queue.size();
			for (int i = 0; i < levelSize; i++) {
				TreeNode current = queue.poll();

				// Check if the current node is leaf node
				// This will be the minimum depth
				if (null == current.left && null == current.right) {
					return minDepth;
				}

				if (null != current.left) {
					queue.add(current.left);
				}
				if (null != current.right) {
					queue.add(current.right);
				}
			}
		}
		return minDepth;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		System.out.println("Tree Minimum Depth: " + findDepth(root));
		root.left.left = new TreeNode(9);
		root.right.left.left = new TreeNode(11);
		System.out.println("Tree Minimum Depth: " + findDepth(root));
	}

}
