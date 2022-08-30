/**
 * 
 */
package home.ak.algo.bs;

/**
 * @author kundu
 * 
 *         Find the last occurrence of x recursively
 *
 */
public class L04_FindElementRecursively {

	public static int findLast(int[] arr, int x) {
		return findLast(arr, x, 0, arr.length - 1);
	}

	private static int findLast(int[] arr, int x, int start, int end) {
		if (end < start) {
			return -1;
		}
		int mid = (start + end) >> 1;
		if (arr[mid] == x)
			return mid;
		if (arr[mid] < x)
			return findLast(arr, x, mid + 1, end);
		return findLast(arr, x, start, mid - 1);

	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 8, 10 };
		System.out.println(findLast(arr, 6));
	}
}
