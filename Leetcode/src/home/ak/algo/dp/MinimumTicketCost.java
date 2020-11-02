/**
 * 
 */
package home.ak.algo.dp;

import java.util.Arrays;

/**
 * @author user
 * 
 *         In a country popular for train travel, you have planned some train
 *         travelling one year in advance. The days of the year that you will
 *         travel is given as an array days. Each day is an integer from 1 to
 *         365.
 * 
 *         Train tickets are sold in 3 different ways:
 * 
 *         a 1-day pass is sold for costs[0] dollars;
 * 
 *         a 7-day pass is sold for costs[1] dollars;
 * 
 *         a 30-day pass is sold for costs[2] dollars.
 * 
 *         The passes allow that many days of consecutive travel. For example,
 *         if we get a 7-day pass on day 2, then we can travel for 7 days: day
 *         2, 3, 4, 5, 6, 7, and 8.
 * 
 *         Return the minimum number of dollars you need to travel every day in
 *         the given list of days.
 * 
 *         Example 1: Input: days = [1,4,6,7,8,20], costs = [2,7,15] Output: 11
 * 
 *         Explanation: For example, here is one way to buy passes that lets you
 *         travel your travel plan: On day 1, you bought a 1-day pass for
 *         costs[0] = $2, which covered day 1. On day 3, you bought a 7-day pass
 *         for costs[1] = $7, which covered days 3, 4, ..., 9. On day 20, you
 *         bought a 1-day pass for costs[0] = $2, which covered day 20. In total
 *         you spent $11 and covered all the days of your travel.
 * 
 */
public class MinimumTicketCost {

	public int mincostTickets(int[] days, int[] costs) {
		boolean[] isTravelDay = new boolean[366];
		for (int day : days) {
			isTravelDay[day] = true;
		}

		int[] dp = new int[366];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;

		for (int i = 1; i < 366; i++) {
			if (!isTravelDay[i]) {
				dp[i] = dp[i - 1];
				continue;
			}

			// for 1 day pass
			dp[i] = Math.min(dp[i], dp[i - 1] + costs[0]);
			// for 7 day pass
			if (i - 7 >= 0) {
				dp[i] = Math.min(dp[i], dp[i - 7] + costs[1]);
			} else {
				// Can also buy the 7 day pass even if i -7 not greater than 0
				dp[i] = Math.min(dp[i], costs[1]);
			}

			if (i - 30 >= 0) {
				dp[i] = Math.min(dp[i], dp[i - 30] + costs[2]);
			} else {
				// Can also buy the 30 day pass even if i -30 not greater than 0
				dp[i] = Math.min(dp[i], costs[2]);
			}

		}
		return dp[365];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] days = {1,4,6,7,8,20}, costs = {2,7,15};
		int result = new MinimumTicketCost().mincostTickets(days, costs);
		System.out.println(result);

	}

}
