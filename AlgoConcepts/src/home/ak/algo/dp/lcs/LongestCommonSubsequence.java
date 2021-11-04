/**
 * 
 */
package home.ak.algo.dp.lcs;

/**
 * @author kundu
 * 
 *         Given two strings ‘s1’ and ‘s2’, find the length of the longest
 *         subsequence which is common in both the strings.
 *
 */
public class LongestCommonSubsequence {

	public static int lcsRecursive(String str1, String str2) {
		return lcsRecursive(str1, str1.length(), str2, str2.length());
	}

	private static int lcsRecursive(String str1, int m, String str2, int n) {
		// Base case
		if (m == 0 || n == 0) {
			return 0;
		}

		if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
			return 1 + lcsRecursive(str1, m - 1, str2, n - 1);
		} else {
			return Math.max(lcsRecursive(str1, m, str2, n - 1), lcsRecursive(str1, m - 1, str2, n));
		}
	}

	public static int lcsBU(String str1, String str2) {
		// Initialize the DP array
		int[][] dp = new int[str1.length() + 1][str2.length() + 1];

		// 1st row and 1st column are 0 implicitly - base case of recursive call
		for (int i = 1; i <= str1.length(); i++) {
			for (int j = 1; j <= str2.length(); j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		return dp[str1.length()][str2.length()];
	}

	public static void main(String[] args) {
		String s1 = "abdca", s2 = "cbda";
		System.out.println(lcsRecursive(s1, s2));
		System.out.println(lcsBU(s1, s2));
	}

}
