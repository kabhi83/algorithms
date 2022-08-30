package home.ak.algo.dp;

import java.util.Arrays;

/**
 * @author kundu
 * 
 *         Given a value V, if we want to make a change for V cents, and we have
 *         an infinite supply of each of C = { C1, C2, .., Cm} valued coins,
 *         what is the minimum number of coins to make the change? If it’s not
 *         possible to make a change, print -1.
 * 
 *         Recursive solution -> TC >= (2^n)
 *
 */
public class L20_MinimumNumberOfCoins {

	public static int minCoinsTD(int coins[], int V) {
		int n = coins.length;
		int[][] dp = new int[n][V + 1];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}
		int ans = minCoinsTD(coins, n - 1, V, dp);
		return ans >= (int) Math.pow(10, 9) ? -1 : ans;
	}

	private static int minCoinsTD(int[] coins, int idx, int V, int[][] dp) {
		if (V == 0) {
			return 0;
		}
		if (idx == 0) {
			if (V % coins[0] == 0) {
				return V / coins[0];
			} else {
				return (int) Math.pow(10, 9);
			}
		}
		if (dp[idx][V] != -1) {
			return dp[idx][V];
		}
		int noTake = 0 + minCoinsTD(coins, idx - 1, V, dp);
		int take = (int) Math.pow(10, 9);
		if (coins[idx] <= V) {
			take = 1 + minCoinsTD(coins, idx, V - coins[idx], dp);
		}
		return dp[idx][V] = Math.min(noTake, take);
	}

	public static int minCoinsBU(int coins[], int V) {
		int n = coins.length;
		int[][] dp = new int[n][V + 1];
		// Base case
		for (int i = 0; i <= V; i++) {
			if (i % coins[0] == 0) {
				dp[0][i] = (i / coins[0]);
			} else {
				dp[0][i] = (int) Math.pow(10, 9);
			}
		}

		for (int idx = 1; idx < n; idx++) {
			for (int val = 0; val <= V; val++) {
				int noTake = 0 + dp[idx - 1][val];
				int take = (int) Math.pow(10, 9);
				if (coins[idx] <= val) {
					take = 1 +  dp[idx][val - coins[idx]];
				}
				dp[idx][val] = Math.min(noTake, take);
			}
		}
		return dp[n - 1][V];
	}

	public static void main(String[] args) {
		int coins[] = { 9, 6, 5, 1 };
		int V = 11;
		System.out.println(minCoinsTD(coins, V));
		System.out.println(minCoinsBU(coins, V));

		coins = new int[] { 2, 1, 5 };
		V = 8;
		System.out.println(minCoinsTD(coins, V));
		System.out.println(minCoinsBU(coins, V));

	}

}
