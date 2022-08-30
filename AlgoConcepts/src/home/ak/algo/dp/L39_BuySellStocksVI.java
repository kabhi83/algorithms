/**
 * 
 */
package home.ak.algo.dp;

import java.util.Arrays;

/**
 * @author kundu
 * 
 *         You are given an array prices where prices[i] is the price of a given
 *         stock on the ith day, and an integer fee representing a transaction
 *         fee.
 * 
 *         Find the maximum profit you can achieve. You may complete as many
 *         transactions as you like, but you need to pay the transaction fee for
 *         each transaction.
 * 
 *         Note: You may not engage in multiple transactions simultaneously
 *         (i.e., you must sell the stock before you buy again).
 *
 */
public class L39_BuySellStocksVI {

	public static int maxProfitTD(int[] prices, int fee) {
		int[][] dp = new int[prices.length][2];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}
		int buyPossibilty = 1;
		return maxProfitTD(prices, 0, buyPossibilty, fee, dp);
	}

	private static int maxProfitTD(int[] prices, int idx, int buyPossibilty, int fee, int[][] dp) {
		if (idx >= prices.length) {
			return 0;
		}

		if (dp[idx][buyPossibilty] != -1) {
			return dp[idx][buyPossibilty];
		}
		if (buyPossibilty == 1) {
			return dp[idx][buyPossibilty] = Math.max(-prices[idx] + maxProfitTD(prices, idx + 1, 0, fee, dp),
					0 + maxProfitTD(prices, idx + 1, 1, fee, dp));
		} else {
			return dp[idx][buyPossibilty] = Math.max(prices[idx] - fee + maxProfitTD(prices, idx + 1, 1, fee, dp),
					0 + maxProfitTD(prices, idx + 1, 0, fee, dp));
		}
	}

	public static int maxProfitBU(int[] prices, int fee) {
		int[][] dp = new int[prices.length + 1][2];

		for (int idx = prices.length - 1; idx >= 0; idx--) {
			for (int buy = 0; buy <= 1; buy++) {
				if (buy == 1) {
					dp[idx][buy] = Math.max(-prices[idx] + dp[idx + 1][0], 0 + dp[idx + 1][1]);
				} else {
					dp[idx][buy] = Math.max(prices[idx] - fee + dp[idx + 1][1], 0 + dp[idx + 1][0]);
				}
			}
		}
		return dp[0][1];
	}

	public static void main(String[] args) {
		int[] prices = { 1, 3, 2, 8, 4, 9 };
		int fee = 2;
		System.out.println(maxProfitTD(prices, fee));
		System.out.println(maxProfitBU(prices, fee));
	}

}
