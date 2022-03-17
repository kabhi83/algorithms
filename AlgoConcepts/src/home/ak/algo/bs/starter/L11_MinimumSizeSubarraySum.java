/**
 * 
 */
package home.ak.algo.bs.starter;

/**
 * @author kundu
 * 
 *         Given an array of positive integers nums and a positive integer
 *         target, return the minimal length of a contiguous subarray [nums_1,
 *         nums_2, ..., nums_n-1, nums_n] of which the sum is greater than or
 *         equal to target. If there is no such subarray, return 0 instead.
 * 
 *         Example: Input: target = 7, nums = [2,3,1,2,4,3] Output: 2
 *         Explanation: The subarray [4,3] has the minimal length under the
 *         problem constraint.
 * 
 *         Rules: This is the first problem on "Binary Search on Answers". This
 *         applies to monotonically increasing or decreasing function, where the
 *         size/ value increases with the inclusion of more input values.
 *
 */
public class L11_MinimumSizeSubarraySum {

	public static int minSubArrayLen(int[] nums, int target) {
		int start = 1, end = nums.length;
		boolean result = false;
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (possibleLength(nums, target, mid)) {
				// If mid value returns possible length, then anything bigger than mid will also
				// be possible
				result = true;
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		return result ? start : 0;
	}

	// Check if there exist a subarray of size k such that sum >= target
	private static boolean possibleLength(int[] nums, int target, int k) {
		int windowStart = 0;
		int windowSum = 0;
		int maxSum = Integer.MIN_VALUE;
		for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
			windowSum += nums[windowEnd];
			// Check if window size reached
			if (windowEnd - windowStart + 1 >= k) {
				maxSum = Math.max(maxSum, windowSum);
				// subtract the element going out and increment windowStart
				windowSum -= nums[windowStart++];
			}
		}
		return maxSum >= target;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 3, 1, 2, 4, 3 };
		System.out.println(minSubArrayLen(nums, 7));
	}

}
