/**
 * 
 */
package home.ak.algo.twopointers;

import java.util.Arrays;

/**
 * @author kundu
 * 
 *         Given an array of unsorted numbers and a target number, find a
 *         triplet in the array whose sum is as close to the target number as
 *         possible, return the sum of the triplet. If there are more than one
 *         such triplet, return the sum of the triplet with the smallest sum.
 * 
 *         Example 1: Input: [-2, 0, 1, 2], target=2 Output: 1 Explanation: The
 *         triplet [-2, 1, 2] has the closest sum to the target.
 * 
 *         Example 2: Input: [-3, -1, 1, 2], target=1 Output: 0 Explanation: The
 *         triplet [-3, 1, 2] has the closest sum to the target.
 *
 */
public class TripletSumCloseToTarget {

	public static int searchTriplet(int[] arr, int targetSum) {

		// Sort the array
		Arrays.sort(arr);
		int smallestDifference = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length - 2; i++) {
			int left = i + 1, right = arr.length - 1;
			while (left < right) {
				int targetDiff = targetSum - arr[i] - arr[left] - arr[right];

				// Case 1: for exact match
				if (targetDiff == targetSum) {
					return targetSum - targetDiff;
				}

				// Case 2: Handle the smallest sum when we have more than one solution
				if (Math.abs(targetDiff) < Math.abs(smallestDifference)
						|| (Math.abs(targetDiff) == Math.abs(smallestDifference) && targetDiff > smallestDifference)) {
					smallestDifference = targetDiff; 
				}

				if (targetDiff > 0)
					left++; // we need a triplet with a bigger sum
				else
					right--; // we need a triplet with a smaller sum
			}
		}
		return targetSum - smallestDifference;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
