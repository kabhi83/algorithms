/**
 * 
 */
package home.ak.algo.generic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kundu
 * 
 *         Roman numerals are represented by seven different symbols: I, V, X,
 *         L, C, D and M.
 * 
 *         Values:
 * 
 *         I -> 1, V -> 5, X -> 10, L -> 50, C -> 100, D -> 500, M -> 1000
 *
 */
public class RomanToIntegers {

	public int romanToInt(String s) {
		// Create the mapping
		Map<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);

		int result = 0;

		for (int i = 0; i < s.length(); i++) {
			if (i > 0 && map.get(s.charAt(i)) > map.get(s.charAt(i - 1))) {
				// Subtractive use case - when the current is greater than previous like IX
				result += map.get(s.charAt(i)) - 2 * map.get(s.charAt(i - 1));
				// 2 because 1 to undo and 1 to subtract
			} else {
				// Additive use case
				result += map.get(s.charAt(i));
			}
		}

		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String roman = "LVIII";
		int result = new RomanToIntegers().romanToInt(roman);
		System.out.println(result);
	}

}
