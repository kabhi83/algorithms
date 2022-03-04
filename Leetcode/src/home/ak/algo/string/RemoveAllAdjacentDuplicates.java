/**
 * 
 */
package home.ak.algo.string;

import java.util.Stack;

/**
 * @author kundu
 * 
 *         You are given a string s consisting of lowercase English letters. A
 *         duplicate removal consists of choosing two adjacent and equal letters
 *         and removing them.
 * 
 *         We repeatedly make duplicate removals on s until we no longer can.
 * 
 *         Return the final string after all such duplicate removals have been
 *         made. It can be proven that the answer is unique.
 *
 */
public class RemoveAllAdjacentDuplicates {

	public static String removeDuplicates(String s) {
		Stack<Character> stack = new Stack<>();
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (!stack.isEmpty() && stack.peek() == s.charAt(i))
				stack.pop();
			else {
				stack.push(s.charAt(i));
			}
		}

		for (char c : stack) {
			stringBuilder.append(c);
		}
		return stringBuilder.toString();
	}
	
	
	public static void main(String[] args) {
		String str = "abbaca";
		System.out.println(removeDuplicates(str));
	}

}
