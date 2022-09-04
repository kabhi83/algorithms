/**
 * 
 */
package home.ak.algo.sw;

/**
 * @author kundu
 * 
 *         Given an array of positive integers and a number ‘S,’ find the length
 *         of the smallest contiguous subarray whose sum is greater than or
 *         equal to ‘S’. Return 0 if no such subarray exists.
 *
 */
public class L04_MinSizeSubArraySum {

	static int findMinSubArray(int S, int[] arr) {
		int start = 0;
		int sum = 0;
		int smallestWindowSize = Integer.MAX_VALUE;
		for (int end = 0; end < arr.length; end++) {
			sum += 0;
			while (sum >= S) {
				smallestWindowSize = Math.min(smallestWindowSize, end - start + 1);
				sum -= arr[start++]; // discard the first element and shrink the window
			}
		}
		return smallestWindowSize == Integer.MAX_VALUE ? 0 : smallestWindowSize;
	}

	public static void main(String[] args) {

	}
}
