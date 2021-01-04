/**
 * 
 */
package home.ak.algo.dp.pattern3;

import java.util.Arrays;

/**
 * @author kundu
 * 
 *         Given a number sequence, find the length of its Longest Bitonic
 *         Subsequence (LBS). A subsequence is considered bitonic if it is
 *         monotonically increasing and then monotonically decreasing.
 * 
 *         Example 1: Input: {4,2,3,6,10,1,12} Output: 5 Explanation: The LBS is
 *         {2,3,6,10,1}.
 * 
 *         Example 2: Input: {4,2,5,9,7,6,10,3,1} Output: 7 Explanation: The LBS
 *         is {4,5,9,7,6,3,1}.
 *
 */
public class LongestBitonicSubsequence {

	/**
	 * LDS -> Longest Decreasing Sequence
	 * 
	 * Find LDS starting from ‘i’ to the end of the array.
	 * 
	 * Find LDS starting from ‘i’ to the beginning of the array.
	 */
	public static int findLBSLengthRecursive(int[] nums) {
		int maxLength = 0;
		for (int i = 0; i < nums.length; i++) {
			int c1 = findLDSLength(nums, i, -1);
			int c2 = findLDSLengthRev(nums, i, -1);
			maxLength = Math.max(maxLength, c1 + c2 - 1);
		}
		return maxLength;
	}

	// find the LDS from currentIndex till the end of the array
	private static int findLDSLength(int[] nums, int currIdx, int prevIdx) {
		// Base Case: Stopping condition
		if (currIdx == nums.length)
			return 0;
		// include the number if it is smaller than the previous number
		int c1 = 0;
		if (prevIdx == -1 || nums[currIdx] < nums[prevIdx]) {
			c1 = 1 + findLDSLength(nums, currIdx + 1, currIdx);
		}

		// excluding the number
		int c2 = findLDSLength(nums, currIdx + 1, prevIdx);

		return Math.max(c1, c2);
	}

	// find the LDS from currentIndex till the beginning of the array
	private static int findLDSLengthRev(int[] nums, int currIdx, int prevIdx) {
		// Base Case
		if (currIdx < 0)
			return 0;

		// include the number if it is smaller than the previous number
		int c1 = 0;
		if (prevIdx == -1 || nums[currIdx] < nums[prevIdx])
			c1 = 1 + findLDSLengthRev(nums, currIdx - 1, currIdx);

		// excluding the number at currentIndex
		int c2 = findLDSLengthRev(nums, currIdx - 1, prevIdx);

		return Math.max(c1, c2);
	}

	public static int findLBSLength(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n];
		int[] dpRev = new int[n];

		// Minimum LDS is 1
		Arrays.fill(dp, 1);
		Arrays.fill(dpRev, 1);

		// Compute from start to end
		for (int i = 1; i < n; i++) {
			for (int j = i - 1; j >= 0; j--) {
				int lds = dp[j];
				if (nums[j] < nums[i]) {
					lds += 1;
					dp[i] = Math.max(lds, dp[i]);
				}
			}
		}

		// Compute from end to start
		for (int i = n - 2; i >= 0; i--) {
			for (int j = i + 1; j < n; j++) {
				int lds = dpRev[j];
				if (nums[j] < nums[i]) {
					lds += 1;
					dpRev[i] = Math.max(lds, dpRev[i]);
				}
			}
		}

		int maxLength = 0;
		for (int i = 0; i < n; i++) {
			maxLength = Math.max(maxLength, dp[i] + dpRev[i] - 1);
		}

		return maxLength;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = { 4, 2, 3, 6, 10, 1, 12 };
		System.out.println(findLBSLength(nums));
	}

}
