/**
 * 
 */
package home.ak.algo.dp.lcs;

/**
 * @author kundu
 * 
 *         Given two strings str1 and str2, the task is to find the length of
 *         the shortest string that has both str1 and str2 as subsequences.
 * 
 *         Example: Input: str1 = "AGGTAB", str2 = "GXTXAYB" Output: 9
 *         Explanation: String "AGXGTXAYB" has both string "AGGTAB" and
 *         "GXTXAYB" as subsequences.
 */
public class ShortestCommonSupersequence {

	/**
	 * The solution to this problem is two step. First step is to find the LCS
	 * between two strings. This is the common part of both the string. And, second
	 * step is to sum the length of both strings and subtract the common part once
	 * from the total length. As the common part should include in both the string
	 * only once.
	 * 
	 * For the example - str1 = "AGGTAB", str2 = "GXTXAYB", the worst case
	 * super-sequence is "AGGTABGXTXAYB". But the common part (LCS) of both the
	 * String is GTAB and hence it should exist once in the super-sequence.
	 * 
	 * Hence, scs length = length("AGGTABGXTXAYB") - LCS = 13 - 4 = 9
	 * 
	 */
	public static int shortestSuperSequence(String str1, String str2) {

		// Step 1: Finding the LCS
		// Initialize the dp array
		int[][] dp = new int[str1.length() + 1][str2.length() + 1];

		// 1st row and 1st column are implicitly 0
		for (int i = 1; i <= str1.length(); i++) {
			for (int j = 1; j <= str2.length(); j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		int lcs = dp[str1.length()][str2.length()];

		int totalLength = str1.length() + str2.length();

		return totalLength - lcs;
	}

	public static void main(String[] args) {
		String str1 = "AGGTAB", str2 = "GXTXAYB";
		System.out.println(shortestSuperSequence(str1, str2));
	}

}
