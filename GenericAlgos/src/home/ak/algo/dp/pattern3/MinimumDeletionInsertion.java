/**
 * 
 */
package home.ak.algo.dp.pattern3;

/**
 * @author kundu
 * 
 *         Given strings s1 and s2, we need to transform s1 into s2 by deleting
 *         and inserting characters. Write a function to calculate the count of
 *         the minimum number of deletion and insertion operations.
 * 
 *         Example 1: Input: s1 = "abc" s2 = "fbc" Output: 1 deletion and 1
 *         insertion. Explanation: We need to delete {'a'} and insert {'f'} to
 *         s1 to transform it into s2.
 * 
 *         Example 2: Input: s1 = "abdca" s2 = "cbda" Output: 2 deletions and 1
 *         insertion. Explanation: We need to delete {'a', 'c'} and insert {'c'}
 *         to s1 to transform it into s2.
 * 
 *         Example 3: Input: s1 = "passport" s2 = "ppsspt" Output: 3 deletions
 *         and 1 insertion Explanation: We need to delete {'a', 'o', 'r'} and
 *         insert {'p'} to s1 to transform it into s2.
 *
 */
public class MinimumDeletionInsertion {

	/**
	 * This problem is similar to Longest Common Subsequence
	 * 
	 * Let c1 is the length of LCS of the two strings s1 and s2.
	 * 
	 * To transform s1 into s2, we need to delete everything from s1 which is not
	 * part of LCS, so minimum deletions we need to perform from s1 => len1 - c1
	 * 
	 * Similarly, we need to insert everything in s1 which is present in s2 but not
	 * part of LCS, so minimum insertions we need to perform in s1 => len2 - c1
	 */
	public static void findMDI(String s1, String s2) {
		int lcs = findLCS(s1, s2);
		System.out.println("Minimum deletions required is " + (s1.length() - lcs));
		System.out.println("Minimum insertions required is " + (s2.length() - lcs));
	}

	private static int findLCS(String s1, String s2) {
		int m = s1.length(), n = s2.length();
		if (m == 0 || n == 0) {
			return 0;
		}

		int[][] dp = new int[m + 1][n + 1];

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		return dp[m][n];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		findMDI("abc", "fbc");
		findMDI("abdca", "cbda");
		findMDI("passport", "ppsspt");

	}

}
