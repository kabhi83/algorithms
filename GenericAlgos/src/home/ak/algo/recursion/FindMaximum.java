/**
 * 
 */
package home.ak.algo.recursion;

/**
 * @author kundu
 * 
 *         Find the maximum value in an array of integers
 * 
 *         Recurrence relation:
 * 
 *         maximum(A, i) = MAX(A[i], maximum(A, i-1))
 *
 */
public class FindMaximum {

	public static int maximum(int[] nums, int i) {
		// Base case to stop the execution further
		if (i == 0) {
			return nums[0];
		}
		return Math.max(nums[i], maximum(nums, i - 1));
	}

	public static void main(String[] args) {
		int[] nums = { 2, 7, 9, 3, 5, 0, 1 };
		int result = maximum(nums, nums.length - 1);
		System.out.println(result);
	}

}
