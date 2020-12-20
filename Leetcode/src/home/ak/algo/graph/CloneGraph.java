/**
 * 
 */
package home.ak.algo.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author kundu
 *
 *         Given a reference of a node in a connected undirected graph, return a
 *         deep copy (clone) of the graph.
 * 
 *         Each node in the graph contains a val (int) and a list (List[Node])
 *         of its neighbors.
 * 
 *         class Node { public int val; public List<Node> neighbors; }
 * 
 * 
 *         Test case format:
 * 
 *         For simplicity sake, each node's value is the same as the node's
 *         index (1-indexed). For example, the first node with val = 1, the
 *         second node with val = 2, and so on. The graph is represented in the
 *         test case using an adjacency list.
 * 
 *         Adjacency list is a collection of unordered lists used to represent a
 *         finite graph. Each list describes the set of neighbors of a node in
 *         the graph.
 * 
 *         The given node will always be the first node with val = 1. You must
 *         return the copy of the given node as a reference to the cloned graph.
 */
public class CloneGraph {

	static class Node {
		public int val;
		public List<Node> neighbors;

		public Node() {
			val = 0;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val) {
			val = _val;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val, ArrayList<Node> _neighbors) {
			val = _val;
			neighbors = _neighbors;
		}
	}

	public Node cloneGraph(Node node) {
		if (null == node) {
			return null;
		}
		// Create a map of the node val to the copy node
		Map<Integer, Node> cloneMap = new HashMap<>();
		// Solve the problem using DFS -iterating thru all the neighbors
		return cloneGraph(node, cloneMap);
	}
	
	private Node cloneGraph(Node node, Map<Integer, Node> map) {
		if(map.containsKey(node.val)) {
			//do nothing - return the cloned copy
			return map.get(node.val);
		}
		//Map don't contain the node
		//add
		Node clone = new Node(node.val);
		map.put(node.val, clone);
		//Iterate for neighbors
		for(Node neighbor: node.neighbors) {
			//Add to the neighbor of the cloned node
			clone.neighbors.add(cloneGraph(neighbor, map));
		}
		return clone;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
