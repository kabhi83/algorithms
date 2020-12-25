/**
 * 
 */
package home.ak.algo.dp.oneDim;

import java.util.Arrays;

/**
 * @author kundu
 * 
 *         Given a collection of boxes return the maximum number of boxes that
 *         can you Russian doll? (put one inside other). Each box has (w, h, l).
 *         Example:
 * 
 *         Input:{{3,9,9}, {1,4,10}, {5,10,11}, {3,9,3}, {1,5,3}, {7, 12, 1}}
 * 
 *         Output: 3
 * 
 *         Explanation: [1,5,3] fits in [3,9,9] which fits in [5,10,11]
 *
 */
public class BoxStackingProblemII {

	public static int solve(int[][] dim) {
		// Sort the array by all dimensions ( l, w, h)
		Arrays.sort(dim, (a, b) -> (a[0] == b[0] ? a[1] == b[1] ? a[2] - b[2] : a[1] - b[1] : a[0] - b[0]));

		System.out.println("All possible combination of boxes after rotation");
		for (int i = 0; i < dim.length; i++) {
			System.out.println(dim[i][0] + " " + dim[i][1] + " " + dim[i][2]);
		}

		// Initialize the dp array
		int[] dp = new int[dim.length];
		Arrays.fill(dp, 1);
		// check how many boxes i can accommodate
		// Something the increasing sub-sequence problem
		int max = 1;
		for (int i = 1; i < dim.length; i++) {
			for (int j = 0; j < i; j++) {
				if (dim[j][0] < dim[i][0] && dim[j][1] < dim[i][1] && dim[j][2] < dim[i][2]) {
					// If all the dimensions of j is less than i then only we can fit j in i
					dp[i] = Math.max(dp[i], dp[j] + 1);
					max = Math.max(max, dp[i]);
				}
			}
		}

		return max;
	}

	public static void main(String[] args) {
		int[][] dimensions = { { 3, 9, 9 }, { 1, 4, 10 }, { 5, 10, 11 }, { 3, 9, 3 }, { 1, 5, 3 }, { 7, 12, 1 } };
		System.out.println(solve(dimensions));
	}

}
