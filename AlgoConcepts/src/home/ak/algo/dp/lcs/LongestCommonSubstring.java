/**
 * 
 */
package home.ak.algo.dp.lcs;

/**
 * @author kundu
 * 
 *         Given two strings ‘s1’ and ‘s2’, find the length of the longest
 *         substring which is common in both the strings.
 * 
 *         Example: Input: s1 = "abdca" s2 = "cbda". Output: 2
 * 
 *         Explanation: The longest common substring is "bd".
 * 
 *         Note: Substring is continuous, whereas subsequence is not continuous
 *
 */
public class LongestCommonSubstring {

	public static int longestCommonSubstring(String str1, String str2) {

		// Initialize the dp array
		int[][] dp = new int[str1.length() + 1][str2.length() + 1];

		// 1st row and 1st column are 0 - implicit. Base case of recursive solution
		// where we return 0 when either str1.length = 0 or str2.length = 0
		// In case of discontinuation, we start from 0 again
		int maxLength = Integer.MIN_VALUE;
		for (int i = 1; i <= str1.length(); i++) {
			for (int j = 1; j <= str2.length(); j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
					maxLength = Math.max(maxLength, dp[i][j]);
				}
				/*
				 * else { dp[i][j] = 0; // discontinuation }
				 */

			}
		}
		return maxLength;
	}

	public static void main(String[] args) {
		System.out.println(longestCommonSubstring("abdca","cbda"));
		System.out.println(longestCommonSubstring("passport", "ppsspt"));
	}

}
