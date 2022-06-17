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
public class L02_CycleInUndirectedGraphUsingBFS {

	static class Pair<K, V> {
		K key;
		V value;

		public Pair(K key, V value) {
			this.key = key;
			this.value = value;
		}

		public K getKey() {
			return key;
		}

		public V getValue() {
			return value;
		}
	}

	public static boolean isCyclicGraph(Graph graph) {

		// Vertices are lebelled from 1
		int vertices = graph.getAdjacencyList().size();
		Map<Integer, List<Integer>> adjList = graph.getAdjacencyList();
		boolean[] visited = new boolean[vertices + 1]; // 0th index is invalid

		Queue<Pair<Integer, Integer>> queue = new LinkedList<>();

		for (int i = 1; i <= vertices; i++) {

			if (!visited[i]) {
				queue.add(new Pair<Integer, Integer>(i, -1)); // Start index of all disconnected components
				visited[i] = true;
				while (!queue.isEmpty()) {
					Pair<Integer, Integer> tempPair = queue.poll();
					int currVertex = tempPair.getKey();
					int parentVertex = tempPair.getValue();

					for (int adjVertex : adjList.get(currVertex)) {
						if (!visited[adjVertex]) {
							queue.add(new Pair<Integer, Integer>(adjVertex, currVertex));
							visited[adjVertex] = true;
						} else if (adjVertex != parentVertex) {
							// Check if the adjacent vertex is same as the parent else return true
							// cycle detected
							return true;
						}
					}
				}
			}

		}
		return false;
	}

	public static void main(String[] args) {
		Graph graph = new Graph(11);

		graph.addUndirectedEdge(1, 2);
		graph.addUndirectedEdge(2, 4);
		graph.addUndirectedEdge(3, 5);
		graph.addUndirectedEdge(5, 6);
		graph.addUndirectedEdge(6, 7);
		graph.addUndirectedEdge(7, 8);
		graph.addUndirectedEdge(5, 10);
		graph.addUndirectedEdge(10, 9);
		//graph.addUndirectedEdge(9, 8);
		graph.addUndirectedEdge(8, 11);
		
		System.out.println(isCyclicGraph(graph));
	}

}
