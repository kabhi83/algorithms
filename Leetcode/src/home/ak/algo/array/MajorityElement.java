/**
 * 
 */
package home.ak.algo.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kundu
 * 
 *         Given an array of size n, find the majority element. The majority
 *         element is the element that appears more than ⌊ n/2 ⌋ times.
 * 
 *         You may assume that the array is non-empty and the majority element
 *         always exist in the array.
 * 
 *         Example 1:
 * 
 *         Input: [3,2,3] Output: 3 Example 2:
 * 
 *         Input: [2,2,1,1,1,2,2] Output: 2
 *
 */
public class MajorityElement {

	public int majorityElement(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}

		Map<Integer, Integer> map = new HashMap<>();
		for (int i : nums) {
			if (map.containsKey(i) && map.get(i) + 1 > nums.length / 2) {
				return i;
			} else {
				map.put(i, map.getOrDefault(i, 0) + 1);
			}
		}
		return -1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = {2,2,1,1,1,2,2};
		int result = new MajorityElement().majorityElement(nums);
		System.out.println(result);
	}

}
