/**
 * 
 */
package home.ak.algo.dp.starter;

/**
 * @author kundu
 *
 */
public class Fibonacci {

	/**
	 * Recursive solution for fibonacci series
	 */
	public static int fibRecursive(int x) {

		// Base case: Stopping condition
		if (x <= 1) {
			return x;
		}

		else {
			return fibRecursive(x - 1) + fibRecursive(x - 2);
		}
	}

	/**
	 * Top-down approach - Memoization (recursion + caching)
	 */
	public static int fibTopDown(int x) {
		int[] cache = new int[x + 1];
		return fibTopDown(x, cache);
	}

	private static int fibTopDown(int x, int[] cache) {
		// Base case
		if (x <= 1) {
			return x;
		}
		// if already computed
		if (cache[x] != 0) {
			return cache[x];
		}

		// compute the value
		int res = fibTopDown(x - 1, cache) + fibTopDown(x - 2, cache);
		cache[x] = res; // set the value in the cache
		return res;
	}

	/**
	 * Bottom-up approach - Tabulation - for loop
	 * 
	 * solve all the smaller sub problems first which will be needed to solve the
	 * larger problems
	 */
	public static int fibBottomUp(int x) {
		int[] dp = new int[x + 1];
		dp[0] = 0;
		dp[1] = 1;

		// Compute the smaller problems
		for (int i = 2; i <= x; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		return dp[x];
	}

	public static void main(String[] args) {
		int x = 10;
		System.out.println("Recursive solution: " + fibRecursive(x));
		System.out.println("Top down solution: " + fibTopDown(x));
		System.out.println("Bottom up solution: " + fibBottomUp(x));
	}

}
