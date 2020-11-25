/**
 * 
 */
package home.ak.algo.dp;

import java.util.Arrays;

/**
 * @author kundu
 * 
 *         Given weights and values of n items, put these items in a knapsack of
 *         capacity W to get the maximum total value in the knapsack.
 * 
 *         1. Define the state - W = Available capacity of the bag and i = index
 *         of the item considered. Cost function, knapsack(W, i)
 * 
 *         2. List out all state transitions - Base case - No more item left to
 *         be considered or no space in the knapsack. W = 0, return 0 and i =
 *         -1, return 0
 * 
 *         Transition: Either take the item or ignore the item at each step of
 *         the problem.
 * 
 *         -> Take Item knapsack(W,i) = value[i] + knapsack(W - weight[i], i -1)
 *         -> Ignore the item knapsack(W,i) = knapsack(W, i -1)
 * 
 *         3. Implement a recursive solution
 * 
 *         knapsack(W,i) = if w[i] < W, ---------------------------------------
 *         MAX(value[i] + knapsack(W - weight[i], i -1), knapsack(W, i-1)),
 * 
 *         else, knapsack(W, i-1)
 * 
 *         4. Memoize
 * 
 *         5. Build Bottom up solution
 *
 */
public class KnapsackProblem {

	/*
	 * Recursive solution
	 */
	public static int knapsack(int[] weights, int[] values, int W, int itemIndex) {
		if (itemIndex == -1 || W == 0) {
			return 0;
		}
		if (weights[itemIndex] <= W) {
			int include = values[itemIndex] + knapsack(weights, values, W - weights[itemIndex], itemIndex - 1);
			int exclude = knapsack(weights, values, W, itemIndex - 1);
			return Math.max(include, exclude);
		} else {
			return knapsack(weights, values, W, itemIndex - 1);
		}
	}

	/*
	 * Memoization
	 */
	public static int knapsackTopDown(int[] weights, int[] values, int W, int itemindex, int[][] dp) {
		if (itemindex == -1 || W == 0) {
			return 0;
		}

		if (dp[W][itemindex] != -1) {
			return dp[W][itemindex];
		}

		if (weights[itemindex] <= W) {
			// we have both the option to include and exclude the item
			int include = values[itemindex]
					+ knapsackTopDown(weights, values, W - weights[itemindex], itemindex - 1, dp);
			int exclude = knapsackTopDown(weights, values, W, itemindex - 1, dp);
			return dp[W][itemindex] = Math.max(include, exclude);
		} else {
			return dp[W][itemindex] = knapsackTopDown(weights, values, W, itemindex - 1, dp);
		}
	}

	/**
	 * Bottom up equation
	 * 
	 * dp[w][i] = MAX(val[i -  1] + dp[w-weight[i - 1]][i - 1], dp[w][i - 1])
	 */
	public static int knapsackButtomUp(int[] weights, int[] values, int W) {
		int N = weights.length;
		int[][] dp = new int[W + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int w = 1; w <= W; w++) {
				if (weights[i - 1] <= w) {
					dp[w][i] = Math.max(values[i - 1] + dp[w - weights[i - 1]][i - 1], dp[w][i - 1]);
				} else {
					dp[w][i] = dp[w][i - 1];
				}
			}
		}
		return dp[W][N];
	}

	public static void main(String args[]) {
		int values[] = { 60, 100, 120 };
		int weights[] = { 10, 20, 30 };
		int W = 50;
		int N = weights.length;
		int[][] dp = new int[W + 1][N + 1];
		for (int i = 0; i <= W; i++) {
			Arrays.fill(dp[i], -1);
		}
		// Invoke Recursive solution
		System.out.println(knapsack(weights, values, W, N - 1));

		// Invoke Top- Down solution
		System.out.println(knapsackTopDown(weights, values, W, N - 1, dp));

		// Invoke Bottom-Up solution
		System.out.println(knapsackButtomUp(weights, values, W));
	}

}
