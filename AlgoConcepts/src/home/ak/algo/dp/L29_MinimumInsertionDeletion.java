/**
 * 
 */
package home.ak.algo.dp;

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
public class L29_MinimumInsertionDeletion {

	/**
	 * This problem is a 3 step process
	 * 
	 * 1. What should be intact, i.e., the common part of the both strings - LCS
	 * 
	 * 2. No. of deletions = Extra characters in str1 -> (s1_length - LCS)
	 * 
	 * 3. No. of insertions = Extra characters in str2 -> (s2_length - LCS)
	 */
	public static int minInsertionDeletion(String s1, String s2) {
		int s1Len = s1.length();
		int s2Len = s2.length();

		int[][] dp = new int[s1Len + 1][s2Len + 1];

		for (int s1Idx = 1; s1Idx <= s1Len; s1Idx++) {
			for (int s2Idx = 1; s2Idx <= s2Len; s2Idx++) {
				if (s1.charAt(s1Idx - 1) == s2.charAt(s2Idx - 1)) {
					// Match
					dp[s1Idx][s2Idx] = 1 + dp[s1Idx - 1][s2Idx - 1];
				} else {
					dp[s1Idx][s2Idx] = Math.max(dp[s1Idx - 1][s2Idx], dp[s1Idx][s2Idx - 1]);
				}
			}
		}
		int lcs = dp[s1Len][s2Len];
		int deletions = s1Len - lcs;
		int insertions = s2Len - lcs;

		return deletions + insertions;
	}
	
	public static void main(String[] args) {
		String s1 = "abcd", s2 = "anc";
		System.out.println(minInsertionDeletion(s1, s2));
		
		s1 = "abdca";
		s2 = "cbda";
		System.out.println(minInsertionDeletion(s1, s2));
	}

}
