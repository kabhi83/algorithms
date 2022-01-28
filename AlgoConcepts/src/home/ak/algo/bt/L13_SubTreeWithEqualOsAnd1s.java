/**
 * 
 */
package home.ak.algo.bt;

import java.util.LinkedList;
import java.util.Queue;

import home.ak.algo.bt.BinaryTree.Node;

/**
 * @author kundu
 * 
 *         Given a Binary Tree having data at nodes as either 0’s or 1’s. Find
 *         out whether there exists a subtree having an equal number of 1’s and
 *         0’s.
 *
 */
public class L13_SubTreeWithEqualOsAnd1s {

	public static boolean findSubTree(Node node) {
		convertTree(node);
		sumTree(node);
		return validate(node);
	}

	// Utility method to convert all the 0's to -1 in the tree
	private static void convertTree(Node node) {
		if (null == node) {
			return;
		}
		if (node.data == 0) {
			node.data = -1;
		}
		convertTree(node.left);
		convertTree(node.right);
	}

	private static int sumTree(Node node) {
		if (null == node) {
			return 0;
		}

		int leftSum = sumTree(node.left);
		int rightSum = sumTree(node.right);

		node.data += leftSum + rightSum;
		return node.data;
	}

	private static boolean validate(Node node) {
		if (null == node) {
			return false;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		while (!queue.isEmpty()) {
			Node curr = queue.poll();
			if (node.data == 0) {
				return true;
			}
			if (null != curr.left) {
				queue.add(curr.left);
			}
			if (null != curr.right) {
				queue.add(curr.right);
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Node node = new Node(0);
		node.left = new Node(0);
		node.right = new Node(1);
		node.right.left = new Node(1);
		
		System.out.println(findSubTree(node));
	}

}
