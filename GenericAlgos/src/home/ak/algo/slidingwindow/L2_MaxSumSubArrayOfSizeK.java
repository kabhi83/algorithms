/**
 * 
 */
package home.ak.algo.slidingwindow;

/**
 * @author kundu
 * 
 *         Given an array of positive numbers and a positive number ‘k,’ find
 *         the maximum sum of any contiguous subarray of size ‘k’.
 * 
 *         Example 1: Input: [2, 1, 5, 1, 3, 2], k=3 Output: 9 Explanation: Subarray with
 *         maximum sum is [5, 1, 3].
 */
public class L2_MaxSumSubArrayOfSizeK {

	public static int findMaxSumSubArray(int[] arr, int k) {
		int maxSum = 0, windowSum = 0;
		int windowStart = 0;
		for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
			// add the next element in the array
			windowSum += arr[windowEnd];

			// slide the window only if we have hit the required window size of 'k'
			if (windowEnd >= k - 1) {
				maxSum = Math.max(maxSum, windowSum);
				// remove the first element from the window
				windowSum -= arr[windowStart];
				windowStart++;
			}
		}
		return maxSum;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Maximum sum of a subarray of size K: "
				+ L2_MaxSumSubArrayOfSizeK.findMaxSumSubArray(new int[] { 2, 1, 5, 1, 3, 2 }, 3));
		System.out.println("Maximum sum of a subarray of size K: "
				+ L2_MaxSumSubArrayOfSizeK.findMaxSumSubArray(new int[] { 2, 3, 4, 1, 5 }, 2));
	}

}
