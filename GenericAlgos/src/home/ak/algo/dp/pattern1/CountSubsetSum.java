/**
 * 
 */
package home.ak.algo.dp.pattern1;

/**
 * @author kundu
 * 
 *         Given a set of positive numbers, find the total number of subsets
 *         whose sum is equal to a given number ‘S’.
 *
 */
public class CountSubsetSum {

	/**
	 * Compute all the possible solutions by including the current item and then by
	 * excluding the item
	 */
	public static int countSubsetsRecursive(int[] nums, int sum) {
		return countSubsetsRecursive(nums, sum, 0);
	}

	private static int countSubsetsRecursive(int[] nums, int sum, int index) {
		// Base Case: to stop the recursion
		if (sum == 0) {
			return 1; // success
		}

		if (nums.length == 0 || index >= nums.length) {
			return 0; // Failure case
		}

		// Include the element and process
		int sum1 = 0;
		if (sum >= nums[index])
			sum1 = countSubsetsRecursive(nums, sum - nums[index], index + 1);
		int sum2 = countSubsetsRecursive(nums, sum, index + 1);

		return sum1 + sum2;

		/*
		 * The time complexity of the above algorithm is exponential O(2^n) where ‘n’
		 * represents the total number. The space complexity is O(n), this memory is
		 * used to store the recursion stack.
		 */
	}

	public static int countSubsets(int[] nums, int sum) {
		int n = nums.length;
		// We will try to find if we can make all possible sums with every subset to
		// populate the array
		int[][] dp = new int[n][sum + 1];

		// Sum 0 can be formed with empty subset
		for (int i = 0; i < n; i++) {
			dp[i][0] = 1;
		}

		for (int s = 1; s <= sum; s++) {
			if (nums[0] == s) {
				dp[0][s] = 1;
			}
		}
		// process all subsets for all sums
		for (int i = 1; i < n; i++) {
			for (int s = 1; s <= sum; s++) {
				// Exclude the number
				dp[i][s] = dp[i - 1][s];
				if (s >= nums[i]) {
					// include the number
					dp[i][s] += dp[i - 1][s - nums[i]];
				}
			}
		}
		return dp[n - 1][sum];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = { 1, 1, 2, 3 };
		System.out.println(countSubsetsRecursive(nums, 4));
		System.out.println(countSubsets(nums, 4));
	}

}
