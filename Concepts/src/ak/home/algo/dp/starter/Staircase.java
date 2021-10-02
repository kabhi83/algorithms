/**
 * 
 */
package ak.home.algo.dp.starter;

/**
 * @author kundu
 * 
 *         A child is climbing up a staircase with n steps, and can hop either 1
 *         step, 2 steps, or 3 steps at a time. Implement a method to count how
 *         many possible ways the child can jump up the stairs.
 * 
 */
public class Staircase {

	/**
	 * Recursive solution
	 */
	public static int possibleWaysRecursive(int n) {
		if (n == 0)
			return 1; // base case, we don't need to take any step, so there is only one way

		if (n == 1)
			return 1; // we can take one step to reach the end, and that is the only way

		if (n == 2)
			return 2; // we can take one step twice or jump two steps to reach at the top

		// if we take 1 step, we are left with 'n-1' steps;
		int take1Step = possibleWaysRecursive(n - 1);
		// similarly, if we took 2 steps, we are left with 'n-2' steps;
		int take2Step = possibleWaysRecursive(n - 2);
		// if we took 3 steps, we are left with 'n-3' steps;
		int take3Step = possibleWaysRecursive(n - 3);

		return take1Step + take2Step + take3Step;
	}

	/**
	 * Top down solution
	 */
	public static int possibleWaysTD(int n) {
		int[] cache = new int[n + 1];
		return possibleWaysTD(n, cache);
	}

	private static int possibleWaysTD(int n, int[] cache) {
		if (n < 0) {
			return 0;
		}
		if (n == 0) {
			// base case, we don't need to take any step, so there is only one way
			return 1;
		}
		if (cache[n] != 0) {
			return cache[n];
		}

		int res = possibleWaysTD(n - 1, cache) + possibleWaysTD(n - 2, cache) + possibleWaysTD(n - 3, cache);
		cache[n] = res;
		return res;
	}

	/**
	 * Bottom up solution
	 */
	public static int possibleWaysBU(int n) {
		if (n < 0) {
			return 0;
		}
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2; // (1 + 1) & 2
		// dp[3] = 4; //1 + 1 + 1, 1 + 2, 2 + 1 & 3
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}
		return dp[n];
	}

	public static void main(String[] args) {
		int n = 10;
		System.out.println("Recursive solution: " + possibleWaysRecursive(n));
		System.out.println("Top down solution: " + possibleWaysTD(n));
		System.out.println("Bottom up solution: " + possibleWaysBU(n));
	}

}
