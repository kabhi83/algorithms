/**
 * 
 */
package home.ak.algo.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author kundu
 * 
 *         Given two strings ‘s1’ and ‘s2’, find the length of the longest
 *         subsequence which is common in both the strings.
 * 
 *         Thumb Rule for recursion
 * 
 *         1. Express everything in-terms of indexes
 * 
 *         [idx1 for s1 and idx2 for s2]
 * 
 *         2. Explore all the possibilities at that index
 * 
 *         [ do comparison character wise]
 * 
 *         3. Find Sum | Maximum | Minimum | Best way
 *
 */
public class L25_LongestCommonSubsequences {

	public static int lcsTD(String s1, String s2) {
		int s1Len = s1.length();
		int s2Len = s2.length();
		int[][] dp = new int[s1Len][s2Len];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}
		return lcsTD(s1, s1Len - 1, s2, s2Len - 1, dp);
	}

	private static int lcsTD(String s1, int s1Idx, String s2, int s2Idx, int[][] dp) {
		// Base cases
		/*
		 * if(s1Idx == 0 || s2Idx == 0) {
		 * 
		 * return s1.charAt(s1Idx) == s2.charAt(s2Idx)? 1: 0;
		 * 
		 * }
		 */
		if (s1Idx < 0 || s2Idx < 0) {
			return 0;
		}

		if (dp[s1Idx][s2Idx] != -1) {
			return dp[s1Idx][s2Idx];
		}

		// String match case
		if (s1.charAt(s1Idx) == s2.charAt(s2Idx)) {
			return dp[s1Idx][s2Idx] = 1 + lcsTD(s1, s1Idx - 1, s2, s2Idx - 1, dp);
		}
		return dp[s1Idx][s2Idx] = 0
				+ Math.max(lcsTD(s1, s1Idx - 1, s2, s2Idx, dp), lcsTD(s1, s1Idx, s2, s2Idx - 1, dp));
	}

	public static int lcsBU(String s1, String s2) {
		int s1Len = s1.length();
		int s2Len = s2.length();
		int[][] dp = new int[s1Len + 1][s2Len + 1];

		for (int idx1 = 1; idx1 <= s1Len; idx1++) {
			for (int idx2 = 1; idx2 <= s2Len; idx2++) {
				if (s1.charAt(idx1 - 1) == s2.charAt(idx2 - 1)) {
					dp[idx1][idx2] = 1 + dp[idx1 - 1][idx2 - 1];
				} else {
					dp[idx1][idx2] = 0 + Math.max(dp[idx1 - 1][idx2], dp[idx1][idx2 - 1]);
				}
			}
		}
		System.out.println(printLCS(s1, s2, dp));
		return dp[s1Len][s2Len];
	}

	private static String printLCS(String s1, String s2, int[][] dp) {
		List<Character> result = new ArrayList<>();
		int i = s1.length();
		int j = s2.length();
		// Rule - if the character matches, move diagonal,
		// else move to the max value of i-1, j or i, j-1
		while (i > 0 && j > 0) {
			if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
				result.add(0, s1.charAt(i - 1));
				i = i - 1;
				j = j - 1;
			} else if (dp[i][j - 1] >= dp[i - 1][j]) {
				j = j - 1;
			} else {
				i = i - 1;
			}
		}
		// Convert the character list to String
		return result.stream().map(String::valueOf).collect(Collectors.joining());

	}

	public static void main(String[] args) {
		String s1 = "abdca", s2 = "cbda";
		System.out.println(lcsTD(s1, s2));
		System.out.println(lcsBU(s1, s2));
	}

}
