/**
 * 
 */
package home.ak.algo.dp;

import java.util.Arrays;

/**
 * @author kundu
 * 
 *         Ninja is planing this ‘N’ days-long training schedule. Each day, he
 *         can perform any one of these three activities. (Running, Fighting
 *         Practice or Learning New Moves). Each activity has some merit points
 *         on each day. As Ninja has to improve all his skills, he can’t do the
 *         same activity in two consecutive days. Can you help Ninja find out
 *         the maximum merit points Ninja can earn? You are given a 2D array of
 *         size N*3 ‘POINTS’ with the points corresponding to each day and
 *         activity. Your task is to calculate the maximum number of merit
 *         points that Ninja can earn.
 * 
 *         Example1: Input: [[1,2,5], [3 ,1 ,1] ,[3,3,3] ], output: 11
 *         Explanation: 5 + 3 + 3 = 11
 * 
 *         Example2: Input: [[10, 50, 1], [5, 100, 11]], output: 110
 *         Explanation: 10 + 100
 *
 */
public class L07_NinjaTraining {

	public static int ninjaTrainingTD(int days, int points[][]) {
		// We have to keep track of the last performed task
		int[][] dp = new int[days][4];
		for (int[] arr : dp) {
			Arrays.fill(arr, -1);
		}
		// Only for 1st case all 3 tasks are possible candidate - hence 3 is passed to
		// indicate the initial flow
		return ninjaTrainingTD(days - 1, points, 3, dp);
	}

	private static int ninjaTrainingTD(int day, int[][] points, int lastTask, int[][] dp) {
		// Base case
		if (day == 0) {
			int max = 0;
			// Need to check for the maximum across all the task
			for (int task = 0; task <= 2; task++) {
				if (task != lastTask) {
					// Consider the maximum possible points if the current task is not last task
					max = Math.max(max, points[0][task]);
				}
			}
			return max;
		}
		if (dp[day][lastTask] != -1) {
			return dp[day][lastTask];
		}
		int maxPoints = 0;
		for (int task = 0; task <= 2; task++) {
			if (task != lastTask) {
				maxPoints = Math.max(maxPoints, +points[day][task] + ninjaTrainingTD(day - 1, points, task, dp));
			}
		}
		return dp[day][lastTask] = maxPoints;
	}

	public static int ninjaTrainingBU(int days, int points[][]) {
		int[][] dp = new int[days][4];
		dp[0][0] = Math.max(points[0][1], points[0][2]);
		dp[0][1] = Math.max(points[0][0], points[0][2]);
		dp[0][2] = Math.max(points[0][0], points[0][1]);
		dp[0][3] = Math.max(dp[0][0], Math.max(dp[0][1], dp[0][2])); // for a single day
		for (int day = 1; day < days; day++) {
			// For everyday there are 4 different task values - 0, 1, 2, 3
			for (int lastTask = 0; lastTask <= 3; lastTask++) {
				dp[day][lastTask] = 0;
				//Copied from recursion
				for (int task = 0; task <= 2; task++) {
					if (task != lastTask) {
						dp[day][lastTask] = Math.max(dp[day][lastTask], points[day][task] + dp[day - 1][task]);
					}
				}
			}
		}
		return dp[days - 1][3];
	}

	public static void main(String[] args) {
		int[][] points = { { 1, 2, 5 }, { 3, 1, 1 }, { 3, 3, 3 } };
		System.out.println(ninjaTrainingTD(3, points));
		System.out.println(ninjaTrainingBU(3, points));
	}

}
