package home.ak.algo.tree;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author kundu
 * 
 *         Serialize a binary tree to a file and then deserialize it back to a
 *         tree so that the original and the deserialized trees are identical.
 *
 */
public class BTSerializeDeserialize {

	static class TreeNode {
		int data;
		TreeNode left, right;

		TreeNode(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	private static final int MARKER = Integer.MIN_VALUE;

	public static void serialize(TreeNode node, ObjectOutputStream stream) throws IOException {
		if (null == node) {
			stream.writeInt(MARKER);
			return;
		}

		stream.writeInt(node.data);
		serialize(node.left, stream);
		serialize(node.right, stream);

	}

	public static TreeNode deserialize(ObjectInputStream stream) throws IOException {
		// read the value from the stream
		int val = stream.readInt();
		if (val == MARKER) {
			return null;
		}
		// Create the node
		TreeNode node = new TreeNode(val);
		node.left = deserialize(stream);
		node.right = deserialize(stream);
		return node;
	}

	public static void printTreePreOrder(TreeNode root) {
		if (root == null)
			return;
		System.out.print(root.data + " ");
		printTreePreOrder(root.left);
		printTreePreOrder(root.right);
	}

	public static void main(String[] args) {
		try {
			TreeNode root = new TreeNode(100);
			root.left = new TreeNode(50);
			root.right = new TreeNode(200);
			root.left.left = new TreeNode(25);
			root.left.right = new TreeNode(75);
			root.right.right = new TreeNode(350);

			printTreePreOrder(root);

			ByteArrayOutputStream baostream = new ByteArrayOutputStream();
			ObjectOutputStream ostream = new ObjectOutputStream(baostream);
			serialize(root, ostream);
			ostream.close();

			ByteArrayInputStream baistream = new ByteArrayInputStream(baostream.toByteArray());
			ObjectInputStream istream = new ObjectInputStream(baistream);
			TreeNode deserializedRoot = deserialize(istream);

			System.out.println("\nResult");
			printTreePreOrder(deserializedRoot);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/*
	 * Runtime Complexity Linear, O(n).
	 * 
	 * Memory Complexity Logarithmic, O(logn).
	 * 
	 * Recursive solution has O(h) memory complexity as it will consume memory on
	 * the stack up to the height of the binary tree h. It will be O(logn) for a
	 * balanced tree and in the worst case can be O(n).
	 */
}
