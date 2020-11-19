/**
 * 
 */
package home.ak.algo.twoheap;

import java.util.PriorityQueue;

/**
 * @author kundu
 * 
 *         Design a class to calculate the median of a number stream. The class
 *         should have the following two methods:
 * 
 *         1. insertNum(int num): stores the number in the class
 * 
 *         2. findMedian(): returns the median of all numbers inserted in the
 *         class
 * 
 *         Note: If the count of numbers inserted in the class is even, the
 *         median will be the average of the middle two numbers.
 * 
 *
 */
public class MedianOfAStream {

	PriorityQueue<Integer> maxHeap; // containing first half of numbers
	PriorityQueue<Integer> minHeap; // containing second half of numbers

	public MedianOfAStream() {
		maxHeap = new PriorityQueue<>((a, b) -> (b - a));
		minHeap = new PriorityQueue<>((a, b) -> (a - b));
	}

	/**
	 * We can insert a number in the Max Heap (i.e. first half) if the number is
	 * smaller than the top (largest) number of the heap. After every insertion, we
	 * will balance the number of elements in both heaps, so that they have an equal
	 * number of elements. If the count of numbers is odd, let’s decide to have more
	 * numbers in max-heap than the Min Heap.
	 */
	public void insertNum(int num) {
		if (maxHeap.isEmpty() || maxHeap.peek() >= num) {
			maxHeap.add(num);
		} else {
			minHeap.add(num);
		}

		// Balance the heap - either both the heaps will have equal number of elements
		// or max-heap will have one more element than the min-heap
		if (maxHeap.size() - minHeap.size() > 1) {
			minHeap.add(maxHeap.poll());
		} else if (maxHeap.size() < minHeap.size()) {
			maxHeap.add(minHeap.poll());
		}
	}

	public double findMedian() {
		if (maxHeap.size() == minHeap.size()) {
			// Equal stream size
			return (maxHeap.peek() + minHeap.peek()) / 2.0;
		} else {
			return maxHeap.peek();
		}
	}

	public static void main(String[] args) {
		MedianOfAStream medianOfAStream = new MedianOfAStream();
		medianOfAStream.insertNum(3);
		medianOfAStream.insertNum(1);
		System.out.println("The median is: " + medianOfAStream.findMedian());
		medianOfAStream.insertNum(5);
		System.out.println("The median is: " + medianOfAStream.findMedian());
		medianOfAStream.insertNum(4);
		System.out.println("The median is: " + medianOfAStream.findMedian());
	}
}
