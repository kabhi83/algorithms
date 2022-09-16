/**
 * 
 */
package home.ak.algo.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kundu
 * 
 *         Print all subsequence whose sum adds upto K
 *
 */
public class L08_SubsequencesWithSumK {

	public static void subsequences(int[] arr, int K) {
		subsequences(0, arr.length, 0, new ArrayList<Integer>(), arr, K);
	}

	private static void subsequences(int idx, int arrLength, int sum, List<Integer> list, int[] arr, int K) {
		if (idx == arrLength) {
			if (sum == K) {
				System.out.println(list);
			}
			return;
		}

		// Take the value
		list.add(arr[idx]);
		subsequences(idx + 1, arrLength, sum + arr[idx], list, arr, K);
		list.remove(list.size() - 1);

		// Not take the value
		subsequences(idx + 1, arrLength, sum, list, arr, K);
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 1};
		subsequences(arr, 2);
	}

}
