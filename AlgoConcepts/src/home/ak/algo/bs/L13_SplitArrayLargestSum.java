/**
 * 
 */
package home.ak.algo.bs;

import java.util.Arrays;

/**
 * @author kundu
 * 
 *         Given an array nums which consists of non-negative integers and an
 *         integer m, you can split the array into m non-empty continuous
 *         subarrays. Write an algorithm to minimize the largest sum among these
 *         m subarrays.
 * 
 *         Example 1:
 * 
 *         Input: nums = [7,2,5,10,8], m = 2 Output: 18 Explanation: There are
 *         four ways to split nums into two subarrays. The best way is to split
 *         it into [7,2,5] and [10,8], where the largest sum among the two
 *         subarrays is only 18.
 * 
 *         Concept - min of max sum ( min of max)
 *
 */
public class L13_SplitArrayLargestSum {

	/**
	 * Minimum possible sum is the max element when the number of subarrays is m = n
	 * and the maximum possible sum is sum of all the elements when the m = 1
	 */
	public static int splitArray(int[] nums, int m) {

		int start = Arrays.stream(nums).max().getAsInt();
		int end = Arrays.stream(nums).sum();
		int ans = end;
		while (start <= end) {
			int mid = (start + end) / 2;

			if (!canCreateMSubArrays(nums, mid, m)) {
				start = mid + 1;
			} else {
				ans = mid;
				end = mid - 1;
			}
		}

		return ans;
	}

	private static boolean canCreateMSubArrays(int[] nums, int limit, int m) {
		int subArrayCount = 1;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			// If greater than the limit it cannot be part of any subarray; hence increase
			// the limit
			if (nums[i] > limit) {
				return false;
			}
			sum += nums[i];
			if (sum > limit) {
				sum = nums[i];
				subArrayCount++;
			}
		}
		return subArrayCount <= m;
	}
	
	public static void main(String[] args) {
		int[] nums = {7,2,5,10,8};
		int m = 2;
		System.out.println(splitArray(nums, m));
	}

}
