/**
 * 
 */
package home.ak.algo.tree.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kundu
 * 
 *         Given a binary tree and a number ‘S’, find all paths from
 *         root-to-leaf such that the sum of all the node values of each path
 *         equals ‘S’.
 */
public class AllTreePathSum {

	static class TreeNode {
		int val;
		TreeNode left, right;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	/**
	 * Classical problem of backtracking. Every time we find a root-to-leaf path, we
	 * will store it in a list. We will traverse all paths and will not stop
	 * processing after finding the first path.
	 */
	public static List<List<Integer>> findPaths(TreeNode root, int sum) {
		List<List<Integer>> allPaths = new ArrayList<>();
		List<Integer> currentPath = new ArrayList<>();
		findPathsRecursive(root, sum, currentPath, allPaths);
		return allPaths;
	}

	private static void findPathsRecursive(TreeNode current, int sum, List<Integer> currentPath,
			List<List<Integer>> allPaths) {

		if (null == current) {
			return;
		}

		// Add the node to the current path
		currentPath.add(current.val);

		// Check if the node is leaf and the value equals the sum. Deep copy
		if (current.val == sum && null == current.left && null == current.right) {
			allPaths.add(new ArrayList<Integer>(currentPath));
		}

		// Search for the left and right sub-tree
		if (null != current.left) {
			findPathsRecursive(current.left, sum - current.val, currentPath, allPaths);
		}

		if (null != current.right) {
			findPathsRecursive(current.right, sum - current.val, currentPath, allPaths);
		}

		// Backtrack - Remove the last node from the current path
		// Need to remove the current node while going up the recursive call stack
		currentPath.remove(currentPath.size() - 1);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		int sum = 23;
		List<List<Integer>> result = findPaths(root, sum);
		System.out.println("Tree paths with sum " + sum + ": " + result);
	}
}
