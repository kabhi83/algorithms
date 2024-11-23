/**
 * 
 */
package home.ak.algo.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kundu
 * 
 *         Given a string, find the length of the longest substring in it with
 *         no more than K distinct characters.
 * 
 *         Example; Input: String="araaci", K=2 Output: 4
 * 
 *         Explanation: The longest substring with no more than '2' distinct
 *         characters is "araa".
 *
 */
public class L5_LongestSubstringKDistinct {

	public static int findLength(String str, int k) {
		if (str == null || str.length() == 0) {
			return 0;
		}

		int windowStart = 0, maxLength = 0;
		Map<Character, Integer> frequenceyMap = new HashMap<>();
		for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
			char rightChar = str.charAt(windowEnd);
			frequenceyMap.put(rightChar, frequenceyMap.getOrDefault(rightChar, 0) + 1);

			// shrink the sliding window, until 'k' distinct characters in map
			while (frequenceyMap.size() > k) {
				// Start removing the left characters
				char leftChar = str.charAt(windowStart);
				// Decrement the size of leftChar
				frequenceyMap.put(leftChar, frequenceyMap.get(leftChar) - 1);

				// If the frequency of the left char is 0, remove it
				if (frequenceyMap.get(leftChar) == 0) {
					frequenceyMap.remove(leftChar);
				}
				// shrink the window
				windowStart++;
			}
			// remember the maximum length so far
			maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
		}

		return maxLength;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Length of the longest substring: " + L5_LongestSubstringKDistinct.findLength("araaci", 2));
		System.out.println("Length of the longest substring: " + L5_LongestSubstringKDistinct.findLength("araaci", 1));
		System.out.println("Length of the longest substring: " + L5_LongestSubstringKDistinct.findLength("cbbebi", 3));

	}

}
