/**
 * 
 */
package home.ak.algo.dp;

import java.util.Arrays;

/**
 * @author kundu
 * 
 *         Given N items each with an associated weight and value (benefit or
 *         profit). The objective is to fill the knapsack with items such that
 *         we have a maximum profit without crossing the weight limit of the
 *         knapsack. In the Unbounded version of the problem, we are allowed to
 *         select one item multiple times, unlike the classical one, where one
 *         item is allowed to be selected only once.
 *
 */
public class L23_UnboundedKnapsack {

	/**
	 * Top down approach
	 */
	public static int unboundedKnapsackTD(int n, int w, int[] profit, int[] weight) {
		int[][] dp = new int[n][w + 1]; // knapsack weight ranges from 0 to w
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}
		return unboundedKnapsackTD(n - 1, w, profit, weight, dp);
	}

	private static int unboundedKnapsackTD(int idx, int w, int[] profit, int[] weight, int[][] dp) {
		if (w == 0) {
			return 0;
		}
		if (idx == 0) {
			// compute the max items which can be collected
			int maxItems = (w / weight[0]);
			return maxItems * profit[0];
		}
		if (dp[idx][w] != -1) {
			return dp[idx][w];
		}
		int noTake = 0 + unboundedKnapsackTD(idx - 1, w, profit, weight, dp);
		int take = Integer.MIN_VALUE;
		if (weight[idx] <= w) {
			take = profit[idx] + unboundedKnapsackTD(idx, w - weight[idx], profit, weight, dp);
			// Index will be at the same place as there are infinite supply of items
		}
		return dp[idx][w] = Math.max(noTake, take);
	}

	public static int unboundedKnapsackBU(int n, int w, int[] profit, int[] weight) {
		int[][] dp = new int[n][w + 1];
		for (int wt = weight[0]; wt <= w; wt++) {
			dp[0][wt] = (wt / weight[0]) * profit[0];
		}

		for (int idx = 1; idx < n; idx++) {
			for (int wt = 0; wt <= w; wt++) {
				int noTake = 0 + dp[idx - 1][wt];
				int take = Integer.MIN_VALUE;
				if (weight[idx] <= wt) {
					take = profit[idx] + dp[idx][wt - weight[idx]];
				}
				dp[idx][wt] = Math.max(noTake, take);
			}
		}
		return dp[n - 1][w];
	}

	public static void main(String[] args) {
		int[] profit = { 5, 11, 13 };
		int[] weight = { 2, 4, 6 };
		int w = 10;
		System.out.println(unboundedKnapsackTD(profit.length, w, profit, weight));
		System.out.println(unboundedKnapsackBU(profit.length, w, profit, weight));
	}

}
