package home.ak.algo.binarysearch;

/**
 * @author kundu
 * 
 *         On a horizontal number line, we have gas stations at positions
 *         stations[0], stations[1], ..., stations[N-1], where N =
 *         stations.length.
 * 
 *         Now, we add K more gas stations so that D, the maximum distance
 *         between adjacent gas stations, is minimized.
 * 
 *         Return the smallest possible value of D.
 * 
 *         1.stations.length will be an integer in range [10, 2000].
 * 
 *         2.stations[i] will be an integer in range [0, 10^8].
 * 
 *         3.K will be an integer in range [1, 10^6].
 * 
 *         4.Answers within 10^-6 of the true value will be accepted as correct.
 * 
 *         Example 1: Input：stations = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]，K = 9
 *         Output：0.50 Explanation：The distance between adjacent gas stations is
 *         0.50.
 * 
 *         Example 2: Input：stations = [3,6,12,19,33,44,67,72,89,95]，K = 2
 *         Output：14.00 Explanation：construction of gas stations at 86 locations
 *
 */
public class MinimizeMaxDistanceToGasStation {

	public double minmaxGasDist(int[] stations, int K) {
		double left = 0;
		double right = stations[stations.length - 1];
		double delta = 1e-6;

		// We will perform binary search on the width within these boundaries left and
		// right, till we narrow down our search until these boundaries differ less than
		// our desired delta
		while (left + delta < right) {
			double mid = left + (right - left) / 2;
			int count = stationCount(stations, mid);
			if (count > K) {
				// No. of stations added is more than K, hence we have to increase the mid value
				left = mid;
			} else {
				right = mid;
			}
		}
		return left;
	}

	/**
	 * Get the minimum station count at the max distance dist
	 */
	private int stationCount(int[] stations, double dist) {
  		int count = 0;
		for (int i = 1; i < stations.length; i++) {
			count += (int) ((stations[i] - stations[i - 1]) / dist);
		}
		return count;
	}

	public static void main(String[] args) {
		int[] stations = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int K = 9;
		Double dist = new MinimizeMaxDistanceToGasStation().minmaxGasDist(stations, K);
		System.out.println(String.format("%.2f", dist));
	}

}
