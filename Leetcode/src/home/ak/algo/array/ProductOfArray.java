/**
 * 
 */
package home.ak.algo.array;

import java.util.Arrays;

/**
 * @author user
 * 
 *         Given an array nums of n integers where n > 1, return an array output
 *         such that output[i] is equal to the product of all the elements of
 *         nums except nums[i].
 * 
 *         Example: Input: [1,2,3,4] Output: [24,12,8,6]
 * 
 *         Constraint: It's guaranteed that the product of the elements of any
 *         prefix or suffix of the array (including the whole array) fits in a
 *         32 bit integer.
 * 
 *         Note: Please solve it without division and in O(n).
 *
 */
public class ProductOfArray {

	/**
	 * O(n) space solution
	 */
	public int[] productExceptSelf(int[] nums) {

		// The length of the input array
		int length = nums.length;

		// Initialize left and right array
		int[] left = new int[length];
		int[] right = new int[length];

		// Final answer array to be returned
		int[] answer = new int[length];

		// For the element at index '0', there are no elements to the left, so
		// left[0] would be 1
		left[0] = 1;
		for (int i = 1; i < length; i++) {
			left[i] = nums[i - 1] * left[i - 1];
		}

		// For the element at index 'length - 1', there are no elements to the
		// right, so the right[length - 1] would be 1
		right[length - 1] = 1;
		for (int i = length - 2; i >= 0; i--) {
			right[i] = nums[i + 1] * right[i + 1];
		}

		// Constructing the answer array
		for (int i = 0; i < length; i++) {
			answer[i] = left[i] * right[i];
		}

		return answer;
	}

	/**
	 * Constant space solution
	 */
	public int[] productExceptSelfOptimized(int[] nums) {

		int length = nums.length;

		int[] answer = new int[length];
		// Left most element would be 1
		answer[0] = 1;

		for (int i = 1; i < length; i++) {
			// Fill in the answer array with the product of left array
			answer[i] = nums[i - 1] * answer[i - 1];
		}

		// R contains the product of all the elements to the right
		// Note: for the element at index 'length - 1', there are no elements to
		// the right,
		// so the R would be 1
		int R = 1;
		for (int i = length - 1; i >= 0; i--) {

			// For the index 'i', R would contain the
			// product of all elements to the right. We update R accordingly
			answer[i] = answer[i] * R;
			R *= nums[i];
		}

		return answer;
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5};
		int[] result = new ProductOfArray().productExceptSelf(nums);
		System.out.println(Arrays.toString(result));

	}

}
