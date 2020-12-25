/**
 * 
 */
package home.ak.algo.dp.twoDim;

import java.util.Arrays;

/**
 * @author kundu
 * 
 *         Given two strings, s1 and s2 and edit operations (given below). Write
 *         an algorithm to find minimum number operations required to convert
 *         string s1 into s2.
 * 
 *         Allowed Operations:
 * 
 *         Insertion – Insert a new character.
 * 
 *         Deletion – Delete a character.
 * 
 *         Replace – Replace one character by another.
 * 
 *         State: i -> last index of substring of s1 and j -> last index of
 *         substring of s2
 * 
 *         Cost Function: editDistance(i, j, s1, s2)
 * 
 *         Base Case:
 * 
 *         i = -1, j = -1 , represents empty string
 * 
 *         i = -1 , return j+1 , this means s1 is empty, we can convert it to B
 *         by inserting all the j characters of s2.
 * 
 *         j = -1 , return i+1, this means s2 is empty , we can convert s1
 *         ending at i-1 to s2 which is empty by deleting all the characters.
 * 
 *         Transitions:
 * 
 *         Case 1 If last character of s1 is equal to last character of s2 i.e
 *         A[i] == B[j], then we do not need transform, we can move onto smaller
 *         subproblem editDistance(i-1,j-1,A,B)
 * 
 *         Case 2 If last character of s1 is not equal to last character of s2
 *         then we have three choices
 * 
 *         1. Insert - editDistance(i,j-1)+1 (Insert a character into s1 (same
 *         as last character in string s2 so that last character in both the
 *         strings are same)
 * 
 *         2. Replace - editDistance(i-1,j-1)+1 (Same as last character in
 *         string s2 so that last character in both the strings are same)
 * 
 *         3. Delete - editDistance(i-1,j)+1 (Remove the last character from
 *         string s1)
 * 
 *         Choose the minimum of ( 1, 2, 3).
 */
public class EditDistanceProblem {

	public static int editDistanceRecursion(String s1, String s2) {
		return editDistanceRecursion(s1, s2, s1.length() - 1, s2.length() - 1);
	}

	private static int editDistanceRecursion(String s1, String s2, int i, int j) {
		// Base cases
		if (i == -1) // Length of s1 is 0 or empty
			return j + 1; // Insert all characters of s2 in s1 -> Insert

		if (j == -1) {
			return i + 1; // Delete all characters of s1 -> Delete
		}

		if (s1.charAt(i) == s2.charAt(j)) {
			// Ignore and proceed
			return editDistanceRecursion(s1, s2, i - 1, j - 1);
		} else {
			return Math.min(editDistanceRecursion(s1, s2, i - 1, j - 1),
					Math.min(editDistanceRecursion(s1, s2, i, j - 1), editDistanceRecursion(s1, s2, i - 1, j))) + 1;
		}
	}

	public static int editDistanceTD(String s1, String s2) {
		int[][] dp = new int[s1.length()][s2.length()];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}
		return editDistanceTD(s1, s2, s1.length() - 1, s2.length() - 1, dp);
	}

	private static int editDistanceTD(String s1, String s2, int i, int j, int[][] dp) {
		// Base cases
		if (i == -1) // Length of s1 is 0 or empty
			return j + 1; // Insert all characters of s2 in s1 -> Insert

		if (j == -1) {
			return i + 1; // Delete all characters of s1 -> Delete
		}

		// Check the cache value
		if (dp[i][j] != -1) {
			return dp[i][j];
		}

		if (s1.charAt(i) == s2.charAt(j)) {
			return dp[i][j] = editDistanceTD(s1, s2, i - 1, j - 1, dp);
		} else {
			return dp[i][j] = Math.min(editDistanceTD(s1, s2, i - 1, j - 1, dp),
					Math.min(editDistanceTD(s1, s2, i, j - 1, dp), editDistanceTD(s1, s2, i - 1, j, dp))) + 1;
		}
	}

	public static int editDistanceBU(String s1, String s2) {
		int s1Length = s1.length();
		int s2Length = s2.length();

		// Initialize the dp array
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}

		for (int i = 0; i <= s1Length; i++) {
			for (int j = 0; j <= s2Length; j++) {
				if (i == 0) {
					dp[i][j] = j;
				} else if (j == 0) {
					dp[i][j] = i;
				} else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
				}
			}
		}
		return dp[s1Length][s2Length];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s1 = "GOAT", s2 = "GET";
		System.out.println(editDistanceRecursion(s1, s2));
		System.out.println(editDistanceTD(s1, s2));
		System.out.println(editDistanceBU(s1, s2));
	}

}
