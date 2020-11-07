/**
 * 
 */
package home.ak.algo.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kundu
 * 
 *         Given an m x n matrix. If an element is 0, set its entire row and
 *         column to 0. Do it in-place.
 * 
 */
public class SetMatrixZeros {

	static class Pair {
		int x, y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public void setZeroes(int[][] matrix) {
		List<Pair> pairs = new ArrayList<>();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					pairs.add(new Pair(i, j));
				}
			}
		}

		for (Pair pair : pairs) {
			for (int i = 0; i < matrix[0].length; i++) {
				matrix[pair.x][i] = 0;
			}

			for (int j = 0; j < matrix.length; j++) {
				matrix[j][pair.y] = 0;
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] matrix = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
		new SetMatrixZeros().setZeroes(matrix);
		System.out.println(Arrays.deepToString(matrix));
	}

}
