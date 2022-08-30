/**
 * 
 */
package home.ak.algo.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kundu
 * 
 *         Mr. X is a professional robber planning to rob houses along a street.
 *         Each house has a certain amount of money hidden. All houses along
 *         this street are arranged in a circle. That means the first house is
 *         the neighbor of the last one. Meanwhile, adjacent houses have a
 *         security system connected, and it will automatically contact the
 *         police if two adjacent houses were broken into on the same night. You
 *         are given an array/list of non-negative integers 'ARR' representing
 *         the amount of money of each house. Your task is to return the maximum
 *         amount of money Mr. X can rob tonight without alerting the police.
 *
 */
public class L06_HouseRobberII {

	/**
	 * First and the last house cannot be considered together as they are adjacent
	 */
	public static long houseRobber(int[] valueInHouse) {
		int noOfHouses = valueInHouse.length;
		if (noOfHouses == 1) {
			return valueInHouse[0];
		}
		List<Integer> listWithoutFirstHouse = new ArrayList<>();
		List<Integer> listWithoutLastHouse = new ArrayList<>();

		// Fill the lists
		for (int i = 0; i < noOfHouses; i++) {

			if (i != 0)
				listWithoutFirstHouse.add(valueInHouse[i]);
			if (i != noOfHouses - 1)
				listWithoutLastHouse.add(valueInHouse[i]);
		}
		return Math.max(rob(listWithoutFirstHouse), rob(listWithoutLastHouse));
	}

	/**
	 * Same as house robber problem
	 */
	public static long rob(List<Integer> valueInHouse) {
		long prev1 = valueInHouse.get(0); // 0th index value
		long prev2 = 0;
		for (int i = 1; i < valueInHouse.size(); i++) {
			long pick = valueInHouse.get(i);
			if (i > 1) {
				pick += prev2;
			}
			long noPick = prev1;
			long curr = Math.max(pick, noPick);
			prev2 = prev1;
			prev1 = curr;
		}
		return prev1;
	}

	public static void main(String[] args) {
		int[] valueInHouses = {1, 3, 2, 1};
		System.out.println(houseRobber(valueInHouses));
	}

}
