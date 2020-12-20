/**
 * 
 */
package home.ak.algo.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kundu
 * 
 *         Given preorder and inorder traversal of a tree, construct the binary
 *         tree.
 * 
 *         Note: You may assume that duplicates do not exist in the tree.
 * 
 *         For example, given
 * 
 *         preorder = [3,9,20,15,7] inorder = [9,3,15,20,7]
 * 
 * 
 *         Hints: 1) The first value in pre-order list is the root. If you find
 *         the position of that number in the in-order list, everything to the
 *         left of it is the left subtree and everything to the right is the
 *         right subtree. Because finding the position of numbers in the
 *         in-order list is important, use a map to keep track of these things.
 * 
 *         2) As said above, the leftmost pointer in the pre-order is going to
 *         be the root. If we know the root, we just need to recursively build
 *         our left and right subtrees.
 * 
 *         3) If we recall, if we know the position of the root in the in-order,
 *         EVERYTHING to the left (up until the left pointer) is in the left
 *         subtree. So, taking the index of the root - left pointer of in-order
 *         is the number of elements in the left subtree. Since we know the
 *         number of elements, just add that to the left pointer of the
 *         pre-order and you now have both the left and right bounds to
 *         recursively solve the left side. (pLeftNew = 1 + pLeft, pRightNew =
 *         pLeft + numOfElements) and (iLeft = iLeft, iRight = root index - 1)
 * 
 *         4) The right Tree is easy as all the work for calculating the indices
 *         is complete, and we can just modify the variables we used on the left
 *         side. (pLeft = pRightNew + 1, pRight = pRight) and (iLeft = rootIndex
 *         + 1, iRight = iRight)
 *
 */
public class ConstructTreeWithPreorderAndInorder {

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		// Save duplicate work for searches against the inorder traversal
		Map<Integer, Integer> inorderNodeIndex = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			inorderNodeIndex.put(inorder[i], i);
		}

		return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inorderNodeIndex);
	}

	private TreeNode build(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd,
			Map<Integer, Integer> inorderNodeIndex) {

		// check for the base case
		if (pStart > pEnd || iStart > iEnd) {
			return null;
		}

		// Identify the root from the pre-order traversal
		int nodeValue = preorder[pStart];
		TreeNode curr = new TreeNode(nodeValue);
		int currIndex = inorderNodeIndex.get(nodeValue);
		int leftSubTreeElements = currIndex - iStart;
		curr.left = build(preorder, pStart + 1, pStart + leftSubTreeElements, inorder, iStart, currIndex - 1,
				inorderNodeIndex);
		curr.right = build(preorder, pStart + leftSubTreeElements + 1, pEnd, inorder, currIndex + 1, iEnd,
				inorderNodeIndex);
		return curr;
	}
	
	static void traverseInOrder(TreeNode root) {
		if(null == root) {
			return;
		}
		traverseInOrder(root.left);
		System.out.print(root.val + " ");
		traverseInOrder(root.right);
	}

	public static void main(String[] args) {
		int[] preorder = { 3, 9, 20, 15, 7 };
		int[] inorder = { 9, 3, 15, 20, 7 };
		TreeNode root = new ConstructTreeWithPreorderAndInorder().buildTree(preorder, inorder);
		traverseInOrder(root);
	}

}
