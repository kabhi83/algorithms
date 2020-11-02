/**
 * 
 */
package home.ak.algo.array;

/**
 * @author user
 * 
 *         Given a sorted array nums, remove the duplicates in-place such that
 *         each element appears only once and returns the new length.
 * 
 *         Do not allocate extra space for another array, you must do this by
 *         modifying the input array in-place with O(1) extra memory.
 * 
 *         Input: nums = [1,1,2] Output: 2, nums = [1,2]
 * 
 *         Explanation: Your function should return length = 2, with the first
 *         two elements of nums being 1 and 2 respectively. It doesn't matter
 *         what you leave beyond the returned length.
 *
 */
public class RemoveDuplicates {

	public int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		// Solve by two pointer technique
		int slow = 0;
		for (int fast = 1; fast < nums.length; fast++) {
			if (nums[slow] != nums[fast]) {
				nums[++slow] = nums[fast];
			} 
		}
		return slow + 1;
	}

	public static void main(String[] args) {
		int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
		int result = new RemoveDuplicates().removeDuplicates(nums);
		System.out.println(result);

	}

}
