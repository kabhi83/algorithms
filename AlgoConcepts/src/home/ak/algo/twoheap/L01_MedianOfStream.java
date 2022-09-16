/**
 * 
 */
package home.ak.algo.twoheap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author kundu
 * 
 *         This pattern is very efficient in places where you need to maximize
 *         item X while minimizing item Y. Like in the famous IPO problem in
 *         leetcode.
 * 
 *         This pattern uses two Heaps to solve these problems; A Min Heap to
 *         find the smallest element and a Max Heap to find the largest element.
 * 
 *         Problem Statement: Design a class to calculate the median of a number
 *         stream. The median is the middle value in an ordered integer list.
 * 
 *         The class should have the following two methods:
 * 
 *         insertNum(int num): stores the number in the class
 * 
 *         findMedian(): returns the median of all numbers inserted in the class
 * 
 *         If the count of numbers inserted in the class is even, the median
 *         will be the average of the middle two numbers.
 * 
 *         Logic - Initialize 2 heaps (min and max). The smallest numbers will
 *         go to the Max Heap and the larger numbers will go to the Min Heap.
 * 
 *         Complexity - The time complexity of the insertNum() will be O(logN)
 *         due to the insertion in the heap. The time complexity of the
 *         findMedian() will be O(1) as we can find the median from the top
 *         elements of the heaps.
 *
 */
public class L01_MedianOfStream {

	private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

	public void insertNum(int num) {
		if (maxHeap.isEmpty() || maxHeap.peek() >= num) {
			maxHeap.add(num);
		} else {
			minHeap.add(num);
		}
		// Balance the heaps - either both the heaps will have equal number of elements
		// or max-heap will have one more element than the min-heap
		if (maxHeap.size() > minHeap.size() + 1) {
			minHeap.add(maxHeap.poll());
		} else if (maxHeap.size() < minHeap.size()) {
			maxHeap.add(minHeap.poll());
		}
	}

	public double findMedian() {
		if (maxHeap.size() == minHeap.size()) {
			// Equal number of elements
			return (maxHeap.peek() + minHeap.peek()) / 2.0;
		} else {
			return maxHeap.peek();
		}
	}

	public static void main(String[] args) {
		L01_MedianOfStream medianOfStream = new L01_MedianOfStream();
		medianOfStream.insertNum(3);
		medianOfStream.insertNum(1);
		medianOfStream.insertNum(5);
		System.out.println(medianOfStream.findMedian());
	}
}
