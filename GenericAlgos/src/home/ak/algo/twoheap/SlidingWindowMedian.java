/**
 * 
 */
package home.ak.algo.twoheap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author kundu
 * 
 *         Given an array of numbers and a number ‘k’, find the median of all
 *         the ‘k’ sized sub-arrays (or windows) of the array
 *
 */
public class SlidingWindowMedian {

	PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
	PriorityQueue<Integer> minHeap = new PriorityQueue<>();

	public double[] findSlidingWindowMedian(int[] nums, int k) {
		double[] result = new double[nums.length - k + 1];
		for (int i = 0; i < nums.length; i++) {
			if (maxHeap.isEmpty() || maxHeap.peek() >= nums[i]) {
				maxHeap.add(nums[i]);
			} else {
				minHeap.add(nums[i]);
			}

			// Re-balance the heaps
			rebalance();

			// if we have at least 'k' elements in the sliding window
			if (i - k + 1 >= 0) {
				// Add the median to the result array
				if (maxHeap.size() == minHeap.size()) {
					result[i - k + 1] = (maxHeap.peek() + minHeap.peek()) / 2.0;
				} else {
					result[i - k + 1] = maxHeap.peek();
				}

				// remove the the element going out of the sliding window
				int elementToBeRemoved = nums[i - k + 1];
				if (elementToBeRemoved <= maxHeap.peek()) {
					maxHeap.remove(elementToBeRemoved);
				} else {
					minHeap.remove(elementToBeRemoved);
				}

				rebalance();
			}
		}

		return result;
	}

	private void rebalance() {
		if (maxHeap.size() - minHeap.size() > 1) {
			minHeap.add(maxHeap.poll());
		} else if (minHeap.size() > maxHeap.size()) {
			maxHeap.add(minHeap.poll());
		}
	}

	public static void main(String[] args) {
		SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
		double[] result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 2);
		System.out.print("Sliding window medians are: ");
		for (double num : result)
			System.out.print(num + " ");
		System.out.println();

		slidingWindowMedian = new SlidingWindowMedian();
		result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 3);
		System.out.print("Sliding window medians are: ");
		for (double num : result)
			System.out.print(num + " ");
	}

}
