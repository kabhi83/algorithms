/**
 * 
 */
package home.ak.algo.slidingwindow;

import java.util.Arrays;

/**
 * @author kundu
 * 
 *         Given an array, find the average of all contiguous subarrays of size
 *         ‘K’ in it.
 *
 */
public class L4_AverageOfSubarrayOfSizeK {

	public static double[] findAverages(int[] arr, int K) {
		double[] result = new double[arr.length - K + 1];
		double windowSum = 0;
		int windowStart = 0;
		for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
			// add the next element in the array
			windowSum += arr[windowEnd];
			// Operate on the window only when the window size is reached
			if (windowEnd >= K - 1) {
				// Find the average
				result[windowStart] = (windowSum / K);
				// Remove the first added element
				windowSum -= arr[windowStart];
				windowStart++;
			}
		}

		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 1, 3, 2, 6, -1, 4, 1, 8, 2 };
		int K = 5;
		double[] result = L4_AverageOfSubarrayOfSizeK.findAverages(arr, K);
		System.out.println("Averages of subarrays of size K: " + Arrays.toString(result));
	}

}
