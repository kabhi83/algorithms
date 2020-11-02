/**
 * 
 */
package home.ak.algo.generic;

import java.util.HashSet;
import java.util.Set;

/**
 * @author user
 * 
 *         Given a non-empty array of integers nums, every element appears twice
 *         except for one. Find that single one.
 * 
 *         Follow up: Could you implement a solution with a linear runtime
 *         complexity and without using extra memory?
 * 
 *         Example 1: Input: nums = [2,2,1] Output: 1
 * 
 *         Example 2: Input: nums = [4,1,2,1,2] Output: 4
 *
 */
public class SingleNumber {

	public int singleNumber(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int num : nums) {
			if (!set.add(num)) {
				// Number already exist in the set
				set.remove(num);
			}
		}
		// Only the number without duplicate is in the set
		return set.iterator().next();
	}

	/**
	 * Optimized with Bit Manipulation - XOR
	 */
	public int singleNumberOptimized(int[] nums) {
		int result = 0;
		for (int num : nums) {
			result ^= num;
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 4, 1, 2, 1, 2 };
		int result1 = new SingleNumber().singleNumber(nums);
		System.out.println(result1);
		int result2 =  new SingleNumber().singleNumberOptimized(nums);
		System.out.println(result2);
	}

}
