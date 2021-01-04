/**
 * 
 */
package home.ak.algo.dp.pattern2;

/**
 * @author kundu
 *
 */
public class LongestPalindromicSubstring {

	public static int findLPSLength(String str) {
		// Initialize the DP Array
		boolean[][] dp = new boolean[str.length()][str.length()];

		// String with 1 character is a palindrome
		int maxLength = 1;
		for (int i = 0; i < str.length(); i++) {
			dp[i][i] = true;
		}

		// For 2 character string we have to compare the values
		for (int i = 0; i < str.length() - 1; i++) {
			if (str.charAt(i) == str.charAt(i + 1)) {
				dp[i][i + 1] = true;
				maxLength = 2;
			}
		}
		/*
		 * For 3 or more character string if the character at start and end index are
		 * equal, the string if palindrome if the string non-boundary string is
		 * palindrome
		 */
		for (int startIdx = str.length() - 3; startIdx >= 0; startIdx--) {
			for (int endIdx = startIdx + 2; endIdx < str.length(); endIdx++) {
				if (str.charAt(startIdx) == str.charAt(endIdx) && dp[startIdx + 1][endIdx - 1]) {
					dp[startIdx][endIdx] = true;
					maxLength = Math.max(maxLength, endIdx - startIdx + 1);
				}
			}
		}
		return maxLength;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(findLPSLength("abdbca"));
		System.out.println(findLPSLength("cdpdd"));
	}

}
