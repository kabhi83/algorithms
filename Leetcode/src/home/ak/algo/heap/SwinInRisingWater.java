/**
 * 
 */
package home.ak.algo.heap;

import java.util.PriorityQueue;

/**
 * @author kundu
 * 
 *         On an N x N grid, each square grid[i][j] represents the elevation at
 *         that point (i,j).
 * 
 *         Now rain starts to fall. At time t, the depth of the water at i,j is
 *         max(t, grid[i][j]) is t. You can swim from a square to another
 *         4-directionally adjacent square if and only if the elevation of both
 *         squares individually are at most t. You can swim infinite distance in
 *         zero time. Of course, you must stay within the boundaries of the grid
 *         during your swim.
 * 
 *         You start at the top left square (0, 0). What is the least time until
 *         you can reach the bottom right square (N-1, N-1)?
 *
 */
public class SwinInRisingWater {

	/**
	 * We will be considering only the cell with the lowest value to swim into
	 */
	public int swimInWater(int[][] grid) {
		int N = grid.length;
		// All possible directions
		int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

		// Initialize Min heap
		PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
		boolean[][] visited = new boolean[N][N]; // Mark all the visited node

		// Add the start node to the heap
		queue.offer(new int[] { 0, 0, grid[0][0] });
		visited[0][0] = true;
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			// Check for all directions
			for (int[] dir : dirs) {
				int x = curr[0] + dir[0];
				int y = curr[1] + dir[1];

				if (x >= 0 & x < N && y >= 0 && y < N && !visited[x][y]) {
					visited[x][y] = true;
					int t = Math.max(curr[2], grid[x][y]);
					if (x == N - 1 && y == N - 1)
						return t;
					queue.offer(new int[] { x, y, t });
				}
			}
		}
		return 0;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] grid = { { 0, 1, 2, 3, 4 }, { 24, 23, 22, 21, 5 }, { 12, 13, 14, 15, 16 }, { 11, 17, 18, 19, 20 },
				{ 10, 9, 8, 7, 6 } };
		System.out.println(new SwinInRisingWater().swimInWater(grid));
	}

}
