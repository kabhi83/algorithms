/**
 * 
 */
package home.ak.algo.graph;

import java.util.List;
import java.util.Map;

/**
 * @author kundu
 *
 */
public class L5_CycleInDirectedGraphUsingDFS {

	public static boolean isCyclicGraph(Graph graph) {
		Map<Integer, List<Integer>> adjList = graph.getAdjacencyList();
		int vertices = adjList.size();
		boolean[] visited = new boolean[vertices + 1];
		int[] dfsPath = new int[vertices + 1]; // Used the track the current path
		for (int i = 1; i <= vertices; i++) {
			if (!visited[i]) {
				if (isCyclic(adjList, i, visited, dfsPath)) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean isCyclic(Map<Integer, List<Integer>> adjList, int node, boolean[] visited, int[] dfsPath) {
		visited[node] = true;
		// Add the node to the current dfs path
		dfsPath[node] = 1;
		// Vertify adjacent nodes through DFS
		for (int adjNode : adjList.get(node)) {
			if (!visited[adjNode]) {
				if(isCyclic(adjList, adjNode, visited, dfsPath)) {
					return true;
				}
			} else if (dfsPath[adjNode] == 1) {
				return true; // Same node seen in the same dfs path
			}
		}
		// Backtrack from current dfs path
		dfsPath[node] = 0;
		return false;
	}
	
	public static void main(String[] args) {
		Graph graph = new Graph(9);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.addEdge(4, 5);
		graph.addEdge(3, 6);
		graph.addEdge(6, 5);
		graph.addEdge(7, 2);
		graph.addEdge(7, 8);
		graph.addEdge(8, 9);
		graph.addEdge(9, 7);
		
		System.out.println(isCyclicGraph(graph));
	}

}
