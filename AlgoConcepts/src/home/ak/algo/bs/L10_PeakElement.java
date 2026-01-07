/**
 * 
 */
package home.ak.algo.bs;

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
 *         You may imagine that nums[-1] = nums[n] = - Infinity. In other words,
 *         an element is always considered to be strictly greater than a
 *         neighbor that is outside the array.
 * 
 *         You must write an algorithm that runs in O(log n) time.
 * 
 * 
 *         Example 1:
 * 
 *         Input: nums = [1,2,3,1] Output: 2 Explanation: 3 is a peak element
 *         and your function should return the index number 2.
 * 
 *         Example 2:
 * 
 *         Input: nums = [1,2,1,3,5,6,4] Output: 5 Explanation: Your function
 *         can return either index number 1 where the peak element is 2, or
 *         index number 5 where the peak element is 6.
 *
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
				// Peak definitely exists in the left and mid is a candidate
				end = mid;
			} else {
				// Element at mid is not a candidate as it's less than mid + 1
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
