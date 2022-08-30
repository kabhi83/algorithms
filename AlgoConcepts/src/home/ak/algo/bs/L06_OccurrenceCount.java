/**
 * 
 */
package home.ak.algo.bs;

/**
 * @author kundu
 * 
 *         Given an duplicate array and a value x, find the number of occurrence
 *         of x
 * 
 *         Solution 1: last occurrence - first occurrence + 1
 * 
 *         Solution 2: upper bound - lower bound (if exists)
 *
 */
public class L06_OccurrenceCount {

	public static int findOccurences(int[] arr, int x) {
		int[] result = { -1, -1 }; // search first and last occurrence
		result[0] = findOccurences(arr, x, true);
		if (result[0] != -1) {
			// Item found
			result[1] = findOccurences(arr, x, false);
		}
		return result[1] - result[0] + 1;
	}

	public static int findOccurences(int[] arr, int x, boolean firstOccurrence) {
		int start = 0, end = arr.length - 1;
		int result = -1;
		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (arr[mid] == x) {
				// found
				result = mid;
				if (firstOccurrence) {
					// search left
					end = mid - 1;
				} else {
					// search right for last occurrence
					start = mid + 1;
				}
			} else if (arr[mid] < x) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 4, 5, 6, 6, 6, 6, 6, 9, 11, 14 };
		System.out.println(findOccurences(arr, 6));
	}

}
