/**
 * 
 */
package home.ak.algo.dp.subset;

import java.util.Arrays;

/**
 * @author kundu
 * 
 *         Given a set of positive numbers, partition the set into two subsets
 *         with a minimum difference between their subset sums.
 *
 */
public class MinimumSubsetSumDifference {

	public static int minSubsetSumDiffRecursive(int[] nums) {
		// Add the value at the current index recursively to both subset and find
		// minimum difference
		return minSubsetSumDiffRecursive(nums, 0, 0, 0);
	}

	private static int minSubsetSumDiffRecursive(int[] nums, int sum1, int sum2, int currIdx) {
		if (currIdx == nums.length) {
			return Math.abs(sum1 - sum2);
		}

		int diff1 = minSubsetSumDiffRecursive(nums, sum1 + nums[currIdx], sum2, currIdx + 1);
		int diff2 = minSubsetSumDiffRecursive(nums, sum1, sum2 + nums[currIdx], currIdx + 1);

		return Math.min(diff1, diff2);
	}

	/**
	 * Let’s assume ‘S’ represents the total sum of all the numbers. So what we are
	 * trying to achieve in this problem is to find a subset whose sum is as close
	 * to ‘S/2’ as possible, because if we can partition the given set into two
	 * subsets of an equal sum, we get the minimum difference i.e. zero. This
	 * transforms our problem to Subset Sum, where we try to find a subset whose sum
	 * is equal to a given number of ‘S/2’
	 */
	public static int minSubsetSumDiffBU(int[] nums) {
		int sum = Arrays.stream(nums).sum();

		// Initialize the DP array
		boolean[][] dp = new boolean[nums.length + 1][(sum / 2) + 1];

		// Initialize first column as true. 0 sum is possible with all elements.
		for (int i = 0; i <= nums.length; i++)
			dp[i][0] = true;

		// Initialize first row except dp[0][0], as false. With 0 elements, no other sum
		// except 0 is possible - This is implicit
		for (int s = 1; s < sum / 2 + 1; s++) {
			dp[0][s] = false;
		}

		// Try to find the subset sum which will result in minimum difference
		for (int i = 1; i <= nums.length; i++) {
			for (int s = 1; s <= sum / 2; s++) {
				dp[i][s] = dp[i - 1][s]; // Exclude from subset
				if (s >= nums[i - 1]) {
					dp[i][s] = dp[i - 1][s - nums[i - 1]]; // Include in the subset
				}
			}
		}

		// Find the largest index in the last row that is true. This is the largest one
		// subset sum achievable
		int sum1 = 0;
		for (int j = sum / 2; j >= 0; j--) {
			if (dp[nums.length][j] == true) {
				sum1 = j;
				break;
			}
		}
		int sum2 = sum - sum1;
		return Math.abs(sum2 - sum1);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 9 };
		System.out.println("Recursive solution: " + minSubsetSumDiffRecursive(nums));
		System.out.println("Bottom up solution: " + minSubsetSumDiffBU(nums));

		nums = new int[] { 1, 2, 7, 1, 5 };
		System.out.println("Recursive solution: " + minSubsetSumDiffRecursive(nums));
		System.out.println("Bottom up solution: " + minSubsetSumDiffBU(nums));
	}

}
