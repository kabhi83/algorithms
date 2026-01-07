/**
 * 
 */
package home.ak.algo.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kundu
 * 
 *         Technique to print only 1 answer
 * 
 *         In base case if the condition is satisfied, return true
 * 
 *         Function should return a boolean
 * 
 *         Validate the boolean return value during the function call. If true,
 *         just return, else false.
 *
 */
public class L09_AnySubsequenceWithSumK {

	public static void subsequences(int[] arr, int K) {
		subsequences(0, arr.length, 0, new ArrayList<Integer>(), arr, K);
	}

	private static boolean subsequences(int idx, int arrLength, int sum, List<Integer> list, int[] arr, int K) {
		if (idx == arrLength) {
			if (sum == K) {
				System.out.println(list);
				return true;
			}
			return false;
		}

		// Take the value
		list.add(arr[idx]);
		if (subsequences(idx + 1, arrLength, sum + arr[idx], list, arr, K)) {
			return true;
		}
		list.remove(list.size() - 1);

		// Not take the value
		if (subsequences(idx + 1, arrLength, sum, list, arr, K)) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 1 };
		subsequences(arr, 2);
	}

}
