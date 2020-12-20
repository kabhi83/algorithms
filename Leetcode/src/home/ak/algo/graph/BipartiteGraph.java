/**
 * 
 */
package home.ak.algo.graph;

/**
 * @author kundu
 * 
 *         Given an undirected graph, return true if and only if it is
 *         bipartite.
 * 
 *         Recall that a graph is bipartite if we can split its set of nodes
 *         into two independent subsets A and B, such that every edge in the
 *         graph has one node in A and another node in B.
 * 
 *         The graph is given in the following form: graph[i] is a list of
 *         indexes j for which the edge between nodes i and j exists. Each node
 *         is an integer between 0 and graph.length - 1. There are no self edges
 *         or parallel edges: graph[i] does not contain i, and it doesn't
 *         contain any element twice.
 * 
 *         Input: graph = [[1,3],[0,2],[1,3],[0,2]] Output: true Explanation: We
 *         can divide the vertices into two groups: {0, 2} and {1, 3}.
 *
 */
public class BipartiteGraph {

	/**
	 * Solution to the problem is the graph coloring alogorithm
	 */
	public boolean isBipartite(int[][] graph) {
		int nodes = graph.length;
		// Try to color the graph with 2 colors - red (1) and blue (-1)
		int[] colors = new int[nodes]; // Array to maintain the node colors

		for (int i = 0; i < nodes; i++) {
			//Try to start with red color
			if (colors[i] == 0 && !dfs(i, graph, 1, colors)) {
				return false;
			}
		}
		return true;
	}

	private boolean dfs(int node, int[][] graph, int color, int[] colors) {
		if (colors[node] != 0) {
			// Validate if the assigned color matches the attempted color
			return colors[node] == color;
		} else {
			colors[node] = color;
			// Validate the neighbours
			for (int neighbour : graph[node]) {
				if(!dfs(neighbour, graph, -color, colors)) {
					return false;
				}
			}
		}

		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] graph = { { 1, 3 }, { 0, 2 }, { 1, 3 }, { 0, 2 } };
		boolean result = new BipartiteGraph().isBipartite(graph);
		System.out.println(result);
	}

}
