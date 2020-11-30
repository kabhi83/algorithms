/**
 * 
 */
package home.ak.algo.dp;

/**
 * @author kundu
 *
 *         A message containing letters from A-Z is being encoded to numbers
 *         using the following mapping:
 * 
 *         'A' -> 1, 'B' -> 2, ... 'Z' -> 26. Given a non-empty string
 *         containing only digits, determine the total number of ways to decode
 *         it.
 * 
 *         The answer is guaranteed to fit in a 32-bit integer.
 */
public class DecodeWays {

	/**
	 * DP solved using bottom up approach
	 */
	public int numDecodings(String s) {
		int[] dp = new int[s.length() + 1];
		// for empty string
		dp[0] = 1;

		// for single character string - valid for values from 1 - 9
		dp[1] = s.charAt(0) - '0' == 0 ? 0 : 1;

		for (int i = 2; i <= s.length(); i++) {
			int oneDigit = Integer.valueOf(s.substring(i - 1, i));
			int twoDigits = Integer.valueOf(s.substring(i - 2, i));

			if (oneDigit > 0) {
				dp[i] += dp[i - 1];
			}

			if (twoDigits >= 10 && twoDigits <= 26) {
				dp[i] += dp[i - 2];
			}
		}
		return dp[s.length()];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "123";

		int result = new DecodeWays().numDecodings(s);
		System.out.println(result);

	}

}
