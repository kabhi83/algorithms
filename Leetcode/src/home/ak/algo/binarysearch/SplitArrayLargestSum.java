/**
 * 
 */
package home.ak.algo.binarysearch;

/**
 * @author kundu
 * 
 *         Given an array nums which consists of non-negative integers and an
 *         integer m, you can split the array into m non-empty continuous
 *         subarrays.
 * 
 *         Write an algorithm to minimize the largest sum among these m
 *         subarrays.
 * 
 *         Example 1: Input: nums = [7,2,5,10,8], m = 2 Output: 18 Explanation:
 *         There are four ways to split nums into two subarrays. The best way is
 *         to split it into [7,2,5] and [10,8], where the largest sum among the
 *         two subarrays is only 18.
 * 
 *         Example 2: Input: nums = [1,2,3,4,5], m = 2 Output: 9
 * 
 *         Example 3: Input: nums = [1,4,4], m = 3 Output: 4
 *
 */
public class SplitArrayLargestSum {

	/**
	 * Binary Search problem with lower bound when m = nums.length and upper bound
	 * when m = 1. Hence low = max value in the nums array and high = sum of all the
	 * elements
	 */
	public int splitArray(int[] nums, int m) {
		int max = 0, sum = 0;
		for (int num : nums) {
			sum += num;
			max = Math.max(max, num);
		}

		int low = max, high = sum;
		while (low < high) {
			int mid = low + (high - low) / 2;
			int splits = splits(nums, mid);
			if (splits > m) {
				// target value should go up to reduce the splits
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return low;
	}

	/**
	 * Greedy heuristic approach to figure out number of splits required
	 * [7,2,5][10][8] needs 3 splits to have max(subarray sum) <= 17
	 * 
	 * [7,2,5][10, 8] needs 2 splits to have max(subarray sum) <= 18
	 * 
	 * [7,2,5][10, 8] needs 2 splits to have max(subarray sum) <= 19
	 */
	private int splits(int[] nums, int target) {
		int splits = 1, sum = 0;
		for (int num : nums) {
			if (sum + num > target) { // Running sum greater than target
				splits++; // Increase the split
				sum = num; // Add the num to the next split
			} else {
				sum += num;
			}
		}
		return splits;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = { 7, 2, 5, 10, 8 };
		int result = new SplitArrayLargestSum().splitArray(nums, 2);
		System.out.println(result);

	}

}
