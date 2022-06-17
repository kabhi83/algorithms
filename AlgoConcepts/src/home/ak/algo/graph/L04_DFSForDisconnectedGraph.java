/**
 * 
 */
package home.ak.algo.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @author kundu
 *
 */
public class L04_DFSForDisconnectedGraph {

	public static void traverse(Graph graph) {
		Map<Integer, List<Integer>> adjList = graph.getAdjacencyList();
		int vertices = adjList.size();
		boolean[] visited = new boolean[vertices + 1];

		// Initialize stack
		Stack<Integer> stack = new Stack<>();
		for (int i = 1; i <= vertices; i++) {
			if (!visited[i]) {
				stack.add(i);
				visited[i] = true;
				while (!stack.isEmpty()) {
					int curr = stack.pop();
					System.out.print(curr + " ");
					for (int adjVer : adjList.get(curr)) {
						if (!visited[adjVer]) {
							stack.add(adjVer);
							visited[adjVer] = true;
						}
					}
				}
			}
		}
		System.out.println();
	}

	/**
	 * Recursive Depth First Search
	 */
	public static void traverseRecursive(Graph graph) {
		Map<Integer, List<Integer>> adjList = graph.getAdjacencyList();
		int vertices = adjList.size();
		List<Integer> path = new ArrayList<>();
		boolean[] visited = new boolean[vertices + 1];
		for (int i = 1; i <= vertices; i++) {
			if (!visited[i]) {
				dfs(i, adjList, visited, path);
			}
		}
		System.out.println(path);
	}

	private static void dfs(int curr, Map<Integer, List<Integer>> adjList, boolean[] visited, List<Integer> path) {
		path.add(curr);
		visited[curr] = true;
		for (int adjVer : adjList.get(curr)) {
			if (!visited[adjVer]) {
				dfs(adjVer, adjList, visited, path);
			}
		}
	}
	
	public static void main(String[] args) {
		Graph graph = new Graph(7);
		graph.addUndirectedEdge(1, 2);
		graph.addUndirectedEdge(2, 4);
		graph.addUndirectedEdge(2, 7);
		graph.addUndirectedEdge(4, 6);
		graph.addUndirectedEdge(6, 7);
		graph.addUndirectedEdge(3, 5);
		
		traverse(graph);
		
		traverseRecursive(graph);
	}

}
