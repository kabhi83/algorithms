/**
 * 
 */
package home.ak.algo.binarysearch;

import java.util.Arrays;

/**
 * @author kundu
 * 
 *         Koko loves to eat bananas. There are N piles of bananas, the i-th
 *         pile has piles[i] bananas. The guards have gone and will come back in
 *         H hours.
 * 
 *         Koko can decide her bananas-per-hour eating speed of K. Each hour,
 *         she chooses some pile of bananas, and eats K bananas from that pile.
 *         If the pile has less than K bananas, she eats all of them instead,
 *         and won't eat any more bananas during this hour.
 * 
 *         Koko likes to eat slowly, but still wants to finish eating all the
 *         bananas before the guards come back.
 * 
 *         Return the minimum integer K such that she can eat all the bananas
 *         within H hours.
 *
 *         Example 1: Input: piles = [3,6,7,11], H = 8 Output: 4
 * 
 *         Example 2: Input: piles = [30,11,23,4,20], H = 5 Output: 30
 * 
 */
public class KokoEatingBananas {

	public int minEatingSpeed(int[] piles, int H) {
		int left = 1; // Koko must eat at least 1 banana
		int right = Arrays.stream(piles).max().getAsInt();
		while (left < right) {
			int mid = left + (right - left) / 2;
			int k = timeToEat(piles, mid);
			if (k > H) {
				left = mid + 1; // Increase eating rate
			} else {
				right = mid - 1; // Reduce eating rate
			}
		}
		return left;
	}

	private int timeToEat(int[] piles, int mid) {
		int hours = 0;
		for (int i = 0; i < piles.length; i++) {
			if (piles[i] % mid == 0)
				hours += piles[i] / mid;
			else
				hours += 1 + piles[i] / mid;

		}
		return hours;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] piles1 = { 3, 6, 7, 11 };
		int H = 8;
		System.out.println(new KokoEatingBananas().minEatingSpeed(piles1, H));

		int[] piles2 = { 30, 11, 23, 4, 20 };
		H = 5;
		System.out.println(new KokoEatingBananas().minEatingSpeed(piles2, H));
	}

}
