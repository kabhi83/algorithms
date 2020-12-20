/**
 * 
 */
package home.ak.algo.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author kundu
 * 
 *         There are N network nodes, labeled 1 to N.
 * 
 *         Given times, a list of travel times as directed edges times[i] = (u,
 *         v, w), where u is the source node, v is the target node, and w is the
 *         time it takes for a signal to travel from source to target.
 * 
 *         Now, we send a signal from a certain node K. How long will it take
 *         for all nodes to receive the signal? If it is impossible, return -1.
 * 
 *         Example 1: Input: times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
 *         Output: 2
 *
 */
public class NetworkDelayTimeDijkstra {

	static class Node {
		int vertex;
		int weight;

		public Node(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
	}

	public int networkDelayTime(int[][] times, int N, int K) {
		// Initialize the adjacency list
		Map<Integer, List<Node>> adjList = new HashMap<>();
		for (int i = 1; i <= N; i++) {
			adjList.put(i, new ArrayList<Node>());
		}
		// Build the adjacency list
		for (int[] time : times) {
			adjList.get(time[0]).add(new Node(time[1], time[2]));
		}

		// Initialize the distance map to maintain distance from source
		Map<Integer, Integer> distMap = new HashMap<>();

		// Build the priority queue - sorted by the weight. Dijkstra is a greedy
		// algorithm which works by considering the edge with minimum weight
		PriorityQueue<Node> minHeap = new PriorityQueue<>((n1, n2) -> (n1.weight - n2.weight));
		// add the source to priority queue
		minHeap.offer(new Node(K, 0));
		int res = Integer.MIN_VALUE;
		while (!minHeap.isEmpty()) {
			// Poll and add to distance map
			Node current = minHeap.poll();
			int vertex = current.vertex;
			int distance = current.weight;

			if (distMap.containsKey(vertex)) {
				continue;
			}
			// Update the distance map
			distMap.put(vertex, distance);
			res = Math.max(res, distance);

			for (Node neighbor : adjList.get(vertex)) {
				minHeap.offer(new Node(neighbor.vertex, neighbor.weight + distance));
			}
		}

		return distMap.size() == N ? res : -1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] times = { { 2, 1, 1 }, { 2, 3, 1 }, { 3, 4, 1 } };
		int N = 4, K = 2;
		int result = new NetworkDelayTimeDijkstra().networkDelayTime(times, N, K);
		System.out.println(result);

	}

}
