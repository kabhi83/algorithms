/**
 * 
 */
package home.ak.algo.dp;

/**
 * @author kundu
 * 
 *         You are given an array prices where prices[i] is the price of a given
 *         stock on the ith day.
 * 
 *         Find the maximum profit you can achieve. You may complete at most two
 *         transactions.
 * 
 *         Note: You may not engage in multiple transactions simultaneously
 *         (i.e., you must sell the stock before you buy again).
 * 
 *         Example: Input: prices = [3,3,5,0,0,3,1,4] Output: 6
 * 
 *         Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3),
 *         profit = 3-0 = 3. Then buy on day 7 (price = 1) and sell on day 8
 *         (price = 4), profit = 4-1 = 3.
 * 
 * 
 *         3D DP problem with 3 variables - prices, buy/sell, transaction cap
 *
 */
public class L36_BuySellStocksIII {

	public static int maxProfit(int[] prices) {
		int buyPossibility = 1;
		int purchaseCap = 2; // { 2, 1, 0}
		int[][][] dp = new int[prices.length][2][3];
		for (int row = 0; row < prices.length; row++) {
			for (int col = 0; col < 2; col++) {
				for (int cap = 0; cap < 3; cap++) {
					dp[row][col][cap] = -1;
				}
			}
		}
		return maxProfit(prices, 0, buyPossibility, purchaseCap, dp);
	}

	private static int maxProfit(int[] prices, int idx, int buyPossibility, int purchaseCap, int[][][] dp) {
		if (idx == prices.length || purchaseCap == 0) {
			return 0;
		}

		if (dp[idx][buyPossibility][purchaseCap] != -1) {
			return dp[idx][buyPossibility][purchaseCap];
		}

		if (buyPossibility == 1) {
			// either but or don't buy
			return dp[idx][buyPossibility][purchaseCap] = Math.max(
					-prices[idx] + maxProfit(prices, idx + 1, 0, purchaseCap, dp), // buy
					0 + maxProfit(prices, idx + 1, 1, purchaseCap, dp)); // don't buy
		} else {
			// either sell or don't sell. If sell transaction completes and hence cap
			// reduces
			return dp[idx][buyPossibility][purchaseCap] = Math.max(
					prices[idx] + maxProfit(prices, idx + 1, 1, purchaseCap - 1, dp), // sell
					0 + maxProfit(prices, idx + 1, 0, purchaseCap, dp)); // don't sell
		}
	}

	public static void main(String[] args) {
		int[] prices = { 3, 3, 5, 0, 0, 3, 1, 4 };
		System.out.println(maxProfit(prices));

		prices = new int[] { 1, 2, 3, 4, 5 };

		System.out.println(maxProfit(prices));
	}

}
