/**
 * 
 */
package home.ak.algo.cyclicsort;

/**
 * @author kundu
 * 
 *         We are given an array containing ‘n’ objects. Each object, when
 *         created, was assigned a unique number from 1 to ‘n’ based on their
 *         creation sequence. This means that the object with sequence number
 *         ‘3’ was created just before the object with sequence number ‘4’.
 * 
 *         Write a function to sort the objects in-place on their creation
 *         sequence number in O(n) and without any extra space.
 *
 */
public class CyclicSort {

	public static void sort(int[] nums) {
		int i = 0;
		while (i < nums.length) {
			// Get the actual sequence of ith item. -1 as the number ranges between 1 to n
			int j = nums[i] - 1;
			if (nums[i] != nums[j]) {
				swap(nums, i, j);
			} else {
				i++;
			}
		}
	}

	private static void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 3, 1, 5, 4, 2 };
		CyclicSort.sort(arr);
		for (int num : arr)
			System.out.print(num + " ");
		System.out.println();

		arr = new int[] { 2, 6, 4, 3, 1, 5 };
		CyclicSort.sort(arr);
		for (int num : arr)
			System.out.print(num + " ");
		System.out.println();

		arr = new int[] { 1, 5, 6, 4, 3, 2 };
		CyclicSort.sort(arr);
		for (int num : arr)
			System.out.print(num + " ");
		System.out.println();
	}

}
