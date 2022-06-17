/**
 * 
 */
package home.ak.algo.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author kundu
 *
 */
public class L01_BFSForDisconnectedGraph {

	public static void traverse(Graph graph) {
		int vertices = graph.getAdjacencyList().size();
		Map<Integer, List<Integer>> adjList = graph.getAdjacencyList();

		boolean[] visited = new boolean[vertices + 1]; // Since it's not 0 based vertices
		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1; i <= vertices; i++) {
			if (!visited[i]) {
				queue.add(i); // Add the 1st node
				visited[i] = true;
				while (!queue.isEmpty()) {
					int currVertex = queue.poll();
					System.out.println(currVertex);

					for (int x : adjList.get(currVertex)) {
						if (!visited[x]) {
							queue.add(x);
							visited[x] = true;
						}
					}
				} //End of while loop
			}
		}
	}
	
	public static void main(String[] args) {
		Graph graph = new Graph(7);
		
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(2, 7);
		graph.addEdge(3, 5);
		graph.addEdge(5, 7);
		graph.addEdge(4, 6);
		
		traverse(graph);
		
	}

}
