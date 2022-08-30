/**
 * 
 */
package home.ak.algo.dp;

/**
 * @author kundu
 * 
 *         A palindrome string is one that reads the same backward as well as
 *         forward. Given a string 'STR', you need to tell the minimum number of
 *         characters needed to insert into it to make it a palindromic string.
 *
 */
public class L28_MinInsertionForPalindrome {

	public static int minInsertion(String str) {
		int n = str.length();
		String str1 = str;
		String str2 = new StringBuilder(str).reverse().toString();
		int[][] dp = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		int lpsLength = dp[n][n];
		int noOfCharInsertions = n - lpsLength;
		return noOfCharInsertions;
	}
	
	public static void main(String[] args) {
		String str = "abdbca";
		System.out.println(minInsertion(str));
	}

}
