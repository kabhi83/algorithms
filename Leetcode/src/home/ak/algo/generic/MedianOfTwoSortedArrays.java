/**
 * 
 */
package home.ak.algo.generic;

/**
 * @author kundu
 * 
 *         Given two sorted arrays nums1 and nums2 of size m and n respectively,
 *         return the median of the two sorted arrays.
 * 
 *         Follow up: The overall run time complexity should be O(log (m+n)).
 * 
 * 
 *         Solution:
 * 
 *         Take minimum size of two array. Possible number of partitions are
 *         from 0 to m in m size array.
 * 
 *         Try every cut in binary search way. When you cut first array at i
 *         then you cut second array at (m + n + 1)/2 - i
 *
 */
public class MedianOfTwoSortedArrays {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		// consider operation on the array with minimum size
		if (nums1.length > nums2.length) {
			findMedianSortedArrays(nums2, nums1);
		}

		int x = nums1.length;
		int y = nums2.length;

		int low = 0, high = x;

		// Binary Search
		while (low <= high) {
			int partitionX = (low + high) / 2; // Partition smaller array
			int partitionY = ((x + y + 1) / 2) - partitionX;

			// Check for the left and right boundary.
			// if partitionX is 0; nothing is there on left side. Use -INF for maxLeftX
			// if partitionX is length of input; nothing on right side. Use +INF for
			// minRightX
			int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
			int minRightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];

			// In similar lines
			int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
			int minRightY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];

			// Case: 1 - Found the solution
			if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
				if ((x + y) % 2 == 0) {
					return ((double) Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
				} else {
					return (double) Math.max(maxLeftX, maxLeftY);
				}
			} else if (maxLeftX > minRightY) {
				// we are too far on right side for partitionX. Go on left side.
				high = partitionX - 1;
			} else {
				low = partitionX + 1;
			}
		}
		// Only we we can come here is if input arrays were not sorted. Throw in that
		// scenario.
		throw new IllegalArgumentException();
	}

	public static void main(String[] args) {
		int[] nums1 = { 1, 3, 8, 9, 15 };
		int[] nums2 = { 7, 11, 19, 21, 18, 25 };

		MedianOfTwoSortedArrays median = new MedianOfTwoSortedArrays();
		System.out.println(median.findMedianSortedArrays(nums1, nums2));
	}

}
