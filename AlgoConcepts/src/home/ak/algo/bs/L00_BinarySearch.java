/**
 * 
 */
package home.ak.algo.bs;

/**
 * @author kundu
 * 
 *         Given a sorted array arr[] of n elements, write a function to search
 *         a given element x in arr[].
 * 
 *         Tips - When low and high are very large integers, their sum (low +
 *         high) might exceed the maximum value that the data type (like an
 *         integer) can hold, leading to an overflow
 * 
 *         The formula mid = start + (end - start) / 2 is preferred over mid =
 *         (start + end) / 2 in algorithms like binary search to prevent
 *         potential integer overflow. When dealing with very large integers,
 *         adding start and end directly might exceed the maximum value
 *         representable by the integer data type, leading to incorrect results
 *         or crashes.
 *
 */
public class L00_BinarySearch {

	public static int binarySearch(int[] arr, int x) {

		int start = 0, end = arr.length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2; // To avoid integer overflow
			if (x == arr[mid]) { // Item found
				return mid;
			} else if (x < arr[mid]) { // Searched item is less than mid
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int x = 2;
		System.out.println(binarySearch(arr, x));
	}

}
