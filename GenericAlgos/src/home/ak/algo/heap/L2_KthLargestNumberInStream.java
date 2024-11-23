/**
 * 
 */
package home.ak.algo.heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * @author kundu
 * 
 *         Design a class to efficiently find the Kth largest element in a
 *         stream of numbers.
 * 
 *         The class should have the following two things:
 * 
 *         The constructor of the class should accept an integer array
 *         containing initial numbers from the stream and an integer ‘K’. The
 *         class should expose a function add(int num) which will store the
 *         given number and return the Kth largest number.
 *
 */
public class L2_KthLargestNumberInStream {

	static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	final int k;

	public L2_KthLargestNumberInStream(int[] nums, int k) {
		minHeap.addAll(Arrays.stream(nums).boxed().collect(Collectors.toList()));
		//minHeap.addAll(Arrays.stream(nums).boxed().toList()); // Java 17
		this.k = k;
		while (minHeap.size() > k) {
			// Remove the elements smaller than the kth element
			minHeap.poll();
		}
	}

	public int add(int num) {
		if (num > minHeap.peek()) {
			minHeap.add(num);
		}
		if (minHeap.size() > k) {
			minHeap.poll();
		}
		return minHeap.peek();
	}

	public static void main(String[] args) {
		int[] input = new int[] { 3, 1, 5, 12, 2, 11 };
		L2_KthLargestNumberInStream kthLargestNumber = new L2_KthLargestNumberInStream(input, 4);
		System.out.println("4th largest number is: " + kthLargestNumber.add(6));
		System.out.println("4th largest number is: " + kthLargestNumber.add(13));
		System.out.println("4th largest number is: " + kthLargestNumber.add(4));
	}

}
