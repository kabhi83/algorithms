/**
 * 
 */
package home.ak.algo.dp;

import java.util.Arrays;

/**
 * @author kundu
 * 
 *         You are given an integer array prices where prices[i] is the price of
 *         a given stock on the ith day.
 * 
 *         On each day, you may decide to buy and/or sell the stock. You can
 *         only hold at most one share of the stock at any time. However, you
 *         can buy it then immediately sell it on the same day.
 * 
 *         Find and return the maximum profit you can achieve.
 * 
 *         Example 1:
 * 
 *         Input: prices = [7,1,5,3,6,4] Output: 7
 * 
 *         Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5),
 *         profit = 5-1 = 4. Then buy on day 4 (price = 3) and sell on day 5
 *         (price = 6), profit = 6-3 = 3. Total profit is 4 + 3 = 7.
 *
 */
public class L35_BuySellStocksII {

	public static int maxProfit(int[] prices) {
		int[][] dp = new int[prices.length][2];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}
		int buyPossible = 1; // 1 = buy possible, 0 = buy not possible
		return maxProfit(prices, buyPossible, 0, dp);
	}

	private static int maxProfit(int[] prices, int buyPossible, int idx, int[][] dp) {
		// Base cases
		if (idx >= prices.length) {
			return 0;
		}
		if (dp[idx][buyPossible] != -1) {
			return dp[idx][buyPossible];
		}
		if (buyPossible == 1) {
			// for buy price is deducted and for sell price is added
			return dp[idx][buyPossible] = Math.max(-prices[idx] + maxProfit(prices, 0, idx + 1, dp),
					0 + maxProfit(prices, 1, idx + 1, dp));
		} else {
			return dp[idx][buyPossible] = Math.max(prices[idx] + maxProfit(prices, 1, idx + 1, dp),
					0 + maxProfit(prices, 0, idx + 1, dp));
		}
	}

	public static void main(String[] args) {
		int[] prices = { 7, 1, 5, 3, 6, 4 };
		System.out.println(maxProfit(prices));

	}

}
