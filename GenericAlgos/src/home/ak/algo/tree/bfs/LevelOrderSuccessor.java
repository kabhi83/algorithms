/**
 * 
 */
package home.ak.algo.tree.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author kundu
 * 
 *         Given a binary tree and a node, find the level order successor of the
 *         given node in the tree. The level order successor is the node that
 *         appears right after the given node in the level order traversal.
 *
 */
public class LevelOrderSuccessor {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static TreeNode findSuccessor(TreeNode root, int key) {
		if (null == root) {
			return null;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		// Add the root
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode current = queue.poll();

			if (null != current.left) {
				queue.add(current.left);
			}
			if (null != current.right) {
				queue.add(current.right);
			}

			if (current.val == key) {
				break;
			}
		}
		return queue.peek();
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		TreeNode result = LevelOrderSuccessor.findSuccessor(root, 12);
		if (result != null)
			System.out.println(result.val + " ");
		result = LevelOrderSuccessor.findSuccessor(root, 9);
		if (result != null)
			System.out.println(result.val + " ");
	}

}
