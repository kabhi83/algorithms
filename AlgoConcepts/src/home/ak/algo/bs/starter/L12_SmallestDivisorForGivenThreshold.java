/**
 * 
 */
package home.ak.algo.bs.starter;

import java.util.Arrays;

/**
 * @author kundu
 * 
 *         Binary Search on Answers
 * 
 *         Given an array of integers nums and an integer threshold, we will
 *         choose a positive integer divisor, divide all the array by it, and
 *         sum the division's result. Find the smallest divisor such that the
 *         result mentioned above is less than or equal to threshold.
 * 
 *         Each result of the division is rounded to the nearest integer greater
 *         than or equal to that element. (For example: 7/3 = 3 and 10/2 = 5).
 * 
 *         The test cases are generated so that there will be an answer.
 * 
 *         Concept - Summation decreases with the increase in the divisor value
 *         - Monotonic decreasing function
 *
 */
public class L12_SmallestDivisorForGivenThreshold {

	public static int smallestDivisor(int[] nums, int threshold) {
		int start = 1;
		int end = Arrays.stream(nums).max().getAsInt();
		int ans = end; // best possible divisor
		while (start <= end) {
			int mid = start + (end - start) / 2;
			// mid is giving summation lesser than equal to threshold, but we have to look
			// even smaller; hence do search on left
			if (sumAfterDivision(nums, mid) < threshold) {
				ans = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		return ans;
	}

	private static int sumAfterDivision(int[] nums, int divisor) {
		int sum = 0;
		for(int i = 0; i < nums.length; i++) {
			sum += nums[i]/divisor;
			// Find the ceil value
			if(nums[i] % divisor != 0) {
				sum += 1;
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 5, 9 };
		int threshold = 6;
		System.out.println(smallestDivisor(nums, threshold));
	}

}
