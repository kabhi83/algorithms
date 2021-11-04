/**
 * 
 */
package home.ak.algo.dp.subset;

/**
 * @author kundu
 * 
 *         Given a set of positive numbers, determine if there exists a subset
 *         whose sum is equal to a given number ‘S’.
 *
 */
public class SubsetSum {

	/**
	 * Variation of 0/1 Knapsack problem
	 */
	static boolean canPartitionRecursive(int[] num, int sum) {
		return canPartitionRecursive(num, sum, num.length - 1);
	}

	private static boolean canPartitionRecursive(int[] num, int sum, int currIdx) {
		// Same include and exclude strategy
		if (sum == 0) {
			return true; // Found the result
		}
		if (currIdx < 0) {
			return false; // No more elements to consider
		}
		if (sum >= num[currIdx]) {
			boolean include = canPartitionRecursive(num, sum - num[currIdx], currIdx - 1);
			boolean exclude = canPartitionRecursive(num, sum, currIdx - 1);
			return include || exclude;
		} else {
			return canPartitionRecursive(num, sum, currIdx - 1);
		}
	}

	static boolean canPartitionBU(int[] num, int sum) {
		// Create the DP array
		boolean[][] dp = new boolean[num.length + 1][sum + 1];

		// If sum is 0, then answer is true, as we can always form '0' sum with an empty
		// set
		for (int i = 0; i <= num.length; i++) {
			dp[i][0] = true;
		}

		for (int i = 1; i <= num.length; i++) {
			for (int s = 1; s <= sum; s++) {
				if (num[i - 1] <= s) {
					dp[i][s] = dp[i - 1][s - num[i - 1]] || dp[i - 1][s];
				} else {
					dp[i][s] = dp[i - 1][s]; // only exclude
				}
			}
		}

		return dp[num.length][sum];
	}

	static boolean canPartitionBUOptimized(int[] num, int sum) {
		// Create the DP array
		boolean[][] dp = new boolean[num.length + 1][sum + 1];

		// If sum is 0, then answer is true, as we can always form '0' sum with an empty
		// set
		for (int i = 0; i <= num.length; i++) {
			dp[i][0] = true;
		}

		// with only one number, we can form a subset only when the required sum is
		// equal to its value
		for (int s = 1; s <= sum; s++) {
			dp[1][s] = (num[0] == s ? true : false); // Only applicable for 1st row
		}

		for (int i = 1; i <= num.length; i++) {
			for (int s = 1; s <= sum; s++) {
				// if we can get the sum 's' without the number at index 'i'
				if (dp[i - 1][s]) {
					dp[i][s] = dp[i - 1][s];
				} else if (s >= num[i - 1]) {
					dp[i][s] = dp[i - 1][s - num[i - 1]]; // Include the number
				}
			}
		}
		return dp[num.length][sum];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// test case 1
		int[] num = { 1, 2, 3, 7 };
		System.out.println(canPartitionRecursive(num, 6));
		System.out.println(canPartitionBU(num, 6));
		System.out.println(canPartitionBUOptimized(num, 6));

		// test case 2
		num = new int[] { 1, 2, 7, 1, 5 };
		System.out.println(canPartitionRecursive(num, 10));
		System.out.println(canPartitionBU(num, 10));

		// test case 3
		num = new int[] { 1, 3, 4, 8 };
		System.out.println(canPartitionRecursive(num, 6));
		System.out.println(canPartitionBU(num, 6));
		System.out.println(canPartitionBUOptimized(num, 6));
	}

}
