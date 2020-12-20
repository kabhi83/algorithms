/**
 * 
 */
package home.ak.algo.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kundu
 * 
 *         Given a string, find the length of the longest substring, which has
 *         no repeating characters.
 * 
 *         Example 1: Input: String="aabccbb" Output: 3. Explanation: The
 *         longest substring without any repeating characters is "abc".
 * 
 *         Example 2:Input: String="abbbb" Output: 2. Explanation: The longest
 *         substring without any repeating characters is "ab".
 *
 */
public class NoRepeatSubstring {

	/**
	 * We can use a HashMap to remember the last index of each character we have
	 * processed. Whenever we get a repeating character, we will shrink our sliding
	 * window to ensure that we always have distinct characters in the sliding
	 * window.
	 */
	public static int findLength(String str) {
		int windowStart = 0, maxLength = 0;
		// Map to capture the character and the last occurrence index
		Map<Character, Integer> charIndexMap = new HashMap<>();
		for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
			char rightChar = str.charAt(windowEnd);
			// shrink the window from the beginning so we have only one occurrence of
			// 'rightChar'
			if (charIndexMap.containsKey(rightChar)) {
				// Shrink from start till the rightChar is removed from the sub-string
				windowStart = Math.max(windowStart, charIndexMap.get(rightChar) + 1);
			}

			// Now put the rightChar back
			charIndexMap.put(rightChar, windowEnd);
			maxLength = Math.max(maxLength, windowEnd - windowStart + 1);

		}
		return maxLength;
	}

	public static void main(String[] args) {
		System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("aabccbb"));
		System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abbbb"));
		System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abccde"));
	}

}
