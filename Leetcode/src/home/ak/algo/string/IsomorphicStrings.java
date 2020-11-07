/**
 * 
 */
package home.ak.algo.string;

/**
 * @author kundu
 * 
 *         Given two strings s and t, determine if they are isomorphic.
 * 
 *         Two strings are isomorphic if the characters in s can be replaced to
 *         get t.
 * 
 *         All occurrences of a character must be replaced with another
 *         character while preserving the order of characters. No two characters
 *         may map to the same character but a character may map to itself.
 * 
 *         Example 1: Input: s = "egg", t = "add" Output: true
 * 
 *         Example 2: Input: s = "foo", t = "bar" Output: false
 *
 */
public class IsomorphicStrings {

	public boolean isIsomorphic(String s, String t) {

		// Correctness check
		if (s.length() != t.length()) {
			return false;
		}

		int[] sChars = new int[256];
		int[] tChars = new int[256];

		int label = 1;

		for (int i = 0; i < s.length(); i++) {
			if (sChars[s.charAt(i) - '0'] != tChars[t.charAt(i) - '0']) {
				return false;
			}
			sChars[s.charAt(i) - '0'] = label;
			tChars[t.charAt(i) - '0'] = label;

			label++;
		}
		return true;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// String s = "egg", t = "add";
		// String s = "foo", t = "bar";
		String s = "paper", t = "title";
		boolean result = new IsomorphicStrings().isIsomorphic(s, t);
		System.out.println(result);
	}

}
