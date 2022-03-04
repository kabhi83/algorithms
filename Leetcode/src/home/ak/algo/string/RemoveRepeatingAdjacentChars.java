/**
 * 
 */
package home.ak.algo.string;

import java.util.Stack;

/**
 * @author kundu
 * 
 *         Given string with lowercase characters remove all the repeating
 *         adjacent characters.
 * 
 *         Example - Input String - "abbba" => Output String = ""
 *
 */
public class RemoveRepeatingAdjacentChars {

	public static String removeDuplicates(String s) {
		Stack<Character> stack = new Stack<>();
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (!stack.isEmpty() && stack.peek() == s.charAt(i)) {
				// Iterate till last occurrence
				while (s.charAt(i) == s.charAt(i + 1)) {
					i++;
				}
				stack.pop();
			} else {
				stack.push(s.charAt(i));
			}
		}

		for (char c : stack) {
			stringBuilder.append(c);
		}
		return stringBuilder.toString();
	}

	public static void main(String[] args) {
		String str = "abbbaca";
		System.out.println(removeDuplicates(str));
	}

}
