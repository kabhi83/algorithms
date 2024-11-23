/**
 * 
 */
package home.ak.algo.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author kundu
 * 
 *         Given an unsorted array of numbers, find the ‘K’ largest numbers in
 *         it.
 * 
 *         Input: [3, 1, 5, 12, 2, 11], K = 3, Output: [5, 12, 11]
 *
 */
public class L1_KLargestNumbers {

	public static List<Integer> findKLargestNumbers(int[] nums, int k) {
		// initialize the min heap
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for (int i : nums) {
			minHeap.add(i);
			if (minHeap.size() > k) {
				// Remove the top (minimum) element from heap
				minHeap.poll();
			}
		}
		return new ArrayList<>(minHeap);
	}

	public static void main(String[] args) {
		List<Integer> result = L1_KLargestNumbers.findKLargestNumbers(new int[] { 3, 1, 5, 12, 2, 11 }, 3);
		System.out.println("Here are the top K numbers: " + result);

		result = L1_KLargestNumbers.findKLargestNumbers(new int[] { 5, 12, 11, -1, 12 }, 3);
		System.out.println("Here are the top K numbers: " + result);
	}

}
