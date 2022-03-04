/**
 * 
 */
package home.ak.algo.binarysearch;

import java.util.Arrays;

/**
 * @author kundu
 * 
 *         You are given an array time where time[i] denotes the time taken by
 *         the ith bus to complete one trip.
 * 
 *         Each bus can make multiple trips successively; that is, the next trip
 *         can start immediately after completing the current trip. Also, each
 *         bus operates independently; that is, the trips of one bus do not
 *         influence the trips of any other bus.
 * 
 *         You are also given an integer totalTrips, which denotes the number of
 *         trips all buses should make in total. Return the minimum time
 *         required for all buses to complete at least totalTrips trips.
 * 
 *         Example - Input: time = [1,2,3], totalTrips = 5, Output: 3
 *         Explanation:
 * 
 *         - At time t = 1, the number of trips completed by each bus are
 *         [1,0,0]. The total number of trips completed is 1 + 0 + 0 = 1.
 * 
 *         - At time t = 2, the number of trips completed by each bus are
 *         [2,1,0]. The total number of trips completed is 2 + 1 + 0 = 3.
 * 
 *         - At time t = 3, the number of trips completed by each bus are
 *         [3,1,1]. The total number of trips completed is 3 + 1 + 1 = 5. So the
 *         minimum time needed for all buses to complete at least 5 trips is 3.
 * 
 *         Constraints:
 * 
 *         1 <= time.length <= 10e5; 1 <= time[i], totalTrips <= 10e7
 * 
 *         Solution: Binary search on the answer - monotonic function -> number
 *         of trips increases with time
 *
 */
public class MinimumTimeToCompleteTrips {

	public static long minimumTime(int[] time, int totalTrips) {

		// some intuition - lowest time for all the trips is 0 (if no trips asked).
		// Highest time is the max value in the time array multiplied with total trips
		// asked

		long start = 0;
		long end = (Arrays.stream(time).max().getAsInt()) * totalTrips;
		long ans = end;
		while (start <= end) {
			long mid = (start + end) >> 1;
			if (tripsCompleted(time, mid) < totalTrips) {
				// Less trips - Increase the time
				start = mid + 1;
			} else {
				// More trips - Reduce the time
				ans = mid;
				end = mid - 1;
			}
		}
		return ans;
	}

	private static long tripsCompleted(int[] time, long mid) {
		long trips = 0;
		for (int t : time) {
			trips += mid / t;
		}
		return trips;
	}
	
	public static void main(String[] args) {
		int[] time = {1, 2, 3};
		System.out.println(minimumTime(time, 5));
	}
}
