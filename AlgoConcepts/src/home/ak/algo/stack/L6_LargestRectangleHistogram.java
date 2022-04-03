package home.ak.algo.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author kundu
 * 
 *         Given an array of integers heights representing the histogram's bar
 *         height where the width of each bar is 1, return the area of the
 *         largest rectangle in the histogram.
 *
 */
public class L6_LargestRectangleHistogram {

	/**
	 * Solution to the problem is based on NSL and NSR (NS - Next Smaller)
	 */
	public static int largestRectangleArea(int[] heights) {
		int pseudoLeftIdx = -1;
		int pseudoRightIdx = heights.length;

		// here nsl and nsr will hold the index of the next smallest element
		int[] nsl = new int[heights.length];
		int[] nsr = new int[heights.length];

		// Compute for nsl
		Stack<Integer> stack = new Stack<>();
		nsl[0] = pseudoLeftIdx;
		stack.push(0);
		for (int i = 1; i < heights.length; i++) {
			// Pop the stack still we find a smaller element
			while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
				stack.pop();
			}
			nsl[i] = stack.isEmpty() ? pseudoLeftIdx : stack.peek();
			stack.push(i);
		}

		// Compute for nsr
		stack = new Stack<>(); // Reinitialize the stack
		nsr[heights.length - 1] = pseudoRightIdx;
		stack.push(heights.length - 1);
		for (int i = heights.length - 2; i >= 0; i--) {
			// Pop the stack still we find a smaller element
			while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
				stack.pop();
			}
			nsr[i] = stack.isEmpty() ? pseudoRightIdx : stack.peek();
			stack.push(i);
		}

		// Logic for max area calculation - width * height
		int[] area = new int[heights.length];
		for (int i = 0; i < heights.length; i++) {
			area[i] = (nsr[i] - nsl[i] - 1) * heights[i];
		}

		return Arrays.stream(area).max().getAsInt();
	}

	public static void main(String[] args) {
		int[] heights = { 2, 1, 5, 6, 2, 3, 1 };
		System.out.println(largestRectangleArea(heights));
	}
}
