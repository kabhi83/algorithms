/**
 * 
 */
package home.ak.algo.sw;

/**
 * @author kundu
 * 
 *         Given an array arr[] of size n containing only positive integers.
 *         Find the length of the longest sub-array having sum equal to the
 *         given value k.
 *
 */
public class L06_LongestSubArrayOfSumK {

	/**
	 * In case of variable window size problem, we need to check for all the
	 * possible conditions which was not the case with the fixed size window
	 * problem. There only we have to check if the window size reached or not.
	 */
	public static int longestSubArrayofSumK(int[] arr, int k) {
		int windowStart = 0, maxLength = 0;
		int sum = 0;
		for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
			sum += arr[windowEnd];
			// Check for conditions
			if (k == sum) {
				// Check if the window size is maximum
				maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
			} else if (k > sum) {
				continue;
			} else {
				// Get the window till the sum is less than k
				while (k < sum) {
					sum -= arr[windowStart++];
					// Need to re-check the window size again while decrementing the sum
					if (k == sum) {
						maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
					}
				}
			}
		}
		return maxLength;
	}

	public static void main(String[] args) {
		int[] arr = { 10, 5, 1, 1, 7, 1, 9 };
		int k = 15;
		System.out.println(longestSubArrayofSumK(arr, k));

		arr = new int[] { 4, 1, 1, 1, 1, 2, 3, 5 };
		k = 5;
		System.out.println(longestSubArrayofSumK(arr, k));
	}

}
