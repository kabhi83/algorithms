/**
 * 
 */
package home.ak.algo.bs;

/**
 * @author kundu
 * 
 *         Suppose an array of length n sorted in ascending order is rotated
 *         between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7]
 *         might become:
 * 
 *         [4,5,6,7,0,1,2] if it was rotated 4 times.
 * 
 *         [0,1,2,4,5,6,7] if it was rotated 7 times.
 * 
 *         Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time
 *         results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
 * 
 *         Given the sorted rotated array nums of unique elements, return the
 *         minimum element of this array.
 * 
 *         You must write an algorithm that runs in O(log n) time.
 *
 */
public class L07_MinimumInRotatedSortedArray {

	public static int findMin(int[] nums) {
		int start = 0, end = nums.length - 1;

		while (start < end) {
			int mid = (start + end) >> 1;
			if (nums[mid] < nums[end]) {
				// Safely eliminate the right side of the mid
				end = mid;
			} else {
				// Minimum is definitely on the right side of mid
				start = mid + 1;
			}
		}
		return nums[start];

	}

	public static void main(String[] args) {
		int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
		System.out.println(findMin(nums));
	}

}
