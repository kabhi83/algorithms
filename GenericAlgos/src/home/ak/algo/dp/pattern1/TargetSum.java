/**
 * 
 */
package home.ak.algo.dp.pattern1;

import java.util.Arrays;

/**
 * @author kundu
 * 
 *         Given a set of positive numbers (non zero) and a target sum ‘S’. Each
 *         number should be assigned either a ‘+’ or ‘-’ sign. We need to find
 *         out total ways to assign symbols to make the sum of numbers equal to
 *         target ‘S’.
 * 
 *         Example 1: # Input: {1, 1, 2, 3}, S=1. Output: 3. Explanation: The
 *         given set has '3' ways to make a sum of '1': {+1-1-2+3} & {-1+1-2+3}
 *         & {+1+1+2-3}
 * 
 *         Example 2: # Input: {1, 2, 7, 1}, S=9. Output: 2. Explanation: The
 *         given set has '2' ways to make a sum of '9': {+1+2+7-1} & {-1+2+7+1}
 *
 */
public class TargetSum {

	/**
	 * Let us assume all +ve values as one subset (S1) and all -ve values as another
	 * subset (S2). Hence S1 - S2 = S. We also know, S1 + S2 = Sum. By combining
	 * both, we get(S1 - S2) + (S1 + S2) = S + Sum or 2* S1 = S + Sum.
	 * 
	 * Hence S1 = (S + Sum) /2
	 */
	public static int findTargetSubsets(int[] nums, int S) {
		int totalSum = Arrays.stream(nums).sum();

		// if 's + totalSum' is odd, we can't find a subset with sum equal to the value
		// of '(s +totalSum) / 2'
		if (totalSum < S || (S + totalSum) % 2 == 1)
			return 0;

		return countSubsets(nums, (S + totalSum) / 2);
	}

	private static int countSubsets(int[] nums, int sum) {
		int n = nums.length;
		int[] dp = new int[sum + 1];
		dp[0] = 1;

		// with only one number, we can form a subset only when the required sum is
		// equal to the number
		for (int s = 1; s <= sum; s++) {
			dp[s] = (nums[0] == s ? 1 : 0);
		}

		// process all subsets for all sums
		for (int i = 1; i < n; i++) {
			for (int s = sum; s >= 0; s--) {
				if (s >= nums[i])
					dp[s] += dp[s - nums[i]];
			}
		}

		return dp[sum];
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 1, 2, 3};
		System.out.println(findTargetSubsets(nums, 1));
	}

}
