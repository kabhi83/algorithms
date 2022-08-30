/**
 * 
 */
package home.ak.algo.dp;

/**
 * @author kundu
 * 
 *         Given the dimension of a sequence of matrices in an array arr[],
 *         where the dimension of the ith matrix is (arr[i-1] * arr[i]), the
 *         task is to find the most efficient way to multiply these matrices
 *         together such that the total number of element multiplications is
 *         minimum.
 *
 */
public class L43_MatrixChainMultiplication {

	public static int matrixMultiplication(int[] arr) {
		// Since the Ai = arr[i - 1] * arr[i], i will start at 1 and j will be at N - 1
		int i = 1;
		int j = arr.length - 1;
		return matrixMultiplication(arr, i, j);
	}

	private static int matrixMultiplication(int[] arr, int i, int j) {
		// Base case
		if (i == j) {
			// Single element
			return 0;
		}

		int minVal = (int) Math.pow(10, 9);

		// Move k from i to j
		// k ranges from i to j - 1; fn(i, k) and fn(k+1, j)
		// Or k ranges from i + 1 to j; fn(i, k - 1) and fn(k, j)
		for (int k = i; k < j; k++) {
			minVal = Math.min(minVal, matrixMultiplication(arr, i, k) + matrixMultiplication(arr, k + 1, j)
					+ arr[i - 1] * arr[k] * arr[j]);
		}
		return minVal;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 3 };
		System.out.println(matrixMultiplication(arr));
	}
}
