/**
 * 
 */
package home.ak.algo.dp;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author kundu
 * 
 *         Given a ‘N’ * ’M’ maze with obstacles, count and return the number of
 *         unique paths to reach the right-bottom cell from the top-left cell. A
 *         cell in the given maze has a value '-1' if it is a blockage or
 *         dead-end, else 0. From a given cell, we are allowed to move down and
 *         right i.e., (i+1, j) and (i, j+1) only.
 *
 */
public class L09_UniquePathsII {

	/**
	 * Top down approach
	 */
	static int mazeObstaclesTD(int m, int n, ArrayList<ArrayList<Integer>> mat) {
		int[][] dp = new int[m][n];
		for (int[] rows : dp) {
			Arrays.fill(rows, -1);
		}
		return mazeObstaclesTD(m, n, mat, dp);
	}

	private static int mazeObstaclesTD(int m, int n, ArrayList<ArrayList<Integer>> mat, int[][] dp) {
		if (m == 0 && n == 0) {
			return 1;
		}
		if (m < 0 || n < 0) {
			return 0;
		}
		if (m >= 0 && n >= 0 && mat.get(m).get(n) == -1) {
			return 0;
		}
		// check in the dp array
		if (dp[m][n] != -1) {
			return dp[m][n];
		}

		int up = mazeObstaclesTD(m - 1, n, mat, dp);
		int left = mazeObstaclesTD(m, n - 1, mat, dp);

		return dp[m][n] = up + left;
	}

	/**
	 * Bottom up approach
	 */
	static int mazeObstaclesBU(int m, int n, ArrayList<ArrayList<Integer>> mat) {
		int[][] dp = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (mat.get(m).get(n) == -1) {
					dp[i][j] = 0;
				}
				if (i == 0 && j == 0) {
					dp[i][j] = 1;
				} else {
					int down = 0, right = 0;
					if (i > 0) {
						down = dp[i - 1][j];
					}
					if (j > 0) {
						right = dp[i][j - 1];
					}
					dp[i][j] = down + right;
				}
			}
		}
		return dp[m - 1][n - 1];
	}

}
