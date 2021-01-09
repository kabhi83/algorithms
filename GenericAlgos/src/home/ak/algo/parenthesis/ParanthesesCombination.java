/**
 * 
 */
package home.ak.algo.parenthesis;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author kundu
 * 
 *         For a given number ‘N’, write a function to generate all combination
 *         of ‘N’ pairs of balanced parentheses.
 *
 */
public class ParanthesesCombination {

	static class ParenthesesString {
		String str;
		int openCount; // open parentheses count
		int closeCount; // close parentheses count

		public ParenthesesString(String str, int openCount, int closeCount) {
			this.str = str;
			this.openCount = openCount;
			this.closeCount = closeCount;
		}
	}

	public static List<String> generateValidParentheses(int N) {
		List<String> result = new ArrayList<String>();
		if (N == 0) {
			return result;
		}

		Queue<ParenthesesString> queue = new LinkedList<>();
		// Add the empty string to the queue along with open & close count
		queue.add(new ParenthesesString("", 0, 0));
		while (!queue.isEmpty()) {
			ParenthesesString curr = queue.poll();
			// Reached the maximum number of open and close parentheses, add to the result
			if (curr.openCount == N && curr.closeCount == N) {
				result.add(curr.str);
			} else {
				// Check if we can add the open parentheses
				if (curr.openCount < N) {
					queue.add(new ParenthesesString(curr.str + "(", curr.openCount + 1, curr.closeCount));
				}

				// check if we can add the close parentheses
				if (curr.closeCount < curr.openCount) {
					queue.add(new ParenthesesString(curr.str + ")", curr.openCount, curr.closeCount + 1));
				}
			}
		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> result = generateValidParentheses(2);
		System.out.println("All combinations of balanced parentheses are: " + result);

		result = generateValidParentheses(3);
		System.out.println("All combinations of balanced parentheses are: " + result);
	}

	/*
	 * Time complexity # If we don’t care for the ordering - that ) can only come
	 * after ( - then we have two options for every position, i.e., either put open
	 * parentheses or close parentheses. This means we can have a maximum of 2^N
	 * combinations. Because of the ordering, the actual number will be less than
	 * 2^N.
	 * 
	 * Hence in the worst case, it is equivalent to a binary tree, where each node
	 * will have two children. This means that we will have 2^N leaf nodes and 2^N-1
	 * intermediate nodes. So the total number of elements pushed to the queue will
	 * be 2^N + 2^N-1, which is asymptotically equivalent to O(2^N). While
	 * processing each element, we do need to concatenate the current string with (
	 * or ). This operation will take O(N), so the overall time complexity of our
	 * algorithm will be O(N*2^N).
	 * 
	 * Space complexity # All the additional space used by our algorithm is for the
	 * output list. Since we can’t have more than O(2^N) combinations, the space
	 * complexity of our algorithm is O(N*2^N).
	 */

}
