/**
 * 
 */
package home.ak.algo.recursion;

import java.util.Arrays;

/**
 * @author kundu
 * 
 *         Merge sort is the divide and merge algorithm with the time complexity
 *         of O(nlog) - splitting the array in half (log n levels) and
 *         performing linear O(n) work at each level to merge the sorted halves
 * 
 *         Merge sort algorithm stops when there are only 1 element in an array.
 * 
 *         We don't create additional arrays but just play with indexes.
 *
 */
public class L12_MergeSort {

	static void mergeSort(int[] arr) {
		mergeSort(arr, 0, arr.length - 1);
	}

	static void mergeSort(int[] arr, int low, int high) {
		if (low >= high) {
			return;
		}

		// Still there are multiple elements in the array
		int mid = (low + high) / 2;
		mergeSort(arr, low, mid);
		mergeSort(arr, mid + 1, high);

		merge(arr, low, mid, high);
	}

	private static void merge(int[] arr, int low, int mid, int high) {
		int left = low;
		int right = mid + 1;
		int[] merged = new int[high - low + 1];
		int idx = 0;

		while (left <= mid && right <= high) {
			if (arr[left] <= arr[right]) {
				merged[idx++] = arr[left++];
			} else {
				merged[idx++] = arr[right++];
			}
		}

		// If there are pending items in left section of the array
		while (left <= mid) {
			merged[idx++] = arr[left++];
		}

		// If there are pending items in right section of the array
		while (right <= high) {
			merged[idx++] = arr[right++];
		}

		// Add the elements back to the arr
		for (int i = low; i <= high; i++) {
			arr[i] = merged[i - low]; // i-low will be the starting index for merged
		}
	}

	public static void main(String[] args) {
		int[] arr = { 2, 3, 0, 7, 6, 5, 9, 7, 11 };
		mergeSort(arr);
		System.out.println(Arrays.toString(arr));
	}

}
