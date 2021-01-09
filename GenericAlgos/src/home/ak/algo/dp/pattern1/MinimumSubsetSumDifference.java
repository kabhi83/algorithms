/**
 * 
 */
package home.ak.algo.dp.pattern1;

import java.util.Arrays;

/**
 * @author kundu
 * 
 *         Given a set of positive numbers, partition the set into two subsets
 *         with a minimum difference between their subset sums.
 * 
 *         Example 1: # Input: {1, 2, 3, 9} Output: 3 Explanation: We can
 *         partition the given set into two subsets where minimum absolute
 *         difference between the sum of numbers is '3'. Following are the two
 *         subsets: {1, 2, 3} & {9}.
 * 
 *         Example 2: # Input: {1, 2, 7, 1, 5} Output: 0 Explanation: We can
 *         partition the given set into two subsets where minimum absolute
 *         difference between the sum of number is '0'. Following are the two
 *         subsets: {1, 2, 5} & {7, 1}.
 * 
 *         Hint: For recursive solution - for each number 'i'
 * 
 *         1. add number 'i' to S1 and recursively process the remaining numbers
 *         2. add number 'i' to S2 and recursively process the remaining numbers
 *         return the minimum absolute difference of the above two sets
 *
 */
public class MinimumSubsetSumDifference {

	public static int minSubsetSumDiffRec(int[] nums) {
		return minSubsetSumDiffRec(nums, 0, 0, 0);
	}

	private static int minSubsetSumDiffRec(int[] nums, int index, int sum1, int sum2) {
		// Base case
		if (index >= nums.length) {
			return Math.abs(sum1 - sum2);
		}

		// recursive call after including the number at the currentIndex in the first
		// set
		int diff1 = minSubsetSumDiffRec(nums, index + 1, sum1 + nums[index], sum2);

		// recursive call after including the number at the currentIndex in the second
		// set
		int diff2 = minSubsetSumDiffRec(nums, index + 1, sum1, sum2 + nums[index]);

		return Math.min(diff1, diff2);
	}

	/**
	 * we are trying to achieve in this problem is to find a subset whose sum is as
	 * close to ‘S/2’ as possible, because if we can partition the given set into
	 * two subsets of an equal sum, we get the minimum difference i.e. zero.
	 */
	public static int minSubsetSumDiff(int[] nums) {
		int sum = Arrays.stream(nums).sum();
		int n = nums.length;

		// Initialize the dp array
		boolean[][] dp = new boolean[n][(sum / 2) + 1];
		// populate the sum=0 columns, as we can always form '0' sum with an empty set
		for (int i = 0; i < n; i++) {
			dp[i][0] = true;
		}

		for (int s = 1; s <= sum / 2; s++) {
			dp[0][s] = nums[0] == s ? true : false;
		}

		// process all subsets for all sums
		for (int i = 1; i < nums.length; i++) {
			for (int s = 1; s <= sum / 2; s++) {
				// if we can get the sum 's' without the number at index 'i'
				if (dp[i - 1][s]) {
					dp[i][s] = dp[i - 1][s];
				} else if (s >= nums[i]) {
					// else include the number and see if we can find a subset to get the remaining
					// sum
					dp[i][s] = dp[i - 1][s - nums[i]];
				}
			}
		}

		// Find the largest index in the last row which is true
		// this is the largest sub array sum possible
		int sum1 = 0;
		for (int i = sum / 2; i >= 0; i--) {
			if (dp[n - 1][i] == true) {
				sum1 = i;
				break;
			}
		}

		int sum2 = sum - sum1;

		return Math.abs(sum1 - sum2);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 9 };
		System.out.println(minSubsetSumDiff(nums));
		nums = new int[] { 1, 2, 7, 1, 5 };
		System.out.println(minSubsetSumDiff(nums));
		nums = new int[] { 1, 3, 100, 4 };
		System.out.println(minSubsetSumDiff(nums));

	}

}
