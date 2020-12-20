/**
 * 
 */
package home.ak.algo.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author kundu
 * 
 *         There are N network nodes, labelled 1 to N.
 * 
 *         Given times, a list of travel times as directed edges times[i] = (u,
 *         v, w), where u is the source node, v is the target node, and w is the
 *         time it takes for a signal to travel from source to target.
 * 
 *         Now, we send a signal from a certain node K. How long will it take
 *         for all nodes to receive the signal? If it is impossible, return -1.
 * 
 *         Input: times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2 Output: 2
 *
 */
public class NetworkDelayTimeBFS {

	static class AdjNode {
		int vertex;
		int weight;

		public AdjNode(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
	}

	static class QNode {
		int vertex;
		int dist;

		public QNode(int vertex, int dist) {
			this.vertex = vertex;
			this.dist = dist;
		}
	}

	public int networkDelayTime(int[][] times, int N, int K) {
		// Initialize the adjacency list
		Map<Integer, List<AdjNode>> adjList = new HashMap<>();
		for(int i = 1; i <= N; i++) {
			adjList.put(i, new ArrayList<AdjNode>());
		}
		// Build the adjacency list
		for (int[] time : times) {
			adjList.get(time[0]).add(new AdjNode(time[1], time[2]));
		}

		int[] dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[K] = 0;
		dist[0] = 0; // Invalid index

		// Start the BFS
		Queue<QNode> queue = new LinkedList<>();
		queue.add(new QNode(K, 0)); // Add the source Node
		while (!queue.isEmpty()) {
			QNode current = queue.poll();
			int currDist = current.dist;
			for (AdjNode neighbor : adjList.get(current.vertex)) {
				queue.offer(new QNode(neighbor.vertex, neighbor.weight + currDist));
				dist[neighbor.vertex] = Math.min(dist[neighbor.vertex], neighbor.weight + currDist);
			}
		}

		// Check the max value
		int max = Arrays.stream(dist).max().getAsInt();
		return max == Integer.MAX_VALUE ? -1 : max;
	}

	public static void main(String[] args) {
		int[][] times = { { 2, 1, 1 }, { 2, 3, 1 }, { 3, 4, 1 } };
		int N = 4, K = 2;
		int result = new NetworkDelayTimeBFS().networkDelayTime(times, N, K);
		System.out.println(result);
	}

}
