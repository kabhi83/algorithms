/**
 * 
 */
package ak.home.algo.dp.lcs;

/**
 * @author kundu
 * 
 *         Given a sequence, find the length of its Longest Palindromic
 *         Subsequence (LPS). In a palindromic subsequence, elements read the
 *         same backward and forward.
 *
 */
public class LongestPalindromicSubsequence {

	/**
	 * This problem is the continuation of the LCS series problem. LPS of a string
	 * is same as the LCS of the string and the reverse of the same string
	 */
	public static int lps(String str) {

		// Initialize DP array
		int[][] dp = new int[str.length() + 1][str.length() + 1];

		String str1 = str;
		String str2 = new StringBuilder(str).reverse().toString();

		for (int i = 1; i <= str.length(); i++) {
			for (int j = 1; j <= str.length(); j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}

			}
		}
		return dp[str.length()][str.length()];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "abdbca";
		System.out.println(lps(str));
		str = "agbcba";
		System.out.println(lps(str));
		str = "aabb";
		System.out.println(lps(str));
	}

}
