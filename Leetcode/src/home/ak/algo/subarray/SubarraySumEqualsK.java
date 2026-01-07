/**
 * 
 */
package home.ak.algo.subarray;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kundu
 * 
 *         Given an array of integers nums and an integer k, return the total
 *         number of subarrays whose sum equals to k.
 * 
 *         A subarray is a contiguous non-empty sequence of elements within an
 *         array.
 * 
 * 
 * 
 *         Example 1: Input: nums = [1,1,1], k = 2 Output: 2
 * 
 *         Example 2: Input: nums = [1,2,3], k = 3 Output: 2
 *
 */
;

public class SubarraySumEqualsK {

	public static int subarraySum(int[] nums, int k) {
		// Using the concept of prefix sum
		int prefixSum = 0, counter = 0;

		Map<Integer, Integer> prefixSumMap = new HashMap<>();
		// Default mandatory value
		prefixSumMap.put(0, 1);

		for (int i = 0; i < nums.length; i++) {
			prefixSum += nums[i];
			prefixSumMap.put(prefixSum, prefixSumMap.getOrDefault(prefixSum, 0) + 1);
			if (null != prefixSumMap.get(prefixSum - k)) {
				counter += prefixSumMap.get(prefixSum - k);
			}
		}

		return counter;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		int k = 3;
		System.out.println(subarraySum(nums, k));
	}

}
