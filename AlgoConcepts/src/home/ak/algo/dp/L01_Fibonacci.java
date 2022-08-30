/**
 * 
 */
package home.ak.algo.dp;

import java.util.Arrays;

/**
 * @author kundu
 * 
 *         Overlapping sub-problems - When we solve same subproblem again and
 *         again
 * 
 *         Memoization - Tend to store the value of the subproblems in some
 *         map/table
 * 
 *         DP Problem identification -
 * 
 *         1. Count number of ways - all possible ways
 * 
 *         2. Minimum value/ maximum value
 *
 */
public class L01_Fibonacci {

	/**
	 * Top down approach - Recursion + Memoization
	 */
	public static int fibTD(int n) {
		int[] dp = new int[n + 1];
		Arrays.fill(dp, -1);
		return fibTD(n, dp);
	}

	private static int fibTD(int n, int[] dp) {
		// Base case
		if (n <= 1) {
			return n;
		}

		if (dp[n] != -1) {
			return dp[n];
		}

		return dp[n] = fibTD(n - 1, dp) + fibTD(n - 2, dp);
	}

	public static int fibBU(int n) {
		int[] dp = new int[n + 1];// n + 1, since we want the value of n starting from 0
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}

	public static int fibBUOptimized(int n) {
		int prev2 = 0;
		int prev1 = 1;
		for (int i = 2; i <= n; i++) {
			int curr = prev1 + prev2;

			// Re-initialization
			prev2 = prev1;
			prev1 = curr;
		}
		return prev1;
	}

	public static void main(String[] args) {
		System.out.println(fibTD(6));
		System.out.println(fibBU(6));
		System.out.println(fibBUOptimized(6));
	}

}
