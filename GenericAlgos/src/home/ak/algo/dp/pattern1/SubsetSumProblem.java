/**
 * 
 */
package home.ak.algo.dp.pattern1;

/**
 * @author kundu
 * 
 *         Given a set of positive numbers, determine if there exists a subset
 *         whose sum is equal to a given number ‘S’.
 * 
 *         Example 1: # Input: {1, 2, 3, 7}, S=6 Output: True The given set has
 *         a subset whose sum is '6': {1, 2, 3}
 * 
 *         Example 2: # Input: {1, 2, 7, 1, 5}, S=10 Output: True The given set
 *         has a subset whose sum is '10': {1, 2, 7}
 *
 */
public class SubsetSumProblem {

	public static boolean canBuildSubsetSum(int[] nums, int sum) {
		int n = nums.length;

		// Create a initialize DP array
		boolean[][] dp = new boolean[n][sum + 1];

		// populate the sum=0 columns, as we can always form '0' sum with an empty set
		for (int i = 0; i < n; i++)
			dp[i][0] = true;

		for (int s = 1; s <= sum; s++) {
			// With one item, value of the item should be equal to the sum
			dp[0][s] = (nums[0] == s ? true : false);
		}

		// process all subsets for all sums
		for (int i = 1; i < n; i++) {
			for (int s = 1; s <= sum; s++) {
				// if we can get the sum 's' without the number at index 'i'
				if (dp[i - 1][s]) {
					dp[i][s] = dp[i - 1][s];
				} else if (s >= nums[i]) {
					// else include the number and see if we can find a subset to get the remaining
					// sum
					dp[i][s] = dp[i - 1][s - nums[i]];
				}
			}
		}

		return dp[n - 1][sum];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] num = { 1, 2, 3, 7 };
		System.out.println(canBuildSubsetSum(num, 6));
		num = new int[] { 1, 2, 7, 1, 5 };
		System.out.println(canBuildSubsetSum(num, 10));
		num = new int[] { 1, 3, 4, 8 };
		System.out.println(canBuildSubsetSum(num, 6));

	}

}
