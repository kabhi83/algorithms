/**
 * 
 */
package home.ak.algo.bt;

import java.util.LinkedList;
import java.util.Queue;

import home.ak.algo.bt.BinaryTree.Node;

/**
 * @author kundu
 * 
 *         Serialize and De-serialize a binary tree using level order traversal
 *
 */
public class L12_BinaryTreeSerializeDeserialize {

	public static String serialize(Node node) {
		if (null == node) {
			return null;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		StringBuilder builder = new StringBuilder();

		while (!queue.isEmpty()) {
			Node temp = queue.poll();
			if (null == temp) {
				builder.append("#" + " ");
				continue;
			}

			builder.append(temp.data + " ");

			// Process the children - always add left & right child, even if null
			queue.add(temp.left);
			queue.add(temp.right);
		}

		return builder.toString();
	}
	
	public static Node deserialize(String str) {
		if(null == str) {
			return null;
		}
		String[] strArr = str.split(" ");
		Node root = new Node(Integer.parseInt(strArr[0]));
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		for(int i = 1; i < strArr.length; i++) {
			Node parent = queue.poll();
			//Check for null or node
			if(!strArr[i].equals("#")) {
				parent.left = new Node(Integer.parseInt(strArr[i]));
				queue.add(parent.left);
			}
			if(!strArr[++i].equals("#")) {
				parent.right = new Node(Integer.parseInt(strArr[i]));
				queue.add(parent.right);
			}
		}
		return root;
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(13);
		root.right.left = new Node(4);
		root.right.right = new Node(5);

		String str = serialize(root);
		System.out.println();
		Node newRoot = deserialize(str);
		
		System.out.println(newRoot.data);
		System.out.println(newRoot.left.data);
		System.out.println(newRoot.right.data);
		System.out.println(newRoot.right.left.data);
		System.out.println(newRoot.right.right.data);
	}

}
