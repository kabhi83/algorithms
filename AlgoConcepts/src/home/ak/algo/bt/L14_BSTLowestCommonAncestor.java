/**
 * 
 */
package home.ak.algo.bt;

import home.ak.algo.bt.BinaryTree.Node;

/**
 * @author kundu
 *
 */
public class L14_BSTLowestCommonAncestor {

	public static Node lowestCommonAncestor(Node root, Node p, Node q) {
		if (null == root) {
			return null;
		}

		int curr = root.data;
		if (curr > p.data && curr > q.data) {
			// Search left subtree
			return lowestCommonAncestor(root.left, p, q);
		}
		if (curr < p.data && curr < q.data) {
			// Search right subtree
			return lowestCommonAncestor(root.right, p, q);
		}
		// If we cannot compare both the nodes then the current node is LCA
		// This applies when 1 node is left subtree and 1 node in right subtree
		return root;
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

		Node root = tree.root;
		Node p = root.left.left;
		Node q = root.left.right;
		
		System.out.println(lowestCommonAncestor(root, p, q).data);
	}

}
