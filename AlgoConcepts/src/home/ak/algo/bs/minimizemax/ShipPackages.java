/**
 * 
 */
package home.ak.algo.bs.minimizemax;

import java.util.Arrays;

/**
 * @author kundu
 * 
 *         A conveyor belt has packages that must be shipped from one port to
 *         another within "days" days.
 * 
 *         The ith package on the conveyor belt has a weight of weights[i]. Each
 *         day, we load the ship with packages on the conveyor belt (in the
 *         order given by weights). We may not load more weight than the maximum
 *         weight capacity of the ship.
 * 
 *         Return the least weight capacity of the ship that will result in all
 *         the packages on the conveyor belt being shipped within "days" days.
 *
 *         Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5 Output: 15
 *         Explanation: A ship capacity of 15 is the minimum to ship all the
 *         packages in 5 days like this: 1st day: 1, 2, 3, 4, 5; 2nd day: 6, 7;
 *         3rd day: 8; 4th day: 9; 5th day: 10
 * 
 * 
 */
public class ShipPackages {

	public static int shipWithinDays(int[] weights, int days) {
		int start = weights[0]; // Minimum weight
		int end = Arrays.stream(weights).sum(); // Maximum possible weight to ship
		int res = 0;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			// Check if with the max weight of mid, can we ship in given days
			if (canShip(weights, days, mid)) {
				// Minimize the ship weight to carry items in given days
				end = mid - 1;
				res = mid;
			} else {
				// Need to increase the weight of the ship to ship the items in the given days
				start = mid + 1;
			}
		}
		return res;
	}

	private static boolean canShip(int[] weights, int days, int minShipWeight) {
		int requiredDays = 1;
		int shippedWt = 0;
		for (int i = 0; i < weights.length; i++) {
			shippedWt += weights[i];
			if (shippedWt > minShipWeight) {
				requiredDays++;
				shippedWt = weights[i];
			}
			// Check for the days
			if (requiredDays > days) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] weights = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int days = 5;
		System.out.println(shipWithinDays(weights, days));
	}

}
