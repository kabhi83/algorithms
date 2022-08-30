/**
 * 
 */
package home.ak.algo.dp;

import java.util.Arrays;

/**
 * @author kundu
 * 
 *         You are present at point ‘A’ which is the top-left cell of an M X N
 *         matrix, your destination is point ‘B’, which is the bottom-right cell
 *         of the same matrix. Your task is to find the total number of unique
 *         paths from point ‘A’ to point ‘B’.In other words, you will be given
 *         the dimensions of the matrix as integers ‘M’ and ‘N’, your task is to
 *         find the total number of unique paths from the cell MATRIX[0][0] to
 *         MATRIX['M' - 1]['N' - 1]. To traverse in the matrix, you can either
 *         move Right or Down at each step. For example in a given point
 *         MATRIX[i] [j], you can move to either MATRIX[i + 1][j] or MATRIX[i][j
 *         + 1].
 *
 */
public class L08_UniquePaths {

	/**
	 * Top down approach
	 */
	public static int uniquePathsTD(int m, int n) {
		int[][] dp = new int[m][n];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}

		return uniquePathsTD(m - 1, n - 1, dp);
	}

	private static int uniquePathsTD(int m, int n, int[][] dp) {
		// Base case
		if (m == 0 && n == 0) {
			return 1;
		}
		if (m < 0 || n < 0) {
			return 0;
		}

		// Check for the value in dp array
		if (dp[m][n] != -1) {
			return dp[m][n];
		}

		int up = uniquePathsTD(m - 1, n, dp);
		int left = uniquePathsTD(m, n - 1, dp);

		return dp[m][n] = up + left;
	}

	/**
	 * Bottom up approach
	 * 
	 * 1. Declare base case
	 * 
	 * 2. Express all states in for loop
	 * 
	 * 3. Copy the recurrence and write
	 */
	public static int uniquePathsBU(int m, int n) {
		int[][] dp = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
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

	public static void main(String[] args) {
		int m = 3, n = 3;
		System.out.println(uniquePathsTD(m, n));
		System.out.println(uniquePathsBU(m, n));
	}

}
