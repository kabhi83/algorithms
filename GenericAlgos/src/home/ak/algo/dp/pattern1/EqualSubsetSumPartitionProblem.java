/**
 * 
 */
package home.ak.algo.dp.pattern1;

import java.util.Arrays;

/**
 * @author kundu
 * 
 *         Given a set of positive numbers, find if we can partition it into two
 *         subsets such that the sum of elements in both the subsets is equal.
 *
 */
public class EqualSubsetSumPartitionProblem {

	/**
	 * Recursive solution by including an item at an index or ignoring the item
	 */
	static boolean canPartitionRecursive(int[] nums) {
		if (nums.length == 0) {
			return false;
		}
		// Find the sum
		int sum = Arrays.stream(nums).sum();
		if (sum % 2 == 1) {
			return false;
		}
		return canPartitionRecursive(nums, 0, sum / 2);
	}

	private static boolean canPartitionRecursive(int[] nums, int index, int sum) {
		// Base case
		if (sum == 0) {
			return true;
		}

		if (index >= nums.length) {
			return false;
		}
		// Consider the case of including the element
		if (nums[index] <= sum) {
			if (canPartitionRecursive(nums, index + 1, sum - nums[index])) {
				return true;
			}
		}
		// recursive call after excluding the number at the current index
		return canPartitionRecursive(nums, index + 1, sum);
	}

	public static boolean canPartition(int[] nums) {
		int n = nums.length;
		// Find the sum
		int sum = Arrays.stream(nums).sum();

		// if 'sum' is a an odd number, we can't have two subsets with equal sum
		if (sum % 2 == 1) {
			return false;
		}

		// Initialize DP Array for Bottom Up solution
		// we are trying to find a subset of given numbers that has a total sum of
		// ‘sum/2’.
		sum /= 2;
		boolean[][] dp = new boolean[n][sum + 1];

		// populate the sum=0 columns, as we can always form '0' sum with an empty set
		for (int i = 0; i < n; i++)
			dp[i][0] = true;

		// with only one number, we can form a subset only when the required sum is
		// equal to its value
		for (int s = 0; s <= sum; s++) {
			dp[0][s] = (nums[0] == s) ? true : false;
		}

		for (int i = 1; i < n; i++) {
			for (int s = 1; s <= sum; s++) {
				// if we can get the sum 's' without the number at index 'i'
				if (dp[i - 1][s]) {
					dp[i][s] = dp[i - 1][s];
				} else if (s >= nums[i]) { // else if we can find a subset to get the remaining sum
					dp[i][s] = dp[i - 1][s - nums[i]];
				}
			}

		}
		// the bottom-right corner will have our answer.
		return dp[n - 1][sum];
	}
	/*
	 * The above solution has time and space complexity of O(N*S), where ‘N’
	 * represents total numbers and ‘S’ is the total sum of all the numbers.
	 */

	public static void main(String[] args) {
		int[] nums = { 1, 5, 11, 5, 6, 7 };
		System.out.println(canPartitionRecursive(nums));
		System.out.println(canPartition(nums));
	}

}
