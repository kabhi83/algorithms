/**
 * 
 */
package home.ak.algo.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kundu
 * 
 *         Given a task tree where every node represents a task and the value
 *         indicates the amount of time to complete that task. The task node has
 *         the reference to the list of dependent tasks which depends on the
 *         current task, find the maximum time taken by any task path from the
 *         root.
 * 
 *         Alternate, You are given an n-ary tree consisting of "N" nodes. Your
 *         task is to return the maximum sum of the path from the root to the
 *         leaf node.
 *
 */
public class L01_MaxPathSumNArrTree {

	class Node {
		int data;
		List<Node> children;

		public Node(int data, List<Node> children) {
			this.data = data;
			this.children = new ArrayList<>();
		}
	}

	public static int findMaxSum(Node node) {
		if (null == node) {
			return 0;
		}

		int[] maxSum = { 0 }; // shared by reference
		dfs(node, node.data, maxSum);

		return maxSum[0];
	}

	private static void dfs(Node node, int pathSum, int[] maxSum) {
		// Base case
		if (null == node.children) {
			maxSum[0] = Math.max(maxSum[0], pathSum);
		}

		for (Node child : node.children) {
			dfs(child, pathSum + child.data, maxSum);
		}
	}
}
