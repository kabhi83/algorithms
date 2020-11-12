/**
 * 
 */
package home.ak.algo.dp;

import java.util.Arrays;

/**
 * @author kundu
 * 
 *         You are given coins of different denominations and a total amount of
 *         money amount. Write a function to compute the fewest number of coins
 *         that you need to make up that amount. If that amount of money cannot
 *         be made up by any combination of the coins, return -1.
 * 
 *         You may assume that you have an infinite number of each kind of coin.
 * 
 *         Example 1: Input: coins = [1,2,5], amount = 11 Output: 3
 * 
 *         Explanation: 11 = 5 + 5 + 1
 * 
 *         Example 2: Input: coins = [2], amount = 3 Output: -1
 * 
 *         Example 3: Input: coins = [1], amount = 0 Output: 0
 * 
 *         Example 4: Input: coins = [1], amount = 1 Output: 1
 * 
 *         Example 5: Input: coins = [1], amount = 2 Output: 2
 *
 */
public class CoinChange {

	public int coinChange(int[] coins, int amount) {
		if (null == coins || coins.length == 0 || amount == 0) {
			return 0;
		}

		int[] dp = new int[amount + 1];
		// Fill the array with a higher invalid number
		Arrays.fill(dp, amount + 1);

		dp[0] = 0;

		for (int i = 1; i <= amount; i++) {
			// For each amount value iterate over all coins
			for (int j = 0; j < coins.length; j++) {
				// If the current coin value is less than the current amount, consider it
				if (coins[j] <= i) {
					// Add 1 for considering the coin
					dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
				}
			}

		}

		return dp[amount] > amount ? -1 : dp[amount];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// int[] coins = {1, 2, 5};
		int[] coins = { 1 };
		// int amount = 11;
		int amount = 2;
		int result = new CoinChange().coinChange(coins, amount);
		System.out.println(result);
	}

}
