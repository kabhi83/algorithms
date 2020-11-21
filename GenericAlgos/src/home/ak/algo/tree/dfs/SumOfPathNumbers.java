package home.ak.algo.tree.dfs;

/**
 * @author kundu
 * 
 *         Given a binary tree where each node can only have a digit (0-9)
 *         value, each root-to-leaf path will represent a number. Find the total
 *         sum of all the numbers represented by all paths.
 *         		
 *         			1
 *				  /	 \	
 * 			     0    1
 * 				/	 / \
 * 			   1    6   5
 * 
 * 		 	Path Sum = 101 + 116 + 115 = 332
 */
public class SumOfPathNumbers {

	static class TreeNode {
		int val;
		TreeNode left, right;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	public static int findSumOfPathNumbers(TreeNode root) {
		return findRootToLeafPathNumbers(root, 0);
	}

	private static int findRootToLeafPathNumbers(TreeNode current, int pathSum) {
		if (null == current) {
			return 0;
		}

		// Compute pathSum
		pathSum = pathSum * 10 + current.val;

		// If leaf then return the pathSum
		if (null == current.left && null == current.right) {
			return pathSum;
		}

		// Continue with computing pathSum if not leaf
		return findRootToLeafPathNumbers(current.left, pathSum) + findRootToLeafPathNumbers(current.right, pathSum);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(1);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(5);
		System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.findSumOfPathNumbers(root));
	}

	/*
	 * Time complexity # The time complexity of the above algorithm is O(N),
	 * where ‘N’ is the total number of nodes in the tree. This is due to the fact
	 * that we traverse each node once.
	 * 
	 * Space complexity # The space complexity of the above algorithm will be
	 * O(N) in the worst case. This space will be used to store the recursion
	 * stack. The worst case will happen when the given tree is a linked list (i.e.,
	 * every node has only one child).
	 */
}
