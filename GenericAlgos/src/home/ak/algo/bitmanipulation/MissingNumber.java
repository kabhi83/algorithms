/**
 * 
 */
package home.ak.algo.bitmanipulation;

/**
 * @author kundu
 * 
 *         Given an array of n-1 integers in the range from 1 to n, find the one
 *         number that is missing from the array.
 * 
 *         Example: Input: 1, 5, 2, 6, 4 Answer: 3
 * 
 *         Hint: XOR of a number with itself will always result in 0. This means
 *         that if we XOR all the numbers in the input array with all numbers
 *         from the range 1 to n then each number in the input is going to get
 *         zeroed out except the missing number. Following are the set of steps
 *         to find the missing number using XOR:
 * 
 *         XOR all the numbers from 1 to n, let’s call it x1. XOR all the
 *         numbers in the input array, let’s call it x2. The missing number can
 *         be found by x1 XOR x2.
 *
 */
public class MissingNumber {

	public static int findMissingNumber(int[] nums) {
		int n = nums.length + 1;

		// XOR from 1 to n
		int x1 = 1;
		for (int i = 2; i <= n; i++) {
			x1 ^= i;
		}

		// XOR of all the numbers in the array
		int x2 = nums[0];
		for (int i = 1; i < n - 1; i++) {
			x2 ^= nums[i];
		}

		// missing number is the xor of x1 and x2
		return x1 ^ x2;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 5, 2, 6, 4 };
		System.out.print("Missing number is: " + MissingNumber.findMissingNumber(arr));
	}

}
