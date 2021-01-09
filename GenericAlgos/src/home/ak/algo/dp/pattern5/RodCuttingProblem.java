package home.ak.algo.dp.pattern5;

import java.util.Arrays;

/**
 * @author kundu
 * 
 *         We are given a steel rod of certain length. Also we are given a table
 *         of prices for rods of different lengths. We have to maximize the
 *         profit by cutting the given rod into pieces as given in the table.
 * 
 *         ** Exhaustive Search problem
 * 
 *         State: l ->Length of the rod
 * 
 *         Cost function: maxProfit(l, P)
 * 
 *         Base case: if l = 0, return 0
 * 
 *         Recurrence relation: for L = 6 P[0] + maxProfit(5, P] + P[1] +
 *         maxProfit(4, P) +...
 * 
 *         maxProfit(l, P) = MAX(P[i] + maxProfit(l - i - 1, P)), for i = 0, 1,
 *         2, ..L - 1
 */
public class RodCuttingProblem {

	public static int maxProfitRec(int L, int[] prices) {
		if (L == 0) {
			return 0;
		}

		int max = 0;
		for (int i = 0; i < L; i++) {
			max = Math.max(max, prices[i] + maxProfitRec(L - i - 1, prices));
		}
		return max;
	}

	public static int maxProfitTD(int L, int[] prices) {
		int[] dp = new int[L];
		Arrays.fill(dp, -1);
		return maxProfitTD(L, prices, dp);
	}

	private static int maxProfitTD(int l, int[] prices, int[] dp) {
		if (l == 0)
			return 0;

		if (dp[l] != -1)
			return dp[l];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < l; i++) {
			// Rod of length 6 can be splitted in rod length 1 + rod length 5
			max = Math.max(max, prices[i] + maxProfitTD(l - i - 1, prices, dp));
		}
		dp[l] = max;
		return dp[l];
	}

	/**
	 * Solve for smaller sub problems sequentially to get the outcome of the bigger
	 * problems
	 */
	public static int maxProfitBU(int L, int[] prices) {
		if (L == 0)
			return 0;

		int[] dp = new int[L + 1];
		Arrays.fill(dp, -1);
		// base case
		dp[0] = 0;

		for (int l = 1; l <= L; l++) {
			for (int i = 0; i < l; i++) {
				// Max cost of selling the rod of length 1, 2, 3, .., L
				dp[l] = Math.max(dp[l], prices[i] + dp[l - i - 1]);
			}
		}
		return dp[L];
	}

}
