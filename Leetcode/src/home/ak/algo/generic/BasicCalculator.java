/**
 * 
 */
package home.ak.algo.generic;

import java.util.Stack;

/**
 * @author kundu
 * 
 *         Given a string s representing an expression, implement a basic
 *         calculator to evaluate it.
 * 
 *         Example 1: Input: s = "1 + 1" Output: 2
 * 
 *         Example 2: Input: s = " 2-1 + 2 " Output: 3
 * 
 *         Example 3: Input: s = "(1+(4+5+2)-3)+(6+8)" Output: 23
 */
public class BasicCalculator {

	private static int evaluate(int num2, int num1, char operator) {
		if (operator == '+') {
			return num1 + num2;
		}

		return num1 - num2;
	}

	/**
	 * Check for 5 possible cases - Empty character, number, operator, ( and )
	 */
	public static int calculate(String s) {
		if (null == s) {
			return 0;
		}

		Stack<Integer> numberStack = new Stack<>();
		Stack<Character> operatorStack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char current = s.charAt(i);
			if (current == ' ') {
				// Case 0: Check for empty character
				continue;
				
			} else if (Character.isDigit(current)) {
				// Case 1: Check for number
				int num = current - '0';
				while (i < s.length() && Character.isDigit(s.charAt(++i))) {
					num *= 10 + s.charAt(i) - '0';
				}
				numberStack.push(num);
				i--; // Since the pointer has moved forward
			} else if (current == '(') {
				// Case 2: Check for '('
				operatorStack.push('(');
				
			} else if (current == ')') {
				// Case 3: Check for ')'. Compute all the value till '('
				while (operatorStack.peek() != '(') {
					numberStack.push(evaluate(numberStack.pop(), numberStack.pop(), operatorStack.pop()));
				}
				operatorStack.pop(); // To remove the char '('
				
			} else {
				// Case 4: If operator. Evaluate previous entries
				while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
					numberStack.push(evaluate(numberStack.pop(), numberStack.pop(), operatorStack.pop()));
				}
				operatorStack.push(current);
			}
		}

		// Perform the remaining operations
		while (!operatorStack.isEmpty())
			numberStack.push(evaluate(numberStack.pop(), numberStack.pop(), operatorStack.pop()));

		return numberStack.pop(); // Return the last remaining element
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "(1+(4+5+2)-3)+(6+8)";
		System.out.println(calculate(s));

	}

}
