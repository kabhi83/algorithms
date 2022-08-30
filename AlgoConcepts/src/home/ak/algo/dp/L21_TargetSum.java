/**
 * 
 */
package home.ak.algo.dp;

import java.util.Arrays;

/**
 * @author kundu
 *
 */
public class L21_TargetSum {

	static int sum;

	public static int findTargetSumWaysTD(int[] nums, int target) {
		int currSum = 0;
		int n = nums.length;
		sum = Arrays.stream(nums).sum();
		int[][] dp = new int[n][2 * sum + 1]; // For max range of all -'s and all +'s
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}
		return findTargetSumWaysTD(nums, n - 1, currSum, target, dp);
	}

	private static int findTargetSumWaysTD(int[] nums, int idx, int currSum, int target, int[][] dp) {
		// Base case
		if (idx == -1) {
			if (currSum == target) {
				return 1;
			} else {
				return 0;
			}
		}
		if (dp[idx][currSum + sum] != -1) {
			return dp[idx][currSum + sum];
		}
		int positive = findTargetSumWaysTD(nums, idx - 1, currSum + nums[idx], target, dp);
		int negative = findTargetSumWaysTD(nums, idx - 1, currSum - nums[idx], target, dp);

		return dp[idx][currSum + sum] = positive + negative;
	}

	/**
	 * This problem is alternate to the subset partition with difference problem
	 * Target = S1 - S2 = D
	 */
	public static int findTargetSumWaysBU(int[] nums, int target) {
		int sum = Arrays.stream(nums).sum();
		int n = nums.length;
		//target = s1 - s2
		//sum = s1 + s2
		//sum = target + s2 + s2 => 2(s2) = sum - target
		if ((sum - target) < 0) {
			return 0;
		}
		if((sum - target)%2 != 0) {
			return 0;
		}

		int subsetDiff = (sum - target) / 2;

		int[][] dp = new int[n][subsetDiff + 1];

		// base cases
		if (nums[0] == 0) {
			dp[0][0] = 2; // Both pick and no pick
		} else {
			dp[0][0] = 1; // no pick -> nums[0] != 0 and target is already 0
		}

		if (nums[0] != 0 && nums[0] <= subsetDiff) {
			dp[0][nums[0]] = 1; // 1 case -pick
		}
		// special case
		if (nums[0] != 0 && nums[0] <= subsetDiff) {
			dp[0][nums[0]] = 1;
		}

		for (int idx = 1; idx < n; idx++) {
			for (int tar = 0; tar <= subsetDiff; tar++) {
				int noPick = dp[idx - 1][tar];
				int pick = 0;
				if (nums[idx] <= tar) {
					pick = dp[idx - 1][tar - nums[idx]];
				}
				dp[idx][tar] = noPick + pick;
			}
		}

		return dp[n - 1][subsetDiff];
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 1 };
		int target = 3;
		System.out.println(findTargetSumWaysTD(nums, target));
		System.out.println(findTargetSumWaysBU(nums, target));
	}

}
