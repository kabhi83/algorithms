/**
 * 
 */
package home.ak.algo.dp;

import java.util.Arrays;

/**
 * @author kundu
 *
 *         Given an array ‘ARR’, partition it into two subsets such that their
 *         union is the original array. Let the sum of the elements of these two
 *         subsets be ‘S1’ and ‘S2’. Given a difference ‘D’, count the number of
 *         partitions in which ‘S1’ is greater than or equal to ‘S2’ and the
 *         difference between ‘S1’ and ‘S2’ is equal to ‘D’. Since the answer
 *         may be too large, return it modulo ‘10^9 + 7’.
 * 
 *         Constraints: 1 <= N <= 50 and 0 <= D <= 2500 and 0 <= ARR[i] <= 50
 */
public class L18_SubsetPartitionWithDifference {

	static int mod = (int) (Math.pow(10, 9) + 7);

	public static int countPartitionsTD(int[] arr, int n, int d) {
		int totalSum = Arrays.stream(arr).sum();
		// totalSum = s1 + s2
		// s1 - s2 = d
		// s1 = s2 + d
		// totalSum = s2 + d + s2 = 2s2 + d
		// s2 = (totalSum - d)/2 -> we are looking for a subsets with this target
		// Checking for edge cases
		if (totalSum - d < 0)
			return 0;
		if ((totalSum - d) % 2 == 1)
			return 0;

		int s2 = (totalSum - d) / 2;

		int dp[][] = new int[n][s2 + 1];

		for (int row[] : dp) {
			Arrays.fill(row, -1);
		}

		return countPartitionsTD(arr, n - 1, s2, dp);
	}

	private static int countPartitionsTD(int[] arr, int idx, int target, int[][] dp) {
		// Base case - Modified as the array can contain 0's
		if (idx == 0) {
			if (target == 0 && arr[0] == 0)
				return 2; // 1 for take and 1 for noTake
			if (target == 0 || target == arr[0])
				return 1; // target == 0 -> noTake & target == arr[0] -> take
			return 0;
		}
		if (dp[idx][target] != -1) {
			return dp[idx][target];
		}
		int noTake = countPartitionsTD(arr, idx - 1, target, dp);
		int take = 0;
		if (arr[idx] <= target) {
			take = countPartitionsTD(arr, idx - 1, target - arr[idx], dp);
		}
		return dp[idx][target] = (take + noTake) % mod;
	}

	public static int countPartitionsBU(int[] arr, int n, int d) {
		int totalSum = Arrays.stream(arr).sum();
		if (totalSum - d < 0)
			return 0;
		if ((totalSum - d) % 2 == 1)
			return 0;

		int target = (totalSum - d) / 2;

		int[][] dp = new int[n][target + 1];

		// base cases
		if (arr[0] == 0) {
			dp[0][0] = 2; // Both pick and no pick
		} else {
			dp[0][0] = 1; // no pick -> arr[0] != 0 and target is already 0
		}

		if (arr[0] != 0 && arr[0] <= target) {
			dp[0][arr[0]] = 1; // 1 case -pick
		}
		// special case
		if (arr[0] != 0 && arr[0] <= target) {
			dp[0][arr[0]] = 1;
		}

		for (int idx = 1; idx < n; idx++) {
			for (int tar = 0; tar <= target; tar++) {
				int noPick = dp[idx - 1][tar];
				int pick = 0;
				if (arr[idx] <= tar) {
					pick = dp[idx - 1][tar - arr[idx]];
				}
				dp[idx][tar] = noPick + pick;
			}
		}

		return dp[n - 1][target];
	}

	public static void main(String[] args) {
		int[] arr = { 1, 1, 1, 1 };
		int d = 0;
		System.out.println(countPartitionsTD(arr, arr.length, d));
		System.out.println(countPartitionsBU(arr, arr.length, d));

		arr = new int[] { 5, 2, 6, 4 };
		d = 3;
		System.out.println(countPartitionsTD(arr, arr.length, d));
		System.out.println(countPartitionsBU(arr, arr.length, d));
	}

}
