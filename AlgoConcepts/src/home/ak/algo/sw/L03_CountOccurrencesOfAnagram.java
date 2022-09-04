/**
 * 
 */
package home.ak.algo.sw;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kundu
 * 
 *         Given a word (or pattern) and a text, return the count of occurrences
 *         of the anagrams of the word in the text.
 * 
 *         An anagram of a word is a word that’s formed by rearranging the
 *         letters of the original word.
 * 
 *         Note: For a word of length n, there will n! anagrams. Example for the
 *         letter 'for' below are the list of anagrams -
 * 
 *         for, fro, ofr, orf, rof, rfo,
 *
 */
public class L03_CountOccurrencesOfAnagram {

	/**
	 * This is a sliding window problem, where the length of the window is the
	 * length of the word
	 */
	public static int countOccurrenceOfAnagram(String text, String word) {

		int windowStart = 0;
		int k = word.length(); // Sliding window size
		int count = 0;

		// Compute the letter frequency map of the word or pattern
		Map<Character, Integer> wordCharCount = new HashMap<>();
		for (char c : word.toCharArray()) {
			wordCharCount.put(c, wordCharCount.getOrDefault(c, 0) + 1);
		}

		Map<Character, Integer> windowCharCount = new HashMap<>();
		for (int windowEnd = 0; windowEnd < text.length(); windowEnd++) {
			char currChar = text.charAt(windowEnd);
			windowCharCount.put(currChar, windowCharCount.getOrDefault(currChar, 0) + 1);
			// Check if the window size is reached
			if (windowEnd - windowStart + 1 >= k) {
				if (isAnagram(wordCharCount, windowCharCount)) {
					count++;
				}
				// Remove the character from the map
				char charToRemove = text.charAt(windowStart);
				windowCharCount.put(charToRemove, windowCharCount.get(charToRemove) - 1);
				// We need to remove the character if the count of that is 0 in the map
				if (windowCharCount.get(charToRemove) == 0) {
					windowCharCount.remove(charToRemove);
				}
				windowStart++; // Slide the window ahead
			}
		}

		return count;
	}

	private static boolean isAnagram(Map<Character, Integer> wordCharCount, Map<Character, Integer> windowCharCount) {
		for (char c : windowCharCount.keySet()) {
			if (wordCharCount.get(c) != windowCharCount.get(c)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String text = "forxxorfxdofr";
		String word = "for";
		System.out.println(countOccurrenceOfAnagram(text, word));
	}

}
