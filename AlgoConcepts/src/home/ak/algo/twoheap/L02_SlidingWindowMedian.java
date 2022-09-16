/**
 * 
 */
package home.ak.algo.twoheap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author kundu
 * 
 *         Given an array of numbers and a number ‘k’, find the median of all
 *         the ‘k’ sized sub-arrays (or windows) of the array.
 *
 */
public class L02_SlidingWindowMedian {

	private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

	public double[] findSlidingWindowMedian(int[] nums, int k) {
		double[] result = new double[nums.length - k + 1];

		// Iterate the nums array
		for (int i = 0; i < nums.length; i++) {
			if (maxHeap.isEmpty() || maxHeap.peek() >= nums[i]) {
				maxHeap.add(nums[i]);
			} else {
				minHeap.add(nums[i]);
			}

			rebalance();

			// Median computation on reaching the window size
			if (i - k + 1 >= 0) { // if we have at least 'k' elements in the sliding window
				if (maxHeap.size() == minHeap.size()) {
					result[i - k + 1] = (maxHeap.peek() + minHeap.peek()) / 2.0;
				} else {
					result[i - k + 1] = maxHeap.peek();
				}

				// Remove the element from the heap to shrink the window
				int elementToRemove = nums[i - k + 1];
				if (maxHeap.peek() >= elementToRemove) {
					maxHeap.remove(elementToRemove);
				} else {
					minHeap.remove(elementToRemove);
				}

				rebalance();
			}
		}
		return result;
	}

	private void rebalance() {
		if (maxHeap.size() > minHeap.size() + 1) {
			minHeap.add(maxHeap.poll());
		} else if (maxHeap.size() < minHeap.size()) {
			maxHeap.add(minHeap.poll());
		}
	}

	public static void main(String[] args) {
		L02_SlidingWindowMedian slidingWindow = new L02_SlidingWindowMedian();
		int[] nums = { 1, 2, -1, 3, 5 };
		int k = 2;
		System.out.println(Arrays.toString(slidingWindow.findSlidingWindowMedian(nums, k)));
	}

}
