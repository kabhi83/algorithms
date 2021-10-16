/**
 * 
 */
package home.ak.algo.intervals;

import java.util.PriorityQueue;

/**
 * @author kundu
 * 
 *         Given the arrival and departure times of all trains that reach a
 *         railway station, the task is to find the minimum number of platforms
 *         required for the railway station so that no train waits. We are given
 *         two arrays that represent the arrival and departure times of trains
 *         that stop.
 *
 */
public class MinimumNumberOfPlatforms {
	static class TrainStatus {
		int time;
		String state;

		public TrainStatus(int time, String state) {
			this.time = time;
			this.state = state;
		}
	}

	public static int findPlatform(int arr[], int dep[]) {
		if (arr.length == 0 || dep.length == 0 || arr.length != dep.length) {
			return -1;
		}
		PriorityQueue<TrainStatus> pq = new PriorityQueue<>((a, b) -> a.time - b.time);
		for (int i = 0; i < arr.length; i++) {
			pq.add(new TrainStatus(arr[i], "arr"));
			pq.add(new TrainStatus(dep[i], "dep"));
		}

		int platformCount = 0;
		int max = 0;
		while (!pq.isEmpty()) {
			if (pq.remove().state.equalsIgnoreCase("arr")) {
				platformCount++;
				max = max > platformCount ? max : platformCount;
			} else {
				platformCount--;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
		int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };
		System.out.println("Minimum Number of Platforms Required = " + findPlatform(arr, dep));
	}

}
