/**
 * 
 */
package home.ak.algo.dp.twoDim;

/**
 * @author kundu
 * 
 *         A thief is in search of cakes. Queen Elizabeth has a limited number
 *         of types of cake, she has an unlimited supply of each type.
 * 
 *         Each type of cake has a weight and a value, stored in tuples with two
 *         indices:
 * 
 *         1. An integer representing the weight of the cake in kilograms
 * 
 *         2. An integer representing the monetary value of the cake in British
 *         pounds
 * 
 *         For example:
 * 
 *         # weighs 7 kilograms and has a value of 160 pounds (7, 160)
 * 
 *         # weighs 3 kilograms and has a value of 90 pounds (3, 90)
 * 
 *         The thief brought a duffel bag that can hold limited weight, and he
 *         want to make off with the most valuable haul possible.
 * 
 *         Write a method maxDuffelBagValue() that takes an array of cake
 *         weights and an array of monetary values and returns the maximum
 *         monetary value the duffel bag can hold.
 *
 */
public class CakeThiefProblem {

	/**
	 * Solution using 1D array
	 */
	public static int maxDuffelBagValue1D(int[] W, int[] V, int capacity) {
		int cakes = W.length;
		int[] dp = new int[capacity + 1];
		dp[0] = 0;
		int best = 0;
		for (int w = 1; w <= capacity; w++) {
			for (int i = 0; i < cakes; i++) {
				// When the available weight in duffel bag is greater than the weight of the
				// current item
				if (w >= W[i]) {
					best = Math.max(dp[w - W[i]] + V[i], best);
				}
			}
			dp[w] = best;
		}
		return dp[capacity];
	}

	/**
	 * State: i -> item index to be considered; W -> available capacity
	 * 
	 */
	public static int maxDuffelBagValue2D(int[] W, int[] V, int capacity) {
		// Initialize a 2D array
		int cakes = W.length;
		int[][] dp = new int[cakes][capacity + 1];

		/*
		 * Either we include the item or exclude the item completely
		 * 
		 * Exclude: dp[i-1][j] -> we consider the previous item only for the current
		 * capacity
		 * 
		 * Include: if W[i] < j then dp[i][j - W[i]] -> we reduce the weight and
		 * consider again
		 */
		for (int i = 0; i < cakes; i++) {
			for (int j = 1; j <= capacity; j++) {
				int include = 0, exclude = 0;
				if (W[i] <= j) {
					include = V[i] + dp[i][j - W[i]];
				}
				if (i > 0) {
					exclude = dp[i - 1][j];
				}

				dp[i][j] = Math.max(include, exclude);
			}
		}

		return dp[cakes - 1][capacity];
	}

	public static void main(String[] args) {
		int[] W = { 6, 3, 4, 2 };
		int[] V = { 30, 14, 16, 9 };
		int capacity = 10;
		int optimalValue = maxDuffelBagValue1D(W, V, capacity);
		System.out.println("Optimal value for unbounded knapsack: " + optimalValue);

		optimalValue = maxDuffelBagValue2D(W, V, capacity);
		System.out.println("Optimal value for unbounded knapsack: " + optimalValue);
	}

}
