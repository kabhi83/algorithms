/**
 * 
 */
package home.ak.algo.graph.starter;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import home.ak.algo.graph.starter.WeightedGraph.Node;

/**
 * @author kundu
 * 
 *         Dijkstra's Shortest Path Algorithm
 *
 */
public class L6_ShortestPathUndirectedGraph {
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

		int[] distance = new int[vertices + 1]; // Index 1 based graph
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[source] = 0; // 0 distance for starting node

		PriorityQueue<NodeDistPair> pq = new PriorityQueue<>((a1, a2) -> (a1.dist - a2.dist)); // Min heap
		pq.add(new NodeDistPair(source, 0));

		while (!pq.isEmpty()) {
			NodeDistPair curr = pq.poll();

			for (Node adjNode : adjList.get(curr.node)) {
				if (distance[curr.node] + adjNode.weight < distance[adjNode.vertex]) {
					distance[adjNode.vertex] = distance[curr.node] + adjNode.weight;
					pq.add(new NodeDistPair(adjNode.vertex, distance[adjNode.vertex]));
				}
			}

		}

		for (int i = 0; i < vertices; i++) {
			System.out.print(distance[i + 1] + " ");
		}
	}
	
	public static void main(String[] args) {
		WeightedGraph graph = new WeightedGraph(5);
		
		graph.addUndirectedEdge(1, 2, 2);
		graph.addUndirectedEdge(1, 4, 1);
		graph.addUndirectedEdge(2, 3, 4);
		graph.addUndirectedEdge(4, 3, 3);
		graph.addUndirectedEdge(2, 5, 5);
		graph.addUndirectedEdge(3, 5, 1);
		
		findShortestPath(graph, 1);
	}

}
