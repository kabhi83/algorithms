package home.ak.algo.dp;

import java.util.Arrays;

/**
 * @author kundu
 * 
 *         Ninja has a 'GRID' of size 'R' X 'C'. Each cell of the grid contains
 *         some chocolates. Ninja has two friends Alice and Bob, and he wants to
 *         collect as many chocolates as possible with the help of his friends.
 *         Initially, Alice is in the top-left position i.e. (0, 0), and Bob is
 *         in the top-right place i.e. (0, ‘C’ - 1) in the grid. Each of them
 *         can move from their current cell to the cells just below them. When
 *         anyone passes from any cell, he will pick all chocolates in it, and
 *         then the number of chocolates in that cell will become zero. If both
 *         stay in the same cell, only one of them will pick the chocolates in
 *         it. If Alice or Bob is at (i, j) then they can move to (i + 1, j), (i
 *         + 1, j - 1) or (i + 1, j + 1). They will always stay inside the
 *         ‘GRID’. Your task is to find the maximum number of chocolates Ninja
 *         can collect with the help of his friends by following the above
 *         rules.
 * 
 *         Example: Input: ‘R’ = 3, ‘C’ = 4
 * 
 *         ‘GRID’ = [[2, 3, 1, 2], [3, 4, 2, 2], [5, 6, 3, 5]]
 * 
 *         Output: 21
 * 
 *         Initially Alice is at the position (0,0) he can follow the path (0,0)
 *         -> (1,1) -> (2,1) and will collect 2 + 4 + 6 = 12 chocolates.
 * 
 *         Initially Bob is at the position (0, 3) and he can follow the path
 *         (0, 3) -> (1,3) -> (2, 3) and will colllect 2 + 2 + 5 = 9 chocolates.
 * 
 *         Hence the total number of chocolates collected will be 12 + 9 = 21.
 *         there is no other possible way to collect a greater number of
 *         chocolates than 21.
 *
 */
public class L13_ChocolatePickup {

	/**
	 * This is a fixed start to variable end problem
	 */
	public static int maximumChocolates(int r, int c, int[][] grid) {
		int dp[][][] = new int[r][c][c];
		for (int row1[][] : dp) {
			for (int row2[] : row1) {
				Arrays.fill(row2, -1);
			}
		}
		// Both Alice and Bob need to move together and both need to move to the next
		// row. Hence the variables here are i (for both Alice & Bob), j1 (for Alice's
		// movement across the possible columns) and j2 (for Bob's movement across the
		// possible columns)
		return maximumChocolates(0, 0, c - 1, r, c, grid, dp);
	}

	private static int maximumChocolates(int i, int j1, int j2, int r, int c, int[][] grid, int[][][] dp) {
		// Base cases
		// Case 1: Out of bound cases
		if (j1 < 0 || j1 >= c || j2 < 0 || j2 >= c) {
			return (int) Math.pow(-10, 9); // High negative value
		}
		// Case 2: Destination reached
		if (i == r - 1) {
			if (j1 == j2) {
				return grid[i][j1]; // or grid[i][j2]
			} else {
				// different column values
				return grid[i][j1] + grid[i][j2];
			}
		}
		if (dp[i][j1][j2] != -1) {
			return dp[i][j1][j2];
		}

		int max = Integer.MIN_VALUE;
		int ans = 0;
		int[] direction = { -1, 0, 1 };
		// Note: for every movement of Alice's, Bob can move into 3 possible columnar
		// direction. Hence there are 3 * 3 possibilities
		for (int da : direction) { // Direction for Alice's movement
			for (int db : direction) { // Direction for Bob's movement
				if (j1 == j2) {
					// consider single value
					ans = grid[i][j1] + maximumChocolates(i + 1, j1 + da, j2 + db, r, c, grid, dp);
				} else {
					ans = grid[i][j1] + grid[i][j2] + maximumChocolates(i + 1, j1 + da, j2 + db, r, c, grid, dp);
				}
				max = Math.max(max, ans);
			}
		}
		return dp[i][j1][j2] = max;
	}

	public static void main(String[] args) {
		int matrix[][] = { { 2, 3, 1, 2 }, { 3, 4, 2, 2 }, { 5, 6, 3, 5 } };
		int r = matrix.length;
		int c = matrix[0].length;
		System.out.println(maximumChocolates(r, c, matrix));
	}

}
