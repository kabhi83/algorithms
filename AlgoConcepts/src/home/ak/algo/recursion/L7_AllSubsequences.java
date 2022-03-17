/**
 * 
 */
package home.ak.algo.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kundu
 * 
 *         Take | Not Take Pattern
 *
 */
public class L7_AllSubsequences {

	public static void subsequences(int[] arr) {
		subsequences(0, arr.length, new ArrayList<Integer>(), arr);
	}

	private static void subsequences(int idx, int arrLength, List<Integer> list, int[] arr) {
		// Base case
		if (idx >= arrLength) {
			System.out.println(list);
			return;
		}

		// Take action
		list.add(arr[idx]);
		subsequences(idx + 1, arrLength, list, arr);
		list.remove(list.size() - 1);

		// Non Take action
		subsequences(idx + 1, arrLength, list, arr);
	}

	public static void main(String[] args) {
		int[] arr = { 3, 1, 2 };
		subsequences(arr);
	}

	// Time complexity - For every index there are 2 options - Take & not take 2^n.
	// For Printing n. Total = 2^n * n
	// Space complexity - Depth of the recursion tree - O(n)
}
