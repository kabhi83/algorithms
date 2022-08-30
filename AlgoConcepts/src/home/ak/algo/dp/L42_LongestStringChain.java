/**
 * 
 */
package home.ak.algo.dp;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author kundu
 * 
 *         You are given an array of words where each word consists of lowercase
 *         English letters.
 * 
 *         wordA is a predecessor of wordB if and only if we can insert exactly
 *         one letter anywhere in wordA without changing the order of the other
 *         characters to make it equal to wordB.
 * 
 *         For example, "abc" is a predecessor of "abac", while "cba" is not a
 *         predecessor of "bcad". A word chain is a sequence of words [word1,
 *         word2, ..., wordk] with k >= 1, where word1 is a predecessor of
 *         word2, word2 is a predecessor of word3, and so on. A single word is
 *         trivially a word chain with k == 1.
 * 
 *         Return the length of the longest possible word chain with words
 *         chosen from the given list of words.
 *
 */
public class L42_LongestStringChain {

	public static int longestStrChain(String[] words) {
		sort(words);
		int[] dp = new int[words.length];
		Arrays.fill(dp, 1);

		for (int curr = 1; curr < words.length; curr++) {
			for (int prev = 0; prev < curr; prev++) {
				if (compare(words[curr], words[prev]) && (1 + dp[prev]) > dp[curr]) {
					dp[curr] = 1 + dp[prev];
				}
			}
		}

		return Arrays.stream(dp).max().getAsInt();
	}

	private static boolean compare(String cWord, String pWord) {
		if (cWord.length() - pWord.length() != 1) {
			return false;
		}
		int ptr1 = cWord.length() - 1, ptr2 = pWord.length() - 1;
		int displaced = 0;
		while (ptr1 >= 0 && ptr2 >= 0) {
			if (cWord.charAt(ptr1) == pWord.charAt(ptr2)) {
				ptr1--;
				ptr2--;
			} else if (cWord.charAt(ptr1) != pWord.charAt(ptr2) && displaced < 1) {
				displaced++;
				ptr1--; // reduce the size of the current word
			} else {
				return false;
			}
		}
		return true;
	}

	private static String[] sort(String[] words) {
		// Function to perform sorting
		Arrays.sort(words, new Comparator<String>() {

			@Override
			public int compare(final String s1, final String s2) {
				return s1.length() < s2.length() ? -1 : 1;
			}
		});
		return words;
	}

	public static void main(String[] args) {
		String[] words = { "a", "b", "ba", "bca", "bda", "bdca" };
		System.out.println(longestStrChain(words));

		words = new String[] { "x", "xx", "y", "xyx" };
		System.out.println(longestStrChain(words));

		words = new String[] { "m", "nm", "mmm" };
		System.out.println(longestStrChain(words));
		
		words = new String[] {"xbc","pcxbcf","xb","cxbc","pcxbc"};
		System.out.println(longestStrChain(words));
	}

}
