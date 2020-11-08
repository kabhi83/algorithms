/**
 * 
 */
package home.ak.algo.graph;

import java.util.Arrays;

/**
 * @author kundu
 * 
 *         You are given a m x n 2D grid initialized with these three possible
 *         values.
 * 
 *         1. -1 - A wall or an obstacle.
 * 
 *         2. 0 - A gate.
 * 
 *         3. INF - Infinity means an empty room.
 * 
 *         We use the value 231 - 1 = 2147483647 to represent INF as you may
 *         assume that the distance to a gate is less than 2147483647. Fill each
 *         empty room with the distance to its nearest gate. If it is impossible
 *         to reach a gate, it should be filled with INF.
 *
 */
public class WallsAndGates {

	public void wallsAndGates(int[][] rooms) {

		int m = rooms.length;
		int n = rooms[0].length;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				// If we encounter a gate, compute the distance of all the rooms from the gate
				if (rooms[i][j] == 0) {
					dfs(i, j, 0, rooms, m, n);
				}
			}
		}
	}

	private void dfs(int i, int j, int distance, int[][] rooms, int m, int n) {
		// Boundary check
		if (i < 0 || i >= m || j < 0 || j >= n) {
			return;
		}

		// Pruning - if distance greater than previous distance - ignore
		if (rooms[i][j] < distance) {
			return;
		}

		// If wall return - Implicit with the rooms[i][j] < distance check
		if (rooms[i][j] == -1) {
			return;
		}

		// Note: No need to of the visited array as the distance value will prune the
		// result

		// Set the value of distance
		rooms[i][j] = distance;

		// dfs for all 4 directions
		dfs(i - 1, j, distance + 1, rooms, m, n);
		dfs(i + 1, j, distance + 1, rooms, m, n);
		dfs(i, j - 1, distance + 1, rooms, m, n);
		dfs(i, j + 1, distance + 1, rooms, m, n);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] rooms = { { Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE },
				{ Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1 },
				{ Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1 }, { 0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE } };

		new WallsAndGates().wallsAndGates(rooms);
		System.out.println(Arrays.deepToString(rooms));

	}

}
