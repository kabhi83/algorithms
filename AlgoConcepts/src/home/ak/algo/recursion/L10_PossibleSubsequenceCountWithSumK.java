/**
 * 
 */
package home.ak.algo.recursion;

/**
 * @author kundu
 * 
 * 
 *         function should have an integer return type
 * 
 *         base case:
 * 
 *         return 1 if condition satisfies and return 0 if condition does not
 *         satisfy
 *
 */
public class L10_PossibleSubsequenceCountWithSumK {

	public static void subsequences(int[] arr, int K) {
		int count = subsequences(0, arr.length, 0, arr, K);
		System.out.println(count);
	}

	private static int subsequences(int idx, int arrLength, int sum, int[] arr, int K) {
		if (sum > K)
			return 0; // Pruning
		if (idx == arrLength) {
			if (sum == K) {
				return 1;
			}
			return 0;
		}

		// Take the value
		int withValue = subsequences(idx + 1, arrLength, sum + arr[idx], arr, K);

		// Not take the value
		int withoutValue = subsequences(idx + 1, arrLength, sum, arr, K);

		return withValue + withoutValue;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 1 };
		subsequences(arr, 2);
	}

}
