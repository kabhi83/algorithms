/**
 * 
 */
package home.ak.algo.bitmanipulation;

/**
 * @author kundu
 * 
 *         Given an integer array nums where every element appears three times
 *         except for one, which appears exactly once. Find the single element
 *         and return it.
 * 
 *         Example 1: Input: nums = [2,2,3,2] Output: 3
 * 
 *         Example 2: Input: nums = [0,1,0,1,0,1,99] Output: 99
 *
 */
public class SingleNumberII {

	public int singleNumber(int[] nums) {
		int ans = 0;
		for (int i = 0; i < 32; i++) {
			int sum = 0;
			for (int j = 0; j < nums.length; j++) {
				if (((nums[j] >> i) & 1) == 1) {
					// Counting the 1 values at individual indexes
					sum++;
				}
			}
			sum %= 3;
			if(sum != 0) {
				ans |= sum << i;
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		int[] nums = {4, 3, 4, 2, 4, 3, 3};
		System.out.println(new SingleNumberII().singleNumber(nums));
	}

}
