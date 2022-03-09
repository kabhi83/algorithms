/**
 * 
 */
package home.ak.algo.bs.starter;

/**
 * @author kundu
 * 
 *         The lower and upper bound of a binary search are the lowest and
 *         highest position where the value could be inserted without breaking
 *         the ordering
 *
 */
public class L5_LowerBoundUpperBound {

	/**
	 * Lower bound of x is the value greater than and equal to x
	 */
	public static int lowerBound(int[] arr, int x) {
		int start = 0, end = arr.length - 1;
		int result = arr.length;
		while (start <= end) {
			int mid = (start + end) >> 1;
			if (arr[mid] >= x) {
				// Always search in the left for better solution
				result = mid;
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
			if (arr[mid] <= x) { // since we need greater
				start = mid + 1;
			} else {
				// > x, then we need to first, hence move left
				result = mid;
				end = mid - 1;
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
