/**
 * 
 */
package home.ak.algo.dp;

/**
 * @author kundu
 * 
 *         Given a pattern (p) and an input string (s), implement wildcard
 *         pattern matching with support for '?' and '*' where:
 * 
 *         '?' Matches any single character.
 * 
 *         '*' Matches any sequence of characters (including the empty
 *         sequence).
 * 
 *         The matching should cover the entire input string (not partial).
 * 
 *
 */
public class L33_WildcardMatching {

	public static boolean wildcardMatching(String pattern, String str) {
		int pLen = pattern.length();
		int sLen = str.length();
		boolean[][] dp = new boolean[pLen][sLen];
		return wildcardMatching(pattern, pLen - 1, str, sLen - 1, dp);
	}

	private static boolean wildcardMatching(String pattern, int pIdx, String str, int sIdx, boolean[][] dp) {

		// Base case
		if (pIdx < 0) {
			if (sIdx < 0) {
				// Both strings exhausted
				return true;
			} else if (sIdx >= 0) {
				return false;
			}
		}
		if (sIdx < 0) {
			// All the remaining characters of pattern should be "*" for returning true
			for (int i = 0; i <= pIdx; i++) {
				if (pattern.charAt(i) != '*') {
					return false;
				}
			}
			return true;
		}

		if (dp[pIdx][sIdx]) {
			return dp[pIdx][sIdx];
		}

		// When the string chars matches - direct or thru '?'
		if (pattern.charAt(pIdx) == str.charAt(sIdx) || pattern.charAt(pIdx) == '?') {
			// Reduce both the strings by 1
			return dp[pIdx][sIdx] = wildcardMatching(pattern, pIdx - 1, str, sIdx - 1, dp);
		} else if (pattern.charAt(pIdx) == '*') {
			// two possibilities
			// 1. consider * as nothing (empty), so just reduce the size if pattern by 1
			// 2. replace the curr char of str by "*" of pattern and reduce str size by 1
			return dp[pIdx][sIdx] = wildcardMatching(pattern, pIdx - 1, str, sIdx, dp)
					|| wildcardMatching(pattern, pIdx, str, sIdx - 1, dp);
		} else {
			// Character mismatch between pattern and str
			return false;
		}
	}

	public static void main(String[] args) {
		String str = "aa", pattern = "*";
		System.out.println(wildcardMatching(pattern, str));

		str = "cb";
		pattern = "?a";
		System.out.println(wildcardMatching(pattern, str));
		
		 pattern = "ab*cd";
		 str = "abdefcd";
		 System.out.println(wildcardMatching(pattern, str));
	}

}
