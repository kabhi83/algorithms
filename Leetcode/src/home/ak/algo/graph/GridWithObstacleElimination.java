/**
 * 
 */
package home.ak.algo.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author kundu
 * 
 *         Given a m * n grid, where each cell is either 0 (empty) or 1
 *         (obstacle). In one step, you can move up, down, left or right from
 *         and to an empty cell.
 * 
 *         Return the minimum number of steps to walk from the upper left corner
 *         (0, 0) to the lower right corner (m-1, n-1) given that you can
 *         eliminate at most k obstacles. If it is not possible to find such
 *         walk return -1.
 * 
 *         Example 1:Input: grid = [[0,0,0], [1,1,0], [0,0,0], [0,1,1],
 *         [0,0,0]], k = 1 Output: 6. Explanation: The shortest path without
 *         eliminating any obstacle is 10. The shortest path with one obstacle
 *         elimination at position (3,2) is 6. Such path is (0,0) -> (0,1) ->
 *         (0,2) -> (1,2) -> (2,2) -> (3,2) -> (4,2).
 *
 */
public class GridWithObstacleElimination {

	static class Entry {
		int x;
		int y;
		int step;
		int obs;

		public Entry(int x, int y, int step, int obs) {
			this.x = x;
			this.y = y;
			this.step = step;
			this.obs = obs;
		}
	}

	/**
	 * Dijkstra's Algorithm of shortest path
	 */
	public static int shortestPath(int[][] grid, int k) {
		int m = grid.length, n = grid[0].length;
		// Cost matrix
		int[][] cost = new int[grid.length][grid[0].length];
		int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

		// Initialize the cost matrix to maximum value
		for (int[] c : cost) {
			Arrays.fill(c, Integer.MAX_VALUE);
		}

		PriorityQueue<Entry> queue = new PriorityQueue<>((a, b) -> a.step - b.step);
		// Add the 1st entry
		queue.offer(new Entry(0, 0, 0, 0));
		while (!queue.isEmpty()) {
			Entry curr = queue.poll();
			// End check
			if (curr.x == m - 1 && curr.y == n - 1) {
				return curr.step;
			}
			for (int[] dir : dirs) {
				int x = curr.x + dir[0];
				int y = curr.y + dir[1];
				if (x >= 0 && x < m && y >= 0 && y < n && curr.obs + grid[x][y] < cost[x][y]
						&& curr.obs + grid[x][y] <= k) {
					queue.offer(new Entry(x, y, curr.step + 1, curr.obs + grid[x][y]));
					cost[x][y] = curr.obs + grid[x][y];
				}
			}

		}
		return -1;
	}

	/**
	 * BFS solution without the visited array as we can reach a cell faster by
	 * removing an obstacle
	 */
	public static int shortestPathBFS(int[][] grid, int k) {
		int m = grid.length, n = grid[0].length;
		int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		int[][] obstacles = new int[m][n];
		for (int[] c : obstacles) {
			Arrays.fill(c, Integer.MAX_VALUE);
		}

		int step = 0;
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { 0, 0, 0 });
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[] curr = queue.poll();
				int row = curr[0], col = curr[1];
				if (row == m - 1 && col == n - 1) {
					return step;
				}
				for (int[] dir : dirs) {
					int x = row + dir[0];
					int y = col + dir[1];
					if (x >= 0 && x < m && y >= 0 && y < n) {
						int obs = curr[2] + grid[x][y];
						if (obs >= obstacles[x][y] || obs > k) {
							continue;
						}
						obstacles[x][y] = obs;
						queue.offer(new int[] { x, y, obs });
					}
				}
			}
			step++;
		}
		return -1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] grid = { { 0, 0, 0 }, { 1, 1, 0 }, { 0, 0, 0 }, { 0, 1, 1 }, { 0, 0, 0 } };
		int k = 1;
		System.out.println(shortestPath(grid, k));
		System.out.println(shortestPathBFS(grid, k));
	}

}
