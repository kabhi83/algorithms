/**
 * 
 */
package home.ak.algo.bs.starter;

/**
 * @author kundu
 * 
 *         A peak element is an element that is strictly greater than its
 *         neighbors.
 * 
 *         Given an integer array nums, find a peak element, and return its
 *         index. If the array contains multiple peaks, return the index to any
 *         of the peaks.
 * 
 *         You may imagine that nums[-1] = nums[n] = - Infinity
 * 
 *         You must write an algorithm that runs in O(log n) time.
 *
 */
public class L10_PeakElement {

	public static int findPeakElement(int[] nums) {
		int start = 0, end = nums.length - 1;
		while (start < end) {
			// We consider start < end, when we are not sure about the middle element being
			// a candidate for consideration
			int mid = (start + end) >> 1;
			if (nums[mid] > nums[mid + 1]) {
				// Peak definitely exists in the left
				end = mid;
			} else {
				// Element at mid is not a candidate
				start = mid + 1;
			}
		}
		return nums[start];
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 1, 3, 5, 6, 4 };
		System.out.println(findPeakElement(nums));
	}

}
