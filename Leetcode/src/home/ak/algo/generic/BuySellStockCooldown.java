/**
 * 
 */
package home.ak.algo.generic;

/**
 * @author kundu
 * 
 *         Say you have an array for which the ith element is the price of a
 *         given stock on day i.
 * 
 *         Design an algorithm to find the maximum profit. You may complete as
 *         many transactions as you like (ie, buy one and sell one share of the
 *         stock multiple times) with the following restrictions:
 * 
 *         1. You may not engage in multiple transactions at the same time (ie,
 *         you must sell the stock before you buy again).
 * 
 *         2. After you sell your stock, you cannot buy stock on next day. (ie,
 *         cooldown 1 day)
 * 
 *         Example: Input: [1,2,3,0,2] Output: 3
 * 
 *         Explanation: transactions = [buy, sell, cooldown, buy, sell]
 *
 */
public class BuySellStockCooldown {

	public static int maxProfitRec(int[] prices) {
		return maxProfitRec(prices, 0, prices.length);
	}

	/**
	 * Profit(start, end) = Max of either
	 * 
	 * 1. Profit(buy on start day, end),
	 * 
	 * 2. Profit(not buy on start day, end))
	 */
	private static int maxProfitRec(int[] prices, int start, int end) {
		if (start >= end)
			return 0;
		int res = 0;
		// Consider not buy on start day
		res = maxProfitRec(prices, start + 1, end);
		// For Profit(buy on day start, end), the problem becomes to decide which day to
		// sell will make the profit max. Let's iterate every day after the buy day and
		// check whether sell on this day will be best. That is Profit(buy on day start,
		// end) = for each day i>start, find the max(prices[i]-prices[start] +
		// Profit(start+2, end)) (start+2 since we need cooldown 1 day)
		for (int i = start + 1; i < end; i++) {
			int maxProfit = prices[i] - prices[start] + maxProfitRec(prices, i + 2, end); // i + 1 is cooldown
			res = Math.max(res, maxProfit);
		}
		return res;
	}
	
	/**
	 * Dynamic Programming solution
	 * dp[i][0] = Not holding any stock. Hence the outcome is max of below
	 * 		Case 1: Sold it today i.e dp[i-1][1] + prices[i] 
	 * 		Case 2: Not doing anything i.e dp[i-1][0]
	 * dp[i][1] = Holding a stock
	 * 		Case 1: Bought it today after cooldown i.e., dp[i-2][0] - prices[i]
	 * 		Case 2: Doing nothing (carried forward) i.e., dp[i-1][1]
	 */
	public static int maxProfit(int[] prices) {
		if (prices.length < 2) {
			return 0;
		}
		// Initialize the dp array
		int[][] dp = new int[prices.length][2];

		// Base cases
		dp[0][0] = 0; // Empty plate
		dp[0][1] = -prices[0]; // First buy

		dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);
		dp[1][1] = Math.max(dp[0][1], dp[0][0] - prices[1]);
		
		for(int i = 2; i < prices.length; i++) {
			dp[i][0] = Math.max(dp[i-1][0], dp[i -1][1] + prices[i]); //Sell value
			dp[i][1] = Math.max(dp[i-1][1], dp[i-2][0] - prices[i]); // Buy value
		}
		
		return dp[prices.length - 1][0];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] prices = { 1, 2, 3, 0, 2 };
		System.out.println(maxProfitRec(prices));
		System.out.println(maxProfit(prices));
	}

}
