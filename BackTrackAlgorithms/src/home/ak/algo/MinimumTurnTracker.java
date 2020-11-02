/**
 * 
 */
package home.ak.algo;

/**
 * Program to track the minimum turns required to reach the destination
 */
public class MinimumTurnTracker {

	static int minTurns = Integer.MAX_VALUE;
	static int[][] maze;
	static boolean[][] visited;
	static int[][] solution;
	static int M, N;

	static int[] move_x = { -1, 1, 0, 0 };
	static int[] move_y = { 0, 0, -1, 1 };

	private static boolean isSafe(int x, int y) {
		return (x >= 0 && x < M && y >= 0 && y < N && !visited[x][y] && maze[x][y] == 1);
	}

	public static void dfs(int x, int y, int px, int py, int gx, int gy, int turn) {
		if (x == M - 1 && y == N - 1) {
			// Reached the destination
			if (x != gx || y != gy) {
				turn = turn + 1;
			}
			if (minTurns > turn) {
				minTurns = turn;
				// Update solution matrix
				solution[x][y] = turn;
			}
			return;
		}

		// Pruning
		if (turn > minTurns) {
			return;
		}

		if (isSafe(x, y)) {
			visited[x][y] = true;
			solution[x][y] = turn;
			for (int i = 0; i < 4; i++) {
				if (x == gx || y == gy) {
					// No turn yet
					dfs(x + move_x[i], y + move_y[i], x, y, px, py, turn);
				} else {
					dfs(x + move_x[i], y + move_y[i], x, y, px, py, turn + 1);
				}
			}
			// Backtrack
			visited[x][y] = false;
		}
	}

	public static void main(String[] args) {
		int[][] arr = { { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 1 }, { 1, 0, 0, 1, 1 }, { 1, 0, 0, 1, 0 }, { 1, 1, 0, 1, 1 } };
		maze = arr;
		M = arr.length;
		N = arr[0].length;
		visited = new boolean[M][N];
		solution = new int[M][N];
		dfs(0, 0, -1, -1, -1, -1, 0);
		System.out.println(minTurns);
	}
}
