/**
 * 
 */
package home.ak.algo.dp.oneDim;

/**
 * @author kundu
 * 
 *         A robber is planning to rob a row of houses. Each house has an amount
 *         of money stashed in it. He has to be careful as adjacent houses are
 *         installed with a security system which calls the police if two
 *         adjacent houses are robbed. The robber cannot rob two adjacent
 *         houses, he knows before hand how much stash each house has. He has to
 *         come up with a strategy to rob the houses such that he can make
 *         maximum profit without being caught by the police.
 * 
 *         S - is the array having the values of stash in each house.
 * 
 *         int[] S= { 20,25, 30, 15, 10 }
 * 
 *         State: i -> index of the house lat robbed
 * 
 *         Cost Function: maxProfit(i, S)
 * 
 *         Transition: Base case: If i = 0, return S[0], rob only the 1st house
 * 
 *         Recurrence relation: Max of either rob or don't
 * 
 *         maxProfit(i, S) = MAX(S[i] + maxProfit(i-2, S) + maxProfit(i - 1, S))
 *
 */
public class RobberProblem {

	public static int maxProfitRec(int[] S) {
		return maxProfitRec(S.length - 1, S);
	}

	public static int maxProfitRec(int i, int[] S) {
		// Base case check
		if (i < 0) {
			return 0;
		}
		if (i == 0) {
			// Houses are marked from index 0 to n-1
			return S[0];
		}
		// Either rob and take the stack else don't and next next stack
		return Math.max(S[i] + maxProfitRec(i - 2, S), maxProfitRec(i - 1, S));
	}

	public static int maxProfitTD(int[] S) {
		int[] cache = new int[S.length];
		return maxProfitTD(S.length - 1, S, cache);
	}

	public static int maxProfitTD(int i, int[] S, int[] dp) {
		// Base case check
		if (i < 0) {
			return 0;
		}
		if (i == 0) {
			// Houses are marked from index 0 to n-1
			return S[0];
		}

		// Check the cache value if present
		if (dp[i] != 0) {
			return dp[i];
		}
		// Compute value for dp[i]
		dp[i] = Math.max(S[i] + maxProfitTD(i - 2, S, dp), maxProfitTD(i - 1, S, dp));
		return dp[i];
	}

	/**
	 * Consider the state of all the houses to rob without getting caught
	 */
	public static int maxProfitBU(int[] S) {
		int noOfHouses = S.length;
		int[] dp = new int[noOfHouses];
		dp[0] = S[0];
		dp[1] = S[1];

		for (int i = 2; i < noOfHouses; i++) {
			dp[i] = Math.max(S[i] + dp[i - 2], dp[i - 1]);
		}

		return dp[noOfHouses - 1];
	}

	public static void main(String[] args) {
		// int[] S = { 20, 25, 30, 15, 10 };
		int[] S = { 20, 25, 30, 15, 10, 5, 12, 32, 25, 8, 15, 18 };
		System.out.println("Recurrence Solution: " + maxProfitRec(S));

		System.out.println("Top Down Solution: " + maxProfitTD(S));

		System.out.println("Bottom Up Solution: " + maxProfitBU(S));
	}

}
