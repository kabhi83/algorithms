/**
 * 
 */
package home.ak.algo.dp;

import java.util.Arrays;

/**
 * @author kundu
 * 
 *         You are a professional robber planning to rob houses along a street.
 *         Each house has a certain amount of money stashed, the only constraint
 *         stopping you from robbing each of them is that adjacent houses have
 *         security systems connected and it will automatically contact the
 *         police if two adjacent houses were broken into on the same night.
 * 
 *         Given an integer array nums representing the amount of money of each
 *         house, return the maximum amount of money you can rob tonight without
 *         alerting the police.
 * 
 *         Similar Problem - Maximum sum of the subsequence with the constraint
 *         that no two elements are adjacent in the given array/list
 * 
 *         Example: Input: nums = [2,7,9,3,1] Output: 12
 * 
 *         Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob
 *         house 5 (money = 1). Total amount you can rob = 2 + 9 + 1 = 12.
 *
 */
public class L05_HouseRobber {

	public static int robTD(int[] nums) {
		int[] dp = new int[nums.length];
		Arrays.fill(dp, -1);
		return robTD(nums.length - 1, nums, dp);
	}

	private static int robTD(int idx, int[] nums, int[] dp) {
		// Base case
		if (idx == 0) {
			// reached the last house - picking it will get max value always
			return nums[0];
		}
		if (idx < 0) {
			// Invalid index - always return 0
			return 0;
		}

		if (dp[idx] != -1) {
			return dp[idx];
		}

		int pick = robTD(idx - 2, nums, dp) + nums[idx];
		int notPick = robTD(idx - 1, nums, dp) + 0;
		return dp[idx] = Math.max(pick, notPick);
	}

	public static int robBU(int[] nums) {
		int[] dp = new int[nums.length];
		dp[0] = nums[0]; // In case we reach the 0th index
		for (int i = 1; i < nums.length; i++) {
			int pick = nums[i];
			if (i > 1) {
				pick += dp[i - 2];
			}
			int noPick = dp[i - 1];
			dp[i] = Math.max(pick, noPick);
		}
		return dp[nums.length - 1];
	}

	public static int robBUOptimized(int[] nums) {
		int prev1 = nums[0]; // 0th index value
		int prev2 = 0;
		for (int i = 1; i < nums.length; i++) {
			int pick = nums[i];
			if (i > 1) {
				pick += prev2;
			}
			int noPick = prev1;
			int curr = Math.max(pick, noPick);
			prev2 = prev1;
			prev1 = curr;
		}
		return prev1;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 1, 3, 1, 9, 7 };
		System.out.println(robTD(nums));
		System.out.println(robBU(nums));
		System.out.println(robBUOptimized(nums));
	}

}
