/**
 * 
 */
package home.ak.algo.intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author kundu
 * 
 *         Given a list of intervals, merge all the overlapping intervals to
 *         produce a list that has only mutually exclusive intervals.
 * 
 *         Example 1: Intervals: [[1,4], [2,5], [7,9]] Output: [[1,5], [7,9]]
 *         Explanation: Since the first two intervals [1,4] and [2,5] overlap,
 *         we merged them into one [1,5].
 *
 */
public class L01_MergeIntervals {

	static class Interval {
		int start, end;

		Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static List<Interval> merge(List<Interval> intervals) {
		if (intervals.size() < 2) {
			return intervals;
		}

		List<Interval> mergedIntervals = new LinkedList<Interval>();

		// Sort the intervals by start time
		// Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
		Collections.sort(intervals, (a, b) -> a.start - b.start);
		Interval interval = intervals.get(0);
		int i = 1;
		while (i < intervals.size()) {
			// If current interval starts after the previous
			Interval current = intervals.get(i);
			if (current.start > interval.end) {
				// Add the previous interval
				mergedIntervals.add(interval);
				interval = current;
			} else {
				interval.end = Math.max(interval.end, current.end);
			}
			i++;
		}
		mergedIntervals.add(interval);

		return mergedIntervals;
	}

	public static void main(String[] args) {
		List<Interval> input = new ArrayList<Interval>();
		input.add(new Interval(1, 4));
		input.add(new Interval(2, 5));
		input.add(new Interval(7, 9));
		System.out.print("Merged intervals: ");
		for (Interval interval : L01_MergeIntervals.merge(input))
			System.out.print("[" + interval.start + "," + interval.end + "] ");
		System.out.println();

		input = new ArrayList<Interval>();
		input.add(new Interval(6, 7));
		input.add(new Interval(2, 4));
		input.add(new Interval(5, 9));
		System.out.print("Merged intervals: ");
		for (Interval interval : L01_MergeIntervals.merge(input))
			System.out.print("[" + interval.start + "," + interval.end + "] ");
		System.out.println();

		input = new ArrayList<Interval>();
		input.add(new Interval(1, 4));
		input.add(new Interval(2, 6));
		input.add(new Interval(3, 5));
		System.out.print("Merged intervals: ");
		for (Interval interval : L01_MergeIntervals.merge(input))
			System.out.print("[" + interval.start + "," + interval.end + "] ");
		System.out.println();
	}

}
