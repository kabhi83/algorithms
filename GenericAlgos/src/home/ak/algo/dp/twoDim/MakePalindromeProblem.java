/**
 * 
 */
package home.ak.algo.dp.twoDim;

import java.util.Arrays;

/**
 * @author kundu
 * 
 *         Given a string S, find out minimum number of deletions required to
 *         make the string a palindrome.
 * 
 *         Note : Palindrome is a string which is same when read backwards and
 *         forward. For example : Civic, Kayak, Level etc
 * 
 *         Example: Input = KAZAYAKE, Output = 3
 * 
 *         We can delete Z and E, to make the word = KAYAK
 * 
 *         State: i -> start index and j -> end index
 * 
 *         Cost Function: minDeletions(i, j, S)
 * 
 *         Base case: i >= j, return 0 (deletions)
 * 
 *         S[i] == S[j] -> minDeletions(i + 1, j - 1, S)
 * 
 *         S[i] != S[j] ->
 * 
 *         MIN[minDeletions(i + 1, j, S),minDeletions(i, j - 1, S)] + 1
 */
public class MakePalindromeProblem {

	/**
	 * Recursive Solution
	 */
	public static int minDeletionsRec(String S) {
		return minDeletionsRec(0, S.length() - 1, S);
	}

	private static int minDeletionsRec(int i, int j, String S) {
		// Base case
		if (i >= j)
			return 0; // Nothing to delete

		if (S.charAt(i) == S.charAt(j)) {
			return minDeletionsRec(i + 1, j - 1, S);
		} else {
			return Math.min(minDeletionsRec(i + 1, j, S), minDeletionsRec(i, j - 1, S)) + 1;
		}
	}

	/**
	 * Top Down Approach
	 */
	public static int minDeletionsTD(String S) {
		int[][] dp = new int[S.length()][S.length()];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}
		return minDeletionsTD(0, S.length() - 1, S, dp);
	}

	private static int minDeletionsTD(int i, int j, String S, int[][] dp) {
		// Base case
		if (i >= j)
			return 0; // Nothing to delete

		if (dp[i][j] != -1) {
			return dp[i][j];
		}

		if (S.charAt(i) == S.charAt(j)) {
			return dp[i][j] = minDeletionsTD(i + 1, j - 1, S, dp);
		} else {
			return dp[i][j] = Math.min(minDeletionsTD(i + 1, j, S, dp), minDeletionsTD(i, j - 1, S, dp)) + 1;
		}
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String S = "KAYAAPK";
		System.out.println(minDeletionsRec(S));
		System.out.println(minDeletionsTD(S));

	}

}
