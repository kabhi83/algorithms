/**
 * 
 */
package ak.home.algo.dp.lcs;

/**
 * @author kundu
 * 
 *         Given a string, find the minimum number of characters that we can
 *         remove to make it a palindrome.
 *
 */
public class MinDeletionToPalindrome {

	/**
	 * This problem is similar to LPS. If we get to find the longest palindrome,
	 * then that translates to the minimum deletion required to get the palindromic
	 * string
	 */
	public static int minDeletionToPalindrome(String str) {

		// Initialize DP array for finding the LPS
		int[][] dp = new int[str.length() + 1][str.length() + 1];

		String str1 = str, str2 = new StringBuilder(str).reverse().toString();

		for (int i = 1; i <= str.length(); i++) {
			for (int j = 1; j <= str.length(); j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		}

		int lps = dp[str.length()][str.length()];

		int minDeletion = str.length() - lps;

		return minDeletion;
	}

	public static void main(String[] args) {
		String str = "abdbca";
		System.out.println(minDeletionToPalindrome(str));
	}

}
