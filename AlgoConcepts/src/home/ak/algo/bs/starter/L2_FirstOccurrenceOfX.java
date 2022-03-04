/**
 * 
 */
package home.ak.algo.bs.starter;

/**
 * @author kundu
 * 
 *         Given an array of duplicates find out the first occurrence of x
 *
 */
public class L2_FirstOccurrenceOfX {

	public static int firstOccurrence(int[] arr, int x) {
		int start = 0, end = arr.length - 1;
		int result = -1;
		while (start <= end) {
			int mid = (start + end) >> 1;

			if (arr[mid] == x) {
				// found - but look left for first occurrance
				result = mid;
				end = mid - 1;
				continue; // to retrigger search
			}

			if (arr[mid] < x) {
				// Look right
				start = mid + 1;
			} else {
				// look left
				end = mid - 1;
			}
		}
		return result; // if element is found it will be start value
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 2, 2, 3, 4, 4, 4, 5 };
		int x = 4;
		System.out.println(firstOccurrence(arr, x));
	}

}
