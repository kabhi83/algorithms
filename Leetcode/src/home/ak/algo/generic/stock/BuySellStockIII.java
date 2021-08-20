/**
 * 
 */
package home.ak.algo.generic.stock;

/**
 * @author kundu
 * 
 *         Say you have an array for which the ith element is the price of a
 *         given stock on day i.
 * 
 *         Design an algorithm to find the maximum profit. You may complete at
 *         most two transactions.
 * 
 *         Note: You may not engage in multiple transactions at the same time
 *         (i.e., you must sell the stock before you buy again).
 * 
 *         Example 1: Input: prices = [3,3,5,0,0,3,1,4] Output: 6 Explanation:
 *         Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0
 *         = 3. Then buy on day 7 (price = 1) and sell on day 8 (price = 4),
 *         profit = 4-1 = 3.
 * 
 *         Example 2: Input: prices = [1,2,3,4,5] Output: 4 Explanation: Buy on
 *         day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 *         Note that you cannot buy on day 1, buy on day 2 and sell them later,
 *         as you are engaging multiple transactions at the same time. You must
 *         sell before buying again.
 *
 */
public class BuySellStockIII {

	public int maxProfit(int[] prices) {
		if (prices.length == 0) {
			return 0;
		}
		int firstBuy = Integer.MIN_VALUE, secondBuy = Integer.MIN_VALUE;
		int firstSell = 0, secondSell = 0;
		for (int i = 0; i < prices.length; i++) {
			// Since this is a first transaction, we negate the price
			firstBuy = Integer.max(firstBuy, -prices[i]);
			firstSell = Integer.max(firstSell, firstBuy + prices[i]);
			secondBuy = Integer.max(secondBuy, firstSell - prices[i]);
			secondSell = Integer.max(secondSell, secondBuy + prices[i]);
		}
		return secondSell;
	}

	/**
	 * Alternate approach
	 */
	public int maxProfitAlternate(int[] prices) {
		int buy1 = Integer.MAX_VALUE, buy2 = Integer.MAX_VALUE;
		int profit1 = 0, profit2 = 0;
		for (int i = 0; i < prices.length; i++) {
			// We should buy with min value and make make max profit
			buy1 = Math.min(buy1, prices[i]);
			profit1 = Math.max(profit1, prices[i] - buy1);
			buy2 = Math.min(buy2, prices[i] - profit1);
			profit2 = Math.max(profit2, prices[i] - buy2);
		}
		return profit2;
	}

	public static void main(String[] args) {
		int[] prices = { 3, 3, 5, 0, 0, 3, 1, 4 };
		int profit = new BuySellStockIII().maxProfit(prices);
		System.out.println(profit);

		int profitAlt = new BuySellStockIII().maxProfitAlternate(prices);
		System.out.println(profitAlt);
	}

}
