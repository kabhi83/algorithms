/**
 * 
 */
package home.ak.algo.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author kundu
 * 
 *         Given a string, sort it based on the decreasing frequency of its
 *         characters.
 * 
 *         Example 1:Input: "Programming" Output: "rrggmmPiano"
 * 
 *         Explanation: 'r', 'g', and 'm' appeared twice, so they need to appear
 *         before any other character.
 * 
 *         Example 2:Input: "abcbab" Output: "bbbaac"
 * 
 *         Explanation: 'b' appeared three times, 'a' appeared twice, and 'c'
 *         appeared only once.
 *
 */
public class FrequencySort {

	public static String sortCharacterByFrequency(String str) {

		// Create the character frequency map
		Map<Character, Integer> freqMap = new HashMap<>();
		for (char c : str.toCharArray()) {
			freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
		}

		// Create map heap to the track the character occurences
		PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
				(a, b) -> b.getValue() - a.getValue());

		// add all characters to the max heap
		maxHeap.addAll(freqMap.entrySet());

		// Build the sorted string
		StringBuilder sortedString = new StringBuilder();
		while (!maxHeap.isEmpty()) {
			Map.Entry<Character, Integer> entry = maxHeap.poll();
			for (int i = 0; i < entry.getValue(); i++) {
				sortedString.append(entry.getKey());
			}
		}
		return sortedString.toString();

		/**
		 * Time complexity # The time complexity of the above algorithm is O(D*logD)
		 * where ‘D’ is the number of distinct characters in the input string. This
		 * means, in the worst case, when all characters are unique the time complexity
		 * of the algorithm will be O(N*logN) where ‘N’ is the total number of
		 * characters in the string.
		 * 
		 * Space complexity # The space complexity will be O(N), as in the worst case,
		 * we need to store all the ‘N’ characters in the HashMap.
		 **/
	}

	public static void main(String[] args) {
		String result = FrequencySort.sortCharacterByFrequency("Programming");
		System.out.println("Here is the given string after sorting characters by frequency: " + result);

		result = FrequencySort.sortCharacterByFrequency("abcbab");
		System.out.println("Here is the given string after sorting characters by frequency: " + result);
	}

}
