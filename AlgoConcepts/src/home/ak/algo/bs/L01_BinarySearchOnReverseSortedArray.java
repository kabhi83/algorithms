/**
 * 
 */
package home.ak.algo.bs;

/**
 * @author kundu
 * 
 *         Binary search on the reverse sorted array
 *
 */
public class L01_BinarySearchOnReverseSortedArray {

	public static int binarySearch(int[] arr, int x) {

		int start = 0, end = arr.length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2; // To avoid integer overflow
			if (x == arr[mid]) {
				return mid;
			} else if (x > arr[mid]) { // Item is on the left hand side
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9 };
		int x = 14;
		System.out.println(binarySearch(arr, x));
	}

}
