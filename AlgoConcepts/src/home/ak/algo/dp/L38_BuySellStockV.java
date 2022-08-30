/**
 * 
 */
package home.ak.algo.dp;

import java.util.Arrays;

/**
 * @author kundu
 * 
 *         You are given an array prices where prices[i] is the price of a given
 *         stock on the ith day.
 * 
 *         Find the maximum profit you can achieve. You may complete as many
 *         transactions as you like (i.e., buy one and sell one share of the
 *         stock multiple times) with the following restrictions:
 * 
 *         After you sell your stock, you cannot buy stock on the next day
 *         (i.e., cooldown one day). Note: You may not engage in multiple
 *         transactions simultaneously (i.e., you must sell the stock before you
 *         buy again).
 *
 */
public class L38_BuySellStockV {

	public static int maxProfitTD(int[] prices) {

		int[][] dp = new int[prices.length][2];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}
		int buyPossibility = 1;
		return maxProfitTD(prices, 0, buyPossibility, dp);
	}

	private static int maxProfitTD(int[] prices, int idx, int buyPossibility, int[][] dp) {
		if (idx >= prices.length) {
			return 0;
		}

		if (dp[idx][buyPossibility] != -1) {
			return dp[idx][buyPossibility];
		}
		if (buyPossibility == 1) {
			return dp[idx][buyPossibility] = Math.max(-prices[idx] + maxProfitTD(prices, idx + 1, 0, dp),
					0 + maxProfitTD(prices, idx + 1, 1, dp));
		} else {
			// When a sell happens, for cooldown, idx is moved by 2, rather than next day
			return dp[idx][buyPossibility] = Math.max(prices[idx] + maxProfitTD(prices, idx + 2, 1, dp),
					0 + maxProfitTD(prices, idx + 1, 0, dp));
		}
	}

	public static int maxProfitBU(int[] prices) {
		int[][] dp = new int[prices.length + 2][2];
		for (int idx = prices.length - 1; idx >= 0; idx--) {
			for (int buy = 0; buy <= 1; buy++) {
				if (buy == 1) { //
					dp[idx][buy] = Math.max(-prices[idx] + dp[idx + 1][0], 0 + dp[idx + 1][1]);
				} else {
					// When a sell happens, for cooldown, idx is moved by 2, rather than next day
					dp[idx][buy] = Math.max(prices[idx] + dp[idx + 2][1], 0 + dp[idx + 1][0]);
				}

			}
		}

		return dp[0][1];
	}

	public static void main(String[] args) {
		int[] prices = { 1, 2, 3, 0, 2 };
		System.out.println(maxProfitTD(prices));
		System.out.println(maxProfitBU(prices));
	}

}
