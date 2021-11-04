/**
 * 
 */
package home.ak.algo.bs.starter;

/**
 * @author kundu
 * 
 *         Given a sorted array arr[] of n elements, write a function to search
 *         a given element x in arr[].
 *
 */
public class BinarySearch {

	public static int binarySearch(int[] arr, int x) {

		int start = 0, end = arr.length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2; // To avoid integer overflow
			if (x == arr[mid]) {
				return mid;
			} else if (x < arr[mid]) {
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
