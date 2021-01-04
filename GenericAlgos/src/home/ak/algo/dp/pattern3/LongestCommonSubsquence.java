/**
 * 
 */
package home.ak.algo.dp.pattern3;

/**
 * @author kundu
 * 
 *         Given two strings ‘s1’ and ‘s2’, find the length of the longest
 *         subsequence which is common in both the strings.
 * 
 *         A subsequence is a sequence that can be derived from another sequence
 *         by deleting some or no elements without changing the order of the
 *         remaining elements.
 * 
 *         Example 1: Input: s1 = "abdca" s2 = "cbda" Output: 3 Explanation: The
 *         longest common subsequence is "bda".
 * 
 *         Example 2: Input: s1 = "passport" s2 = "ppsspt" Output: 5
 *         Explanation: The longest common subsequence is "psspt".
 *
 */
public class LongestCommonSubsquence {

	static int findLCSLengthRecursive(String s1, String s2) {
		return findLCSLengthRecursive(s1, s2, 0, 0);
	}

	private static int findLCSLengthRecursive(String s1, String s2, int idx1, int idx2) {
		// Base Case
		if (idx1 == s1.length() || idx2 == s2.length()) {
			return 0;
		}

		if (s1.charAt(idx1) == s2.charAt(idx2)) {
			return 1 + findLCSLengthRecursive(s1, s2, idx1 + 1, idx2 + 1);
		} else {
			int c1 = findLCSLengthRecursive(s1, s2, idx1 + 1, idx2);
			int c2 = findLCSLengthRecursive(s1, s2, idx1, idx2 + 1);
			return Math.max(c1, c2);
		}
	}

	static int findLCSLength(String s1, String s2) {
		int m = s1.length(), n = s2.length();
		if (m == 0 || n == 0) {
			return 0;
		}

		// Initialize DP array
		int[][] dp = new int[m + 1][n + 1];

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		
		return dp[m][n];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(findLCSLengthRecursive("abdca", "cbda"));
	    System.out.println(findLCSLengthRecursive("passport", "ppsspt"));
		System.out.println(findLCSLength("abdca", "cbda"));
	    System.out.println(findLCSLength("passport", "ppsspt"));

	}

}
