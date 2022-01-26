/**
 * 
 */
package home.ak.algo.bt;

import home.ak.algo.bt.BinaryTree.Node;

/**
 * @author kundu
 *
 */
public class L1_BinaryTreeTraversal {

	public static void preorderTraversal(Node node) {
		if (null == node) {
			return;
		}
		System.out.print(node.data + " ");
		preorderTraversal(node.left);
		preorderTraversal(node.right);
	}

	public static void inorderTraversal(Node node) {
		if (null == node) {
			return;
		}
		inorderTraversal(node.left);
		System.out.print(node.data + " ");
		inorderTraversal(node.right);
	}

	public static void postorderTraversal(Node node) {
		if (null == node) {
			return;
		}
		postorderTraversal(node.left);
		postorderTraversal(node.right);
		System.out.print(node.data + " ");
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.add(8);
		tree.add(3);
		tree.add(6);
		tree.add(10);
		tree.add(4);
		tree.add(7);
		tree.add(1);
		tree.add(14);
		tree.add(13);

		preorderTraversal(tree.root);
		System.out.println();
		inorderTraversal(tree.root);
		System.out.println();
		postorderTraversal(tree.root);
	}
}
