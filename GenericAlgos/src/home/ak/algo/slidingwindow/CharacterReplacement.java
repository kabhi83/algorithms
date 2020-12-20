/**
 * 
 */
package home.ak.algo.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kundu
 * 
 *         Given a string with lowercase letters only, if you are allowed to
 *         replace no more than ‘k’ letters with any letter, find the length of
 *         the longest substring having the same letters after replacement.
 * 
 *         Example 1: Input: String="aabccbb", k=2 Output: 5 Explanation:
 *         Replace the two 'c' with 'b' to have a longest repeating substring
 *         "bbbbb".
 * 
 *         Example 2: Input: String="abbcb", k=1 Output: 4 Explanation: Replace
 *         the 'c' with 'b' to have a longest repeating substring "bbbb".
 *
 */
public class CharacterReplacement {

	/**
	 * Current window size is from windowStart to windowEnd. We have a letter which
	 * is repeating 'maxRepeatLetterCount' times, this means we can have a window
	 * which has one letter repeating 'maxRepeatLetterCount' times and the remaining
	 * letters we should replace. If the remaining letters are more than 'k', it is
	 * the time to shrink the window as we are not allowed to replace more than 'k'
	 * letters
	 */
	public static int findLength(String str, int k) {

		int windowStart = 0, maxLength = 0, maxRepeatLetterCount = 0;
		// Initialize the HashMap for character frequency
		Map<Character, Integer> letterFreqMap = new HashMap<>();

		for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
			char rightChar = str.charAt(windowEnd);
			letterFreqMap.put(rightChar, letterFreqMap.getOrDefault(rightChar, 0) + 1);
			maxRepeatLetterCount = Math.max(maxRepeatLetterCount, letterFreqMap.get(rightChar));

			if (windowEnd - windowStart + 1 - maxRepeatLetterCount >= k) {
				char leftChar = str.charAt(windowStart);
				letterFreqMap.put(leftChar, letterFreqMap.get(leftChar) - 1);
				windowStart++;
			}

			maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
		}
		return maxLength;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(CharacterReplacement.findLength("aabccbb", 2));
		System.out.println(CharacterReplacement.findLength("abbcb", 1));
		System.out.println(CharacterReplacement.findLength("abccde", 1));
	}

}
