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
 *         Given a binary tree, populate an array to represent the averages of
 *         all of its levels.
 *
 */
public class LevelAverage {
	static class TreeNode {
		int val;
		TreeNode left, right;

		TreeNode(int val) {
			this.val = val;
		}
	}

	public static List<Double> findLevelAverages(TreeNode root) {
		List<Double> result = new ArrayList<>();
		if (null == root) {
			return result;
		}

		// Initialize the queue for level order traversal
		Queue<TreeNode> queue = new LinkedList<>();
		// Add the root node
		queue.add(root);
		while (!queue.isEmpty()) {
			int levelSize = queue.size();
			List<Integer> currentLevel = new ArrayList<>();
			double levelSum = 0;
			for (int i = 0; i < levelSize; i++) {
				TreeNode current = queue.poll();
				levelSum += current.val;
				currentLevel.add(current.val);

				if (null != current.left) {
					queue.add(current.left);
				}
				if (null != current.right) {
					queue.add(current.right);
				}
			}
			// append the current level's average to the result array
			result.add(levelSum / levelSize);
		}
		return result;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.left.right = new TreeNode(2);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		List<Double> result = LevelAverage.findLevelAverages(root);
		System.out.print("Level averages are: " + result);
	}
}
