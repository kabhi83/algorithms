/**
 * 
 */
package home.ak.algo.tree;

/**
 * @author kundu
 * 
 *         Given the root of a binary tree, return its maximum depth.
 * 
 *         A binary tree's maximum depth is the number of nodes along the
 *         longest path from the root node down to the farthest leaf node.
 *
 */
public class BTMaximumDepth {

	public int maxDepth(TreeNode root) {
		if (null == root) {
			return 0;
		}

		int leftTreeDepth = maxDepth(root.left);
		int rightTreeDepth = maxDepth(root.right);

		return Math.max(leftTreeDepth, rightTreeDepth) + 1;
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

		int maxDepth = new BTMaximumDepth().maxDepth(root);
		System.out.println(maxDepth);

	}

}
