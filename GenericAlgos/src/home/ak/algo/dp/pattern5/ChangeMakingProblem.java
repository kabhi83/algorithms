/**
 * 
 */
package home.ak.algo.dp.pattern5;

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
 *         Input: coins = [1,2,5], amount = 11 Output: 3
 * 
 *         Explanation: 11 = 5 + 5 + 1
 * 
 *         States: i -> index of the coin and w -> amount
 *
 */
public class ChangeMakingProblem {

	public static int minimumCoins(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, amount + 1);
		/*
		 * Never use Integer.MAX_VALUE here. Adding 1 + Integer.MAX_VALUE results in a
		 * negative value
		 */
		
		// Base case
		dp[0] = 0; // If amount is 0, coins required is also 0

		for (int i = 1; i <= amount; i++) {
			for (int j = 0; j < coins.length; j++) {
				// For each i, check the best value by using all possible j
				if (i >= coins[j])
					dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
			}
		}

		return dp[amount] > amount ? -1 : dp[amount];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] coins = { 1, 2, 5 };
		//int[] coins = { 2 };
		System.out.println(minimumCoins(coins, 11));

	}

}
