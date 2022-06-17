/**
 * 
 */
package home.ak.algo.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author kundu
 * 
 *         Bipartite graphs are graphs whose vertices can be colored using two
 *         colors in such a way that vertices of the same color are never
 *         adjacent along an edge.
 * 
 *         BFS Time Complexity: O(V+E)
 * 
 *         Space Complexity: Adjacency List -> O(V+E) + Queue -> O(V) + Color
 *         O(V)
 *
 */
public class L03_BipartiteGraphUsingBFS {

	/**
	 * This method is executed on a single undirected graph
	 */
	public static boolean isBipartite(Graph graph) {
		Map<Integer, List<Integer>> adjList = graph.getAdjacencyList();
		int vertices = adjList.size();
		int[] color = new int[vertices + 1]; // Since 1 index graph
		Arrays.fill(color, -1);

		for (int i = 1; i <= vertices; i++) {
			if (color[i] == -1) {
				if (!bfs(adjList, i, color)) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Breadth first search with color matrix working as the visited matrix
	 */
	private static boolean bfs(Map<Integer, List<Integer>> adjList, int start, int[] color) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		color[start] = 1;
		while (!queue.isEmpty()) {
			int curr = queue.poll();

			// Chcek for adjacent vertices
			for (int adjVer : adjList.get(curr)) {
				if (color[adjVer] == -1) {
					// Unvisited node
					color[adjVer] = 1 - color[curr];
					queue.add(adjVer);
				} else if (color[adjVer] == color[curr]) {
					// Adjacent node is having same color as current
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Graph graph = new Graph(8);
		graph.addUndirectedEdge(1, 2);
		graph.addUndirectedEdge(2, 3);
		graph.addUndirectedEdge(2, 8);
		graph.addUndirectedEdge(3, 4);
		graph.addUndirectedEdge(8, 5);
		graph.addUndirectedEdge(4, 5);
		graph.addUndirectedEdge(5, 6);
		graph.addUndirectedEdge(6, 7);
		graph.addUndirectedEdge(5, 6);

		System.out.println(isBipartite(graph));
	}
}
