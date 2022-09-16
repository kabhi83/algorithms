/**
 * 
 */
package home.ak.algo.sw;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author kundu
 * 
 *         You are given an array of integers nums, there is a sliding window of
 *         size k which is moving from the very left of the array to the very
 *         right. You can only see the k numbers in the window. Each time the
 *         sliding window moves right by one position.
 * 
 *         Return the max sliding window.
 *
 */
public class L04_SlidingWindowMaximum {

	public static int[] maxSlidingWindow(int[] nums, int k) {
		int[] result = new int[nums.length - k + 1];
		int idx = 0;

		// Initialize the deque to store the indexes
		// the first of the Deque should point to the index of the largest element in
		// the sliding window. All insertions from the last
		Deque<Integer> dq = new ArrayDeque<>();

		for (int i = 0; i < nums.length; i++) {
			// Remove the out-of bound elements
			if (!dq.isEmpty() && dq.peek() == i - k) {
				dq.poll(); // same as pollFirst()
			}
			
			//Remove all the indexes of the smaller elements to the current element
			while(!dq.isEmpty() && nums[dq.peek()] < nums[i]) {
				dq.pollLast();
			}
			
			dq.offer(i); // same as offerLast(e)
			
			//Now get the window maximum
			if(i >= k - 1) {
				result[idx++] = nums[dq.peek()];
			}
		}

		return result;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,3,-1,-3,5,3,6,7};
		int k = 3;
		System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
	}

}
