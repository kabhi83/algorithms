/**
 * 
 */
package home.ak.algo.bs.maximizemin;

import java.util.Arrays;

/**
 * @author kundu
 * 
 *         In universe Earth C-137, Rick discovered a special form of magnetic
 *         force between two balls if they are put in his new invented basket.
 *         Rick has n empty baskets, the ith basket is at position[i], Morty has
 *         m balls and needs to distribute the balls into the baskets such that
 *         the minimum magnetic force between any two balls is maximum.
 * 
 *         Rick stated that magnetic force between two different balls at
 *         positions x and y is |x - y|.
 * 
 *         Given the integer array position and the integer m. Return the
 *         required force.
 *
 */
public class MagneticForceBetweenBalls {

	public static int maxDistance(int[] position, int m) {
		Arrays.sort(position); // Make sure position array is sorted
		int start = position[0];
		int end = position[position.length - 1] - position[0]; // Maximum magnetic force
		int res = 0;
		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (canPlaceBalls(position, m, mid)) {
				// Try to maximize the distance between balls
				start = mid + 1;
				res = mid;
			} else {
				// Minimize the distance between the balls to place them in given buckets
				end = mid - 1;
			}
		}

		return res;
	}

	private static boolean canPlaceBalls(int[] position, int m, int minDistBetweenBalls) {
		// Place the 1st ball in the 1st position - Greedy
		int pos = position[0];
		int balls = 1;
		for (int i = 1; i < position.length; i++) {
			if (position[i] - pos >= minDistBetweenBalls) {
				// Ball can be placed in the position i
				pos = position[i];
				balls++;
			}
			if (balls == m) {
				// All balls placed with the given minimum distance between them
				return true;
			}
		}
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] position = { 1, 2, 3, 4, 7 };
		int m = 3;
		System.out.println(maxDistance(position, m));

		position = new int[] { 5, 4, 3, 2, 1, 1000000000 };
		m = 2;
		System.out.println(maxDistance(position, m));
	}

}
