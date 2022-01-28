/**
 * 
 */
package home.ak.algo.bs.starter;

/**
 * @author kundu
 * 
 *         Given a sorted array arr[] and a number x, write a function that
 *         counts the occurrences of x in arr[]. Expected time complexity is
 *         O(Logn)
 *
 */
public class L2_NumberFrequency {

	public static int countOccurrences(int[] arr, int x) {
		int first = getFirstIndex(arr, x);
		int last = getLastIndex(arr, x);
		if (first == -1 || last == -1) {
			return -1;
		}
		return last - first + 1;
	}

	private static int getFirstIndex(int[] arr, int x) {
		int start = 0, end = arr.length - 1;
		int res = -1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (x == arr[mid]) {
				res = mid;
				end = mid - 1;
			} else if (x < arr[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return res;
	}

	private static int getLastIndex(int[] arr, int x) {
		int start = 0, end = arr.length - 1;
		int res = -1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (x == arr[mid]) {
				res = mid;
				start = mid + 1;
			} else if (x < arr[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 2, 3, 3, 3, 3 };
		int x = 3;
		System.out.println(countOccurrences(arr, x));
	}

}
