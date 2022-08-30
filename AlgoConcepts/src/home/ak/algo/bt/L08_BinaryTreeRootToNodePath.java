/**
 * 
 */
package home.ak.algo.bt;

import java.util.ArrayList;
import java.util.List;

import home.ak.algo.bt.BinaryTree.Node;

/**
 * @author kundu
 *
 */
public class L08_BinaryTreeRootToNodePath {

	public static List<Integer> getPath(Node root, int x) {
		List<Integer> path = new ArrayList<>();
		getPath(root, x, path);
		return path;
	}

	private static boolean getPath(Node node, int x, List<Integer> path) {
		if (null == node) {
			// Processing ends - no match found
			return false;
		}

		// Add the node getting processed
		path.add(node.data);
		// Compare the value for match
		if (node.data == x) {
			return true;
		}

		// Process both left and right child separately
		if (getPath(node.left, x, path) || getPath(node.right, x, path)) {
			return true;
		}

		// Remove the node and return false
		path.remove(path.size() - 1);// Remove the last element
		return false;
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
		
		System.out.println(getPath(tree.root, 7));
	}
}
