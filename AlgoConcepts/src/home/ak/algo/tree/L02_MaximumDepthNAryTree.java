/**
 * 
 */
package home.ak.algo.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author kundu
 * 
 *         Given a n-ary tree, find its maximum depth.
 * 
 *         The maximum depth is the number of nodes along the longest path from
 *         the root node down to the farthest leaf node.
 * 
 *         Nary-Tree input serialization is represented in their level order
 *         traversal, each group of children is separated by the null value (See
 *         examples).
 *
 */
public class L02_MaximumDepthNAryTree {

	static class Node {
		public int val;
		public List<Node> children;

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, List<Node> _children) {
			val = _val;
			children = _children;
		}
	}

	public int maxDepth(Node root) {
		if(null == root) {
			return 0;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		int depth = 0;
		while(!queue.isEmpty()) {
			int levelSize = queue.size();
			for(int i = 0; i < levelSize; i++) {
				Node current = queue.poll();
				for(Node child: current.children) {
					queue.offer(child);
				}
			}
			depth++;
		}
		return depth;
	}

}
