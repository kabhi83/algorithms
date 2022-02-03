/**
 * 
 */
package home.ak.algo.bt;

import home.ak.algo.bt.BinaryTree.Node;

/**
 * @author kundu
 *
 */
public class L14_BinaryTreeDepthAndDiameter {

	public static int depth(Node node) {
		if (null == node)
			return 0;
		return 1 + Math.max(depth(node.left), depth(node.right));
	}

	/**
	 * The diameter of a binary tree is the length of the longest path between any
	 * two nodes in a tree. This path may or may not pass through the root.
	 * 
	 */
	public static int diameter(Node node) {
		int[] diameter = new int[1];
		diameter(node, diameter);
		return diameter[0];
	}

	private static int diameter(Node node, int[] diameter) {
		if (null == node) {
			return 0;
		}

		int leftHeight = diameter(node.left, diameter);
		int rightHeight = diameter(node.right, diameter);
		// For every node, add the max left height and max right height plus the current
		// node and finally compare with the global max value (passed by ref here)
		// Hence for every node we are computing the max possible diameter
		diameter[0] = Math.max(diameter[0], leftHeight + rightHeight);
		
		return 1 + Math.max(leftHeight, rightHeight);
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.right.left = new Node(4);
		root.right.left.left = new Node(5);
		root.right.left.left.left = new Node(9);
		root.right.right = new Node(6);
		root.right.right.right = new Node(7);
		root.right.right.right.right = new Node(8);

		System.out.println(diameter(root));

	}

}
