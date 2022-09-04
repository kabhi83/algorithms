/**
 * 
 */
package home.ak.algo.sw;

import java.util.Arrays;

/**
 * @author kundu
 *
 *         Given an array, find the average of each subarray of ‘K’ contiguous
 *         elements in it.
 */
public class L01_AverageOfSubarrayOfSizeK {

	static double[] findAverages(int[] arr, int K) {
		double[] result = new double[arr.length - K + 1];
		int start = 0;
		double sum = 0;
		for (int end = 0; end < arr.length; end++) {
			sum += arr[end];
			if (end >= K - 1) {
				result[start] = sum / K;
				sum -= arr[start];
				start++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 3, 2, 6, -1, 4, 1, 8, 2 };
		System.out.println(Arrays.toString(findAverages(arr, 5)));
	}

}
