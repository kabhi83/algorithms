/**
 * 
 */
package home.ak.algo.tree.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author kundu
 * 
 *         Given a binary tree and a number ‘S’, find all paths in the tree such
 *         that the sum of all the node values of each path equals ‘S’. Please
 *         note that the paths can start or end at any node but all paths must
 *         follow direction from parent to child (top to bottom).
 *
 */
public class CountMatchingSumPaths {

	static class TreeNode {
		int val;
		TreeNode left, right;

		TreeNode(int val) {
			this.val = val;
		}
	}

	/**
	 * We will keep track of the current path in a list which will be passed to
	 * every recursive call. Whenever we traverse a node we will do two things:
	 * 
	 * 1. Add the current node to the current path.
	 * 
	 * 2. As we added a new node to the current path, we should find the sums of all
	 * sub-paths ending at the current node. If the sum of any sub-path is equal to
	 * ‘S’ we will increment our path count.
	 */
	public static int countPaths(TreeNode root, int S) {
		List<Integer> currentPath = new ArrayList<>();
		return countPathsRecursive(root, S, currentPath);
	}

	private static int countPathsRecursive(TreeNode current, int S, List<Integer> currentPath) {
		if (null == current)
			return 0;

		// Add the current to the currentPath
		currentPath.add(current.val);

		// find the sums of all sub-paths in the current path list
		int pathCount = 0, pathSum = 0;
		ListIterator<Integer> pathIterator = currentPath.listIterator(currentPath.size());
		// For every item added, back count from the item to check if the path sum is S
		while (pathIterator.hasPrevious()) {
			pathSum += pathIterator.previous();
			// if the sum of any sub-path is equal to 'S' we increment our path count.
			if (pathSum == S) {
				pathCount++;
			}
		}

		// traverse the left sub-tree
		pathCount += countPathsRecursive(current.left, S, currentPath);
		// traverse the right sub-tree
		pathCount += countPathsRecursive(current.right, S, currentPath);

		// remove the current node from the path to backtrack,
		// we need to remove the current node while we are going up the recursive call
		// stack.
		currentPath.remove(currentPath.size() - 1);

		return pathCount;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		System.out.println("Tree has path: " + countPaths(root, 11));
	}

	/*
	 * Time complexity # The time complexity of the above algorithm is O(N^2) in the
	 * worst case, where ‘N’ is the total number of nodes in the tree. This is due
	 * to the fact that we traverse each node once, but for every node, we iterate
	 * the current path. The current path, in the worst case, can be O(N) (in the
	 * case of a skewed tree). But, if the tree is balanced, then the current path
	 * will be equal to the height of the tree, i.e., O(logN). So the best case of
	 * our algorithm will be O(NlogN).
	 * 
	 * Space complexity # The space complexity of the above algorithm will be O(N).
	 * This space will be used to store the recursion stack. The worst case will
	 * happen when the given tree is a linked list (i.e., every node has only one
	 * child). We also need O(N) space for storing the currentPath in the worst
	 * case.
	 * 
	 * Overall space complexity of our algorithm is O(N).
	 */

}
