/**
 * 
 */
package home.ak.algo.stack;

import java.util.Stack;

/**
 * @author kundu
 * 
 *         In this problem, you have to implement findCelebrity() method to find
 *         the celebrity in a party (matrix) using a stack. A celebrity is
 *         someone that everyone knows, but he/she doesn’t know anyone at the
 *         party.
 *
 */
public class L8_CelebrityProblem {

	public static int findCelebrity(int[][] party, int numPeople) {
		int celebrity = -1;
		Stack<Integer> stack = new Stack<>();
		// Push all the people to the stack
		for (int i = numPeople - 1; i >= 0; i--) {
			stack.push(i);
		}
		// Pop 2 elements from stack and compare their relationship
		while (stack.size() > 1) {
			int person1 = stack.pop();
			int person2 = stack.pop();
			// Check if person 1 knows person 2
			if (party[person1][person2] == 1) {
				stack.push(person2); // discard person1
			} else {
				stack.push(person1); // discard person2
			}
		}
		celebrity = stack.pop();
		// validate celebrity
		for (int k = 0; k < numPeople; k++) {
			if (celebrity != k && party[celebrity][k] == 1) {
				// The identified celebrity is not celebrity
				celebrity = -1;
				break;
			}
		}

		return celebrity;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] party1 = { { 0, 1, 1, 0 }, { 1, 0, 1, 1 }, { 0, 0, 0, 0 }, { 0, 1, 1, 0 }, };

		int[][] party2 = { { 0, 1, 1, 0 }, { 1, 0, 1, 1 }, { 0, 0, 0, 1 }, { 0, 1, 1, 0 }, };

		int[][] party3 = { { 0, 0, 0, 0 }, { 1, 0, 0, 1 }, { 1, 0, 0, 1 }, { 1, 1, 1, 0 }, };

		System.out.println(findCelebrity(party1, 4));
		System.out.println(findCelebrity(party2, 4));
		System.out.println(findCelebrity(party3, 4));
	}

}
