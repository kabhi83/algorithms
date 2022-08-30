/**
 * 
 */
package home.ak.algo.dp;

import java.util.Arrays;

/**
 * @author kundu
 * 
 *         You are given a triangular array/list 'TRIANGLE'. Your task is to
 *         return the minimum path sum to reach from the top to the bottom row.
 *         The triangle array will have N rows and the i-th row, where 0 <= i <
 *         N will have i + 1 elements. You can move only to the adjacent number
 *         of row below each step. For example, if you are at index j in row i,
 *         then you can move to i or i + 1 index in row j + 1 in each step.
 * 
 *         Example: If the array given is 'TRIANGLE' = [[1], [2,3], [3,6,7],
 *         [8,9,6,1]] the triangle array will look like:
 * 
 *         1 _________________________________________________________________
 *         2,3 _______________________________________________________________
 *         3,6,7 _____________________________________________________________
 *         8,9,6,10 __________________________________________________________
 *
 *         Note: This is a problem with variable ending points
 * 
 *         -------------------------------------------------------------------------------
 *         Time Complexity: O(N*N)
 * 
 *         Reason: At max, there will be (half of, due to triangle) N*N calls of
 *         recursion.
 * 
 *         Space Complexity: O(N) + O(N*N)
 * 
 *         Reason: We are using a recursion stack space: O((N), where N is the
 *         path length and an external DP Array of size ‘N*N’.
 */
public class L11_Triangle {

	/**
	 * Top down approach
	 */
	public static int minimumPathSumTD(int[][] triangle, int n) {
		int[][] dp = new int[n][n]; // Right angled triangle; hence n*n
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}
		return minimumPathSumTD(triangle, 0, 0, n, dp);
	}

	private static int minimumPathSumTD(int[][] triangle, int row, int col, int n, int[][] dp) {
		if (row == n - 1) {
			// reached the last row
			return triangle[row][col];
		}
		if (dp[row][col] != -1) {
			return dp[row][col];
		}
		int down = triangle[row][col] + minimumPathSumTD(triangle, row + 1, col, n, dp);
		int diagonal = triangle[row + 1][col + 1] + minimumPathSumTD(triangle, row + 1, col + 1, n, dp);
		return dp[row][col] = Math.min(down, diagonal);
	}

	/**
	 * Bottom up approach
	 */
	public static int minimumPathSumBU(int[][] triangle, int n) {
		int[][] dp = new int[n][n];
		// Bottom up is always reverse of top-down
		// Initialize the dp array
		for (int j = 0; j < n; j++) {
			dp[n - 1][j] = triangle[n - 1][j];
		}

		for (int i = n - 2; i >= 0; i--) {
			for (int j = i; j >= 0; j--) {
				int down = triangle[i][j] + dp[i + 1][j];
				int diagonal = triangle[i][j] + dp[i + 1][j + 1];
				dp[i][j] = Math.min(down, diagonal);
			}
		}

		return dp[0][0];
	}

	public static void main(String[] args) {
		int[][] triangle = { { 1 }, { 2, 3 }, { 3, 6, 7 }, { 8, 9, 6, 10 } };
		System.out.println(minimumPathSumTD(triangle, triangle.length));
		System.out.println(minimumPathSumBU(triangle, triangle.length));
	}

}
