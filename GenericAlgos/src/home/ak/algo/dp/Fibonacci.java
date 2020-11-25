/**
 * 
 */
package home.ak.algo.dp;

/**
 * @author kundu
 * 
 *         Top down approach (Memoization) -> recursion + caching
 * 
 *         Bottom up approach (Tabulation) -> for loop
 *
 */
public class Fibonacci {

	/**
	 * recursive method to compute the fibonacci value of a number
	 */
	public static int fibRecursive(int n) {
		if (n <= 1) {
			return n;
		}
		return fibRecursive(n - 1) + fibRecursive(n - 2);
	}

	/**
	 * Top down approach to solve fobonacci number using memoization
	 */
	public static int fibTopDown(int n) {
		int[] cache = new int[n + 1];
		return fibMemo(n, cache);
	}

	/**
	 * Recursion + memoization
	 */
	private static int fibMemo(int n, int[] cache) {
		if (n <= 1) {
			return n;
		}
		if (cache[n] != 0) {
			return cache[n];
		}
		int result = fibMemo(n - 1, cache) + fibMemo(n - 2, cache);
		return cache[n] = result;
	}

	/**
	 * Bottom Up for-loop to iterate over all the subproblems and solve them.
	 */
	public static int fibBottomUp(int n) {
		int[] cache = new int[n + 1];
		cache[0] = 0;
		cache[1] = 1;

		for (int i = 2; i <= n; i++) {
			cache[i] = cache[i - 1] + cache[i - 2];
		}

		return cache[n];
	}

	public static void main(String args[]) {
		int n = 9;
		System.out.println(fibRecursive(n));
		System.out.println(fibTopDown(n));
		System.out.println(fibBottomUp(n));
	}

}
