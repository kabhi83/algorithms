/**
 * 
 */
package home.ak.algo.bs.starter;

/**
 * @author kundu
 * 
 *         Suppose an array of length n sorted in ascending order is rotated
 *         between 1 and n times. For example, the array nums = [0,1,4,4,5,6,7]
 *         might become:
 * 
 *         [4,5,6,7,0,1,4] if it was rotated 4 times.
 * 
 *         [0,1,4,4,5,6,7] if it was rotated 7 times.
 * 
 *         Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time
 *         results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
 * 
 *         Given the sorted rotated array nums that may contain duplicates,
 *         return the minimum element of this array.
 * 
 *         You must decrease the overall operation steps as much as possible.
 * 
 *         //Worst case time complexity is O(n)
 *
 */
public class L8_MinimumInRotatedSortedArray2 {

	public static int findMin(int[] nums) {
		int start = 0, end = nums.length - 1;

		while (start < end) {
			int mid = (start + end) >> 1;
			if (nums[mid] < nums[end]) {
				// Safely eliminate the right side of the mid
				end = mid;
			} else if (nums[mid] > nums[end]) {
				// Minimum is definitely on the right side of mid
				start = mid + 1;
			} else {
				// No particular section can be eliminated directly but definitely the last
				// elemenet can be removed safely
				end--;
			}
		}
		return nums[start];

	}

	public static void main(String[] args) {
		int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
		System.out.println(findMin(nums));

		nums = new int[] { 1, 1, 1, 0, 0, 1 };
		System.out.println(findMin(nums));
	}

}
