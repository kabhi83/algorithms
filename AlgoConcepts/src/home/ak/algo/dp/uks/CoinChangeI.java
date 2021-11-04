/**
 * 
 */
package home.ak.algo.dp.uks;

/**
 * @author kundu
 * 
 *         Given a number array to represent different coin denominations and a
 *         total amount ‘T’, we need to find all the different ways to make a
 *         change for ‘T’ with the given coin denominations. We can assume an
 *         infinite supply of coins, therefore, each coin can be chosen multiple
 *         times.
 * 
 *         Example: Denominations: {1,2,3}, Total amount: 5, Output: 5
 *         Explanation: There are five ways to make the change for '5'.They are
 *         1. {1,1,1,1,1} 2. {1,1,1,2} 3. {1,2,2} 4. {1,1,3} 5. {2,3}
 *
 */
public class CoinChangeI {

	/**
	 * This is a variation of unbounded knapsack as the coins can be picked multiple
	 * times. Also, whenever the question requires number of ways or total possible
	 * solution, we have to get the sum of all the approaches
	 */
	public static int numberofWays(int[] denominations, int total) {
		// Initialize the DP array
		int[][] dp = new int[denominations.length + 1][total + 1];

		// The first column of 0 sum can be formed with empty set of all the coins
		for (int i = 0; i <= denominations.length; i++) {
			dp[i][0] = 1;
		}

		for (int i = 1; i <= denominations.length; i++) {
			for (int t = 1; t <= total; t++) {
				if (t >= denominations[i - 1]) {
					int include = dp[i][t - denominations[i - 1]];
					int exclude = dp[i - 1][t];
					// Result is combination of both options
					dp[i][t] = include + exclude;
				} else {
					dp[i][t] = dp[i - 1][t];
				}
			}
		}
		return dp[denominations.length][total];
	}

	public static void main(String[] args) {
		int[] denominations = { 1, 2, 3 };
		System.out.println(numberofWays(denominations, 5));
	}

}
