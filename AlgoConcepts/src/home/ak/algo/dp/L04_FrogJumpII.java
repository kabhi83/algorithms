/**
 * 
 */
package home.ak.algo.dp;

import java.util.Arrays;

/**
 * @author kundu
 * 
 *         Extension to the previous problem with the frog can now jump from 1
 *         to k steps
 *
 */
public class L04_FrogJumpII {

	public static int frogJumpTD(int[] heights, int k) {
		int[] dp = new int[heights.length];
		Arrays.fill(dp, -1);
		return frogJumpTD(heights.length - 1, heights, k, dp);
	}

	private static int frogJumpTD(int idx, int[] heights, int k, int[] dp) {
		if (idx == 0) {
			return 0;
		}

		if(dp[idx] != -1) {
			return dp[idx];
		}
		int minEnergy = Integer.MAX_VALUE;

		for (int i = 1; i <= k; i++) {
			if (idx - i >= 0) {
				int energy = frogJumpTD(idx - i, heights, k, dp) + Math.abs(heights[idx] - heights[i]);
				minEnergy = Math.min(minEnergy, energy);
			}
		}
		return dp[idx] = minEnergy;
	}
	
	public static void main(String[] args) {
		int[] heights = { 30, 10, 60, 10, 60, 50 };
		System.out.println(frogJumpTD(heights, 2));
	}

}
