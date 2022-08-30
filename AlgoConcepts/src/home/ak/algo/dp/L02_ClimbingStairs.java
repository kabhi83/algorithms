/**
 * 
 */
package home.ak.algo.dp;

import java.util.Arrays;

/**
 * @author kundu
 * 
 *         You are climbing a staircase. It takes n steps to reach the top.
 * 
 *         Each time you can either climb 1 or 2 steps. In how many distinct
 *         ways can you climb to the top?
 * 
 *         Concept:
 * 
 *         1. Try to represent the problem in terms of index
 * 
 *         2. Do all possible stuffs in that index according to the problem
 *         statement
 * 
 *         3. Follow below steps to close on the result
 * 
 *         i> For number of possible ways - sum all the stuffs.
 * 
 *         ii> For minimum - find the minimum of all stuffs
 *
 */
public class L02_ClimbingStairs {

	public static int climbStairsTD(int n) {
		int[] dp = new int[n + 1];
		Arrays.fill(dp, -1);
		return climbStairsTD(n, dp);
	}

	public static int climbStairsTD(int n, int[] dp) {
		// Base case
		if (n <= 1) {
			return 1; // for n = 0, there is only 1 way - no jump required
		}

		if (dp[n] != -1) {
			return dp[n];
		}

		return dp[n] = climbStairsTD(n - 1, dp) + climbStairsTD(n - 2, dp);
	}

	public static int climbStairsBU(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		return dp[n];
	}

}
