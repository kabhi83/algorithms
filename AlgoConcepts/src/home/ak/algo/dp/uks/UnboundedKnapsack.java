/**
 * 
 */
package home.ak.algo.dp.uks;

/**
 * @author kundu
 * 
 *         Given the weights and profits of ‘N’ items, we are asked to put these
 *         items in a knapsack that has a capacity ‘C’. The goal is to get the
 *         maximum profit from the items in the knapsack. In this problem we are
 *         allowed to use an unlimited quantity of an item.
 * 
 *         Example: Merry, who wants to carry some fruits in the knapsack to get
 *         maximum profit. Here are the weights and profits of the fruits:
 * 
 *         Items: { Apple, Orange, Melon }
 * 
 *         Weights: { 1, 2, 3 }, Profits: { 15, 20, 50 } Knapsack capacity: 5
 * 
 *         Explanation: Different combinations of fruits in the knapsack, such
 *         that their total weight is not more than 5.
 * 
 *         5 Apples (total weight 5) => 75 profit
 * 
 *         1 Apple + 2 Oranges (total weight 5) => 55 profit
 * 
 *         2 Apples + 1 Melon (total weight 5) => 80 profit
 * 
 *         1 Orange + 1 Melon (total weight 5) => 70 profit
 * 
 *         This shows that 2 apples + 1 melon is the best combination, as it
 *         gives us the maximum profit and the total weight does not exceed the
 *         capacity.
 *
 */
public class UnboundedKnapsack {

	/**
	 * In unbounded knapsack, if we decide to include an item, it can be included
	 * multiple times. But if excluded, the decision is final and the item will be
	 * never be considered again
	 */
	public static int maxProfit2DBU(int[] profits, int[] weights, int capacity) {

		// Initialize DP array
		int[][] dp = new int[profits.length + 1][capacity + 1];

		// Set 1st row and 1st column to 0 - Implicit
		for (int i = 0; i <= profits.length; i++) {
			dp[i][0] = 0;
		}
		for (int w = 0; w <= capacity; w++) {
			dp[0][w] = 0;
		}

		for (int i = 1; i <= profits.length; i++) {
			for (int w = 1; w <= capacity; w++) {
				if (w >= weights[i - 1]) {
					// Repeated inclusion - dp[i][w - profits[i - 1]]
					// Same ith item reconsidered
					int include = profits[i - 1] + dp[i][w - weights[i - 1]];
					int exclude = dp[i - 1][w];
					dp[i][w] = Math.max(include, exclude);
				} else {
					dp[i][w] = dp[i - 1][w];
				}
			}
		}
		return dp[profits.length][capacity];
	}

	public static int maxProfit1DBU(int[] profits, int[] weights, int capacity) {
		int[] dp = new int[capacity + 1];
		for (int w = 1; w <= capacity; w++) {
			for (int i = 0; i < profits.length; i++) {
				// If the item can be included
				if (weights[i] <= w) {
					// Max of excluding and including the current item
					dp[w] = Math.max(dp[w], profits[i] + dp[w - weights[i]]);
				}
			}
		}
		return dp[capacity];
	}

	public static void main(String[] args) {
		int[] profits = { 15, 50, 60, 90 };
		int[] weights = { 1, 3, 4, 5 };
		System.out.println(maxProfit2DBU(profits, weights, 8));
		System.out.println(maxProfit1DBU(profits, weights, 8));
	}

}
