/**
 * 
 */
package home.ak.algo.dp;

import java.util.Arrays;

/**
 * @author kundu
 * 
 *         There is a frog on the 1st step of an N stairs long staircase. The
 *         frog wants to reach the Nth stair. HEIGHT[i] is the height of the
 *         (i+1)th stair.If Frog jumps from ith to jth stair, the energy lost in
 *         the jump is given by |HEIGHT[i-1] - HEIGHT[j-1] |.If the Frog is on
 *         ith staircase, he can jump either to (i+1)th stair or to (i+2)th
 *         stair. Your task is to find the minimum total energy used by the frog
 *         to reach from 1st stair to Nth stair.
 *
 */
public class L03_FrogJump {

	public static int frogJumpTD(int[] heights) {
		int[] dp = new int[heights.length]; //0 based indexing
		Arrays.fill(dp, -1);
		return frogJumpTD(heights.length - 1, heights, dp);
	}

	private static int frogJumpTD(int n, int[] heights, int[] dp) {
		if (n == 0) {
			return 0;
		}

		if (dp[n] != -1) {
			return dp[n];
		}

		int n_1_jumpEnergy = frogJumpTD(n - 1, heights, dp) + Math.abs(heights[n] - heights[n - 1]);
		int n_2_jumpEnergy = Integer.MAX_VALUE;
		if (n > 1) { // Right jump will not happen at staircase 1
			n_2_jumpEnergy = frogJumpTD(n - 2, heights, dp) + Math.abs(heights[n] - heights[n - 2]);
		}

		return dp[n] = Math.min(n_1_jumpEnergy, n_2_jumpEnergy);
	}

	public static int frogJumpBU(int[] heights) {
		int[] dp = new int[heights.length];
		dp[0] = 0;
		dp[1] = Math.abs(heights[1] - heights[0]);

		for (int i = 1; i < heights.length; i++) {
			int firstStep = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);
			int secondStep = Integer.MAX_VALUE;
			if(i > 1)
				secondStep = dp[i - 2] + Math.abs(heights[i] - heights[i - 2]);
			dp[i] = Math.min(firstStep, secondStep);
		}
		return dp[heights.length - 1];
	}

	public static void main(String[] args) {
		int[] heights = { 30, 10, 60, 10, 60, 50 };
		System.out.println(frogJumpTD(heights));
		System.out.println(frogJumpBU(heights));
	}

}
