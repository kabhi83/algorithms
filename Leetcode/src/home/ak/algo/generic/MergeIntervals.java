/**
 * 
 */
package home.ak.algo.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kundu
 * 
 *         Given a collection of intervals, merge all overlapping intervals.
 * 
 *         Example 1: Input: intervals = [[1,3],[2,6],[8,10],[15,18]] Output:
 *         [[1,6],[8,10],[15,18]] Explanation: Since intervals [1,3] and [2,6]
 *         overlaps, merge them into [1,6].
 * 
 *         Example 2: Input: intervals = [[1,4],[4,5]] Output: [[1,5]]
 *         Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 */
public class MergeIntervals {

	public int[][] merge(int[][] intervals) {

		// Sort the intervals by starting time
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

		List<int[]> list = new ArrayList<>();
		int[] interval = intervals[0];
		// interval[0] -> start, interval[1] ->end
		int i = 1;
		while (i < intervals.length) {
			// Start of the current is greater than the end of previous
			if (intervals[i][0] > interval[1]) {
				list.add(interval);
				interval = intervals[i];
			} else {
				// merge the interval and update the end time
				interval[1] = Math.max(interval[1], intervals[i][1]);
			}
			i++;
		}
		list.add(interval);

		return list.toArray(new int[list.size()][]);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
		int[][] intervals = { { 1, 4 }, { 4, 5 } };
		int[][] mergedInterval = new MergeIntervals().merge(intervals);
		System.out.println(Arrays.deepToString(mergedInterval));
	}

}
