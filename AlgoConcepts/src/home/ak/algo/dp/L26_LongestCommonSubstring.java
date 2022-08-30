/**
 * 
 */
package home.ak.algo.dp;

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
public class L26_LongestCommonSubstring {

	public static int lcs(String s1, String s2) {
		int s1Len = s1.length();
		int s2Len = s2.length();

		// Initialize the dp array
		int[][] dp = new int[s1Len + 1][s2Len + 1];

		int lcsLen = 0;

		for (int s1Idx = 1; s1Idx <= s1Len; s1Idx++) {
			for (int s2Idx = 1; s2Idx <= s2Len; s2Idx++) {
				if (s1.charAt(s1Idx - 1) == s2.charAt(s2Idx - 1)) {
					// Match - check for previous consecutive match
					dp[s1Idx][s2Idx] = 1 + dp[s1Idx - 1][s2Idx - 1];
					lcsLen = Math.max(lcsLen, dp[s1Idx][s2Idx]);
				} else {
					dp[s1Idx][s2Idx] = 0; // substring character matches are consecutive
				}
			}
		}
		return lcsLen;
	}
	
	public static void main(String[] args) {
		String s1 = "abdca", s2 = "cbda";
		System.out.println(lcs(s1, s2));
	}

}
