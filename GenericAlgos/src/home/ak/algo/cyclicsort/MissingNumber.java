/**
 * 
 */
package home.ak.algo.cyclicsort;

/**
 * @author kundu
 * 
 *         We are given an array containing ‘n’ distinct numbers taken from the
 *         range 0 to ‘n’. Since the array has only ‘n’ numbers out of the total
 *         ‘n+1’ numbers, find the missing number.
 *
 */
public class MissingNumber {

	/**
	 * we will not move to the next number after the swap until we have a correct
	 * number at the index i.
	 */
	public static int findMissingNumber(int[] nums) {
		int i = 0;
		while (i < nums.length) {
			if (nums[i] < nums.length && nums[i] != nums[nums[i]]) {
				// We will be ignoring the last number and try to arrange all before that
				swap(nums, i, nums[i]);
			} else {
				i++;
			}
		}

		for (i = 0; i < nums.length; i++) {
			if (nums[i] != i) {
				return i;
			}
		}

		return nums.length;
	}

	private static void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(MissingNumber.findMissingNumber(new int[] { 4, 0, 3, 1 }));
		System.out.println(MissingNumber.findMissingNumber(new int[] { 8, 3, 5, 2, 4, 6, 0, 1 }));
	}

}
