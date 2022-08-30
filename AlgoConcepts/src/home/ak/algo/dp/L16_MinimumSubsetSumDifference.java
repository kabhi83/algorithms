/**
 * 
 */
package home.ak.algo.dp;

import java.util.Arrays;

/**
 * @author kundu
 * 
 *         You are given an array containing N non-negative integers. Your task
 *         is to partition this array into two subsets such that the absolute
 *         difference between subset sums is minimum.
 * 
 *         Notes:
 * 
 *         1. Each element of the array should belong to exactly one of the
 *         subset.
 * 
 *         2. Subsets need not be contiguous always. For example, for the array
 *         : {1,2,3}, some of the possible divisions are a) {1,2} and {3} b)
 *         {1,3} and {2}.
 * 
 *         3. Subset-sum is the sum of all the elements in that subset.
 * 
 */
public class L16_MinimumSubsetSumDifference {

	/**
	 * Bottom up solution
	 */
	public static int minSubsetSumDifference(int[] arr, int n) {
		// Subset can include 0 to n items; hence subset sum can vary from 0 to Σ(n)
		int sum = Arrays.stream(arr).sum();

		/*
		 * Note: Every row in the dp array indicates if the target sum is achievable for
		 * that given index. Hence we will be comparing the last row of the dp array to
		 * compute the minimum absolute difference between the subset sum
		 */

		boolean[][] dp = new boolean[n][sum + 1];

		// base cases
		for (int i = 0; i < n; i++) {
			dp[i][0] = true;
		}
		dp[0][arr[0]] = true; // Only if the target matches the index value

		for (int idx = 1; idx < n; idx++) {
			for (int target = 1; target <= sum; target++) {
				boolean notake = dp[idx - 1][target];

				boolean take = false;
				if (target >= arr[idx]) {
					take = dp[idx - 1][target - arr[idx]];
				}
				dp[idx][target] = take || notake;
			}
		}

		int minDiff = Integer.MAX_VALUE;
		for (int s1 = 0; s1 < sum / 2; s1++) {
			// Comparing half the last row will get the result. s1 = sum - s2 and vice versa
			if (dp[n - 1][s1]) {
				minDiff = Math.min(minDiff, Math.abs(sum - s1) - s1); // s2 = sum - s1
			}
		}
		return minDiff;
	}

	public static void main(String[] args) {
		int[] arr = { 8, 6, 5 };
		System.out.println(minSubsetSumDifference(arr, arr.length));

		arr = new int[] { 3, 2, 7 };
		System.out.println(minSubsetSumDifference(arr, arr.length));
	}

}
