/**
 * 
 */
package home.ak.algo.dp.pattern2;

/**
 * @author kundu
 * 
 *         Given a sequence, find the length of its Longest Palindromic
 *         Subsequence (LPS). In a palindromic subsequence, elements read the
 *         same backward and forward.
 * 
 *         A subsequence is a sequence that can be derived from another sequence
 *         by deleting some or no elements without changing the order of the
 *         remaining elements.
 *
 */
public class LongestPalindromicSubsequence {

	public static int findLPSLengthRecursive(String str) {
		return findLPSLengthRecursive(str, 0, str.length() - 1);
	}

	private static int findLPSLengthRecursive(String str, int start, int end) {
		if (start > end) {
			return 0;
		}
		// every sequence with one element is a palindrome of length 1
		if (start == end) {
			return 1;
		}

		// Case 1: Equal characters on either side of the string
		if (str.charAt(start) == str.charAt(end)) {
			return 2 + findLPSLengthRecursive(str, start + 1, end - 1);
		}

		// Case 2: Mismatch - Skip 1 from either side
		int c1 = findLPSLengthRecursive(str, start + 1, end);
		int c2 = findLPSLengthRecursive(str, start, end - 1);

		return Math.max(c1, c2);
	}

	/**
	 * Bottom up Dynamic Programming Solution
	 */
	public static int findLPSLength(String str) {
		// Initialize the DP Array
		int[][] dp = new int[str.length()][str.length()];

		// every sequence with one element is a palindrome of length 1
		for (int i = 0; i < str.length(); i++)
			dp[i][i] = 1;

		// Case 1: When the start & end characters are same
		for (int startIdx = str.length() - 2; startIdx >= 0; startIdx--) {
			// startIndex is str.length - 2 as the last row is considered
			for (int endIdx = startIdx + 1; endIdx < str.length(); endIdx++) {
				// case 1: elements at the beginning and the end are the same
				if (str.charAt(startIdx) == str.charAt(endIdx)) {
					dp[startIdx][endIdx] = 2 + dp[startIdx + 1][endIdx - 1];
				} else { // case 2: skip one element either from the beginning or the end
					dp[startIdx][endIdx] = Math.max(dp[startIdx + 1][endIdx], dp[startIdx][endIdx - 1]);
				}
			}
		}
		return dp[0][str.length() - 1];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(findLPSLength("abdbca"));

	}

}
