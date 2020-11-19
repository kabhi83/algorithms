/**
 * 
 */
package home.ak.algo.recursion;

/**
 * @author kundu
 * 
 *         Given an array of integers, validate if the elements of the array are
 *         in sequence
 * 
 *         Input = [2, 3, 4, 5, 6, 7], output = true
 * 
 *         Input = [2, 3, 5, 6, 7], output = false, since 4 is missing
 *
 */
public class SequenceValidation {

	public static boolean isValidSequence(int[] nums) {
		return isValidSequence(nums, 0);
	}

	private static boolean isValidSequence(int[] nums, int i) {
		// Base case - Compare till the 2nd last element
		if (i >= nums.length - 1) {
			return true;
		}
		return nums[i] == nums[i + 1] - 1 && isValidSequence(nums, i + 1);
	}

	public static void main(String[] args) {
		// int[] nums = { 2, 3, 4, 5, 6, 7};
		int[] nums = { 2, 3, 4, 5, 6, 8 };
		System.out.println(isValidSequence(nums));

	}

}
