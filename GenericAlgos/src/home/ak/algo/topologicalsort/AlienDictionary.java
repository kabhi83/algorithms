/**
 * 
 */
package home.ak.algo.topologicalsort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author kundu
 * 
 *         There is a dictionary containing words from an alien language for
 *         which we don’t know the ordering of the alphabets. Write a method to
 *         find the correct order of the alphabets in the alien language. It is
 *         given that the input is a valid dictionary and there exists an
 *         ordering among its alphabets.
 * 
 *         Example 1: Input: Words: ["ba", "bc", "ac", "cab"] Output: bac.
 *         Explanation: Given that the words are sorted lexicographically by the
 *         rules of the alien language, so from the given words we can conclude
 *         the following ordering among its characters:
 * 
 *         1. From "ba" and "bc", we can conclude that 'a' comes before 'c'. 2.
 *         From "bc" and "ac", we can conclude that 'b' comes before 'a'
 * 
 *         From the above two points, we can conclude that the correct character
 *         order is: "bac"
 * 
 *         Example 2: Input: Words: ["cab", "aaa", "aab"] Output: cab.
 *         Explanation: From the given words we can conclude the following
 *         ordering among its characters:
 * 
 *         1. From "cab" and "aaa", we can conclude that 'c' comes before 'a'.
 *         2. From "aaa" and "aab", we can conclude that 'a' comes before 'b'
 * 
 *         From the above two points, we can conclude that the correct character
 *         order is: "cab"
 *
 */
public class AlienDictionary {

	public static String findOrder(String[] words) {
		if (null == words || words.length == 0) {
			return "";
		}

		// a. Initialize the graph
		Map<Character, List<Character>> adjList = new HashMap<>();
		Map<Character, Integer> inDegree = new HashMap<>();
		for (String word : words) {
			for (Character c : word.toCharArray()) {
				adjList.put(c, new ArrayList<Character>());
				inDegree.put(c, 0);
			}
		}

		// b. Build the graph
		for (int i = 0; i < words.length - 1; i++) {
			// find ordering of characters from adjacent words
			String word1 = words[i], word2 = words[i + 1];
			int k = Math.min(word1.length(), word2.length());
			for (int j = 0; j < k; j++) { // Only compare till the size of smaller word
				char parent = word1.charAt(j), child = word2.charAt(j);
				if (parent != child) {
					adjList.get(parent).add(child); // put the child into it's parent's list
					inDegree.put(child, inDegree.get(child) + 1); // increment child's inDegree
					break; // Since the 1st different character helps to analyze the order
				}
			}
		}

		// c. Get all the source i.e., vertices with 0 in-degree
		Queue<Character> sources = new LinkedList<>();
		for (Map.Entry<Character, Integer> map : inDegree.entrySet()) {
			if (map.getValue() == 0) {
				sources.offer(map.getKey());
			}
		}

		// d. Add the vertex to the sorted order string
		StringBuilder sortedOrder = new StringBuilder();
		while (!sources.isEmpty()) {
			Character c = sources.poll();
			sortedOrder.append(c);
			// Reduce the in degree of the child vertices
			List<Character> children = adjList.get(c);
			for (Character child : children) {
				inDegree.put(child, inDegree.get(child) - 1);
				if (inDegree.get(child) == 0) {
					sources.offer(child);
				}
			}
		}

		// if sortedOrder doesn't contain all characters, there is a cyclic dependency
		// between characters, therefore, we will not be able to find the correct
		// ordering of the characters
		if (sortedOrder.length() != inDegree.size())
			return "";

		return sortedOrder.toString();
	}

	public static void main(String[] args) {
		String result = AlienDictionary.findOrder(new String[] { "ba", "bc", "ac", "cab" });
		System.out.println("Character order: " + result);

		result = AlienDictionary.findOrder(new String[] { "cab", "aaa", "aab" });
		System.out.println("Character order: " + result);

		result = AlienDictionary.findOrder(new String[] { "ywx", "wz", "xww", "xz", "zyy", "zwz" });
		System.out.println("Character order: " + result);
	}

}
