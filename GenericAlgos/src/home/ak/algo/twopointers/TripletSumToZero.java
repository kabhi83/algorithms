/**
 * 
 */
package home.ak.algo.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kundu
 * 
 *         Given an array of unsorted numbers, find all unique triplets in it
 *         that add up to zero.
 * 
 *         Example 1: Input: [-3, 0, 1, 2, -1, 1, -2] Output: [-3, 1, 2], [-2,
 *         0, 2], [-2, 1, 1], [-1, 0, 1] Explanation: There are four unique
 *         triplets whose sum is equal to zero.
 * 
 *         Example 2: Input: [-5, 2, -1, -2, 3] Output: [[-5, 2, 3], [-2, -1,
 *         3]] Explanation: There are two unique triplets whose sum is equal to
 *         zero.
 *
 */
public class TripletSumToZero {

	public static List<List<Integer>> searchTriplets(int[] arr) {
		List<List<Integer>> triplets = new ArrayList<>();
		// Sort the array
		Arrays.sort(arr);

		for (int i = 0; i < arr.length - 2; i++) {
			// skip same element to avoid duplicate triplets)
			if (i == 0 || (i > 0 && arr[i] != arr[i - 1])) {
				int left = i + 1;
				int right = arr.length - 1;
				int targetSum = 0 - arr[i];
				while (left < right) {
					int currentSum = arr[left] + arr[right];
					if (currentSum == targetSum) {
						triplets.add(Arrays.asList(arr[i], arr[left], arr[right]));
						left++;
						right--;
						while (left < right && arr[left] == arr[left - 1])
							left++; // skip same element to avoid duplicate triplets
						while (left < right && arr[right] == arr[right + 1])
							right--; // skip same element to avoid duplicate triplets
					} else if (currentSum < targetSum) {
						left++; // we need a pair with a bigger sum
					} else {
						right--; // we need a pair with a smaller sum
					}
				}
			}

		}
		return triplets;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(TripletSumToZero.searchTriplets(new int[] { -3, 0, 1, 2, -1, 1, -2 }));
		System.out.println(TripletSumToZero.searchTriplets(new int[] { -5, 2, -1, -2, 3 }));
	}

}
