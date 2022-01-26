package home.ak.algo.bt;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import home.ak.algo.bt.BinaryTree.Node;

/**
 * @author kundu
 *
 */
public class L4_BoundaryTraversal {

	public static List<Integer> boundaryTraversal(Node node) {
		List<Integer> result = null;
		if (null == node) {
			return null;
		}
		result = new ArrayList<>();
		result.add(node.data);
		if (isLeafNode(node)) {
			return result;
		}
		getLeftBoundary(node.left, result);
		getLeafNodes(node, result);
		getRightBoundary(node.right, result);
		return result;
	}

	private static void getLeftBoundary(Node node, List<Integer> result) {
		if (!isLeafNode(node)) {
			result.add(node.data);
		}
		if (null != node.left) {
			getLeftBoundary(node.left, result);
		} else if (null != node.right) {
			getLeftBoundary(node.right, result);
		}

	}

	private static void getLeafNodes(Node node, List<Integer> result) {
		if (isLeafNode(node)) {
			result.add(node.data);
			return;
		}
		if (null != node.left) {
			getLeafNodes(node.left, result);
		}
		if (null != node.right) {
			getLeafNodes(node.right, result);
		}

	}

	private static void getRightBoundary(Node node, List<Integer> result) {
		Stack<Integer> stack = new Stack<>();
		Node curr = node;
		while (curr != null) {
			if (!isLeafNode(curr)) {
				stack.add(curr.data);
			}
			if (null != curr.right) {
				curr = curr.right;
			} else {
				curr = curr.left;
			}
		}
		while (!stack.isEmpty()) {
			result.add(stack.pop());
		}
	}

	private static boolean isLeafNode(Node node) {
		return node.left == null & node.right == null;
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

		System.out.println(boundaryTraversal(tree.root));
	}

}
