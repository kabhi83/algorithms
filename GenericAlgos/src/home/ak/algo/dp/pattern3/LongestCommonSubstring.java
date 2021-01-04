/**
 * 
 */
package home.ak.algo.dp.pattern3;

/**
 * @author kundu
 * 
 *         Given two strings ‘s1’ and ‘s2’, find the length of the longest
 *         substring which is common in both the strings.
 * 
 *         Example 1: Input: s1 = "abdca" s2 = "cbda" Output: 2 Explanation: The
 *         longest common substring is "bd".
 * 
 *         Example 2: Input: s1 = "passport" s2 = "ppsspt" Output: 3
 *         Explanation: The longest common substring is "ssp".
 *
 */
public class LongestCommonSubstring {

	public static int findLCSLengthRecursive(String s1, String s2) {
		return findLCSLengthRecursive(s1, s2, 0, 0, 0);
	}

	private static int findLCSLengthRecursive(String s1, String s2, int idx1, int idx2, int count) {
		// Base Case:
		if (idx1 == s1.length() || idx2 == s2.length()) {
			return count;
		}

		// Case 1: Matching characters
		if (s1.charAt(idx1) == s2.charAt(idx2)) {
			return findLCSLengthRecursive(s1, s2, idx1 + 1, idx2 + 1, count + 1);
		}

		// Case 2: Mismatch
		int c1 = findLCSLengthRecursive(s1, s2, idx1 + 1, idx2, count);
		int c2 = findLCSLengthRecursive(s1, s2, idx1, idx2 + 1, count);

		return Math.max(c1, c2);
	}

	public static int findLCSLength(String s1, String s2) {
		int m = s1.length(), n = s2.length();

		// Initialize the DP array
		int[][] dp = new int[m + 1][n + 1];
		int maxLength = 0;
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
					maxLength = Math.max(maxLength, dp[i][j]);
				}
			}
		}
		return maxLength;
	}

	/*
	 * The time and space complexity of the above algorithm is O(m*n), where ‘m’ and
	 * ‘n’ are the lengths of the two input strings.
	 */

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(findLCSLength("abdca", "cbda"));
		System.out.println(findLCSLength("passport", "ppsspt"));
	}

}
