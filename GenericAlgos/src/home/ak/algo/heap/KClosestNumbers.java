/**
 * 
 */
package home.ak.algo.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author kundu
 * 
 *         Given a sorted number array and two integers ‘K’ and ‘X’, find ‘K’
 *         closest numbers to ‘X’ in the array. Return the numbers in the sorted
 *         order. ‘X’ is not necessarily present in the array.
 * 
 *         Example 1: Input: [5, 6, 7, 8, 9], K = 3, X = 7 Output: [6, 7, 8]
 * 
 *         Example 2: Input: [2, 4, 5, 6, 9], K = 3, X = 6 Output: [4, 5, 6]
 * 
 *         Example 3: Input: [2, 4, 5, 6, 9], K = 3, X = 10 Output: [5, 6, 9]
 * 
 *         Hint:
 * 
 *         Since the array is sorted, we can first find the number closest to
 *         ‘X’ through Binary Search. Let’s say that number is ‘Y’.
 * 
 *         The ‘K’ closest numbers to ‘Y’ will be adjacent to ‘Y’ in the array.
 *         We can search in both directions of ‘Y’ to find the closest numbers.
 * 
 *         We can use a heap to efficiently search for the closest numbers. We
 *         will take ‘K’ numbers in both directions of ‘Y’ and push them in a
 *         Min Heap sorted by their absolute difference from ‘X’. This will
 *         ensure that the numbers with the smallest difference from ‘X’ (i.e.,
 *         closest to ‘X’) can be extracted easily from the Min Heap.
 * 
 *         Finally, we will extract the top ‘K’ numbers from the Min Heap to
 *         find the required numbers.
 *
 */
public class KClosestNumbers {

	static class Entry {
		int key;
		int value;

		public Entry(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	public static List<Integer> findClosestElements(int[] arr, int K, Integer X) {

		// Binary search to get the closest value
		int closestIdx = search(arr, X);
		// take K values on the either side of closest index
		int low = closestIdx - K, high = closestIdx + K;
		low = Math.max(low, 0); // 'low' should not be less than zero
		high = Math.min(high, arr.length - 1); // 'high' should not be greater the size of the array

		// Build the min heap with absolute difference between X and K * 2 + 1 elements
		PriorityQueue<Entry> minHeap = new PriorityQueue<>((e1, e2) -> e1.key - e2.key);
		for (int i = low; i <= high; i++) {
			minHeap.offer(new Entry(Math.abs(X - arr[i]), i));
		}
		// we need the top 'K' elements having smallest difference from 'X'
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < K; i++) {
			result.add(arr[minHeap.poll().value]);
		}

		Collections.sort(result);
		return result;
	}

	private static int search(int[] arr, Integer X) {
		int left = 0, right = arr.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] == X) {
				return mid;
			}
			if (arr[mid] < X) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		if (left > 0) {
			return left - 1;
		}
		return left;
	}

	/*
	 * Time complexity # The time complexity of the above algorithm is O(logN + K).
	 * We need O(logN) for Binary Search and O(K) for finding the ‘K’ closest
	 * numbers using the two pointers.
	 * 
	 * Space complexity # If we ignoring the space required for the output list, the
	 * algorithm runs in constant space O(1).
	 */

	public static void main(String[] args) {
		List<Integer> result = KClosestNumbers.findClosestElements(new int[] { 5, 6, 7, 8, 9 }, 3, 7);
		System.out.println("'K' closest numbers to 'X' are: " + result);

		result = KClosestNumbers.findClosestElements(new int[] { 2, 4, 5, 6, 9 }, 3, 6);
		System.out.println("'K' closest numbers to 'X' are: " + result);

		result = KClosestNumbers.findClosestElements(new int[] { 2, 4, 5, 6, 9 }, 3, 10);
		System.out.println("'K' closest numbers to 'X' are: " + result);
	}

}
