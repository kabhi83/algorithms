/**
 * 
 */
package home.ak.algo.tree.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

/**
 * @author kundu
 * 
 *         Given a binary tree, print it in Top View of it.
 * 
 *         Problem is the combination of LevelOrderTraversal +
 *         VerticalOrderTraversal
 *
 */
public class TopViewBT {

	// node structure of tree
	static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		public TreeNode(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	static class QueueNode {
		int level;
		TreeNode tnode;

		public QueueNode(int level, TreeNode tnode) {
			this.level = level;
			this.tnode = tnode;
		}
	}

	public static TreeMap<Integer, Integer> verticalOrderMap = new TreeMap<>();;

	public void topView(TreeNode root, int level) {
		if (root == null)
			return;
		// create a queue for level order traversal
		Queue<QueueNode> queue = new LinkedList<>();
		// add root with level 0 (create a queue item pack)
		queue.add(new QueueNode(level, root));
		while (!queue.isEmpty()) {
			QueueNode q = queue.remove();
			// take out the items from the package
			TreeNode tnode = q.tnode;
			int lvl = q.level;

			// check if this is the first node you are visiting at the level
			if (!verticalOrderMap.containsKey(lvl)) {
				// print it, its the first element at his level
				System.out.print(tnode.data + "   ");
				verticalOrderMap.put(lvl, tnode.data);
			}

			// add the left and right children of visiting nodes to the queue
			if (tnode.left != null) {
				queue.add(new QueueNode(lvl - 1, tnode.left));
			}
			if (tnode.right != null) {
				queue.add(new QueueNode(lvl + 1, tnode.right));
			}
		}

	}

	public static void main(String args[]) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.left.left = new TreeNode(8);
		root.left.left.right = new TreeNode(9);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		TopViewBT p = new TopViewBT();
		p.topView(root, 0);
	}
}
