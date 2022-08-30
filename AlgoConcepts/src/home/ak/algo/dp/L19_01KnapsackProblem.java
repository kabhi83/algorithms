/**
 * 
 */
package home.ak.algo.dp;

import java.util.Arrays;

/**
 * @author kundu
 * 
 *         Given a Knapsack/Bag with W weight capacity and a list of N items
 *         with given vi value and wi weight. Put these items in the knapsack in
 *         order to maximise the value of all the placed items without exceeding
 *         the limit of the Knapsack.
 *
 */
public class L19_01KnapsackProblem {

	/**
	 * Rule:
	 * 
	 * 1. Express everything in terms of index
	 * 
	 * 2. Explore all possibilities - pick & non-pick
	 * 
	 * 3. Max of all possibilities
	 */
	public static int knapSackTD(int W, int N, int[] val, int[] wt) {
		int[][] dp = new int[N][W + 1];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}
		return knapSackTD(W, N - 1, val, wt, dp);
	}

	private static int knapSackTD(int w, int idx, int[] val, int[] wt, int[][] dp) {
		// Base case
		if (idx == 0) {
			if (wt[0] <= w) {
				return val[0];
			} else {
				return 0;
			}
		}
		if (dp[idx][w] != -1) {
			return dp[idx][w];
		}
		int noPick = knapSackTD(w, idx - 1, val, wt, dp);
		int pick = Integer.MIN_VALUE;
		if (wt[idx] <= w) {
			pick = val[idx] + knapSackTD(w - wt[idx], idx - 1, val, wt, dp);
		}
		return dp[idx][w] = Math.max(noPick, pick);
	}

	public static int knapSackBU(int W, int N, int[] val, int[] wt) {
		int[][] dp = new int[N][W + 1];

		for (int weight = wt[0]; weight <= W; weight++) {
			// only when the bag weight is available we take the item
			dp[0][weight] = val[0];
		}

		for (int idx = 1; idx < N; idx++) {
			for (int weight = 0; weight <= W; weight++) {
				int noTake = dp[idx - 1][weight];
				int take = Integer.MIN_VALUE;
				if (wt[idx] <= weight) {
					take = val[idx] + dp[idx - 1][weight - wt[idx]];
				}
				dp[idx][weight] = Math.max(noTake, take);
			}
		}
		return dp[N - 1][W];
	}

	public static void main(String[] args) {
		int[] wt = { 1, 2, 4, 5 };
		int[] val = { 5, 4, 8, 6 };
		int W = 5;
		System.out.println(knapSackTD(W, val.length, val, wt));
		System.out.println(knapSackBU(W, val.length, val, wt));
	}

}
