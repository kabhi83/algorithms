/**
 * 
 */
package home.ak.algo.dp.twoDim;

/**
 * @author kundu
 * 
 *         Given a matrix of 0’s and 1’s (binary matrix). Find out Maximum size
 *         square sub-matrix with all 1’s.
 * 
 *         State: row -> row index of the current element and col - column index
 *         of the current element
 * 
 *         Cost function: maxSquareSubMatrix(row, col, matrix)
 *
 */
public class MaxSquareSubMatrixProblem {

	public static int maxSquareSubMatrix(int[][] matrix) {
		int N = matrix.length;
		int[][] dp = new int[N + 1][N + 1];

		int max = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (matrix[i - 1][j - 1] == 0) {
					dp[i][j] = 0;
				} else {
					dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
				}

				max = Math.max(max, dp[i][j]);
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int[][] matrix = { 
					{ 0, 1, 0, 1, 0, 1 }, 
					{ 1, 0, 1, 0, 1, 0 }, 
					{ 0, 1, 1, 1, 1, 0 }, 
					{ 0, 0, 1, 1, 1, 0 },
					{ 1, 1, 1, 1, 1, 1 } 
					};
		System.out.println(maxSquareSubMatrix(matrix));
	}

}
