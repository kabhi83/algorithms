/**
 * 
 */
package home.ak.algo.slidingwindow;

import java.rmi.Remote;
import java.util.HashMap;
import java.util.Map;

/**
 * @author kundu
 * 
 *         Given an array of characters where each character represents a fruit
 *         tree, you are given two baskets and your goal is to put maximum
 *         number of fruits in each basket. The only restriction is that each
 *         basket can have only one type of fruit. You can start with any tree,
 *         but once you have started you can’t skip a tree. You will pick one
 *         fruit from each tree until you cannot, i.e., you will stop when you
 *         have to pick from a third fruit type. Write a function to return the
 *         maximum number of fruits in both the baskets.
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
 */
public class FruitBasket {

	public static int maxFruitsIntoBasket(char[] fruits) {
		if (null == fruits || fruits.length == 0) {
			return 0;
		}
		Map<Character, Integer> frequencyMap = new HashMap<>();
		int windowStart = 0, maxFruit = 0;

		for (int windowEnd = 0; windowEnd < fruits.length; windowEnd++) {
			// Add the fruit in the basket
			char currentFruit = fruits[windowEnd];
			frequencyMap.put(currentFruit, frequencyMap.getOrDefault(currentFruit, 0) + 1);

			// shrink the sliding window, until '2' fruits in the fruit frequency
			while (frequencyMap.size() > 2) {
				char lastFruit = fruits[windowStart];
				// reduce the frequency
				frequencyMap.put(lastFruit, frequencyMap.get(lastFruit) - 1);
				if (frequencyMap.get(lastFruit) == 0) {
					frequencyMap.remove(lastFruit);
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
