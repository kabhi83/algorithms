/**
 * 
 */
package home.ak.algo.slidingwindow;

/**
 * @author kundu
 * 
 *         Given an array containing 0s and 1s, if you are allowed to replace no
 *         more than ‘k’ 0s with 1s, find the length of the longest contiguous
 *         subarray having all 1s.
 * 
 *         Example 1: Input: Array=[0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1], k=2
 *         Output: 6 Explanation: Replace the '0' at index 5 and 8 to have the
 *         longest contiguous subarray of 1s having length 6.
 * 
 *         Example 2:Input: Array=[0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1], k=3
 *         Output: 9 Explanation: Replace the '0' at index 6, 9, and 10 to have
 *         the longest contiguous subarray of 1s having length 9.
 *
 */
public class LongestSubarrayOf1s {

	public static int findLength(int[] arr, int k) {
		int windowStart = 0, maxLength = 0, max1Count = 0;
		for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
			if (arr[windowEnd] == 1) {
				max1Count++;
			}
			//Shrink the window if the number of 0's is more than k
			if (windowEnd - windowStart + 1 - max1Count > k) {
				if(arr[windowStart] == 1) {
					max1Count--;
				}
				windowStart++;
			}
			maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
		}
		return maxLength;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(findLength(new int[] { 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1 }, 2));
	    System.out.println(findLength(new int[] { 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1 }, 3));
	}

}
