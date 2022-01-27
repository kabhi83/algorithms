/**
 * 
 */
package home.ak.algo.bt;

import java.util.HashMap;
import java.util.Map;

import home.ak.algo.bt.BinaryTree.Node;

/**
 * @author kundu
 *
 */
public class L10_BinaryTreeFromInorderPreorder {

	public static Node buildTree(int[] preorder, int[] inorder) {
		// Build inorder map
		Map<Integer, Integer> inmap = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			inmap.put(inorder[i], i);
		}

		Node root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inmap);
		return root;
	}

	private static Node buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd,
			Map<Integer, Integer> inmap) {
		// Base condition check
		if (preStart > preEnd || inStart > inEnd) {
			return null;
		}

		Node root = new Node(preorder[preStart]);
		int inorderRootIdx = inmap.get(root.data);
		int numsLeft = inorderRootIdx - inStart;

		root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inorderRootIdx - 1, inmap);
		root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder, inorderRootIdx + 1, inEnd, inmap);
		return root;
	}

	public static void main(String[] args) {
		int[] preorder = { 8, 3, 1, 6, 4, 7, 10, 14, 13 };
		int[] inorder = { 1, 3, 4, 6, 7, 8, 10, 13, 14 };

		Node root = buildTree(preorder, inorder);
		System.out.println(root.left.data);
		System.out.println(root.right.data);
		System.out.println(root.left.left.data);
		System.out.println(root.left.right.data);
		System.out.println(root.right.right.data);
	}

}
