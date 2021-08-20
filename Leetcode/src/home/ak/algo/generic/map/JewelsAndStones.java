package home.ak.algo.generic.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kundu
 *
 *         You're given strings jewels representing the types of stones that are
 *         jewels, and stones representing the stones you have. Each character
 *         in stones is a type of stone you have. You want to know how many of
 *         the stones you have are also jewels.
 * 
 *         Letters are case sensitive, so "a" is considered a different type of
 *         stone from "A".
 * 
 *         Example 1: Input: jewels = "aA", stones = "aAAbbbb" Output: 3
 * 
 *         Example 2: Input: jewels = "z", stones = "ZZ" Output: 0
 */
public class JewelsAndStones {

	public static int numJewelsInStones(String jewels, String stones) {
		// Calculate the stone frequencies
		Map<Character, Integer> freqMap = new HashMap<>();
		for (char c : stones.toCharArray()) {
			if (!freqMap.containsKey(c)) {
				freqMap.put(c, 0);
			}
			freqMap.put(c, freqMap.get(c) + 1);
		}

		int count = 0;
		for (char j : jewels.toCharArray()) {
			count += freqMap.containsKey(j) ? freqMap.get(j) : 0;
		}
		return count;
	}

	public static void main(String[] args) {
		// String jewels = "aA", stones = "aAAbbbb";
		String jewels = "z", stones = "ZZ";
		System.out.println(numJewelsInStones(jewels, stones));
	}

}
