/**
 * 
 */
package home.ak.algo.dp;

import java.util.Arrays;

/**
 * @author kundu
 * 
 *         Given two strings word1 and word2, return the minimum number of
 *         operations required to convert word1 to word2.
 * 
 *         You have the following three operations permitted on a word:
 * 
 *         1. Insert a character
 * 
 *         2. Delete a character
 * 
 *         3. Replace a character
 * 
 *         Example: Input: word1 = "horse", word2 = "ros" Output: 3
 * 
 *         Explanation:
 * 
 *         horse -> rorse (replace 'h' with 'r')
 * 
 *         rorse -> rose (remove 'r')
 * 
 *         rose -> ros (remove 'e')
 *
 * 
 */
public class L32_EditDistance {

	public static int minDistanceTD(String word1, String word2) {
		int m = word1.length();
		int n = word2.length();
		int[][] dp = new int[m][n];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}

		return minDistanceTD(word1, m - 1, word2, n - 1, dp);
	}

	private static int minDistanceTD(String word1, int w1Idx, String word2, int w2Idx, int[][] dp) {
		// Base case
		if (w1Idx < 0) {
			// Insert operation
			return w2Idx + 1; // Add the remaining chars of word2
		}

		if (w2Idx < 0) {
			// Delete operation
			return w1Idx + 1; // Add the remaining chars of word1
		}

		if (dp[w1Idx][w2Idx] != -1) {
			return dp[w1Idx][w2Idx];
		}

		// In case of character match
		if (word1.charAt(w1Idx) == word2.charAt(w2Idx)) {
			// Reduce the size of both the strings
			return dp[w1Idx][w2Idx] = minDistanceTD(word1, w1Idx - 1, word2, w2Idx - 1, dp);
		} else {
			// Hypothetically we are inserting a character in word1 at end and cancelling it
			// with the word2 character. Hence word1 index remains in the same location
			// after cancellation and word2 size reduces by 1
			int insert = 1 + minDistanceTD(word1, w1Idx, word2, w2Idx - 1, dp);
			// We delete the character from the word1 and hence its size reduces by 1
			int delete = 1 + minDistanceTD(word1, w1Idx - 1, word2, w2Idx, dp);
			// We replace the character in word1 with the present character of word2 and
			// cancel both
			int replace = 1 + minDistanceTD(word1, w1Idx - 1, word2, w2Idx - 1, dp);

			return dp[w1Idx][w2Idx] = Math.min(replace, Math.min(insert, delete));
		}
	}

	/**
	 * @param word1
	 * @param word2
	 * @return
	 */
	public static int minDistanceBU(String word1, String word2) {
		int m = word1.length();
		int n = word2.length();
		int[][] dp = new int[m + 1][n + 1];

		// Initialize the base cases in dp array
		for (int i = 0; i <= m; i++) {
			dp[i][0] = i; // Add the remaining word2 length
		}

		for (int j = 0; j <= n; j++) {
			dp[0][j] = j; // Add the remaining word1 length
		}

		for (int idxW1 = 1; idxW1 <= m; idxW1++) {
			for (int idxW2 = 1; idxW2 <= n; idxW2++) {
				if (word1.charAt(idxW1 - 1) == word2.charAt(idxW2 - 1)) {
					dp[idxW1][idxW2] = dp[idxW1 - 1][idxW2 - 1];
				} else {
					int insert = 1 + dp[idxW1][idxW2 - 1];
					int delete = 1 + dp[idxW1 - 1][idxW2];
					int replace = 1 + dp[idxW1 - 1][idxW2 - 1];
					dp[idxW1][idxW2] = Math.min(insert, Math.min(replace, delete));
				}
			}
		}

		return dp[m][n];
	}

	public static void main(String[] args) {
		String word1 = "horse";
		String word2 = "ros";
		System.out.println(minDistanceTD(word1, word2));
		System.out.println(minDistanceBU(word1, word2));
	}

}
