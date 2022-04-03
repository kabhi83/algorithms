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
 */
public class L3_NearestSmallerLeft {

	public static List<Integer> nearestSmallerLeft(int[] arr) {

		if (arr.length == 0) {
			return null;
		}

		List<Integer> nseList = new LinkedList<>();
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < arr.length; i++) {
			// Check if the stack is empty - add -1
			if (stack.isEmpty()) {
				nseList.add(-1);
			} else if (stack.peek() < arr[i]) {
				nseList.add(stack.peek());
			} else {
				// Pop till we find the next smaller element
				while (!stack.isEmpty() && stack.peek() > arr[i]) {
					stack.pop();
				}
				if (stack.isEmpty()) {
					nseList.add(-1);
				} else {
					nseList.add(stack.peek());
				}
			}
			stack.add(arr[i]);
		}
		return nseList;
	}

	public static void main(String[] args) {
		int[] arr = { 4, 5, 2, 10, 8 };
		List<Integer> list = nearestSmallerLeft(arr);
		for (int val : list) {
			System.out.print(val + " ");
		}
	}

}
