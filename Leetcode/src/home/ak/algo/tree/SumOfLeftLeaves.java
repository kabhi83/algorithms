/**
 * 
 */
package home.ak.algo.tree;

/**
 * @author kundu
 * 
 *         Find the sum of all left leaves in a given binary tree.
 *         					3
 *         				   / \
 *         				  9   20
 *         				 	  /\
 *         					 15 7
 *         
 *         Solution: 9 + 15 = 24
 *
 */
public class SumOfLeftLeaves {

	public int sumOfLeftLeaves(TreeNode root) {
		if(null == root) {
			return 0;
		}
		
		if(null != root.left && null == root.left.left && null == root.left.right) {
			return root.left.val + sumOfLeftLeaves(root.right);
		} else {
			return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		
		int result = new SumOfLeftLeaves().sumOfLeftLeaves(root);
		System.out.println(result);
	}

}
