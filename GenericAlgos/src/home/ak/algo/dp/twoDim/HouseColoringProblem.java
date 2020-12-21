/**
 * 
 */
package home.ak.algo.dp.twoDim;

import java.util.Arrays;

/**
 * @author kundu
 * 
 *         There are a row of n houses, each house can be painted with one of
 *         the three colors: red, blue or green. The cost of painting each house
 *         with a certain color is different. You have to paint all the houses
 *         such that no two adjacent houses have the same color. What is the
 *         minimum cost ?
 * 
 *         cost[][] = { { 17, 2, 17 }, { 16, 16, 5 }, { 14, 3, 9 } };
 * 
 *         RED = 0, BLUE = 1, GREEN = 2
 * 
 *         States: i - house index and c - color
 * 
 *         Cost function: minCost(i, c)
 * 
 *         Base Case: when i == n, we have reached the end
 * 
 *         Recurrence relation:
 * 
 *         1. minCost(i, Red) = cost[i][RED] + MIN(minCost(i+1, BLUE) +
 *         minCost(i+1, GREEN)) 2. minCost(i, BLUE) = cost[i][BLUE] +
 *         MIN(minCost(i+1, RED) + minCost(i+1, GREEN)) 3. minCost(i, GREEN) =
 *         cost[i][GREEN] + MIN(minCost(i+1, RED) + minCost(i+1, BLUE))
 *
 */
public class HouseColoringProblem {

	public static final int RED = 0;
	public static final int BLUE = 1;
	public static final int GREEN = 2;

	public static int minCostRecursive(int[][] cost) {
		int costRed = minCostRecursive(cost, 0, RED);
		int costBlue = minCostRecursive(cost, 0, BLUE);
		int costGreen = minCostRecursive(cost, 0, GREEN);
		return Math.min(costRed, Math.min(costBlue, costGreen));
	}

	private static int minCostRecursive(int[][] cost, int i, int color) {

		if (i == cost.length) {
			return 0;
		}

		switch (color) {
		case RED: {
			int costBlue = minCostRecursive(cost, i + 1, BLUE);
			int costGreen = minCostRecursive(cost, i + 1, GREEN);
			return cost[i][RED] + Math.min(costBlue, costGreen);
		}
		case BLUE: {
			int costRed = minCostRecursive(cost, i + 1, RED);
			int costGreen = minCostRecursive(cost, i + 1, GREEN);
			return cost[i][BLUE] + Math.min(costRed, costGreen);
		}
		case GREEN: {
			int costRed = minCostRecursive(cost, i + 1, RED);
			int costBlue = minCostRecursive(cost, i + 1, BLUE);
			return cost[i][GREEN] + Math.min(costRed, costBlue);
		}
		}
		return 0;
	}

	/*-------------------------------------------------------------------------*/

	public static int minCostTD(int[][] cost) {
		int[][] dp = new int[cost.length][cost[0].length];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}
		int costRed = minCostTD(cost, 0, RED, dp);
		int costBlue = minCostTD(cost, 0, BLUE, dp);
		int costGreen = minCostTD(cost, 0, GREEN, dp);
		return Math.min(costRed, Math.min(costBlue, costGreen));
	}

	private static int minCostTD(int[][] cost, int i, int color, int[][] dp) {
		if (i == cost.length) {
			return 0;
		}

		if (dp[i][color] != -1) {
			return dp[i][color];
		}

		switch (color) {
		case RED: {
			int costBlue = minCostRecursive(cost, i + 1, BLUE);
			int costGreen = minCostRecursive(cost, i + 1, GREEN);
			return dp[i][color] = cost[i][RED] + Math.min(costBlue, costGreen);

		}
		case BLUE: {
			int costRed = minCostRecursive(cost, i + 1, RED);
			int costGreen = minCostRecursive(cost, i + 1, GREEN);
			return dp[i][color] = cost[i][BLUE] + Math.min(costRed, costGreen);
		}
		case GREEN: {
			int costRed = minCostRecursive(cost, i + 1, RED);
			int costBlue = minCostRecursive(cost, i + 1, BLUE);
			return dp[i][color] = cost[i][GREEN] + Math.min(costRed, costBlue);
		}
		}
		return 0;
	}

	/*-------------------------------------------------------------------------*/

	public static int minCostBU(int[][] cost) {
		if (cost.length == 0)
			return 0;

		// Initialize the dp array
		int[][] dp = new int[cost.length + 1][cost[0].length];

		int n = cost.length;

		for (int i = 1; i <= cost.length; i++) {
			dp[i][RED] = cost[i - 1][RED] + Math.min(dp[i - 1][BLUE], dp[i - 1][GREEN]);
			dp[i][BLUE] = cost[i - 1][BLUE] + Math.min(dp[i - 1][RED], dp[i - 1][GREEN]);
			dp[i][GREEN] = cost[i - 1][GREEN] + Math.min(dp[i - 1][RED], dp[i - 1][BLUE]);
		}

		return Math.min(dp[n][RED], Math.min(dp[n][BLUE], dp[n][GREEN]));
	}

	public static void main(String[] args) {
		int cost[][] = { { 17, 2, 17 }, { 16, 16, 5 }, { 14, 3, 9 } };
		int resultRec = minCostRecursive(cost);
		int resultTD = minCostTD(cost);
		int resultBU = minCostBU(cost);
		System.out.println(resultRec + " " + resultTD + " " + resultBU);
	}

}
