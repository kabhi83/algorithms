/**
 * 
 */
package home.ak.algo.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author kundu
 *
 */
public class L4_NearestSmallerRight {

	public static int[] nearestSmallerRight(int[] arr) {
		int n = arr.length;
		int[] nsr = new int[arr.length];
		Stack<Integer> stack = new Stack<>();

		// Implicit - For the last element it will be -1
		nsr[n - 1] = -1;
		stack.push(n - 1);

		for (int i = n - 2; i >= 0; i--) {
			while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
				stack.pop();
			}
			nsr[i] = stack.isEmpty() ? -1 : arr[stack.peek()];
			stack.push(i);
		}
		return nsr;
	}

	public static void main(String[] args) {
		int[] arr = {4, 5, 2, 10 , 8};
		System.out.println(Arrays.toString(nearestSmallerRight(arr)));
	}

}
