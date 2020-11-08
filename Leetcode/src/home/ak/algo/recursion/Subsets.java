/**
 * 
 */
package home.ak.algo.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kundu
 * 
 *         Given a set of distinct integers, nums, return all possible subsets
 *         (the power set).
 * 
 *         Note: The solution set must not contain duplicate subsets.
 * 
 *         Example: Input: nums = [1,2,3]
 * 
 *         Output: [ [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2], [] ]
 *
 */
public class Subsets {

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();

		subsets(0, nums, new ArrayList<Integer>(), result);
		return result;
	}

	/**
	 * Operations are based on either take the number or don't take and move forward
	 */
	private void subsets(int index, int[] nums, ArrayList<Integer> current, List<List<Integer>> result) {
		result.add(new ArrayList<Integer>(current)); // Use deep copy
		for (int i = index; i < nums.length; i++) {
			// Take the number
			current.add(nums[i]);
			subsets(i + 1, nums, current, result);
			// remove the number added and it's at the last index
			current.remove(current.size() - 1);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		System.out.println(new Subsets().subsets(nums));

	}

}
