/**
 * 
 */
package home.ak.algo.slidingwindow;

/**
 * @author kundu
 * 
 *         Given an array of positive numbers and a positive number ‘S,’ find
 *         the length of the smallest contiguous subarray whose sum is greater
 *         than or equal to ‘S’. Return 0 if no such subarray exists.
 * 
 *         Example: Input: [2, 1, 5, 2, 3, 2], S = 7 Output: 2
 * 
 *         Explanation: The smallest subarray with a sum great than or equal to
 *         '7' is [5, 2].
 *
 */
public class MinSizeSubArraySum {

	public static int findMinSubArray(int[] arr, int S) {
		int windowSum = 0, windowStart = 0;
		int minWindow = Integer.MAX_VALUE;
		for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
			windowSum += arr[windowEnd];
			// shrink the window until the 'windowSum' is smaller than 'S'
			while (windowSum >= S) {
				minWindow = Math.min(minWindow, windowEnd - windowStart + 1);
				// Remove the starting element
				windowSum -= arr[windowStart];
				windowStart++;
			}
		}
		return minWindow == Integer.MAX_VALUE ? 0 : minWindow;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int result = MinSizeSubArraySum.findMinSubArray(new int[] { 2, 1, 5, 2, 3, 2 }, 7);
		System.out.println("Smallest subarray length: " + result);
		result = MinSizeSubArraySum.findMinSubArray(new int[] { 2, 1, 5, 2, 8 }, 7);
		System.out.println("Smallest subarray length: " + result);
		result = MinSizeSubArraySum.findMinSubArray(new int[] { 3, 4, 1, 1, 6 }, 8);
		System.out.println("Smallest subarray length: " + result);

	}

}
