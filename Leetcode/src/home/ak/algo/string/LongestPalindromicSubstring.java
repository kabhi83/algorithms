/**
 * 
 */
package home.ak.algo.string;

/**
 * @author kundu
 * 
 *         Given a string s, return the longest palindromic substring in s.
 * 
 *         Example 1: Input: s = "babad" Output: "bab" Note: "aba" is also a
 *         valid answer.
 * 
 *         Example 2: Input: s = "cbbd" Output: "bb"
 * 
 *         Example 3:Input: s = "a" Output: "a"
 * 
 *         Example 4:Input: s = "ac" Output: "a"
 * 
 *         Constraints:
 * 
 *         1 <= s.length <= 1000
 * 
 *         s consist of only digits and English letters (lower-case and/or
 *         upper-case),
 *
 */
public class LongestPalindromicSubstring {
	int resultStart = 0;
	int resultLength = 0;

	public String longestPalindrome(String s) {
		int strLength = s.length();
		if (strLength < 2) {
			return s;
		}

		// check for the every element for being the mid point of a possible palindrome
		for (int start = 0; start < strLength - 1; start++) {
			expandRange(s, start, start); // For odd length
			expandRange(s, start, start + 1); // For even length
		}
		return s.substring(resultStart, resultStart + resultLength);
	}

	private void expandRange(String str, int start, int end) {
		while (start >= 0 && end < str.length() && str.charAt(start) == str.charAt(end)) {
			start--;
			end++;
		}
		if (resultLength < end - start - 1) {
			resultStart = start + 1;
			resultLength = end - start - 1;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "babad";
		String result = new LongestPalindromicSubstring().longestPalindrome(s);
		System.out.println(result);
	}

}
