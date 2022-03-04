/**
 * 
 */
package home.ak.algo.string;

/**
 * @author kundu
 * 
 *         You are given two strings s and t. In one step you can append any
 *         character to either s or t. Return the number of steps to make s and
 *         t anagrams of each other.
 * 
 *         An Anagram of a string is a string that contains the same characters
 *         with a different (or the same) ordering.
 *
 */
public class MinStepsToMakeStringsAnagram {

	public static int minSteps(String s, String t) {
		int[] freq = new int[26];
		for (char c : s.toCharArray()) {
			freq[c - 'a']++;
		}

		for (char c : t.toCharArray()) {
			freq[c - 'a']--;
		}

		int steps = 0;
		for (int i = 0; i < 26; i++) {
			steps += Math.abs(freq[i]);
		}
		return steps;
	}
	
	public static void main(String[] args) {
		String s = "leetcode", t = "coats";
		System.out.println(minSteps(s, t));
	}

}
