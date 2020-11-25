package home.ak.algo.binaysearch;
/**
 * @author kundu
 * 
 *         Given a sorted array of numbers, find if a given number ‘key’ is
 *         present in the array. Though we know that the array is sorted, we
 *         don’t know if it’s sorted in ascending or descending order. The array
 *         can have duplicates.
 * 
 *         Write a function to return the index of the ‘key’ if it is present in
 *         the array, otherwise return -1.
 *
 */
public class OrderAgnosticBinarySearch {

	public static int search(int[] arr, int key) {
		int start = 0, end = arr.length - 1;
		boolean isAscending = arr[start] < arr[end];
		while (start <= end) {
			// calculate the middle of the current range
			int mid = start + (end - start) / 2;
			// Case 1: If the key matches
			if (key == arr[mid]) {
				return mid;
			}
			if (isAscending) {
				if (key > arr[mid]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			} else {
				if (key > arr[mid]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(OrderAgnosticBinarySearch.search(new int[] { 4, 6, 10 }, 10));
		System.out.println(OrderAgnosticBinarySearch.search(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 5));
		System.out.println(OrderAgnosticBinarySearch.search(new int[] { 10, 6, 4 }, 10));
		System.out.println(OrderAgnosticBinarySearch.search(new int[] { 10, 6, 4 }, 4));
	}
}
