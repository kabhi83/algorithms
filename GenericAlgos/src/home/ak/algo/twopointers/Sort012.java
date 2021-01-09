/**
 * 
 */
package home.ak.algo.twopointers;

import java.util.Arrays;

/**
 * @author kundu
 * 
 *         Dutch National Flag Problem: Given an array containing 0s, 1s and 2s,
 *         sort the array in-place. You should treat numbers of the array as
 *         objects, hence, we can’t count 0s, 1s, and 2s to recreate the array.
 *
 */
public class Sort012 {

	public static void sort012(int[] nums) {
		int low = 0, high = nums.length - 1;
		int mid = 0;

		while (mid <= high) {
			switch (nums[mid]) {
			case 0:
				swap(nums, low, mid);
				low++;
				mid++;
				break;

			case 1:
				mid++;
				break;

			case 2:
				swap(nums, mid, high);
				high--;
				break;
			}

		}
	}

	private static void swap(int[] nums, int left, int right) {
		int temp = nums[left];
		nums[left] = nums[right];
		nums[right] = temp;
	}
	
	public static void main(String[] args) {
		int[] nums = {0, 2, 0, 2, 1, 1, 2, 0, 1, 1, 0, 2};
		sort012(nums);
		System.out.println(Arrays.toString(nums));
	}
}
