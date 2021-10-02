package ak.home.algo.dp.lcs;

/**
 * @author kundu
 * 
 *         Given a sequence, find the length of its longest repeating
 *         subsequence (LRS). A repeating subsequence will be the one that
 *         appears at least twice in the original sequence and is not
 *         overlapping (i.e. none of the corresponding characters in the
 *         repeating subsequences have the same index).
 * 
 *         Ex: Input: “t o m o r r o w” Output: 2
 * 
 *         Explanation: The longest repeating subsequence is “or” {tomorrow}.
 *
 */
public class LongestRepeatingSubsequence {

	/**
	 * This problem is the variation of LCS with the only condition that the index
	 * of the matching character should not be equal. This will ensure that the
	 * repeating characters are present in two different indexes and follows the
	 * subsequence properties
	 */
	public static int longestRepeatingSubSequence(String str) {

		// Intitialize DP array
		int[][] dp = new int[str.length() + 1][str.length() + 1];

		for (int i = 1; i <= str.length(); i++) {
			for (int j = 1; j <= str.length(); j++) {
				if (str.charAt(i - 1) == str.charAt(j - 1) && i != j) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		}

		return dp[str.length()][str.length()];
	}

	public static void main(String[] args) {
		String str = "tomorrow";
		System.out.println(longestRepeatingSubSequence(str));
		str = "aabdbcec";
		System.out.println(longestRepeatingSubSequence(str));
	}

}
