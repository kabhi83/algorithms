package home.ak.algo.dp.subset;

/**
 * @author kundu
 * 
 *         Given two integer arrays to represent weights and profits of ‘N’
 *         items, we need to find a subset of these items which will give us
 *         maximum profit such that their cumulative weight is not more than a
 *         given number ‘C’. Write a function that returns the maximum profit.
 *         Each item can only be selected once, which means either we put an
 *         item in the knapsack or skip it.
 *
 */
public class Knapsack {

	public static int knapsackRecursive(int[] profits, int[] weights, int capacity) {
		int items = weights.length;
		return knapsackRecursive(profits, weights, capacity, items - 1);
	}

	private static int knapsackRecursive(int[] profits, int[] weights, int capacity, int itemIdx) {
		// Base case - no items left or no space available in knapsack
		if (itemIdx == -1 || capacity == 0) {
			return 0;
		}

		// If current weight is less than total weight
		if (weights[itemIdx] <= capacity) {

			// Include the item at index - itemIdx
			int include = profits[itemIdx]
					+ knapsackRecursive(profits, weights, capacity - weights[itemIdx], itemIdx - 1);
			// Exclude the item at index - itemIdx
			int exclude = knapsackRecursive(profits, weights, capacity, itemIdx - 1);

			return Math.max(include, exclude);
		} else {
			// Ignore the item - by default
			return knapsackRecursive(profits, weights, capacity, itemIdx - 1);
		}
	}

	/**
	 * Bottom up solution
	 */
	public static int knapsackBU(int[] profits, int[] weights, int capacity) {

		// Initialize the dp array - item index as rows and weight as columns
		int items = weights.length;
		int[][] dp = new int[items + 1][capacity + 1];
		for (int i = 1; i <= items; i++) {
			for (int w = 1; w <= capacity; w++) {
				if (weights[i - 1] <= w) {
					// Include means to include the current item and move to the next item which can
					// be included in the remaining weight
					int include = profits[i - 1] + dp[i - 1][w - weights[i - 1]];
					int exclude = dp[i - 1][w];
					dp[i][w] = Math.max(include, exclude);
				} else {
					dp[i][w] = dp[i - 1][w]; // exclude case
				}
			}
		}
		return dp[items][capacity];
	}

	public static void main(String[] args) {
		int[] profits = { 1, 6, 10, 16 };
		int[] weights = { 1, 2, 3, 5 };
		int capacity = 7;
		System.out.println("Recursive: " + knapsackRecursive(profits, weights, capacity));
		System.out.println("Bottom Up: " + knapsackBU(profits, weights, capacity));
	}

}
