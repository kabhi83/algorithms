/**
 * 
 */
package home.ak.algo.bt;

import home.ak.algo.bt.BinaryTree.Node;

/**
 * @author kundu
 *
 */
public class L16_BinaryTreeLowestCommonAncestor {

	public static Node lowestCommonAncestor(Node node, Node p, Node q) {

		// if the node is null or we find any of the matching node return node
		if (null == node || node == p || node == q) {
			return node;
		}

		Node left = lowestCommonAncestor(node.left, p, q);
		Node right = lowestCommonAncestor(node.right, p, q);

		// If either one is null, return the other
		// this will return null, if both the child nodes are null
		if (null == left) {
			return right;
		} else if (null == right) {
			return left;
		} else {
			// Both left and right nodes are not null; hence we return the result
			return node;
		}

	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		
		root.left.right.left = new Node(6);
		root.left.right.right = new Node(7);
		
		root.right.left = new Node(8);
		root.right.right = new Node(9);
		
		System.out.println(lowestCommonAncestor(root, root.left.left, root.left.right.right).data);
		
	}

}
