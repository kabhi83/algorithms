/**
 * 
 */
package home.ak.algo.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * @author kundu
 *
 */
public class Graph {

	private Map<Integer, List<Integer>> adjList;

	public Graph() {
		adjList = new HashMap<>();
	}

	public Graph(int vertices) {
		adjList = new HashMap<>();
		for (int i = 0; i < vertices; i++) {
			addVertex(i + 1);
		}
	}

	public void addVertex(int vertex) {
		adjList.putIfAbsent(vertex, new ArrayList<>());
	}

	public void addEdge(int srcVertex, int destVertex) {
		adjList.get(srcVertex).add(destVertex);
	}

	public void addUndirectedEdge(int srcVertex, int destVertex) {
		adjList.get(srcVertex).add(destVertex);
		adjList.get(destVertex).add(srcVertex);
	}

	public Map<Integer, List<Integer>> getAdjacencyList() {
		return adjList;
	}

	private List<Integer> getAdjacentVertices(int vertex) {
		return adjList.get(vertex);
	}

	/**
	 * Depth First Search - without using recursive call stack
	 * 
	 * @param start
	 */
	public void dfs(int start) {
		Stack<Integer> stack = new Stack<>();
		Set<Integer> seenSet = new HashSet<>();

		stack.push(start);

		while (!stack.isEmpty()) {
			int current = stack.pop();
			if (!seenSet.contains(current)) {
				seenSet.add(current);
				System.out.print(" " + current);

				// Iterate over the children and add to stack if not seen
				for (int vertex : getAdjacentVertices(current)) {
					// Push only unseen vertices
					if (!seenSet.contains(vertex)) {
						stack.push(vertex);
					}
				}
			}
		}
	}

	/**
	 * DFS using recursive calls
	 * 
	 * @param start
	 */
	public void dfsRecursive(int start) {
		Set<Integer> seenSet = new HashSet<>();
		dfsRecursive(start, seenSet);
	}

	private void dfsRecursive(int current, Set<Integer> seenSet) {
		seenSet.add(current);
		System.out.print(" " + current);
		for (int vertex : getAdjacentVertices(current)) {
			if (!seenSet.contains(vertex)) {
				dfsRecursive(vertex, seenSet);
			}
		}
	}

	/**
	 * Breath First Search - Level Order Traversal
	 * 
	 * @param start
	 */
	public void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		Set<Integer> seenSet = new HashSet<>();

		queue.offer(start);
		while (!queue.isEmpty()) {
			int current = queue.poll();
			if (!seenSet.contains(current)) {
				seenSet.add(current);
				System.out.print(" " + current);

				for (int vertex : getAdjacentVertices(current)) {
					// Push only unseen adjacent nodes
					if (!seenSet.contains(vertex)) {
						queue.offer(vertex);
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Graph graph = new Graph();
		for (int i = 0; i < 8; i++) {
			graph.addVertex(i + 1);
		}

		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(1, 5);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.addEdge(4, 5);
		graph.addEdge(5, 6);
		graph.addEdge(2, 7);
		graph.addEdge(4, 8);
		graph.addEdge(6, 7);
		graph.addEdge(6, 8);

		graph.dfs(1);
		System.out.println("");
		graph.dfsRecursive(1);
		;
		System.out.println("");
		graph.bfs(1);

	}

}
