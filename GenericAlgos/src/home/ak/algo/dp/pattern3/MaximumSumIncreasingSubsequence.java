/**
 * 
 */
package home.ak.algo.dp.pattern3;

/**
 * @author kundu
 * 
 *         Given a number sequence, find the increasing subsequence with the
 *         highest sum. Write a method that returns the highest sum.
 * 
 *         Example 1: Input: {4,1,2,6,10,1,12} Output: 32 Explanation: The
 *         increasing sequence is {4,6,10,12}. Please note the difference, as
 *         the LIS is {1,2,6,10,12} which has a sum of '31'.
 * 
 *         Example 2: Input: {-4,10,3,7,15} Output: 25 Explanation: The
 *         increasing sequences are {10, 15} and {3,7,15}.
 *
 */
public class MaximumSumIncreasingSubsequence {

	public static int findMSISRecursive(int[] nums) {
		return findMSISRecursive(nums, 0, -1, 0);
	}

	private static int findMSISRecursive(int[] nums, int currIdx, int prevIdx, int sum) {
		// Base Case: to stop the processing
		if (currIdx == nums.length) {
			return sum;
		}

		int s1 = sum;
		// Include the number at current index
		if (prevIdx == -1 || nums[currIdx] > nums[prevIdx]) {
			s1 = findMSISRecursive(nums, currIdx + 1, currIdx, sum + nums[currIdx]);
		}
		// Exclude the number at current index
		int s2 = findMSISRecursive(nums, currIdx + 1, prevIdx, sum);

		return Math.max(s1, s2);
	}

	public static int findMSIS(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}

		// Initialize DP array
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		int maxVal = dp[0];
		for (int i = 1; i < nums.length; i++) {
			dp[i] = nums[i];
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j] && dp[i] < dp[j] + nums[i]) {
					dp[i] = dp[j] + nums[i];
					maxVal = Math.max(maxVal, dp[i]);
				}
			}
		}

		return maxVal;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = { 4, 1, 2, 6, 10, 1, 12 };
		System.out.println(findMSISRecursive(nums));
		System.out.println(findMSIS(nums));

	}

}
