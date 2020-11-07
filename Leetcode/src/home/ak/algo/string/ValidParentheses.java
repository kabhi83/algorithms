/**
 * 
 */
package home.ak.algo.string;

import java.util.Stack;

/**
 * @author kundu
 * 
 *         Given a string s containing just the characters '(', ')', '{', '}',
 *         '[' and ']', determine if the input string is valid.
 * 
 *         An input string is valid if:
 * 
 *         Open brackets must be closed by the same type of brackets. Open
 *         brackets must be closed in the correct order.
 * 
 *         Example 1: Input: s = "()" Output: true
 * 
 *         Example 2: Input: s = "()[]{}" Output: true
 *
 */
public class ValidParentheses {

	public boolean isValid(String s) {
		// Error check
		if (s.length() == 0) {
			return true;
		}

		// Initialize a stack
		Stack<Character> stack = new Stack<>();

		for (char c : s.toCharArray()) {
			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			} else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
				stack.pop();
			} else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
				stack.pop();
			} else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
				stack.pop();
			} else {
				return false;
			}
		}
		return stack.isEmpty();

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "()[]{}";
		boolean result = new ValidParentheses().isValid(s);
		System.out.println(result);
	}

}
