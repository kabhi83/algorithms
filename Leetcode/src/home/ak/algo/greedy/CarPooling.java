/**
 * 
 */
package home.ak.algo.greedy;

import java.util.Arrays;

/**
 * @author kundu
 * 
 *         You are driving a vehicle that has capacity empty seats initially
 *         available for passengers. The vehicle only drives east (ie. it cannot
 *         turn around and drive west.)
 * 
 *         Given a list of trips, trip[i] = [num_passengers, start_location,
 *         end_location] contains information about the i-th trip: the number of
 *         passengers that must be picked up, and the locations to pick them up
 *         and drop them off. The locations are given as the number of
 *         kilometers due east from your vehicle's initial location.
 * 
 *         Return true if and only if it is possible to pick up and drop off all
 *         passengers for all the given trips.
 * 
 *         Constraints:
 * 
 *         1. trips.length <= 1000
 * 
 *         2. trips[i].length == 3
 * 
 *         3. 1 <= trips[i][0] <= 100
 * 
 *         4. 0 <= trips[i][1] < trips[i][2] <= 1000
 * 
 *         5. 1 <= capacity <= 100000
 *
 */
public class CarPooling {

	public static boolean carPooling(int[][] trips, int capacity) {
		// Create the trip time array - max trip travel time is 1000
		int[] travelTime = new int[1000 + 1];

		for (int[] trip : trips) {
			travelTime[trip[1]] += trip[0]; // Passengers get in
			travelTime[trip[2]] -= trip[0]; // Passengers get out
		}

		for (int passenger : travelTime) {
			capacity -= passenger; // Check for available capacity throughout the trip
			if (capacity < 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// int[][] trips = { { 2, 1, 5 }, { 3, 3, 7 } };
		// int capacity = 4;
		int[][] trips = { { 3, 2, 7 }, { 3, 7, 9 }, { 8, 3, 9 } };
		int capacity = 11;
		System.out.println(carPooling(trips, capacity));
	}

}
