/**
 * 
 */
package home.ak.algo.tree;

/**
 * @author kundu
 * 
 *         Given two binary trees and imagine that when you put one of them to
 *         cover the other, some nodes of the two trees are overlapped while the
 *         others are not.
 * 
 *         You need to merge them into a new binary tree. The merge rule is that
 *         if two nodes overlap, then sum node values up as the new value of the
 *         merged node. Otherwise, the NOT null node will be used as the node of
 *         new tree.
 *
 */
public class MergeBT {

	public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		return merge(t1, t2);
	}

	public static TreeNode merge(TreeNode t1, TreeNode t2) {
		if (null == t1 && null == t2)
			return null;

		if (null == t1 && null != t2)
			return t2;

		if (null != t1 && null == t2)
			return t1;

		TreeNode node = new TreeNode(t1.val + t2.val);
		node.left = merge(t1.left, t2.left);
		node.right = merge(t1.right, t2.right);
		return node;
	}

	public static void printInOrder(TreeNode root) {
		if (null == root) {
			return;
		}

		printInOrder(root.left);
		System.out.print(root.val + " ");
		printInOrder(root.right);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		t1.left = new TreeNode(3);
		t1.right = new TreeNode(2);
		t1.left.left = new TreeNode(5);

		TreeNode t2 = new TreeNode(2);
		t2.left = new TreeNode(1);
		t2.right = new TreeNode(3);
		t2.left.right = new TreeNode(4);
		t2.right.right = new TreeNode(7);
		
		TreeNode node = mergeTrees(t1, t2);

		printInOrder(node);

	}

}
