/**
 * 
 */
package home.ak.algo.dp;

import java.util.Arrays;

/**
 * @author kundu
 * 
 *         Given a rod of length ‘N’ units. The rod can be cut into different
 *         sizes and each size has a cost associated with it. Determine the
 *         maximum cost obtained by cutting the rod and selling its pieces.
 *         Note: 1. The sizes will range from 1 to ‘N’ and will be integers.
 * 
 *         2. The sum of the pieces cut should be equal to ‘N’.
 * 
 *         3. Consider 1-based indexing.
 *
 */
public class L24_RodCuttingProblem {

	public static int cutRodTD(int price[], int n) {
		int[][] dp = new int[n][n + 1];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}
		return cutRodTD(price, n - 1, n, dp);
	}

	private static int cutRodTD(int[] price, int idx, int length, int[][] dp) {
		if (idx == 0) {
			// current piece size is 1; hence remaining length can be fulfilled with this
			// piece
			return length * price[0];
		}
		if (dp[idx][length] != -1) {
			return dp[idx][length];
		}
		// Consider all possibilities per index and take the maximum
		int noTake = 0 + cutRodTD(price, idx - 1, length, dp);
		int take = Integer.MIN_VALUE;
		int pieceLength = idx + 1; // 1 based index refers to the segment length
		if (length >= pieceLength) {
			// Infinite supply - index will not change
			take = price[idx] + cutRodTD(price, idx, length - pieceLength, dp);
		}
		return dp[idx][length] = Math.max(take, noTake);
	}

	public static int cutRodBU(int price[], int n) {
		int[][] dp = new int[n][n + 1];
		for (int i = 1; i <= n; i++) {
			dp[0][i] = price[0] * i;
		}
		for (int idx = 1; idx < n; idx++) {
			for (int len = 0; len <= n; len++) {
				int noTake = 0 + dp[idx - 1][len];
				int take = Integer.MIN_VALUE;
				if (len >= idx + 1) {
					take = price[idx] + dp[idx][len - (idx + 1)];
				}
				dp[idx][len] = Math.max(take, noTake);
			}
		}
		return dp[n - 1][n];
	}

	public static void main(String[] args) {
		int[] price = { 2, 5, 7, 8, 10 };
		System.out.println(cutRodTD(price, price.length));
		System.out.println(cutRodBU(price, price.length));

		price = new int[] { 3, 5, 8, 9, 10, 17, 17, 20 };
		System.out.println(cutRodTD(price, price.length));
		System.out.println(cutRodBU(price, price.length));
	}

}
