/**
 * 
 */
package home.ak.algo.dp.pattern4;

import java.util.Arrays;

/**
 * @author kundu
 * 
 *         There are N big cubes which are arranged sequentially at equal
 *         distances. You are standing on the first cube indexed 0. You need to
 *         jump over the cubes to reach to the end. In one jump you can jump
 *         over maximum of X stones. Whenever you jump on a stone you need to
 *         pay certain coins. You need to figure out what is the minimum coins
 *         that you need to pay to reach the last stone. The coins that need to
 *         be paid at each stone is given in an array C.
 * 
 *         State: i -> current index
 * 
 *         Cost Function: minCost(i, C, X)
 * 
 *         Base Case: if i = 0, return 0
 * 
 *         If we are at index i. We must have reached at i by jumping anywhere
 *         between 1 and X blocks. So we must haved jumped from i-1 or i-2 or
 *         i-X. Now we can reduce the problem to smaller problems
 * 
 *         minCost(i, C, X) = MIN(minCost(i - 1, C, X), minCost(i-2, C, X),...,
 *         minCost(i - X, C, X))
 * 
 *         Optimal choice: Because we are want path which costs least amount we
 *         pick the minimum minCost(i,C,X) = MIN(minCost(i-j)) for j=1,2,3…X and
 *         i-j >=0
 *
 */
public class StoneJumpProblem {

	/**
	 * Bottom up equation dp[i] = MIN(dp[i-j]+C[i]) for j=1,2,….X AND (i-j)>=0
	 */
	public static int minCostBU(int[] cost, int X) {
		int stones = cost.length;
		int[] dp = new int[stones];
		Arrays.fill(dp, Integer.MAX_VALUE);
		// Base case: Since we are standing on the 0th stone
		dp[0] = 0;

		for (int i = 1; i < stones; i++) {
			for (int j = 1; j <= Math.min(i, X); j++) {
				dp[i] = Math.min(dp[i], cost[i] + dp[i - j]);
			}
		}
		return dp[stones - 1];
	}

	public static void main(String[] args) {
		int[] cost = { 0, 20, 30, 40, 25, 15, 20, 28 };
		System.out.println(minCostBU(cost, 3));
	}

}
