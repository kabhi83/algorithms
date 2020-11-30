/**
 * 
 */
package home.ak.algo.binaysearch;

/**
 * @author kundu
 * 
 *         Given an array of numbers sorted in ascending order, find the range
 *         of a given number ‘key’. The range of the ‘key’ will be the first and
 *         last position of the ‘key’ in the array.
 * 
 *         Write a function to return the range of the ‘key’. If the ‘key’ is
 *         not present return [-1, -1].
 * 
 *         Example 1: Input: [4, 6, 6, 6, 9], key = 6 Output: [1, 3]
 * 
 *         Example 2: Input: [1, 3, 8, 10, 15], key = 10 Output: [3, 3]
 * 
 *         Hint:
 * 
 *         When trying to find the first position of the ‘key’, we can update
 *         end = middle - 1 to see if the key is present before middle.
 * 
 *         When trying to find the last position of the ‘key’, we can update
 *         start = middle + 1 to see if the key is present after middle.
 *
 */
public class KeyRange {

	public static int[] findRange(int[] arr, int key) {
		int[] result = new int[] { -1, -1 };
		result[0] = search(arr, key, false);
		if (result[0] != -1) {
			// found the item in the array
			result[1] = search(arr, key, true);
		}
		return result;
	}

	private static int search(int[] arr, int key, boolean findMaxIndex) {

		int start = 0, end = arr.length - 1;
		int keyIndex = -1;
		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (key == arr[mid]) {
				keyIndex = mid;
				// found the key in the array
				if (findMaxIndex) {
					// continue the search to find the max index - result[1]
					start = start + 1;
				} else {
					// continue the search to find the min index - result[0]
					end = mid - 1;
				}
			} else if (key < arr[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return keyIndex;

	}

	public static void main(String[] args) {
		int[] result = findRange(new int[] { 4, 6, 6, 6, 9 }, 6);
		System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
		result = findRange(new int[] { 1, 3, 8, 10, 15 }, 10);
		System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
		result = findRange(new int[] { 1, 3, 8, 10, 15 }, 12);
		System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
	}

}
