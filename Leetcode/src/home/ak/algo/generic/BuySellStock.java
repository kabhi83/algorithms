/**
 * 
 */
package home.ak.algo.generic;

/**
 * @author user
 * 
 *         Say you have an array for which the ith element is the price of a
 *         given stock on day i.
 * 
 *         If you were only permitted to complete at most one transaction (i.e.,
 *         buy one and sell one share of the stock), design an algorithm to find
 *         the maximum profit.
 * 
 *         Note that you cannot sell a stock before you buy one.
 * 
 *         Example 1: Input: [7,1,5,3,6,4], Output: 5
 * 
 *         Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6),
 *         profit = 6-1 = 5.
 *
 */
public class BuySellStock {

	public int maxProfit(int[] prices) {
		int maxProfit = 0;
		int minPrice = Integer.MAX_VALUE;
		for(int price: prices){
			if(price < minPrice){
				//Found a minimum price
				minPrice = price;
			} else {
				// Evaluate max profit
				maxProfit = Math.max(maxProfit, price - minPrice);
			}
		}
		return maxProfit;
	}
	
	public static void main(String[] args) {
		int[] prices = {7,1,5,3,6,4};
		int maxProfit = new BuySellStock().maxProfit(prices);
		System.out.println(maxProfit);
	}

}
