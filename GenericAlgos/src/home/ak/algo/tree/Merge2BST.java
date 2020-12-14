/**
 * 
 */
package home.ak.algo.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kundu
 * 
 *         Given two Binary Search Trees(BST), print the elements of both BSTs
 *         in sorted form. The expected time complexity is O(m+n) where m is the
 *         number of nodes in the first tree and n is the number of nodes in the
 *         second tree. The maximum allowed auxiliary space is O(height of the
 *         first tree + height of the second tree).
 *
 */
public class Merge2BST {
	
	static class TreeNode {
		int data;
		TreeNode left, right;
		TreeNode(int data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	public static int[] merge(TreeNode root1, TreeNode root2) {
		List<Integer> bst1 = new ArrayList<>();
		List<Integer> bst2 = new ArrayList<>();
		
		return null;
	}
	
	private static void inOrder(TreeNode root) {
		
	}

}
