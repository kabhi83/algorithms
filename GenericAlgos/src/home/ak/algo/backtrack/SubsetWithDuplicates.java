/**
 * 
 */
package home.ak.algo.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kundu
 *
 */
public class SubsetWithDuplicates {

	public static List<List<Integer>> findSubsets(int[] nums) {
		List<List<Integer>> subsets = new ArrayList<>();

		if (null == nums || nums.length == 0) {
			return subsets;
		}
		// Sort the array
		Arrays.sort(nums);
		findSubsetsRecursive(0, new ArrayList<Integer>(), nums, subsets);
		return subsets;
	}

	private static void findSubsetsRecursive(int index, List<Integer> current, int[] nums,
			List<List<Integer>> subsets) {
		// Add the current to the list of subsets
		subsets.add(new ArrayList<Integer>(current));
		for (int i = index; i < nums.length; i++) {
			// Check if duplicate and ignore
			if (i != index && nums[i] == nums[i - 1]) {
				continue;
			}

			current.add(nums[i]);
			findSubsetsRecursive(i + 1, current, nums, subsets);
			current.remove(current.size() - 1);
		}
	}

	public static void main(String[] args) {
		List<List<Integer>> result = SubsetWithDuplicates.findSubsets(new int[] { 1, 3, 3 });
		System.out.println("Here is the list of subsets: " + result);

		result = SubsetWithDuplicates.findSubsets(new int[] { 1, 5, 3, 3 });
		System.out.println("Here is the list of subsets: " + result);
	}

}
