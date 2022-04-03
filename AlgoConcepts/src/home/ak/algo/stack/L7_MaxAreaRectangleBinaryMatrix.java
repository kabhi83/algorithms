/**
 * 
 */
package home.ak.algo.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author kundu
 * 
 *         Given a rows x cols binary matrix filled with 0's and 1's, find the
 *         largest rectangle containing only 1's and return its area.
 *
 */
public class L7_MaxAreaRectangleBinaryMatrix {

	/**
	 * This problem is similar to the Maximum Area Histogram (MAH). We need to
	 * convert the 2D matrix to its 1D representation by computing MAH layer by
	 * layer starting from top and building the MAH.
	 */
	public static int maxAreaRectangle(int[][] matrix) {

		int max = Integer.MIN_VALUE;

		int[] heights = new int[matrix[0].length];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					heights[j] = 0;
				} else {
					heights[j] += matrix[i][j];
				}
			}
			max = Math.max(max, largestRectangleArea(heights));
		}
		return max;
	}

	/**
	 * Method to compute the maximum area of histogram
	 */
	private static int largestRectangleArea(int[] heights) {
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
		int[][] matrix = { { 0, 1, 1, 0 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 0, 0 }, };

		System.out.println(maxAreaRectangle(matrix));
	}

}
