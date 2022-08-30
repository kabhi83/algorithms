/**
 * 
 */
package home.ak.algo.dp;

import java.util.Arrays;

/**
 * @author kundu
 * 
 *         You have been given an M*N matrix filled with integer numbers, find
 *         the maximum sum that can be obtained from a path starting from any
 *         cell in the first row to any cell in the last row. From a cell in a
 *         row, you can move to another cell directly below that row, or
 *         diagonally below left or right. So from a particular cell (row, col),
 *         we can move in three directions i.e.
 * 
 *         Down: (row+1,col)
 * 
 *         Down left diagonal: (row+1,col-1)
 * 
 *         Down right diagonal: (row+1, col+1)
 *
 */
public class L12_MaximumPathSum {

	/**
	 * Top down approach
	 * 
	 * TC: O(M*N)
	 * 
	 * SC: O(M*N) + O(N) - Recursion stack space (path length)
	 */
	public static int getMaxPathSumTD(int[][] matrix) {
		int max = Integer.MIN_VALUE;
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] dp = new int[m][n];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}
		for (int j = 0; j < n; j++) {
			max = Math.max(max, getMaxPathSumTD(matrix, m - 1, j, dp));
		}
		return max;
	}

	private static int getMaxPathSumTD(int[][] matrix, int i, int j, int[][] dp) {
		if (j < 0 || j >= matrix[0].length) {
			return -(int) Math.pow(10, 9);
		}

		if (i == 0) {
			return matrix[i][j];
		}

		if (dp[i][j] != -1) {
			return dp[i][j];
		}

		int up = matrix[i][j] + getMaxPathSumTD(matrix, i - 1, j, dp);
		int diagonalLeft = matrix[i][j] + getMaxPathSumTD(matrix, i - 1, j - 1, dp);
		int diagonalRight = matrix[i][j] + getMaxPathSumTD(matrix, i - 1, j + 1, dp);

		return dp[i][j] = Math.max(Math.max(diagonalLeft, diagonalRight), up);
	}

	public static int getMaxPathSumBU(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] dp = new int[m][n];
		for (int i = 0; i < n; i++) {
			dp[0][i] = matrix[0][i];
		}

		for (int i = 1; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int down = matrix[i][j] + dp[i - 1][j];
				int diagonalLeft = matrix[i][j];
				int diagonalRight = matrix[i][j];
				if (j > 0) {
					diagonalLeft += dp[i - 1][j - 1];
				} else {
					diagonalLeft += (int) Math.pow(-10, 9);
				}
				if ((j < n - 1)) {
					diagonalRight += dp[i - 1][j + 1];
				} else {
					diagonalRight += (int) Math.pow(-10, 9);
				}
				dp[i][j] = Math.max(down, Math.max(diagonalLeft, diagonalRight));
			}
		}

		int max = Integer.MIN_VALUE;
		for (int j = 0; j < n; j++) {
			max = Math.max(max, dp[m - 1][j]);
		}
		return max;
	}

	public static void main(String[] args) {
		int matrix[][] = { { 1, 2, 10, 4 }, { 100, 3, 2, 1 }, { 1, 1, 20, 2 }, { 1, 2, 2, 1 } };

		System.out.println(getMaxPathSumTD(matrix));
		System.out.println(getMaxPathSumBU(matrix));
	}

}
