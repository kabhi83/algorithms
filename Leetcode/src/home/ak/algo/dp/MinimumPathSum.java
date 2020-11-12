/**
 * 
 */
package home.ak.algo.dp;

/**
 * @author kundu
 * 
 *         Given a m x n grid filled with non-negative numbers, find a path from
 *         top left to bottom right, which minimizes the sum of all numbers
 *         along its path.
 * 
 *         Input: grid = [[1,3,1],[1,5,1],[4,2,1]] Output: 7 Explanation:
 *         Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
 *
 */
public class MinimumPathSum {

	public int minPathSum(int[][] grid) {

		if (null == grid || grid.length == 0) {
			return 0;
		}
		int m = grid.length;
		int n = grid[0].length;

		int[][] dp = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				//Add the current value of the grid
				dp[i][j] += grid[i][j];
				if (i > 0 && j > 0) {
					dp[i][j] += Math.min(dp[i - 1][j], dp[i][j - 1]);
				} else if (i > 0) {
					dp[i][j] += dp[i - 1][j];
				} else if (j > 0) {
					dp[i][j] += dp[i][j - 1];
				}
			}
		}
		return dp[m - 1][n - 1];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
		int result = new MinimumPathSum().minPathSum(grid);
		System.out.println(result);
	}

}
