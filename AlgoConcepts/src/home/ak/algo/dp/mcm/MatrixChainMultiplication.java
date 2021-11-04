/**
 * 
 */
package home.ak.algo.dp.mcm;

import java.util.Arrays;

/**
 * @author kundu
 * 
 *         Given a sequence of matrices, find the most efficient way to multiply
 *         these matrices together. The problem is not actually to perform the
 *         multiplications, but merely to decide in which order to perform the
 *         multiplications.
 * 
 *         Format of MCM Problems:
 * 
 *         1. Find i and j, 2. Find Base Condition, 3. Find k loop scheme
 *
 */
public class MatrixChainMultiplication {

	public static enum Strategy {
		RECURSIVE, TOP_DOWN;
	}

	public static int matrixChainMultiplication(int[] arr, Strategy strategy) {
		int N = arr.length;
		// Number of matrics is N - 1,
		// where A1 = arr[0] * arr[1], A2 = arr[1] * arr[2],..., A4 = arr[3] * arr[4]
		if (strategy == Strategy.RECURSIVE) {
			return solveRecursive(arr, 1, N - 1);
		} else if (strategy == Strategy.TOP_DOWN) {
			int[][] dp = new int[arr.length + 1][arr.length + 1];
			for (int[] row : dp) {
				Arrays.fill(row, -1);
			}
			return solveTD(arr, 1, N - 1, dp);
		}
		return 0;
	}

	private static int solveRecursive(int[] arr, int i, int j) {
		if (i >= j) {
			// i == j is 1 array element and hence we cannot derive the dimension
			// i > j signifies zero array element
			return 0;
		}
		int ans = Integer.MAX_VALUE;
		// k should be selected in a way to form 2 groups always i - k and k+1 to j
		// No groups can be empty
		for (int k = i; k <= j - 1; k++) {
			int tempAns = solveRecursive(arr, i, k) + solveRecursive(arr, k + 1, j) + arr[i - 1] * arr[k] * arr[j];
			ans = Math.min(ans, tempAns);
		}
		return ans;
	}

	/**
	 * Top Down approach (Recursion + Memoization)
	 */
	private static int solveTD(int[] arr, int i, int j, int[][] dp) {
		if (i >= j) {
			return 0;
		}

		if (dp[i][j] != -1) {
			return dp[i][j];
		}

		int ans = Integer.MAX_VALUE;
		for (int k = i; k <= j - 1; k++) {
			int tempAns = solveRecursive(arr, i, k) + solveRecursive(arr, k + 1, j) + arr[i - 1] * arr[k] * arr[j];
			ans = Math.min(ans, tempAns);
		}
		return dp[i][j] = ans;
	}

	public static void main(String[] args) {
		int[] arr = { 40, 20, 30, 10, 30 };
		System.out.println(matrixChainMultiplication(arr, Strategy.RECURSIVE));
		System.out.println(matrixChainMultiplication(arr, Strategy.TOP_DOWN));
	}

}
