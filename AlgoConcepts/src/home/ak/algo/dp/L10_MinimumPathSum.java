/**
 * 
 */
package home.ak.algo.dp;

import java.util.Arrays;

/**
 * @author kundu
 * 
 *         Ninjaland is a country in the shape of a 2-Dimensional grid 'GRID',
 *         with 'N' rows and 'M' columns. Each point in the grid has some cost
 *         associated with it. Find a path from top left i.e. (0, 0) to the
 *         bottom right i.e. ('N' - 1, 'M' - 1) which minimizes the sum of the
 *         cost of all the numbers along the path. You need to tell the minimum
 *         sum of that path.
 * 
 *         Note: You can only move down or right at any point in time.
 *
 */
public class L10_MinimumPathSum {

	public static int minSumPathTD(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] dp = new int[m][n];
		for (int[] rows : dp) {
			Arrays.fill(rows, -1);
		}
		return minSumPathTD(m - 1, n - 1, grid, dp);
	}

	private static int minSumPathTD(int m, int n, int[][] grid, int[][] dp) {
		if (m == 0 && n == 0) {
			return grid[m][n];
		}
		if (m < 0 || n < 0) {
			// return Integer.MAX_VALUE; //Avoid for Integer overflow
			return (int) Math.pow(10, 9); // To omit this path in min comparison
		}
		// memoization
		if (dp[m][n] != -1) {
			return dp[m][n];
		}
		int up = grid[m][n] + minSumPathTD(m - 1, n, grid, dp);
		int left = grid[m][n] + minSumPathTD(m, n - 1, grid, dp);

		return dp[m][n] = Math.min(up, left);
	}

	public static int minSumPathBU(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] dp = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0) {
					dp[i][j] = grid[i][j];
				} else {
					int bottom = grid[i][j];
					if (i > 0) {
						bottom += dp[i - 1][j];
					} else {
						bottom = (int) Math.pow(10, 9);
					}
					int right = grid[i][j];
					if (j > 0) {
						right += dp[i][j - 1];
					} else {
						right = (int) Math.pow(10, 9);
					}
					dp[i][j] = Math.min(right, bottom);
				}
			}
		}
		return dp[m - 1][n - 1];
	}

	public static void main(String[] args) {
		// 5 9 6
		// 11 5 2
		int[][] grid = { { 5, 9, 6 }, { 11, 5, 2 } };
		System.out.println(minSumPathTD(grid));
		System.out.println(minSumPathBU(grid));
	}
}
