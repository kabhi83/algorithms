/**
 * 
 */
package home.ak.algo.bt;

import java.util.Arrays;
import java.util.Stack;

import home.ak.algo.bt.BinaryTree.Node;

/**
 * @author kundu
 *
 */
public class L05_BinaryTreeRightView {

	public static Stack<Integer> getRightView(Node node) {
		if (null == node) {
			return null;
		}
		Stack<Integer> stack = new Stack<>();
		traverse(node, stack, 0);
		return stack;
	}

	private static void traverse(Node node, Stack<Integer> stack, int level) {
		if (null == node) {
			return;
		}
		// Push value to stack only when the count of items in the stack is same as the
		// level value
		if (level == stack.size()) {
			stack.push(node.data);
		}
		//Inverse pre-order traversal
		traverse(node.right, stack, level + 1);
		traverse(node.left, stack, level + 1);
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.add(8);
		tree.add(3);
		tree.add(6);
		tree.add(10);
		tree.add(4);
		tree.add(7);
		tree.add(1);
		tree.add(14);
		//tree.add(13);
		
		System.out.println(Arrays.asList(getRightView(tree.root).toArray()));
	}

}
