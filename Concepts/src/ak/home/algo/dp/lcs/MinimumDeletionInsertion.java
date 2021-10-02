/**
 * 
 */
package ak.home.algo.dp.lcs;

/**
 * @author kundu
 * 
 *         Given strings s1 and s2, we need to transform s1 into s2 by deleting
 *         and inserting characters. Write a function to calculate the count of
 *         the minimum number of deletion and insertion operations.
 * 
 *         Example:
 * 
 *         Input: s1 = "abdca" s2 = "cbda" Output: 2 deletions and 1 insertion.
 *         Explanation: We need to delete {'a', 'c'} and insert {'c'} to s1 to
 *         transform it into s2.
 *
 */
public class MinimumDeletionInsertion {

	/**
	 * This problem is the variant of the LCS. It follows are 2 step process. In
	 * first step, we need to convert the String str1 to the LCS. This will give the
	 * minimum deletions. In the second step we have to identify the number of new
	 * characters required to convert the LCS to String str2. This will give minimum
	 * insertions
	 */
	public static int minDeletionInsertion(String str1, String str2) {
		int minDeletions = 0;
		int minInsertions = 0;
		int lcs = 0;

		// Initialize the DP array for LCS computations
		int[][] dp = new int[str1.length() + 1][str2.length() + 1];

		for (int i = 1; i <= str1.length(); i++) {
			for (int j = 1; j <= str2.length(); j++) {
				// If characters match
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		lcs = dp[str1.length()][str2.length()];

		minDeletions = str1.length() - lcs;
		minInsertions = str2.length() - lcs;

		return minDeletions + minInsertions;
	}

	public static void main(String[] args) {
		String s1 = "abdca", s2 = "cbda";
		System.out.println(minDeletionInsertion(s1, s2));
	}

}
