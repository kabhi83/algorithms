/**
 * 
 */
package home.ak.algo.topologicalsort;

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
 *         Topological Sort of a directed graph (a graph with unidirectional
 *         edges) is a linear ordering of its vertices such that for every
 *         directed edge (U, V) from vertex U to vertex V, U comes before V in
 *         the ordering.
 * 
 *         Given a directed graph, find the topological ordering of its
 *         vertices.
 * 
 *         Example: Input: Vertices=4, Edges=[3, 2], [3, 0], [2, 0], [2, 1]
 *         Output: Following are the two valid topological sorts for the given
 *         graph:
 * 
 *         1) 3, 2, 0, 1
 * 
 *         2) 3, 2, 1, 0
 */
public class TopologicalSort {

	/**
	 * Using DFS we pick a random vertex as source and do depth first search (dfs)
	 * and mark the source as visited. For each vertex we visit, we consider each
	 * children of the vertex and do the dfs again. When all the children are
	 * exhausted, we put the vertex in the stack and return the stack.
	 */
	public static List<Integer> sortByDFS(int vertices, int[][] edges) {
		LinkedList<Integer> sortedOrder = new LinkedList<>();

		// Prepare the adjacency list
		Map<Integer, List<Integer>> adjList = new HashMap<>();
		for (int i = 0; i < vertices; i++) {
			adjList.put(i, new ArrayList<Integer>());
		}

		// Build the graph
		for (int i = 0; i < edges.length; i++) {
			int parent = edges[i][0], child = edges[i][1];
			adjList.get(parent).add(child);
		}
		Set<Integer> visited = new HashSet<>();
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < vertices; i++) {
			if (!visited.contains(i)) {
				dfs(i, adjList, visited, stack);
			}
		}
		while (!stack.isEmpty())
			sortedOrder.add(stack.pop());
		return sortedOrder;
	}

	private static void dfs(int vertex, Map<Integer, List<Integer>> adjList, Set<Integer> visited,
			Stack<Integer> stack) {
		// add the vertex as visited
		visited.add(vertex);
		// For every vertex iterate thorough all the child vertices
		for (int childVertex : adjList.get(vertex)) {
			if (!visited.contains(childVertex)) {
				dfs(childVertex, adjList, visited, stack);
			}
		}
		stack.add(vertex);
	}

	/**
	 * To find the topological sort of a graph we can traverse the graph in a
	 * Breadth First Search (BFS) way. We will start with all the sources, and in a
	 * stepwise fashion, save all sources to a sorted list. We will then remove all
	 * sources and their edges from the graph. After the removal of the edges, we
	 * will have new sources, so we will repeat the above process until all vertices
	 * are visited.
	 */
	public static List<Integer> sortByBFS(int vertices, int[][] edges) {
		List<Integer> sortedOrder = new ArrayList<>();

		// a. Initialize the graph
		Map<Integer, List<Integer>> adjlist = new HashMap<>();
		Map<Integer, Integer> inDegree = new HashMap<>();
		for (int i = 0; i < vertices; i++) {
			adjlist.put(i, new ArrayList<Integer>());
			inDegree.put(i, 0);
		}

		// b. Build the graph
		for (int i = 0; i < vertices; i++) {
			int parent = edges[i][0], child = edges[i][1];
			adjlist.get(parent).add(child);
			// Add/increment the in-degree for the child nodes
			inDegree.put(child, inDegree.get(child) + 1);
		}

		// c. Get all the sources i.e., vertices with 0 in-degree
		Queue<Integer> sources = new LinkedList<>();
		for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
			if (entry.getValue() == 0) {
				sources.add(entry.getKey());
			}
		}

		// d. For each source, add it to the sortedOrder and subtract one from all of
		// its children's in-degrees if a child's in-degree becomes zero, add it to the
		// sources queue (as this become a new source)
		while (!sources.isEmpty()) {
			int vertex = sources.poll();
			sortedOrder.add(vertex);
			List<Integer> children = adjlist.get(vertex);
			for (Integer child : children) {
				inDegree.put(child, inDegree.get(child) - 1);
				if (inDegree.get(child) == 0)
					sources.add(child);
			}
		}
		return sortedOrder.size() == vertices ? sortedOrder : new ArrayList<Integer>();
		// for sortedOrder.size() != vertices -> topological sort is not possible as the
		// graph has a cycle
	}

	public static void main(String[] args) {
		List<Integer> result = TopologicalSort.sortByDFS(4,
				new int[][] { new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } });
		System.out.println(result);

		result = TopologicalSort.sortByDFS(5, new int[][] { new int[] { 4, 2 }, new int[] { 4, 3 }, new int[] { 2, 0 },
				new int[] { 2, 1 }, new int[] { 3, 1 } });
		System.out.println(result);

		result = TopologicalSort.sortByDFS(7, new int[][] { new int[] { 6, 4 }, new int[] { 6, 2 }, new int[] { 5, 3 },
				new int[] { 5, 4 }, new int[] { 3, 0 }, new int[] { 3, 1 }, new int[] { 3, 2 }, new int[] { 4, 1 } });
		System.out.println(result);

		result = TopologicalSort.sortByBFS(4,
				new int[][] { new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } });
		System.out.println(result);

		result = TopologicalSort.sortByBFS(5, new int[][] { new int[] { 4, 2 }, new int[] { 4, 3 }, new int[] { 2, 0 },
				new int[] { 2, 1 }, new int[] { 3, 1 } });
		System.out.println(result);

		result = TopologicalSort.sortByBFS(7, new int[][] { new int[] { 6, 4 }, new int[] { 6, 2 }, new int[] { 5, 3 },
				new int[] { 5, 4 }, new int[] { 3, 0 }, new int[] { 3, 1 }, new int[] { 3, 2 }, new int[] { 4, 1 } });
		System.out.println(result);
	}
}
