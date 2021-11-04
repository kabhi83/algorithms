/**
 * 
 */
package home.ak.algo.sw.variable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kundu
 * 
 *         Given an array of characters where each character represents a fruit
 *         tree, you are given two baskets, and your goal is to put maximum
 *         number of fruits in each basket. The only restriction is that each
 *         basket can have only one type of fruit.
 * 
 *         You can start with any tree, but you can’t skip a tree once you have
 *         started. You will pick one fruit from each tree until you cannot,
 *         i.e., you will stop when you have to pick from a third fruit type.
 * 
 *         Write a function to return the maximum number of fruits in both
 *         baskets.
 * 
 *         Example 1: Input: Fruit=['A', 'B', 'C', 'A', 'C'] Output: 3
 *         Explanation: We can put 2 'C' in one basket and one 'A' in the other
 *         from the subarray ['C', 'A', 'C']
 * 
 *         Example 2: Input: Fruit=['A', 'B', 'C', 'B', 'B', 'C'] Output: 5
 *         Explanation: We can put 3 'B' in one basket and two 'C' in the other
 *         basket. This can be done if we start with the second letter: ['B',
 *         'C', 'B', 'B', 'C']
 * 
 * 
 *         Similar to the pick toys problem where mother asks son to pick toys
 *         from the toy rack row and toys can only be of two categories.
 *
 */
public class FruitsInBasket {

	public static int maxFruitsIntoBasket(char[] fruits) {
		if (null == fruits || fruits.length == 0) {
			return 0;
		}

		int windowStart = 0, maxFruit = 0;
		Map<Character, Integer> freqMap = new HashMap<>();

		for (int windowEnd = 0; windowEnd < fruits.length; windowEnd++) {
			char currentFruit = fruits[windowEnd];
			freqMap.put(currentFruit, freqMap.getOrDefault(currentFruit, 0) + 1);

			// Shrink the window if the fruit of different type got picked up
			while (freqMap.size() > 2) {
				char fruitToThrow = fruits[windowStart]; // First fruit picked
				freqMap.put(fruitToThrow, freqMap.get(fruitToThrow) - 1);
				if (freqMap.get(fruitToThrow) == 0) {
					freqMap.remove(fruitToThrow);
				}
				// Shrink the window
				windowStart++;
			}
			maxFruit = Math.max(maxFruit, windowEnd - windowStart + 1);
		}

		return maxFruit;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Max fruits: " + maxFruitsIntoBasket(new char[] { 'A', 'B', 'C', 'A', 'C' }));
		System.out.println("Max fruits: " + maxFruitsIntoBasket(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }));
	}

}
