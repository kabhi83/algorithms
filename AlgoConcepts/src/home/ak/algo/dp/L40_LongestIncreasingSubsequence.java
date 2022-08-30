/**
 * 
 */
package home.ak.algo.dp;

import java.util.Arrays;

/**
 * @author kundu
 *
 *         For a given array with N elements, you need to find the length of the
 *         longest subsequence from the array such that all the elements of the
 *         subsequence are sorted in strictly increasing order. Strictly
 *         Increasing Sequence is when each term in the sequence is larger than
 *         the preceding term. For Example: [1, 2, 3, 4] is a strictly
 *         increasing array, while [2, 1, 4, 3] is not.
 */
public class L40_LongestIncreasingSubsequence {

	public static int lisTD(int arr[]) {
		// We have to track both current and previous index to track the increase in
		// subsequence value
		int n = arr.length;
		int[][] dp = new int[n][n + 1];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}
		return lisTD(arr, 0, -1, dp); // prevIdx is set to -1 for the 0th element
	}

	private static int lisTD(int[] arr, int currIdx, int prevIdx, int[][] dp) {

		// Base case
		if (currIdx >= arr.length) {
			return 0;
		}
		if (dp[currIdx][prevIdx + 1] != -1) {
			return dp[currIdx][prevIdx + 1];
		}
		int noTake = 0 + lisTD(arr, currIdx + 1, prevIdx, dp); // prevIdx to remain same
		int take = 0;
		if (prevIdx == -1 || arr[currIdx] > arr[prevIdx]) {
			take = 1 + lisTD(arr, currIdx + 1, currIdx, dp);
		}
		return dp[currIdx][prevIdx + 1] = Math.max(noTake, take);
	}

	public static int lisBU(int arr[]) {
		int n = arr.length;
		int[][] dp = new int[n + 1][n + 1];

		for (int currIdx = n - 1; currIdx >= 0; currIdx--) {
			for (int prevIdx = currIdx - 1; prevIdx >= -1; prevIdx--) {
				int noTake = 0 + dp[currIdx + 1][prevIdx + 1]; // coordinate shift for prevIdx
				int take = 0;
				if (prevIdx == -1 || arr[currIdx] > arr[prevIdx]) {
					take = 1 + dp[currIdx + 1][currIdx];
				}
				dp[currIdx][prevIdx + 1] = Math.max(noTake, take);
			}
		}
		return dp[0][-1 + 1];
	}

	public static int lisOptimized(int arr[]) {
		int n = arr.length;
		int[] dp = new int[n];

		Arrays.fill(dp, 1); // default value of LIS

		for (int curr = 1; curr < n; curr++) {
			for (int prev = 0; prev < curr; prev++) {
				if (arr[curr] > arr[prev]) {
					dp[curr] = Math.max(dp[curr], 1 + dp[prev]); // 1 added to the length of prev subsequence
				}
			}
		}
		return Arrays.stream(dp).max().getAsInt();
	}

	public static void main(String[] args) {
		int[] arr = { 4, 2, 3, 6, 10, 1, 12 };
		System.out.println(lisTD(arr));
		System.out.println(lisBU(arr));
		System.out.println(lisOptimized(arr));

		arr = new int[] { -4, 10, 3, 7, 15 };
		System.out.println(lisTD(arr));
		System.out.println(lisBU(arr));
		System.out.println(lisOptimized(arr));
	}
}
