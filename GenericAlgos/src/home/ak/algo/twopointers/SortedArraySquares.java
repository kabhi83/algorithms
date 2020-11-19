/**
 * 
 */
package home.ak.algo.twopointers;

/**
 * @author kundu
 * 
 *         Given a sorted array, create a new array containing squares of all
 *         the number of the input array in the sorted order.
 * 
 *         Example 1: Input: [-2, -1, 0, 2, 3] Output: [0, 1, 4, 4, 9]
 * 
 *         Example 2: Input: [-3, -1, 0, 1, 2] Output: [0 1 1 4 9]
 *
 */
public class SortedArraySquares {

	public static int[] makeSquares(int[] arr) {
		int[] squares = new int[arr.length];
		int index = arr.length - 1;
		// Initialize two pointers
		int left = 0, right = arr.length - 1;
		while (left < right) {
			int leftSquare = arr[left] * arr[left];
			int rightSqaure = arr[right] * arr[right];
			if (leftSquare > rightSqaure) {
				// assign
				squares[index--] = leftSquare;
				left++;
			} else {
				squares[index--] = rightSqaure;
				right--;
			}
		}
		return squares;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] result = SortedArraySquares.makeSquares(new int[] { -2, -1, 0, 2, 3 });
		for (int num : result)
			System.out.print(num + " ");
		System.out.println();

		result = SortedArraySquares.makeSquares(new int[] { -3, -1, 0, 1, 2 });
		for (int num : result)
			System.out.print(num + " ");
		System.out.println();
	}

}
