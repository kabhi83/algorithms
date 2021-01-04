/**
 * 
 */
package home.ak.algo.dp.pattern4;

import java.util.Arrays;

/**
 * @author kundu
 * 
 *         Given an array of non negative integers, start from the first element
 *         and reach the last by jumping. The jump length can be at most the
 *         value at the current position in the array. Optimum result is when
 *         you reach the goal in minimum number of jumps.
 * 
 *         state: i -> index of the current location, j -> jumps to reach i
 *
 */
public class MinimumJumpProblem {

	/**
	 */
	public static int minimumJumpBU(int[] arr) {
		if (arr[0] == 0) {
			return -1;
		}
		int[] dp = new int[arr.length];
		Arrays.fill(dp, Integer.MAX_VALUE - 1);
		// Base case: Jump to start index is 0
		dp[0] = 0;

		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				// Check if i reachable from j
				// Minimum jump to reach j plus the value at j
				if (j + arr[j] >= i) {
					dp[i] = Math.min(dp[i], 1 + dp[j]);
				}
			}
		}
		return dp[arr.length - 1] == Integer.MAX_VALUE ? -1 : dp[arr.length - 1];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[] = { 1, 3, 4, 8, 9 };
		// int arr[] = { 1, 3, 5, 3, 2, 2, 6, 1, 6, 8, 9 };
		System.out.println(minimumJumpBU(arr));
	}

}
