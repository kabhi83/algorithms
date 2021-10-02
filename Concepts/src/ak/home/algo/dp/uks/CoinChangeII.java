/**
 * 
 */
package ak.home.algo.dp.uks;

/**
 * @author kundu
 * 
 *         Given a number array to represent different coin denominations and a
 *         total amount ‘T’, we need to find the minimum number of coins needed
 *         to make a change for ‘T’. We can assume an infinite supply of coins,
 *         therefore, each coin can be chosen multiple times.
 * 
 *         Example: Input Denominations: {1,2,3} Total amount: 5 Output: 2
 * 
 *         Explanation: We need a minimum of two coins {2,3} to make a total of
 *         '5'
 */
public class CoinChangeII {

	/**
	 * This is a variation f unbounded knapsack as the same coins can be reused
	 */
	public static int minimumCoins(int[] denominations, int total) {
		int max_val = total + 1; // Or initialize to Integer.MAX_VALUE - 1
		// Initialize DP array
		int[][] dp = new int[denominations.length + 1][total + 1];

		// Initialize the first row. With the 0 coins it is recommended to use infinite
		// number of coins to reach the total of i
		for (int i = 1; i <= total; i++) {
			dp[0][i] = max_val;
		}
		// Initialize second row with 1 coin - if divisible return count else max_val
		for (int i = 1; i <= total; i++) {
			dp[1][i] = (i % denominations[0] == 0) ? i / denominations[0] : max_val;
		}

		for (int i = 2; i <= denominations.length; i++) {
			for (int t = 1; t <= total; t++) {
				if (t >= denominations[i - 1]) {
					// In case of include add 1 for the current coin
					dp[i][t] = Math.min(dp[i - 1][t], 1 + dp[i][t - denominations[i - 1]]);
				} else {
					dp[i][t] = dp[i - 1][t];
				}
			}
		}

		return (dp[denominations.length][total] == max_val ? -1 : dp[denominations.length][total]);
	}

	public static void main(String[] args) {
		int[] denominations = { 1, 2, 3 };
		System.out.println(minimumCoins(denominations, 5));
		System.out.println(minimumCoins(denominations, 7));
		System.out.println(minimumCoins(denominations, 11));
		denominations = new int[] { 3, 5 };
		System.out.println(minimumCoins(denominations, 7));
	}

}
