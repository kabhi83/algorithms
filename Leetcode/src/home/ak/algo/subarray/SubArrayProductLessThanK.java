/**
 * 
 */
package home.ak.algo.subarray;

/**
 * @author kundu
 * 
 *         Given an array of integers nums and an integer k, return the number
 *         of contiguous subarrays where the product of all the elements in the
 *         subarray is strictly less than k.
 * 
 *         Example 1: Input: nums = [10,5,2,6], k = 100 Output: 8
 * 
 *         Explanation: The 8 subarrays that have product less than 100 are:
 *         [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6] Note that
 *         [10, 5, 2] is not included as the product of 100 is not strictly less
 *         than k.
 * 
 *         Initially, we take 10 (1st element), then we take 5. Till the
 *         condition is valid, which is 50 < 100, we introduce 2 new sub-arrays
 *         to existing 10, i.e., [10, 5] & [5]
 *
 */
public class SubArrayProductLessThanK {

	public static int numSubarrayProductLessThanK(int[] nums, int k) {
		int counter = 0;
		int start = 0, product = 1;
		for (int end = 0; end < nums.length; end++) {
			product *= nums[end];
			// Validate the product value
			while (start < end && product >= k) {
				product /= nums[start];
				start++;
			}
			counter += end - start + 1;
			// with every valid product check, we are introducing same number of subarrays
		}
		return counter;
	}

	public static void main(String[] args) {
		int[] nums = {10,5,2,6};
		int k = 100;
		System.out.println(numSubarrayProductLessThanK(nums, k));
	}

}
