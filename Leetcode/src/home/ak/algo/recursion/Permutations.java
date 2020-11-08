package home.ak.algo.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author kundu
 * 
 *         Given a collection of distinct integers, return all possible
 *         permutations.
 * 
 *         Example: Input: [1,2,3]
 * 
 *         Output: [ [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1] ]
 *
 */
public class Permutations {

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		permute(nums, result, 0, nums.length - 1);
		return result;
	}

	private void permute(int[] nums, List<List<Integer>> result, int left, int right) {
		if (left == right) {
			result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
			return;
		}

		for (int i = left; i <= right; i++) {
			this.swap(nums, left, i);
			permute(nums, result, left + 1, right);
			this.swap(nums, left, i);
			// Because we are operating on the original numbers array so we need to switch
			// it back to its original form. But with the string, we created a new string
			// (returned by the swap function) that contains the swapped version and we
			// didn’t change our original string, so we just ignore it and keep operating on
			// the original string.
		}
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		System.out.println(new Permutations().permute(nums));
	}

}
