/**
 * 
 */
package home.ak.algo.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kundu
 * 
 *         Given a set with distinct elements, find all of its distinct subsets.
 *
 */
public class Subsets {

	public static List<List<Integer>> findSubsets(int[] nums) {
		List<List<Integer>> subsets = new ArrayList<>();
		findSubsetsRecursive(0, new ArrayList<Integer>(), nums, subsets);
		return subsets;
	}

	private static void findSubsetsRecursive(int index, List<Integer> current, int[] nums,
			List<List<Integer>> subsets) {
		// Add the current to the subsets
		subsets.add(new ArrayList<>(current)); // Use deep copy

		for (int i = index; i < nums.length; i++) {
			// Take the number
			current.add(nums[i]);
			findSubsetsRecursive(i + 1, current, nums, subsets);
			// Remove the element from the last index
			current.remove(current.size() - 1);
		}
	}

	public static void main(String[] args) {
		List<List<Integer>> result = Subsets.findSubsets(new int[] { 1, 3 });
		System.out.println("Here is the list of subsets: " + result);

		result = Subsets.findSubsets(new int[] { 1, 5, 3 });
		System.out.println("Here is the list of subsets: " + result);
	}

	/*
	 * Time complexity # Since, in each step, the number of subsets doubles as we
	 * add each element to all the existing subsets, therefore, we will have a total
	 * of O(2^N) subsets, where ‘N’ is the total number of elements in the input
	 * set. And since we construct a new subset from an existing set, therefore, the
	 * time complexity of the above algorithm will be O(N*2^N).
	 * 
	 * Space complexity # All the additional space used by our algorithm is for the
	 * output list. Since we will have a total of O(2^N) subsets, and each subset
	 * can take up to O(N) space, therefore, the space complexity of our algorithm
	 * will be O(N*2^N).
	 */

}
