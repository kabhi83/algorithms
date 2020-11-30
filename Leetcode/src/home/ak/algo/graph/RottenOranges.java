/**
 * 
 */
package home.ak.algo.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author kundu
 * 
 *         In a given grid, each cell can have one of three values:
 * 
 *         the value 0 representing an empty cell;
 * 
 *         the value 1 representing a fresh orange;
 * 
 *         the value 2 representing a rotten orange.
 * 
 *         Every minute, any fresh orange that is adjacent (4-directionally) to
 *         a rotten orange becomes rotten.
 * 
 *         Return the minimum number of minutes that must elapse until no cell
 *         has a fresh orange. If this is impossible, return -1 instead.
 *
 */
public class RottenOranges {

	/**
	 * BFS solution to mark the fresh oranges adjacent to the rotten ones at every
	 * iteration
	 */
	public int orangesRotting(int[][] grid) {
		Queue<int[]> rotten = new LinkedList<>();
		int fresh = 0, time = 0;
		// Mark the rotten orange in the grid
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 2) {
					rotten.add(new int[] { i, j });
				} else if (grid[i][j] == 1) {
					fresh++;
				}
			}
		}

		while (!rotten.isEmpty()) {
			int size = rotten.size();
			for (int i = 0; i < size; i++) {
				int[] rottenIdx = rotten.poll();
				int x = rottenIdx[0];
				int y = rottenIdx[1];
				if (x > 0 && grid[x - 1][y] == 1) {
					grid[x - 1][y] = 2;
					rotten.add(new int[] { x - 1, y });
					fresh--;
				}
				if (y > 0 && grid[x][y - 1] == 1) {
					grid[x][y - 1] = 2;
					rotten.add(new int[] { x, y - 1 });
					fresh--;
				}
				if (x < grid.length - 1 && grid[x + 1][y] == 1) {
					grid[x + 1][y] = 2;
					rotten.add(new int[] { x + 1, y });
					fresh--;
				}
				if (y < grid[0].length - 1 && grid[x][y + 1] == 1) {
					grid[x][y + 1] = 2;
					rotten.add(new int[] { x, y + 1 });
					fresh--;
				}
			}
			if (!rotten.isEmpty()) {
				time++;
			}
		}

		return (fresh == 0) ? time : -1;
	}

	public static void main(String[] args) {
		int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
		int result = new RottenOranges().orangesRotting(grid);
		System.out.println(result);
	}
}
