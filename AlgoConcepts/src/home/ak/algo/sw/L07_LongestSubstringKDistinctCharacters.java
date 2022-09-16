/**
 * 
 */
package home.ak.algo.sw;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kundu
 * 
 *         Given a string, find the length of the longest substring in it with
 *         no more than K distinct characters.
 * 
 *         Example 1: Input: String="araaci", K=2. Output: 4.
 * 
 *         Explanation: The longest substring with no more than '2' distinct
 *         characters is "araa".
 * 
 *         Example 2: Input: String="cbbebi", K=3. Output: 5.
 * 
 *         Explanation: The longest substrings with no more than '3' distinct
 *         characters are "cbbeb" & "bbebi".
 *
 */
public class L07_LongestSubstringKDistinctCharacters {

	public static int longestSubStringWithKDistinctChars(String str, int k) {
		int windowStart = 0, maxLength = 0;

		Map<Character, Integer> freqMap = new HashMap<>();
		for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
			char rightChar = str.charAt(windowEnd);
			freqMap.put(rightChar, freqMap.getOrDefault(rightChar, 0) + 1);
			// Condition Evaluation - Shrink the window until we are left with 'k' distinct
			// characters in the frequency map
			while (freqMap.size() > k) {
				char leftChar = str.charAt(windowStart);
				freqMap.put(leftChar, freqMap.get(leftChar) - 1);
				if(freqMap.get(leftChar) == 0) {
					freqMap.remove(leftChar);
				}
				windowStart++;
			}
			
			maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
		}

		return maxLength;
	}
	
	public static void main(String[] args) {
		String str = "araaci";
		int k = 2;
		System.out.println(longestSubStringWithKDistinctChars(str, k));
		
		str = "cbbebi";
		k = 3;
		System.out.println(longestSubStringWithKDistinctChars(str, k));
	}

}
