/**
 * 
 */
package home.ak.algo.cyclicsort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kundu
 * 
 *         We are given an unsorted array containing numbers taken from the
 *         range 1 to ‘n’. The array can have duplicates, which means some
 *         numbers will be missing. Find all those missing numbers.
 *
 */
public class MissingNumbers {

	public static List<Integer> findNumbers(int[] nums) {
		List<Integer> missingNumbers = new ArrayList<>();
		int i = 0;
		while (i < nums.length) {
			if (nums[i] != nums[nums[i] - 1]) {
				swap(nums, i, nums[i] - 1);
			} else {
				i++;
			}
		}

		for (i = 0; i < nums.length; i++)
			if (nums[i] != i + 1)
				missingNumbers.add(i + 1);

		return missingNumbers;
	}

	private static void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	public static void main(String[] args) {
		List<Integer> missing = findNumbers(new int[] { 2, 3, 1, 8, 2, 3, 5, 1 });
		System.out.println("Missing numbers: " + missing);

		missing = findNumbers(new int[] { 2, 4, 1, 2 });
		System.out.println("Missing numbers: " + missing);

		missing = findNumbers(new int[] { 2, 3, 2, 1 });
		System.out.println("Missing numbers: " + missing);
	}

}
