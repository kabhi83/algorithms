/**
 * 
 */
package home.ak.algo.dp.pattern3;

import java.util.Arrays;

/**
 * @author kundu
 * 
 *         Subsequence : A subsequence of a given array is sequence formed by
 *         using subset of items from the original sequence maintaining their
 *         relative ordering. For the array [5,2,3,6,8], [5,3,8] is a sub
 *         sequence.
 * 
 *         Subarray : A sub segment of a given array. [5,2,3] ,[2,3,6], [6,8]
 * 
 *         Increasing subsequence : A subsequence in which elements are sorted
 *         in ascending order. [2,3,6] [3,6,8] [2,3,8] Longest increasing
 *         subsequence [2,3,6,8]
 * 
 *         State: i -> Index of the last item
 * 
 *         Cost function: lis(i, A), where A is the input array
 * 
 *         Base case: if i = 0, return 1 (only 1 element to process)
 * 
 *         Recurrence relation:
 * 
 *         lis(i, A) =
 * 
 *         MAX[lis(j, A) + 1, if A[i] > A[j], lis(j, A), if A[i] < A[j]] for all
 *         j = 0, 1, 2, .. i -1
 * 
 */
public class LongestIncreasingSubsequence {

	public static int lisRecursive(int[] arr) {
		return lisRecursive(arr.length - 1, arr);
	}

	private static int lisRecursive(int i, int[] arr) {
		// Base case: when there is only 1 item to consider
		if (i == 0)
			return 1;

		int max = 1;
		for (int j = 0; j < i; j++) {
			int lis = lisRecursive(j, arr);
			if (arr[i] > arr[j]) {
				lis += 1;
			}
			max = Math.max(max, lis);
		}
		return max;
	}

	public static int lisBU(int[] arr) {
		int N = arr.length;
		int[] dp = new int[N];
		// Minimum size of the longest common sequence is at least 1
		Arrays.fill(dp, 1); // dp[0] = 1 as the minimum size of LIS
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i; j++) {
				int lis = dp[j];
				if (arr[i] > arr[j]) {
					lis += 1;
				}
				dp[i] = Math.max(dp[i], lis);
			}
		}
		return dp[N - 1];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 5, 2, 3, 6, 8 };
		System.out.println(lisRecursive(arr));
		System.out.println(lisBU(arr));

		int[] nums = { 4, 2, 3, 6, 10, 1, 12 };
		System.out.println(lisBU(nums));
	}

}
