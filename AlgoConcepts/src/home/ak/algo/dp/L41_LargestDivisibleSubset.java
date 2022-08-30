/**
 * 
 */
package home.ak.algo.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kundu
 * 
 *         Given a set of distinct positive integers nums, return the largest
 *         subset answer such that every pair (answer[i], answer[j]) of elements
 *         in this subset satisfies:
 * 
 *         answer[i] % answer[j] == 0, or
 * 
 *         answer[j] % answer[i] == 0
 * 
 *         If there are multiple solutions, return any of them.
 * 
 */
public class L41_LargestDivisibleSubset {

	public static List<Integer> largestDivisibleSubset(int[] nums) {
		List<Integer> result = new ArrayList<>();

		// Note; If a number is divisible by a previous number, it is expected to be
		// divisible by all its previous number too. Hence we have to sort the nums
		Arrays.sort(nums);
		int[] dp = new int[nums.length];
		Arrays.fill(dp, 1);

		int[] indexes = new int[nums.length];
		Arrays.fill(indexes, -1);
		for (int curr = 1; curr < nums.length; curr++) {
			for (int prev = 0; prev < curr; prev++) {
				if (nums[curr] % nums[prev] == 0 && (1 + dp[prev]) > dp[curr]) {
					dp[curr] = 1 + dp[prev];
					indexes[curr] = prev;
				}
			}
		}
		// lds=longest divisible subsequence
		int lds = Arrays.stream(dp).max().getAsInt(); // Same as LIS
		// Find the index of the max element
		int idx = 0; // index of the max value to start the search
		for (int i = 0; i < nums.length; i++) {
			if (dp[i] == lds) {
				idx = i;
				break;
			}
		}

		while (idx != -1) {
			result.add(nums[idx]);
			idx = indexes[idx];
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 16, 7, 8, 4 };
		System.out.println(largestDivisibleSubset(nums));
	}
}
