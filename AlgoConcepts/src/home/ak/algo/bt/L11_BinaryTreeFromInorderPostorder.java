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
public class L11_BinaryTreeFromInorderPostorder {

	public static Node buildTree(int[] postorder, int[] inorder) {
		Map<Integer, Integer> inMap = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			inMap.put(inorder[i], i);
		}
		Node root = buildTree(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, inMap);
		return root;
	}

	private static Node buildTree(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd,
			Map<Integer, Integer> inMap) {
		if (postStart > postEnd || inStart > inEnd) {
			return null;
		}
		Node root = new Node(postorder[postEnd]);
		int inorderRootIdx = inMap.get(root.data);
		int numsLeft = inorderRootIdx - inStart;
		root.left = buildTree(postorder, postStart, postStart + numsLeft - 1, inorder, inStart, inorderRootIdx - 1, inMap);
		root.right = buildTree(postorder, postStart + numsLeft, postEnd - 1, inorder, inorderRootIdx + 1, inEnd, inMap);

		return root;
	}

	public static void main(String[] args) {
		int[] postorder = { 1, 4, 7, 6, 3, 13, 14, 10, 8 };
		int[] inorder = { 1, 3, 4, 6, 7, 8, 10, 13, 14 };

		
		Node root = buildTree(postorder, inorder);
		System.out.println(root.data);
		System.out.println(root.left.data);
		System.out.println(root.right.data);
		System.out.println(root.left.left.data);
		System.out.println(root.left.right.data);
		System.out.println(root.right.right.data);
	}

}
