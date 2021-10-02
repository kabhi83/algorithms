/**
 * 
 */
package ak.home.algo.dp.starter;

import java.util.Arrays;

/**
 * @author kundu
 * 
 *         Given an array of positive numbers, where each element represents the
 *         max number of jumps that can be made forward from that element, write
 *         a program to find the minimum number of jumps needed to reach the end
 *         of the array (starting from the first element). If an element is 0,
 *         then we cannot move through that element.
 *
 */
public class MinimumJump {

	public static int countMinJumpsRecursive(int[] jumps) {
		return countMinJumpsRecursive(jumps, 0);
	}

	private static int countMinJumpsRecursive(int[] jumps, int currIdx) {
		// Base case - Reached the last index
		if (currIdx == jumps.length - 1) {
			return 0;
		}
		// Base case - Cannot jump forward from this index
		if (jumps[currIdx] == 0) {
			return Integer.MAX_VALUE;
		}

		int totalJumps = Integer.MAX_VALUE;
		// if the value at the current index is ‘p’, we will try every jump in the range
		// (1 to ‘p’) from that index.
		int start = currIdx + 1;
		int end = currIdx + jumps[currIdx];
		while (start < jumps.length && start <= end) {
			// jump one step and recurse for the remaining array
			int minJumps = countMinJumpsRecursive(jumps, start++);
			if (minJumps != Integer.MAX_VALUE) {
				// End is reachable
				totalJumps = Math.min(totalJumps, minJumps + 1);
			}
		}
		return totalJumps;
	}
	
	public static int countMinJumpsBU(int[] jumps) {
		//Initialize the DP array
		int[] dp = new int[jumps.length];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0; // First jump is 0
		
		//int[] fromJumpArray = new int[jumps.length];
		
		//For every ith index check if it is reachable from jth index
		for(int i = 1; i < jumps.length; i++) {
			for(int j = 0; j < i; j++) {
				//Check if i is in the range of j
				if(i <= j + jumps[j]) {
					dp[i] = Math.min(dp[i], dp[j] + 1);
				}
			}
		}
		return dp[jumps.length - 1];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] jumps = new int[] { 1, 1, 3, 6, 9, 3, 0, 1, 3 };
		System.out.println("Recursive: " + countMinJumpsRecursive(jumps));
		System.out.println("Bottom Up: "+ countMinJumpsBU(jumps));
	}

}
