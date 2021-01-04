/**
 * 
 */
package home.ak.algo.array;

import java.util.Arrays;

/**
 * @author kundu
 * 
 *         Given an array nums of n integers and an integer target, find three
 *         integers in nums such that the sum is closest to target. Return the
 *         sum of the three integers. You may assume that each input would have
 *         exactly one solution.
 * 
 *         Example 1:Input: nums = [-1,2,1,-4], target = 1 Output: 2
 *         Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1
 *         = 2).
 *
 */
public class ThreeSumClosest {

	public int threeSumClosest(int[] nums, int target) {
		if (nums.length == 0 || nums == null)
			throw new IllegalArgumentException("Invalid Input");

		// Sort the numbers
		Arrays.sort(nums);
		int closest = nums[0] + nums[1] + nums[2];
		for (int i = 0; i < nums.length; i++) {
			int left = i + 1;
			int right = nums.length - 1;
			// Execute 2 sum technique
			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				if (Math.abs(sum - target) < Math.abs(closest - target)) {
					closest = sum;
				}

				if (sum == target) {
					return sum;
				} else if (sum < target) {
					left++;
				} else {
					right--;
				}
			}
		}
		return closest;
	}
	
	public static void main(String[] args) {
		int[] nums = {-1,2,1,-4};
		System.out.println(new ThreeSumClosest().threeSumClosest(nums, 1));
	}

}
