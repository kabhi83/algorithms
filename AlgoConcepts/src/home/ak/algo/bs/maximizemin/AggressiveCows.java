/**
 * 
 */
package home.ak.algo.bs.maximizemin;

/**
 * @author kundu
 * 
 * 
 *         Farmer John has built a new long barn, with N (2 <= N <= 100,000)
 *         stalls. The stalls are located along a straight line at positions
 *         x1,...,xN (0 <= xi <= 1,000,000,000).
 * 
 *         His C (2 <= C <= N) cows don't like this barn layout and become
 *         aggressive towards each other once put into a stall. To prevent the
 *         cows from hurting each other, FJ wants to assign the cows to the
 *         stalls, such that the minimum distance between any two of them is as
 *         large as possible. What is the largest minimum distance?
 * 
 * 
 *         Overview: All the C cows must be placed in the N stalls such that the
 *         minimum distance between any two of them is as large as possible.
 *         Print the largest distance.
 *
 */
public class AggressiveCows {

	public static int placeCows(int[] stalls, int cows) {
		int start = stalls[0]; // Best placement for 1st cow
		int end = stalls[stalls.length - 1] - stalls[0]; // Maximum possible distance b/w two cows

		int res = 0;
		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (canPlaceCows(stalls, cows, mid)) {
				// Check if the minimum distance between the cows can be maximized more
				start = mid + 1;
				res = mid;
			} else {
				// Need to reduce the minimum distance between cows
				end = mid - 1;
			}
		}

		return res;
	}

	private static boolean canPlaceCows(int[] stalls, int cows, int minDistance) {
		// Place the 1st cow in the 1st location - Greedy
		int loc = stalls[0];
		int noOfcowsPlaced = 1;
		for (int i = 1; i < stalls.length; i++) {
			// The difference in distance between the two stalls should at least be equal or
			// greater than the minimum distance to place the cows
			if (stalls[i] - loc >= minDistance) {
				loc = stalls[i];
				noOfcowsPlaced++;
			}
			// Check if all cows are accommodated
			if (cows == noOfcowsPlaced) {
				// All cows successfully placed considering the provided minimum distance
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] stalls = { 1, 2, 4, 8, 9 };
		int cows = 3;
		System.out.println(placeCows(stalls, cows));
	}
}
