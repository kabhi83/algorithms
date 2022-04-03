/**
 * 
 */
package home.ak.algo.stack;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author kundu
 * 
 *         Given an array, print the Next Greater Element (NGE) for every
 *         element. The Next greater Element for an element x is the first
 *         greater element on the right side of x in the array. Elements for
 *         which no greater element exist, consider the next greater element as
 *         -1.
 *
 */
public class L2_NearestGreaterRight {

	/**
	 * Case 1: stack empty -> -1
	 * 
	 * Case 2: stack.top > arr[i] -> stack.peek()
	 * 
	 * Case 3: stack.top < arr[i] -> pop till stack is empty or stack.top > arr[i]
	 */
	public static List<Integer> nextGreaterElementRight(int[] arr) {
		if (arr.length == 0) {
			return null;
		}

		List<Integer> ngeList = new LinkedList<>();
		Stack<Integer> stack = new Stack<>();

		for (int i = arr.length - 1; i >= 0; i--) {
			if (stack.isEmpty()) {
				ngeList.add(0, -1);
			} else if (stack.peek() > arr[i]) {
				ngeList.add(0, stack.peek());
			} else if (stack.peek() < arr[i]) {
				while (!stack.isEmpty() && stack.peek() < arr[i]) {
					stack.pop();
				}

				if (stack.isEmpty()) {
					ngeList.add(0, -1);
				} else {
					ngeList.add(0, stack.peek());
				}
			}
			stack.push(arr[i]);
		}
		return ngeList;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 3, 2, 4 };
		List<Integer> list = nextGreaterElementRight(arr);
		for (int val : list) {
			System.out.print(val + " ");
		}
	}

}
