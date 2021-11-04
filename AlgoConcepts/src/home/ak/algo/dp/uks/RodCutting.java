/**
 * 
 */
package home.ak.algo.dp.uks;

/**
 * @author kundu
 *
 *         Given a rod of length n inches and an array of prices that includes
 *         prices of all pieces of size smaller than n. Determine the maximum
 *         value obtainable by cutting up the rod and selling the pieces.
 * 
 *         Example: if the length of the rod is 8 and the values of different
 *         pieces are given as the following, length = {1, 2, 3, 4, 5, 6, 7, 8},
 *         and price = {1, 5, 8, 9, 10, 17, 17, 20}, then the maximum obtainable
 *         value is 22 (by cutting in two pieces of lengths 2 and 6)
 * 
 **/
public class RodCutting {

	/**
	 * Bottom up solution exactly similar to unbounded knapsack as the item lengths
	 * can be repeated. Here, lengths maps to items and n maps to the kanpsack
	 * capacity
	 */
	public static int maxProfit2DBU(int[] lengths, int[] prices, int n) {

		// Initialize the DP array
		int[][] dp = new int[lengths.length + 1][n + 1];

		// Implicitly, first row and first column in zero
		for (int i = 1; i <= lengths.length; i++) {
			for (int j = 1; j <= n; j++) {
				if (j >= lengths[i - 1]) {
					int include = prices[i - 1] + dp[i][j - lengths[i - 1]];
					int exclude = dp[i - 1][j];
					dp[i][j] = Math.max(include, exclude);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		return dp[lengths.length][n];

	}

	public static int maxProfit1DBU(int[] lengths, int[] prices, int n) {

		// Initialize the DP array
		// For every possible length, find the max profit
		int[] dp = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			dp[i] = Integer.MIN_VALUE;
			// Size of j can range from 0 to i - 1
			for (int j = 0; j < i; j++) {
				// If current length is greater than the cut piece length
				if (i >= lengths[j])
					dp[i] = Math.max(dp[i], prices[j] + dp[i - j - 1]);
			}
		}
		return dp[n];
	}

	public static void main(String[] args) {
		int[] lengths = { 1, 2, 3, 4, 5 };
		int[] prices = { 2, 6, 7, 10, 13 };
		System.out.println(maxProfit2DBU(lengths, prices, 5));
		System.out.println(maxProfit1DBU(lengths, prices, 5));
	}

}
