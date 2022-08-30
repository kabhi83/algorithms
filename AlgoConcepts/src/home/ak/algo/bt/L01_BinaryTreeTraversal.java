/**
 * 
 */
package home.ak.algo.bt;

import java.util.Stack;

import home.ak.algo.bt.BinaryTree.Node;

/**
 * @author kundu
 *
 */
public class L01_BinaryTreeTraversal {

	public static void preorderTraversal(Node node) {
		if (null == node) {
			return;
		}
		System.out.print(node.data + " ");
		preorderTraversal(node.left);
		preorderTraversal(node.right);
	}

	public static void iterativePreorderTraversal(Node node) {
		if (null == node) {
			return;
		}
		// Iterative preorder
		Stack<Node> stack = new Stack<>();
		stack.add(node);
		while (!stack.isEmpty()) {
			Node temp = stack.pop();
			System.out.print(temp.data + " ");
			if (null != temp.right) {
				stack.add(temp.right);
			}
			if (null != temp.left) {
				stack.add(temp.left);
			}
		}
	}

	public static void inorderTraversal(Node node) {
		if (null == node) {
			return;
		}
		inorderTraversal(node.left);
		System.out.print(node.data + " ");
		inorderTraversal(node.right);
	}

	public static void iterativeInorderTraversal(Node node) {

		Stack<Node> stack = new Stack<>();
		Node curr = node;
		while (!stack.isEmpty() || null != curr) {
			// if the current node exists, push it into the stack (defer it)
			// and move to its left child
			if (null != curr) {
				stack.push(curr);
				curr = curr.left;
			} else {
				// if the current node is null, pop an element from
				// the stack, print it, and finally set the current node to its
				// right child
				curr = stack.pop();
				System.out.println(curr.data);
				curr = curr.right;
			}
		}
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
		System.out.println();
		System.out.println("************Iterative************");
		iterativePreorderTraversal(tree.root);
	}
}
