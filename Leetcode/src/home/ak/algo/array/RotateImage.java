/**
 * 
 */
package home.ak.algo.array;

import java.util.Arrays;

/**
 * @author kundu
 * 
 *         You are given an n x n 2D matrix representing an image, rotate the
 *         image by 90 degrees (clockwise).
 * 
 *         You have to rotate the image in-place, which means you have to modify
 *         the input 2D matrix directly. DO NOT allocate another 2D matrix and
 *         do the rotation.
 * 
 *         Example: Input: matrix = [[1,2,3],[4,5,6],[7,8,9]] Output:
 *         [[7,4,1],[8,5,2],[9,6,3]]
 */
public class RotateImage {

	/**
	 * Transpose + reverse
	 */
	public void rotate(int[][] matrix) {
		int N = matrix.length;
		// Find the in-place transpose of the matrix
		for (int i = 0; i < N; i++) {
			for (int j = i; j < N; j++) {
				int temp = matrix[i][j];
				 matrix[i][j] = matrix[j][i];
				 matrix[j][i] = temp;
			}
		}

		// Reverse with 2 pointers
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < (N / 2); j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][N - 1 - j];
				matrix[i][N - 1 - j] = temp;
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		new RotateImage().rotate(matrix);
		System.out.println(Arrays.deepToString(matrix));
	}

}
