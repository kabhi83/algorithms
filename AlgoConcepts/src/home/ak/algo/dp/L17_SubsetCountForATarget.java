/**
 * 
 */
package home.ak.algo.dp;

import java.util.Arrays;

/**
 * @author kundu
 * 
 *         You are given an array (0-based indexing) of positive integers and
 *         you have to tell how many different ways of selecting the elements
 *         from the array are there such that the sum of chosen elements is
 *         equal to the target number “target”.
 *
 */
public class L17_SubsetCountForATarget {

	public static int subsetCountTD(int[] arr, int target) {
		int n = arr.length;
		int[][] dp = new int[n][target + 1]; // Since there are two changing parameters
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}
		return subsetCountTD(arr, n - 1, target, dp);
	}

	private static int subsetCountTD(int[] arr, int idx, int target, int[][] dp) {
		// Base cases
		if (target == 0) {
			return 1;
		}
		if (idx == 0) {
			return arr[0] == target ? 1 : 0;
		}

		// Memoize
		if (dp[idx][target] != -1) {
			return dp[idx][target];
		}

		// Pick and non-pick case
		int noPick = subsetCountTD(arr, idx - 1, target, dp);
		int pick = 0;
		if (arr[idx] <= target) {
			pick = subsetCountTD(arr, idx - 1, target - arr[idx], dp);
		}
		return dp[idx][target] = pick + noPick;
	}

	/**
	 * Bottom up solution - Tabulation
	 */
	public static int subsetCountBU(int[] arr, int target) {
		int n = arr.length;
		int[][] dp = new int[n][target + 1];

		for (int i = 0; i < n; i++) {
			// If target is 0, store 1
			dp[i][0] = 1;
		}

		// for 0th row, if the arr value equals target value
		if(arr[0] <= target) {
			dp[0][arr[0]] = 1;
		}
		
		for(int idx = 1; idx < n; idx++) {
			for(int tar = 0; tar <= target; tar++) {
				int noPick = dp[idx - 1][tar];
				int pick = 0;
				if(arr[idx] <= tar) {
					pick = dp[idx - 1][tar - arr[idx]];
				}
				dp[idx][tar] = pick + noPick;
			}
		}
		return dp[n-1][target];
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 2, 3 };
		int target = 3;
		System.out.println(subsetCountTD(arr, target));
		System.out.println(subsetCountBU(arr, target));
	}

}
