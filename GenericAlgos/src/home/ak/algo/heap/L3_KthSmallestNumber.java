/**
 * 
 */
package home.ak.algo.heap;

import java.util.PriorityQueue;

/**
 * @author kundu
 *
 */
public class L3_KthSmallestNumber {

	public static int findKthSmallestNumber(int[] nums, int k) {
		// Use Max heap to store the top K smallest elements
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((m, n) -> (n - m));
		for (int i : nums) {
			maxHeap.add(i);
			if (maxHeap.size() > k) {
				// Remove the higher value element
				maxHeap.poll();
			}
		}
		// the head contains the kth smallest element
		return maxHeap.peek();
	}

	public static void main(String[] args) {
		int result = L3_KthSmallestNumber.findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5 }, 3);
		System.out.println("Kth smallest number is: " + result);

		// since there are two 5s in the input array, our 3rd and 4th smallest numbers
		// should be a '5'
		result = L3_KthSmallestNumber.findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5 }, 4);
		System.out.println("Kth smallest number is: " + result);

		result = L3_KthSmallestNumber.findKthSmallestNumber(new int[] { 5, 12, 11, -1, 12 }, 3);
		System.out.println("Kth smallest number is: " + result);
	}

	/*
	 * Time complexity # The time complexity of this algorithm is
	 * O(K*logK+(N-K)*logK), which is asymptotically equal to O(N*logK)
	 * 
	 * Space complexity # The space complexity will be O(K)O(K) because we need to
	 * store ‘K’ smallest numbers in the heap.
	 */
}
