/**
 * 
 */
package home.ak.algo.tree;

/**
 * @author kundu
 * 
 *         Given a binary search tree, write a function kthSmallest to find the
 *         kth smallest element in it.
 * 
 *         Example 1:
 * 
 *         Input: root = [3,1,4,null,2], k = 1 
 *         
 *         			3 
 *         		   / \ 
 *                1   4 
 *                 \ 
 *                  2  
 *                  
 *         Output: 1
 */
public class KthSmalletElementBST {
	
	public int kthSmallest(TreeNode root, int k) {
		//create an array to hold the kth index and its associated BST element
		int[] nums = new int[2];
		inorder(root, k, nums);
		return nums[1];
	}
	
	public void inorder(TreeNode root, int k, int[] nums) {
		if(null == root) {
			return;
		}
		
		inorder(root.left, k, nums);
		if(++nums[0] == k) {
			nums[1] = root.val;
			return;
		}
		inorder(root.right, k, nums);
	}
	
	public static void main(String[] args) {
		
	}
}
