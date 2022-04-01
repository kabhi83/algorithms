/**
 * 
 */
package home.ak.algo.graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import home.ak.algo.graph.WeightedGraph.Node;

/**
 * @author kundu
 *
 */
public class L6_ShortestPathDAGUsingTopoSort {

	static class NodeDistPair {
		int node;
		int dist;

		public NodeDistPair(int node, int dist) {
			this.node = node;
			this.dist = dist;
		}
	}

	public static void findShortestPath(WeightedGraph graph, int source) {
		Map<Integer, List<Node>> adjList = graph.getAdjacencyList();
		int vertices = adjList.size();

		Set<Integer> visited = new HashSet<>();
		Stack<Integer> stack = new Stack<>();

		// Topological Sort
		for (int i = 1; i <= vertices; i++) {
			if (!visited.contains(i)) {
				topoSortdfs(i, adjList, visited, stack);
			}
		}

		// Compute Shortest Path
		// Initialize distance array
		int[] dist = new int[vertices + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		// Mark the source distance as 0
		dist[source] = 0;

		while (!stack.isEmpty()) {
			int vertex = stack.pop();
			if (dist[vertex] != Integer.MAX_VALUE) {
				//Check for all the adjacent vertices reachable from the vertex node
				for (Node adjVertex : adjList.get(vertex)) {
					if (dist[vertex] + adjVertex.weight < dist[adjVertex.vertex]) {
						dist[adjVertex.vertex] = dist[vertex] + adjVertex.weight;
					}
				}
			}
		}
		
		//Print distances from source
		for(int i = 1; i <= vertices; i++) {
			if(dist[i] == Integer.MAX_VALUE)
				System.out.print("INF" + " "); //Unreachable Node
			else {
				System.out.print(dist[i] + " ");
			}
		}
	}

	private static void topoSortdfs(int vertex, Map<Integer, List<Node>> adjList, Set<Integer> visited,
			Stack<Integer> stack) {
		// add the vertex as visited
		visited.add(vertex);
		// For every vertex iterate thorough all the adjacent vertices
		for (Node adjVertex : adjList.get(vertex)) {
			if (!visited.contains(adjVertex.vertex)) {
				topoSortdfs(adjVertex.vertex, adjList, visited, stack);
			}
		}
		stack.add(vertex);
	}
	
	public static void main(String[] args) {
		WeightedGraph graph = new WeightedGraph(6);
		graph.addDirectedEdge(1, 2, 2);
		graph.addDirectedEdge(2, 3, 3);
		graph.addDirectedEdge(3, 4, 6);
		graph.addDirectedEdge(1, 5, 1);
		graph.addDirectedEdge(5, 3, 2);
		graph.addDirectedEdge(5, 6, 4);
		graph.addDirectedEdge(6, 4, 1);
		
		findShortestPath(graph, 1);
	}

}
