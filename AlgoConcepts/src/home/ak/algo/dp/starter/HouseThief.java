/**
 * 
 */
package home.ak.algo.dp.starter;

/**
 * @author kundu
 * 
 *         Given a number array representing the wealth of n houses, determine
 *         the maximum amount of money the thief can steal without alerting the
 *         security system. The thief can’t steal in two adjacent houses because
 *         the owner of the stolen houses will tell his two neighbors left and
 *         right side.
 *
 */
public class HouseThief {
	// For every house, we have two option -
	// 1. Steal from the current house (i), skip one and steal from (i+2).
	// 2. Skip the current house (i), and steal from the adjacent house (i+1).

	/**
	 * Recursive solution
	 */
	public static int findMaxStealRecursive(int[] wealth) {
		return findMaxStealRecursive(wealth, 0);
	}

	private static int findMaxStealRecursive(int[] wealth, int currentIdx) {
		// Base case
		if (currentIdx >= wealth.length) {
			return 0;
		}

		int stealCurr = wealth[currentIdx] + findMaxStealRecursive(wealth, currentIdx + 2);
		int skipCurr = findMaxStealRecursive(wealth, currentIdx + 1);
		return Math.max(stealCurr, skipCurr);
	}

	/**
	 * Top down solution
	 */
	public static int findMaxStealTD(int[] wealth) {
		int[] cache = new int[wealth.length];
		int noOfHouses = wealth.length;
		// Start from the last house - top down approach
		return findMaxStealTD(wealth, noOfHouses - 1, cache);
	}

	private static int findMaxStealTD(int[] wealth, int currIdx, int[] cache) {
		if (currIdx < 0) {
			return 0;
		}
		if (currIdx == 0) {
			return wealth[0];
		}
		if (cache[currIdx] != 0) {
			return cache[currIdx];
		}
		int profit = Math.max(wealth[currIdx] + findMaxStealTD(wealth, currIdx - 2, cache),
				findMaxStealTD(wealth, currIdx - 1, cache));
		cache[currIdx] = profit;
		return profit;
	}

	/**
	 * Bottom up solution
	 */
	public static int findMaxStealBU(int[] wealth) {
		// Initialize the dp array
		int[] dp = new int[wealth.length + 1];
		dp[0] = 0;// explicitly resetting for 0th element
		dp[1] = wealth[0]; // Rob the first house

		for (int i = 2; i <= wealth.length; i++) {
			dp[i] = Math.max(dp[i - 2] + wealth[i - 1], dp[i -1]);
		}
		return dp[wealth.length];
	}

	public static void main(String[] args) {
		int[] wealth = { 2, 5, 1, 3, 6, 2, 4 };
		System.out.println(findMaxStealRecursive(wealth));
		System.out.println(findMaxStealTD(wealth));
		System.out.println(findMaxStealBU(wealth));
	}

}
