/**
 * 
 */
package home.ak.algo.dp;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author kundu
 * 
 *         Given a non-empty array nums containing only positive integers, find
 *         if the array can be partitioned into two subsets such that the sum of
 *         elements in both subsets is equal.
 *
 */
public class PartitionEqualSubsetSum {

	public boolean canPartition(int[] nums) {
		int total = Arrays.stream(nums).sum();
		if (total % 2 != 0) {
			return false;
		}
		return canPartition(nums, 0, 0, total, new HashMap<String, Boolean>());
	}

	/**
	 * Top down approach by saving the state of the computation
	 */
	private boolean canPartition(int[] nums, int index, int sum, int total, HashMap<String, Boolean> states) {
		String currentState = index + " " + sum;
		if (states.containsKey(currentState)) {
			return states.get(currentState);
		}
		if (sum * 2 == total) {
			return true;
		}

		if (sum > total / 2 || index >= nums.length) {
			return false;
		}

		Boolean foundPartition = canPartition(nums, index + 1, sum, total, states)
				|| canPartition(nums, index + 1, sum + nums[index], total, states);
		states.put(currentState, foundPartition);
		return foundPartition;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
