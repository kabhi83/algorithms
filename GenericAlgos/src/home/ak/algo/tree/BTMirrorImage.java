/**
 * 
 */
package home.ak.algo.tree;

/**
 * @author kundu
 * 
 *         A mirror image of a binary tree is another binary tree with left and
 *         right children of all non-leaf nodes of the given binary tree are
 *         interchanged.
 *
 */
public class BTMirrorImage {

	static class TreeNode {
		int data;
		TreeNode left, right;

		TreeNode(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}

	public static TreeNode mirror(TreeNode node) {
		if (null == node) {
			return node;
		}
		TreeNode left = mirror(node.left);
		TreeNode right = mirror(node.right);

		/* swap the left and right pointers */
		node.left = right;
		node.right = left;

		return node;
	}

	public static void printInOrder(TreeNode node) {
		if (null == node) {
			return;
		}
		printInOrder(node.left);
		System.out.print(node.data + " ");
		printInOrder(node.right);
	}

	public static void main(String[] args) {
		/* creating a binary tree and entering the nodes */
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		System.out.println("Before mirroring");
		printInOrder(root);

		mirror(root);

		System.out.println("\nAfter mirroring");
		printInOrder(root);
	}

}
