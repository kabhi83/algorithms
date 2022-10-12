/**
 * 
 */
package home.ak.algo.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author kundu
 *
 */
public class L03_LevelOrderTraversal {

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

	static List<List<Integer>> levelOrderTraversal(Node root) {
		if(null == root) {
			return null;
		}
		List<List<Integer>> result = new ArrayList<>();

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			int levelSize = queue.size();
			List<Integer> currentLevel = new ArrayList<>();
			for(int i = 0; i < levelSize; i++) {
				Node curr = queue.poll();
				currentLevel.add(curr.val);
				for(Node child: curr.children) {
					queue.offer(child);
				}
			}
			result.add(currentLevel);
		}

		return result;
	}
	public static void main(String[] args) {
		Node root = new Node(1, new ArrayList<Node>());
		Node rootChild_1 = new Node(2, new ArrayList<Node>());
		Node rootChild_2 = new Node(3, new ArrayList<Node>());
		Node rootChild_3 = new Node(4, new ArrayList<Node>());
		root.children.add(rootChild_1);
		root.children.add(rootChild_2);
		root.children.add(rootChild_3);
		
		Node nodeChild2_1= new Node(5, new ArrayList<Node>());
		Node nodeChild2_2= new Node(6, new ArrayList<Node>());
		rootChild_2.children.add(nodeChild2_1);
		rootChild_2.children.add(nodeChild2_2);
		
		System.out.println(levelOrderTraversal(root));
	}

}
