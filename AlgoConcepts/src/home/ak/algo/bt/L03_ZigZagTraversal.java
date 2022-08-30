package home.ak.algo.bt;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import home.ak.algo.bt.BinaryTree.Node;

/**
 * @author kundu
 *
 */
public class L03_ZigZagTraversal {

	public static List<List<Integer>> zigzagTraversal(Node root) {

		if (null == root) {
			return null;
		}

		List<List<Integer>> result = new ArrayList<>();

		// level order traversal
		Queue<Node> queue = new LinkedList<>();
		boolean leftToRight = true;
		queue.add(root);
		while (!queue.isEmpty()) {
			int levelSize = queue.size();
			List<Integer> currentLevel = new ArrayList<>();

			for (int i = 0; i < levelSize; i++) {
				Node temp = queue.poll();
				if (leftToRight)
					currentLevel.add(temp.data);
				else
					currentLevel.add(0, temp.data);
				// Add left child
				if (null != temp.left) {
					queue.add(temp.left);
				}
				// Add right child
				if (null != temp.right) {
					queue.add(temp.right);
				}
			}
			result.add(currentLevel);
			leftToRight = !leftToRight;
		}
		return result;
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

		System.out.println(zigzagTraversal(tree.root));
	}
}
