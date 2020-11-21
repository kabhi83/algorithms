/**
 * 
 */
package home.ak.algo.tree.dfs;

import home.ak.algo.tree.dfs.AllTreePathSum.TreeNode;

/**
 * @author kundu
 *
 *         Given a binary tree and a number sequence, find if the sequence is
 *         present as a root-to-leaf path in the given tree.
 */
public class PathWithGivenSequence {

	static class TreeNode {
		int val;
		TreeNode left, right;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	public static boolean findPath(TreeNode root, int[] sequence) {
		return validateSequence(root, 0, sequence);
	}

	private static boolean validateSequence(TreeNode current, int index, int[] sequence) {
		if (null == current) {
			return false;
		}

		if (index >= sequence.length || current.val != sequence[index]) {
			return false;
		}

		// Check for the leaf node
		if (null == current.left && null == current.right && index == sequence.length - 1) {
			return true;
		}

		// recursively call to traverse the left and right sub-tree
		// return true if any of the two recusrive call return true
		return validateSequence(current.left, index + 1, sequence)
				|| validateSequence(current.right, index + 1, sequence);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(1);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(5);

		System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 0, 7 }));
		System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 1, 6 }));
	}
}
