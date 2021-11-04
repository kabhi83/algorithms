/**
 * 
 */
package home.ak.algo.sw.fixed;

/**
 * @author kundu
 * 
 *         Given an array of positive numbers and a positive number ‘k,’ find
 *         the maximum sum of any contiguous subarray of size ‘k’.
 * 
 *         Ex: Input: [2, 1, 5, 1, 3, 2], k=3. Output: 9
 * 
 *         Explanation: Subarray with maximum sum is [5, 1, 3].
 * 
 *         Note: Sliding window identification - Subarray/ Substring,
 *         largest/smallest and window size (fixed) or condition (variable)
 * 
 *         Window Size = end - start + 1 (for 0 based array index)
 *
 */
public class MaxSumSubArrayOfSizeK {

	public static int findMaxSumSubArray(int[] arr, int k) {
		int windowStart = 0;
		int windowSum = 0;
		int maxSum = Integer.MIN_VALUE;
		for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
			windowSum += arr[windowEnd];
			// Check if window size reached
			if (windowEnd - windowStart + 1 >= k) {
				maxSum = Math.max(maxSum, windowSum);
				// subtract the element going out and increment windowStart
				windowSum -= arr[windowStart++];
			}
		}
		return maxSum;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 1, 5, 1, 3, 2 };
		int k = 3;
		System.out.println(findMaxSumSubArray(arr, k));

		arr = new int[] { 2, 3, 4, 1, 5 };
		k = 2;
		System.out.println(findMaxSumSubArray(arr, k));
	}

}
