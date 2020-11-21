/**
 * 
 */
package home.ak.algo.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author kundu
 * 
 *         Given a set of distinct numbers, find all of its permutations.
 *
 */
public class Permutations {

	public static List<List<Integer>> findPermutations(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();

		if (null == nums || nums.length == 0) {
			return result;
		}

		permute(nums, result, 0, nums.length - 1);

		return result;
	}

	private static void permute(int[] nums, List<List<Integer>> result, int left, int right) {
		if(left == right) {
			result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
		}
		
		for(int i = left; i <= right; i++) {
			swap(nums, left, i);
			permute(nums, result, left + 1, right);
			//restore the item back in nums - backtrack
			swap(nums, left, i);
			
		}
	}

	private static void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	public static void main(String[] args) {
		List<List<Integer>> result = Permutations.findPermutations(new int[] { 1, 3, 5 });
		System.out.print("Here are all the permutations: " + result);
	}

}
