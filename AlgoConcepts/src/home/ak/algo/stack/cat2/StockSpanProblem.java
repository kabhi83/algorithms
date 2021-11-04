package home.ak.algo.stack.cat2;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author kundu
 * 
 *         The stock span problem is a financial problem where we have a series
 *         of n daily price quotes for a stock and we need to calculate span of
 *         stock’s price for all n days. The span Si of the stock’s price on a
 *         given day i is defined as the maximum number of consecutive days just
 *         before the given day, for which the price of the stock on the current
 *         day is less than or equal than its price on the given day.
 *
 */
public class StockSpanProblem {

	/**
	 * Stock Span Plan is current price index - Next Greatest Left Index
	 */
	public static int[] calculateSpan(int[] price) {
		int[] span = new int[price.length];

		Stack<Integer> stack = new Stack<>();

		// For the first day, span value is always 1
		span[0] = 1; // Stock value is only equal to it's current value
		stack.push(0); // Push the 0th index to stack
		for (int i = 1; i < price.length; i++) {
			// Check (pop) till be get next greater value from the current price
			while (!stack.isEmpty() && price[stack.peek()] <= price[i]) {
				stack.pop();
			}
			// If stack becomes empty, then price[i] is greater than all elements on left of
			// it; hence its value is current index + 1
			span[i] = stack.isEmpty() ? i + 1 : i - stack.peek();

			// Push the current element's index to stack
			stack.push(i);
		}
		return span;
	}

	public static void main(String[] args) {
		int[] price = { 10, 80, 60, 70, 60, 90, 50, 85 };
		System.out.println(Arrays.toString(calculateSpan(price)));
	}

}
