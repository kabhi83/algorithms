/**
 * 
 */
package home.ak.algo.dp;

import java.util.Arrays;

/**
 * @author kundu
 * 
 *         You are given an infinite supply of coins of each of denominations D
 *         = {D0, D1, D2, D3, ...... Dn-1}. You need to figure out the total
 *         number of ways W, in which you can make a change for value V using
 *         coins of denominations from D. Print 0, if a change isn't possible.
 *
 */
public class L22_WaysOfCoinChange {

	public static long countWaysToMakeChange(int[] coins, int value) {
		int n = coins.length;
		long[][] dp = new long[n][value + 1];
		for(long[] row: dp) {
			Arrays.fill(row, -1);
		}
		return countWaysToMakeChange(coins, n - 1, value, dp);
	}

	private static long countWaysToMakeChange(int[] coins, int idx, int value, long[][] dp) {
		// Base case
		if (idx == 0) {
			if ((value % coins[idx]) == 0) {
				return 1;
			} else {
				return 0;
			}
		}
		if(dp[idx][value] != -1) {
			return dp[idx][value];
		}
		long noTake = countWaysToMakeChange(coins, idx - 1, value, dp);
		long take = 0;
		if (coins[idx] <= value) {
			take = countWaysToMakeChange(coins, idx, value - coins[idx], dp);
		}
		return dp[idx][value]= (take + noTake);
	}
	
	public static void main(String[] args) {
		int[] coins = {1, 2, 3};
		int value = 4;
		System.out.println(countWaysToMakeChange(coins, value));
	}

}
