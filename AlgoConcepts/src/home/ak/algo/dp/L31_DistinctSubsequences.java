/**
 * 
 */
package home.ak.algo.dp;

import java.util.Arrays;

/**
 * @author kundu
 * 
 *         Given two strings s and t, return the number of distinct subsequences
 *         of s which equals t.
 * 
 *         A string's subsequence is a new string formed from the original
 *         string by deleting some (can be none) of the characters without
 *         disturbing the remaining characters' relative positions. (i.e., "ACE"
 *         is a subsequence of "ABCDE" while "AEC" is not).
 *
 */
public class L31_DistinctSubsequences {

	public static int numDistinctTD(String s, String t) {
		int sLen = s.length();
		int tLen = t.length();
		int[][] dp = new int[sLen][tLen];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}
		return numDistinctTD(s, sLen - 1, t, tLen - 1, dp);
	}

	private static int numDistinctTD(String s, int sIdx, String t, int tIdx, int[][] dp) {
		// Base case
		if (tIdx < 0) {
			// successfully matched t with s
			return 1;
		}
		if (sIdx < 0) {
			// Exhausted all the characters of s while characters in t are left
			return 0;
		}

		// Validate dp array
		if (dp[sIdx][tIdx] != -1) {
			return dp[sIdx][tIdx];
		}

		// if match - we can take the characters or look for another solution
		if (s.charAt(sIdx) == t.charAt(tIdx)) {
			int consider = numDistinctTD(s, sIdx - 1, t, tIdx - 1, dp); // reduce size of both s & t
			int ignore = numDistinctTD(s, sIdx - 1, t, tIdx, dp); // move only s index
			return dp[sIdx][tIdx] = consider + ignore;
		} else {
			return dp[sIdx][tIdx] = numDistinctTD(s, sIdx - 1, t, tIdx, dp);
		}
	}

	public static int numDistinctBU(String s, String t) {
		int sLen = s.length();
		int tLen = t.length();
		int[][] dp = new int[sLen + 1][tLen + 1];

		for (int i = 0; i <= sLen; i++) {
			dp[i][0] = 1;
		}

		for (int i = 1; i <= sLen; i++) {
			for (int j = 1; j <= tLen; j++) {
				if (s.charAt(i - 1) == t.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[sLen][tLen];
	}

	public static void main(String[] args) {
		String s = "rabbbit", t = "rabbit";
		System.out.println(numDistinctTD(s, t));
		System.out.println(numDistinctBU(s, t));
	}

}
