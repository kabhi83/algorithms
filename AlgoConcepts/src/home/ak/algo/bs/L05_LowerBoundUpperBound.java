/**
 * 
 */
package home.ak.algo.bs;

/**
 * @author kundu
 * 
 *         The lower and upper bound of a binary search are the lowest and
 *         highest position where the value could be inserted without breaking
 *         the ordering
 *
 */
public class L05_LowerBoundUpperBound {

	/**
	 * Lower bound of x is the value greater than and equal to x
	 */
	public static int lowerBound(int[] arr, int x) {
		int start = 0, end = arr.length - 1;
		int result = arr.length; // Hypothetical index if we don't find a lower bound
		while (start <= end) {
			int mid = (start + end) >> 1;
			if (arr[mid] >= x) { // May be an answer as we are not searching exact element
				result = mid; // Always search in the left for better solution
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return result == arr.length ? -1 : result;
	}

	/**
	 * Upper bound of x is the first element greater than x
	 */
	public static int upperBound(int[] arr, int x) {
		int start = 0, end = arr.length - 1;
		int result = arr.length;
		while (start <= end) {
			int mid = (start + end) >> 1;
			if (arr[mid] > x) { // since we need greater
				result = mid;
				end = mid - 1; // Look for more smaller index in the left
			} else {
				start = mid + 1; // Look right if the greater value is not found
			}
		}
		return result == arr.length ? -1 : result;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 8, 10 };
		System.out.println(lowerBound(arr, 11));

		System.out.println(upperBound(arr, 6));
	}
}
