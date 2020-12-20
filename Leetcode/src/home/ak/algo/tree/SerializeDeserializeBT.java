/**
 * 
 */
package home.ak.algo.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author kundu
 *
 */
public class SerializeDeserializeBT {

	private static final String NULL_MARKER = "X";
	private static final String DELIMITER = ",";

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if (null == root) {
			return NULL_MARKER + DELIMITER;
		}
		String leftSerialized = serialize(root.left);
		String rightSerialized = serialize(root.right);
		return root.val + DELIMITER + leftSerialized + rightSerialized;
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		Queue<String> nodesToDeserialize = new LinkedList<>();
		nodesToDeserialize.addAll(Arrays.asList(data.split(DELIMITER)));
		return deserializeHelper(nodesToDeserialize);
	}

	private TreeNode deserializeHelper(Queue<String> nodesToDeserialize) {
		String curr = nodesToDeserialize.poll();
		if (curr.equals(NULL_MARKER)) {
			return null;
		}
		TreeNode node = new TreeNode(Integer.valueOf(curr));
		node.left = deserializeHelper(nodesToDeserialize);
		node.right = deserializeHelper(nodesToDeserialize);
		return node;
	}

	public void printInOrder(TreeNode node) {
		if (null == node) {
			return;
		}
		printInOrder(node.left);
		System.out.print(node.val + " ");
		printInOrder(node.right);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(5);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(2);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(8);
		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(4);

		new SerializeDeserializeBT().printInOrder(root);

		String serializedTree = new SerializeDeserializeBT().serialize(root);

		TreeNode newRoot = new SerializeDeserializeBT().deserialize(serializedTree);

		System.out.println("\nPost Deserialization");
		new SerializeDeserializeBT().printInOrder(newRoot);
	}
}
