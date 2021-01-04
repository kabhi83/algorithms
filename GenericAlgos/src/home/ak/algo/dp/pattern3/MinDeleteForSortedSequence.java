/**
 * 
 */
package home.ak.algo.dp.pattern3;

import java.util.Arrays;

/**
 * @author kundu
 * 
 *         Given a number sequence, find the minimum number of elements that
 *         should be deleted to make the remaining sequence sorted.
 * 
 *         Example 1: Input: {4,2,3,6,10,1,12} Output: 2 Explanation: We need to
 *         delete {4,1} to make the remaining sequence sorted {2,3,6,10,12}.
 * 
 *         Example 2: Input: {-4,10,3,7,15} Output: 1 Explanation: We need to
 *         delete {10} to make the remaining sequence sorted {-4,3,7,15}.
 * 
 */
public class MinDeleteForSortedSequence {

	/**
	 * We can convert this problem into a Longest Increasing Subsequence (LIS)
	 * problem. Length-of-input-array - LIS()
	 */
	public static int minDeletionsForSortedSequence(int[] nums) {

		// Find the longest increasing sequence
		int[] dp = new int[nums.length];

		// Minimum length of the LCS is 1
		Arrays.fill(dp, 1);

		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				int lis = dp[j];
				if (nums[i] > nums[j]) {
					lis += 1;
					dp[i] = Math.max(lis, dp[i]);
				}
			}
		}

		return nums.length - dp[nums.length - 1];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = { 4, 2, 3, 6, 10, 1, 12 };
		System.out.println(minDeletionsForSortedSequence(nums));

	}

}
