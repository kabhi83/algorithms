/**
 * 
 */
package home.ak.algo.graph;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author kundu
 * 
 *         There are n houses in a village. We want to supply water for all the
 *         houses by building wells and laying pipes.
 * 
 *         For each house i, we can either build a well inside it directly with
 *         cost wells[i], or pipe in water from another well to it. The costs to
 *         lay pipes between houses are given by the array pipes, where each
 *         pipes[i] = [house1, house2, cost] represents the cost to connect
 *         house1 and house2 together using a pipe. Connections are
 *         bidirectional.
 * 
 *         Find the minimum total cost to supply water to all houses.
 * 
 *         Example 1:
 * 
 *         Input: n = 3, wells = [1,2,2], pipes = [[1,2,1],[2,3,1]] Output: 3
 *         Explanation: The best strategy is to build a well in the first house
 *         with cost 1 and connect the other houses to it with cost 2 so the
 *         total cost is 3.
 * 
 *         Constraints:
 * 
 *         1 <= n <= 10000 wells.length == n 0 <= wells[i] <= 10^5 1 <=
 *         pipes.length <= 10000 1 <= pipes[i][0], pipes[i][1] <= n 0 <=
 *         pipes[i][2] <= 10^5 pipes[i][0] != pipes[i][1]
 *
 */
public class OptimizeWaterDistribution {

	static class DisjointSet {
		int[] root;
		int[] size;

		public DisjointSet(int n) {
			root = new int[n + 1];
			size = new int[n + 1];

			// Make set for all elements
			Arrays.fill(size, 1); // All sets are of size 1 initially
			// Make every node as the parent of itself
			for (int i = 1; i <= n; i++) {
				root[i] = i;
			}
		}

		public int find(int x) {
			if (root[x] != x) { // x is not the parent for itself
				root[x] = find(root[x]); // recursively find x's parent
			}
			return root[x];
		}

		public boolean union(int x, int y) {
			// Find the root of X and Y
			int rootX = find(x);
			int rootY = find(y);

			if (rootX == rootY) {
				return false; // Cannot connect as there will be cycle
			}
			// Union by rank
			if (size[rootX] < size[rootY]) {
				root[rootX] = rootY; // Make Y as the root for X
				size[rootY] += size[rootX];
			} else {
				root[rootY] = rootX;
				size[rootX] += size[rootY];
			}

			return true;
		}
	}

	/**
	 * This is a Shortest path problem/Minimum spanning tree problem. In this graph
	 * problem, view cities as nodes and pipe connects two cities as edges with the
	 * given cost. Here, wells costs, is a self connected edge. We can add extra
	 * node as root node 0, and connect all 0 and i with costs wells[i] so that we
	 * can have one graph/tree
	 */
	public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
		DisjointSet ds = new DisjointSet(n);

		// Initialize the priority Queue sorted by edge weight
		PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[2] - b[2]));

		// Start with populating the well
		for (int i = 0; i < wells.length; i++) {
			minHeap.offer(new int[] { 0, i + 1, wells[i] }); // New edge created from 0 to i
		}

		// Populate pipes
		for (int[] pipe : pipes) {
			minHeap.offer(pipe);
		}

		// compute the result
		int res = 0;
		while (!minHeap.isEmpty()) {
			int[] curr = minHeap.poll();
			if (ds.union(curr[0], curr[1])) {
				res += curr[2];
			}
		}

		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 3;
		int[] wells = { 1, 2, 2 };
		int[][] pipes = { { 1, 2, 1 }, { 2, 3, 1 } };
		int result = new OptimizeWaterDistribution().minCostToSupplyWater(n, wells, pipes);
		System.out.println(result);

	}

}
