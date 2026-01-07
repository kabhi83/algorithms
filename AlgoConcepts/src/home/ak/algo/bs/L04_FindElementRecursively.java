/**
 * 
 */
package home.ak.algo.bs;

/**
 * @author kundu
 * 
 *         Find the element x recursively
 * 
 * 
 *         Note : The code mid = (start + end) >> 1 calculates the middle index
 *         (mid) within a range defined by start and end. It uses bitwise right
 *         shift ( >> 1 ) which is equivalent to integer division by 2,
 *         effectively finding the middle point.
 *
 */
public class L04_FindElementRecursively {

	public static int findrecursively(int[] arr, int x) {
		return findrecursively(arr, x, 0, arr.length - 1);
	}

	private static int findrecursively(int[] arr, int x, int start, int end) {
		if (end < start) {
			return -1;
		}
		int mid = (start + end) >> 1;
		if (arr[mid] == x)
			return mid;
		if (arr[mid] < x)
			return findrecursively(arr, x, mid + 1, end);
		return findrecursively(arr, x, start, mid - 1);

	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 8, 10 };
		System.out.println(findrecursively(arr, 6));

		arr = new int[] { 1, 2, 2, 3, 4, 5, 6, 6, 8, 10 };
		System.out.println(findrecursively(arr, 2));
	}
}
