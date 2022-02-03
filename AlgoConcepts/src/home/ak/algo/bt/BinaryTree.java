/**
 * 
 */
package home.ak.algo.bt;

/**
 * @author kundu 8 / \ 3 10 / \ \ 1 6 14 / \ / 4 7 13
 */
public class BinaryTree {

	static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}

	Node root;

	/**
	 * Utility function to add node to the tree
	 */
	public void add(int data) {
		root = add(root, data);
	}

	private Node add(Node node, int data) {
		if (null == node) {
			return new Node(data);
		}
		if (data < node.data) {
			// scan left subtree
			node.left = add(node.left, data);
		} else if (data > node.data) {
			// scan right subtree
			node.right = add(node.right, data);
		}
		return node;
	}

	/**
	 * Utility function to delete a node from the tree
	 * 
	 * @param data
	 */
	public void delete(int data) {
		root = delete(root, data);
	}

	private Node delete(Node node, int data) {
		if (null == node) {
			return node;
		}
		// search for the node
		if (data < node.data) {
			node.left = delete(node.left, data);
		} else if (data > node.data) {
			node.right = delete(node.right, data);
		} else {
			// Node found
			// case 1: Node has either no children or either left or right child
			if (null == node.left || null == node.right) {
				Node temp = null;
				temp = node.left == null ? node.right : node.left;
				// replace node with temp
				return temp;
			} else {
				// case 2: Node has both children
				// Replace the node with the smallest value in right subtree
				int smallestValue = findSmallestValue(node.right);
				node.data = smallestValue;
				node.right = delete(node.right, smallestValue);
				return node;
			}
		}
		return node;
	}

	private int findSmallestValue(Node node) {
		return node.left == null ? node.data : findSmallestValue(node.left);
	}

	/**
	 * Inorder traversal to print the tree nodes
	 * 
	 * @param root
	 */
	public void print(Node root) {
		if (null == root) {
			return;
		}
		print(root.left);
		System.out.print(root.data + " ");
		print(root.right);
	}

	public static void main(String[] args) {
		// 8,6,5,7,10,9,11
		BinaryTree tree = new BinaryTree();
		tree.add(8);
		tree.add(6);
		tree.add(5);
		tree.add(7);
		tree.add(10);
		tree.add(9);
		tree.add(11);

		tree.print(tree.root);
		tree.delete(8);
		System.out.println("\n________________\n");
		tree.print(tree.root);

	}

}
