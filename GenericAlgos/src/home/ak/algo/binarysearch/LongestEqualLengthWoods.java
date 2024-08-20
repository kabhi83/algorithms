/**
 * 
 */
package home.ak.algo.binarysearch;

import java.util.Arrays;

/**
 * @author kundu
 * 
 *         Given an integer array representing the length of n pieces of wood
 *         and an integer k. It is required to cut these pieces of wood in such
 *         a way that we get k pieces of the same length of wood. What is the
 *         longest length of wood we can get?
 * 
 *         Similar Problem: Given an array of integers with elements
 *         representing lengths of ribbons. Your goal is to obtain k ribbons of
 *         equal length cutting the ribbons into as many pieces as you want.
 *         Find the maximum integer length L to obtain at least k ribbons of
 *         length L
 * 
 *         Example 1: Input: wood = [5, 9, 7], k = 3 Output: 5
 * 
 *         Explanation: 5 -> 5, 9 -> 5 + 4, 7 -> 5 + 2
 * 
 *         Example 2: Input: wood = [5, 9, 7], k = 4 Output: 4
 * 
 *         Explanation: 5 -> 4 + 1, 9 -> 4 * 2 + 1, 7 -> 4 + 3
 *
 */
public class LongestEqualLengthWoods {

	public int cutWood(int[] woods, int k) {
		// Maximum length ranges between 1 and the highest value in the array
		int left = 1;
		int right = Arrays.stream(woods).max().getAsInt();
		while (left <= right) {
			int mid = left + (right - left) / 2;

			// we will use the middle number as a possible cut length and check if every
			// wood in woods can be cut with that length. We need a helper function for it
			// that loop and checks and returns true if number of woodCuts is >= k:
			int woodCount = cutCount(woods, mid);
			if (woodCount > k) {
				// more woods of equal length than k, and since we want even longer wood cuts,
				// we move our left pointer in binary to middle+1. Otherwise,
				// we move our right to middle-1 if wood cut was not valid.
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return left;
	}

	private int cutCount(int[] woods, int cutLength) {
		int count = 0;
		for (int wood : woods) {
			count += wood / cutLength;
		}
		return count;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] woods1 = { 5, 9, 7 };
		int result1 = new LongestEqualLengthWoods().cutWood(woods1, 3);
		System.out.println(result1);

		int[] woods2 = { 5, 9, 7 };
		int result2 = new LongestEqualLengthWoods().cutWood(woods2, 4);
		System.out.println(result2);

	}

}
