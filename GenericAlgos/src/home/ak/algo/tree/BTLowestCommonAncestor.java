/**
 * 
 */
package home.ak.algo.tree;

/**
 * @author kundu
 * 
 *         Given a binary tree, find the lowest common ancestor (LCA) of two
 *         given nodes in the tree.
 * 
 *         According to the definition of LCA on Wikipedia: “The lowest common
 *         ancestor is defined between two nodes p and q as the lowest node in T
 *         that has both p and q as descendants (where we allow a node to be a
 *         descendant of itself).”
 *
 */
public class BTLowestCommonAncestor {

	static class TreeNode {
		int val;
		TreeNode left, right;

		TreeNode(int val) {
			this.val = val;
			this.left = this.right = null;
		}
	}

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		// Base case
		if (root == null)
			return null;
		if (root.val == p.val || root.val == q.val)
			return root;

		// Search left and then search right.
		TreeNode leftSearchResult = lowestCommonAncestor(root.left, p, q);
		TreeNode rightSearchResult = lowestCommonAncestor(root.right, p, q);

		// Nothing on the left sub tree
		if (leftSearchResult == null)
			return rightSearchResult;

		// Nothing on the right sub tree
		if (rightSearchResult == null)
			return leftSearchResult;

		// If the result is distributed between left and right sub-tree
		return root;
	}

	public static void main(String[] args) {
		// [3,5,1,6,2,0,8,null,null,7,4]
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(5);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(2);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(8);
		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(4);

		TreeNode p = new TreeNode(2);
		TreeNode q = new TreeNode(7);

		System.out.println(lowestCommonAncestor(root, p, q).val);

	}

	/*
	 * Time Complexity: O(h)
	 * 
	 * Space Complexity: o(h)
	 */

}
