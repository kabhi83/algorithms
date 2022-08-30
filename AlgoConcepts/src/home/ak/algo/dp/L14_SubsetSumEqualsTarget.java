package home.ak.algo.dp;

import java.util.Arrays;

/**
 * @author kundu
 * 
 *         You are given an array/list ‘ARR’ of ‘N’ positive integers and an
 *         integer ‘K’. Your task is to check if there exists a subset in ‘ARR’
 *         with a sum equal to ‘K’. Note: Return true if there exists a subset
 *         with sum equal to ‘K’. Otherwise, return false.
 * 
 *         For Example : If ‘ARR’ is {1,2,3,4} and ‘K’ = 4, then there exists 2
 *         subsets with sum = 4. These are {1,3} and {4}. Hence, return true.
 *
 */
public class L14_SubsetSumEqualsTarget {

	public static boolean subsetSumToKTD(int arr[], int k) {
		int arrLen = arr.length - 1;
		int[][] dp = new int[arrLen][k + 1];
		// The size of the input array is ‘n’, so the index will always lie between ‘0’
		// and ‘n-1’. The target can take any value between ‘0’ and ‘k’. Therefore we
		// take the dp array as dp[n][k+1]
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}
		return subsetSumToKTD(arr, k, arrLen - 1, dp);
	}

	private static boolean subsetSumToKTD(int[] arr, int k, int idx, int[][] dp) {
		// Base cases
		if (k == 0) {
			return true;
		}
		if (idx == 0) {
			return arr[0] == k; // only if the number in last index is same as k
		}

		if (dp[idx][k] != -1) {
			// Cell is visited
			return dp[idx][k] == 0 ? false : true;
		}

		boolean notake = subsetSumToKTD(arr, k, idx - 1, dp);

		boolean take = false;
		if (k >= arr[idx]) {
			take = subsetSumToKTD(arr, k - arr[idx], idx - 1, dp);
		}
		dp[idx][k] = (take || notake) ? 1 : 0;
		return (take || notake);
	}

	/**
	 * Bottom up approach
	 * @param arr
	 * @param k
	 * @return
	 */
	public static boolean subsetSumToKBU(int arr[], int k) {
		int n = arr.length;
		boolean[][] dp = new boolean[n][k+1];
		for(int i = 0; i < n; i++) {
			//for any index if target is 0, then return true
			dp[i][0] = true;
		}
		dp[0][arr[0]] = true; // only if target matches the index value
		
		for(int idx = 1 ; idx < n ; idx++) {
			for(int target = 1; target <= k; target++) {
				boolean notake = dp[idx-1][target];

				boolean take = false;
				if (target >= arr[idx]) {
					take = dp[idx - 1][target - arr[idx]];
				}
				dp[idx][target] = take || notake;
			}
		}
		return dp[n-1][k];
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4 };
		System.out.println(subsetSumToKTD(arr, 4));
		System.out.println(subsetSumToKBU(arr, 4));
	}

}
