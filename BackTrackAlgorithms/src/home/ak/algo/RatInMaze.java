/**
 * 
 */
package home.ak.algo;

import java.util.Arrays;

/**
 * @author user
 *
 */
public class RatInMaze {

	static int N;
	static int[][] arr;
	static int[][] solution;
	static boolean[][] visited;

	static int[] move_x = { -1, 1, 0, 0 };
	static int[] move_y = { 0, 0, -1, 1 };

	private static boolean isSafe(int x, int y) {
		return (x >= 0 && x < N && y >= 0 && y < N && !visited[x][y] && arr[x][y] == 1);
	}

	private static boolean findPath(int x, int y) {
		// Check if destination is reached
		if (x == N - 1 && y == N - 1) {
			solution[x][y] = 1;
			return true;
		}

		if (isSafe(x, y)) {
			visited[x][y] = true;
			solution[x][y] = 1;

			for (int i = 0; i < 4; i++) {
				if (findPath(x + move_x[i], y + move_y[i])) {
					return true;
				}
			}

			// Nothing gave solution
			// Backtrack
			solution[x][y] = 0;
			return false;
		}
		return false;
	}
	
	public static void solve(){
		if(findPath(0, 0)){
			System.out.println(Arrays.deepToString(solution));
		} else {
			System.out.println("NO PATH FOUND");
		}
	}
	
	public static void main(String[] args) {
		N = 5;
		int[][] maze = { { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 1 }, { 1, 0, 0, 1, 1 }, { 1, 0, 0, 1, 0 },
				{ 1, 1, 0, 1, 1 } };
		arr = maze;
		solution = new int[N][N];
		visited = new boolean[N][N];
		solve();
	}

}
