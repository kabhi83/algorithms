/**
 * 
 */
package home.ak.algo.dp;

/**
 * @author kundu
 * 
 *         Given a sequence, find the length of its Longest Palindromic
 *         Subsequence (LPS). In a palindromic subsequence, elements read the
 *         same backward and forward.
 *
 */
public class L27_LongestPalidromicSubsequence {

	public static int lps(String str) {
		String str1 = str;
		String str2 = new StringBuilder(str).reverse().toString();
		int n = str.length();

		int[][] dp = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = 0 + Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		
		return dp[n][n];
	}
	
	public static void main(String[] args) {
		String str = "abdbca";
		System.out.println(lps(str));
		str = "agbcba";
		System.out.println(lps(str));
		str = "aabb";
		System.out.println(lps(str));
	}

}
