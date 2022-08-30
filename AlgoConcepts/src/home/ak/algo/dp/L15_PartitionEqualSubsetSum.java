/**
 * 
 */
package home.ak.algo.dp;

import java.util.Arrays;

/**
 * @author kundu
 * 
 *         You are given an array 'ARR' of 'N' positive integers. Your task is
 *         to find if we can partition the given array into two subsets such
 *         that the sum of elements in both subsets is equal.
 * 
 *         For example, let’s say the given array is [2, 3, 3, 3, 4, 5], then
 *         the array can be partitioned as [2, 3, 5], and [3, 3, 4] with equal
 *         sum 10.
 *
 */
public class L15_PartitionEqualSubsetSum {

	public static boolean canPartition(int[] arr, int n) {
		int sum = Arrays.stream(arr).sum();
		if (sum % 2 != 0) {
			return false;
		}
		int target = sum / 2;
		int[][] dp = new int[n][target + 1]; // target can range from 0 to target
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}
		return canPartition(arr, n - 1, target, dp);
	}

	private static boolean canPartition(int[] arr, int idx, int target, int[][] dp) {
		// Base cases
		if (target == 0) {
			return true;
		}
		if (idx == 0) {
			return arr[0] == target; // only if the number in last index is same as k
		}
		if (dp[idx][target] != -1) {
			return dp[idx][target] == 1 ? true : false;
		}
		boolean noTake = canPartition(arr, idx - 1, target, dp);

		boolean take = false;
		if (target >= arr[idx]) {
			take = canPartition(arr, idx - 1, target - arr[idx], dp);
		}
		dp[idx][target] = (take || noTake) ? 1 : 0;
		return (take || noTake);
	}

	public static void main(String[] args) {
		int[] arr = { 2, 3, 3, 3, 4, 5 };
		System.out.println(canPartition(arr, arr.length));
	}

}
