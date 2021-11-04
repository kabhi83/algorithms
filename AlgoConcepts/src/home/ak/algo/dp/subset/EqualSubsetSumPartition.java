package home.ak.algo.dp.subset;

import java.util.Arrays;

/**
 * @author kundu
 *
 *         Given a set of positive numbers, find if we can partition it into two
 *         subsets such that the sum of elements in both the subsets is equal.
 */
public class EqualSubsetSumPartition {

	/**
	 * Combination of Knapsack and Subset Sum problem
	 */
	static boolean canPartitionBU(int[] nums) {
		int sum = Arrays.stream(nums).sum();
		if (sum % 2 != 0) {
			// Cannot be partitioned into equal sum subsets
			return false;
		}

		// Updated sum value
		sum /= 2;

		boolean[][] dp = new boolean[nums.length + 1][sum + 1];

		for (int i = 0; i <= nums.length; i++) {
			dp[i][0] = true;
		}

		// Inclusion goes to subset 1 and exclusion goes to subset 2
		for (int i = 1; i <= nums.length; i++) {
			for (int s = 1; s <= sum; s++) {
				if (nums[i - 1] > s) { // exclude
					dp[i][s] = dp[i - 1][s];
				} else if (nums[i - 1] == s) { //exact match
					dp[i][s] = true;
				} else {
					dp[i][s] = dp[i - 1][s - nums[i - 1]] || dp[i - 1][s];
				}
			}
		}

		return dp[nums.length][sum];
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4 };
		System.out.println(canPartitionBU(nums));
		nums = new int[] { 1, 1, 3, 4, 7 };
		System.out.println(canPartitionBU(nums));
		nums = new int[] { 2, 3, 4, 6 };
		System.out.println(canPartitionBU(nums));
	}
}
