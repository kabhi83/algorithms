/**
 * 
 */
package home.ak.algo.bt;

import home.ak.algo.bt.BinaryTree.Node;

/**
 * @author kundu
 *
 */
public class L15_MaximumPathSumInBT {

	// Since binary tree can have max path sum as a negative value
	private static Integer max = Integer.MIN_VALUE;

	public static int maxPathSum(Node node) {
		postOrder(node);
		return max;
	}

	private static int postOrder(Node node) {
		if (node == null) {
			return 0;
		}
		// Bound left and right to zero if the max on left or right is negative
		// Negative added to a positive will only reduce the value
		int left = Math.max(0, postOrder(node.left));
		int right = Math.max(0, postOrder(node.right));
		max = Math.max(max, left + right + node.data);

		// Return max of left or right as we want a single path
		return Math.max(left, right) + node.data;

	}

	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(5);
		root.right = new Node(-10);

		root.left.left = new Node(-5);
		root.left.right = new Node(1);

		root.right.left = new Node(50);
		root.right.right = new Node(20);

		System.out.println(maxPathSum(root));
	}

}
