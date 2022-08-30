/**
 * 
 */
package home.ak.algo.dp;

/**
 * @author kundu
 * 
 *         You are given an integer array prices where prices[i] is the price of
 *         a given stock on the ith day, and an integer k.
 * 
 *         Find the maximum profit you can achieve. You may complete at most k
 *         transactions.
 * 
 *         Note: You may not engage in multiple transactions simultaneously
 *         (i.e., you must sell the stock before you buy again).
 * 
 *         Example 1:Input: k = 2, prices = [2,4,1] Output: 2
 * 
 *         Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4),
 *         profit = 4-2 = 2.
 *
 */
public class L37_BuySellStocksIV {

	public static int maxProfit(int[] prices, int k) {
		int[][][] dp = new int[prices.length][2][k + 1];
		for (int row = 0; row < prices.length; row++) {
			for (int col = 0; col < 2; col++) {
				for (int cap = 0; cap <= k; cap++) {
					dp[row][col][cap] = -1;
				}
			}
		}
		int buyPossibility = 1;
		return maxProfit(prices, 0, buyPossibility, k, dp);
	}

	private static int maxProfit(int[] prices, int idx, int buyPossibility, int k, int[][][] dp) {
		if (idx >= prices.length || k == 0) {
			return 0;
		}
		if (dp[idx][buyPossibility][k] != -1) {
			return dp[idx][buyPossibility][k];
		}
		if (buyPossibility == 1) {
			// Either buy or don't buy
			return dp[idx][buyPossibility][k] = Math.max(-prices[idx] + maxProfit(prices, idx + 1, 0, k, dp), // buy
					0 + maxProfit(prices, idx + 1, 1, k, dp)); // postpone buy
		} else {
			return dp[idx][buyPossibility][k] = Math.max(prices[idx] + maxProfit(prices, idx + 1, 1, k - 1, dp), // sell
					0 + maxProfit(prices, idx + 1, 0, k, dp)); // postponse sell
		}
	}

	public static void main(String[] args) {
		int[] prices = { 3, 2, 6, 5, 0, 3 };
		int k = 2;
		System.out.println(maxProfit(prices, k));
	}

}
