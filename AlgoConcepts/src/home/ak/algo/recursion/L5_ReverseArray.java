/**
 * 
 */
package home.ak.algo.recursion;

import java.util.Arrays;

/**
 * @author kundu
 *
 */
public class L5_ReverseArray {

	public static void reverse(int[] arr) {
		reverse(0, arr.length, arr);
	}

	private static void reverse(int i, int n, int[] arr) {
		if (i >= n / 2) {
			// Stop reversing post halfway traversal
			return;
		}
		swap(i, n - i - 1, arr);
		reverse(i + 1, n, arr);
	}

	private static void swap(int i, int j, int[] arr) {
		arr[i] = arr[i] - arr[j];
		arr[j] = arr[i] + arr[j];
		arr[i] = Math.abs(arr[i] - arr[j]);
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
		reverse(arr);
		System.out.println(Arrays.toString(arr));
	}

	

}
