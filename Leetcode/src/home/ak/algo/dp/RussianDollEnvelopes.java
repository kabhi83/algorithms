/**
 * 
 */
package home.ak.algo.dp;

import java.util.Arrays;

/**
 * @author kundu
 * 
 *         You have a number of envelopes with widths and heights given as a
 *         pair of integers (w, h). One envelope can fit into another if and
 *         only if both the width and height of one envelope is greater than the
 *         width and height of the other envelope.
 * 
 *         What is the maximum number of envelopes can you Russian doll? (put
 *         one inside other)
 * 
 *         Note: Rotation is not allowed.
 * 
 *         Example: Input: [[5,4],[6,4],[6,7],[2,3]] Output: 3
 * 
 *         Explanation: The maximum number of envelopes you can Russian doll is
 *         3 ([2,3] => [5,4] => [6,7]).
 *
 */
public class RussianDollEnvelopes {

	public static int maxEnvelopes(int[][] envelopes) {

		// Sort the envelopes by both width and height
		Arrays.sort(envelopes, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));

		// Initialize the dp array
		int[] dp = new int[envelopes.length];
		// At least 1 envelope will be returned
		Arrays.fill(dp, 1);

		int max = 1;
		// Check how many jth envelopes can fit in ith envelope
		for (int i = 1; i < envelopes.length; i++) {
			for (int j = 0; j < i; j++) {
				//compare the dimensions
				if(envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
					max = Math.max(max, dp[i]);
				}
			}
		}
		return max;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
		System.out.println(maxEnvelopes(envelopes));
	}

}
