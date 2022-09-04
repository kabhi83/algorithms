/**
 * 
 */
package home.ak.algo.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kundu
 * 
 *         Given a list of non-overlapping intervals sorted by their start time,
 *         insert a given interval at the correct position and merge all
 *         necessary intervals to produce a list that has only mutually
 *         exclusive intervals.
 * 
 *         Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,6] Output:
 *         [[1,3], [4,7], [8,12]] Explanation: After insertion, since [4,6]
 *         overlaps with [5,7], we merged them into one [4,7].
 *
 */
public class L02_InsertInterval {

	static class Interval {
		int start, end;

		Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		if (null == intervals || intervals.size() == 0) {
			Arrays.asList(newInterval);
		}

		List<Interval> mergedIntervals = new ArrayList<>();
		// Insert all the intervals whose end time is less than the start of the
		// newInterval
		int i = 0;
		while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
			mergedIntervals.add(intervals.get(i++));
		}

		// Place and merge (if necessary)
		Interval interval = newInterval;
		while (i < intervals.size()) {
			Interval current = intervals.get(i);
			if (current.start > interval.end) {
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
		input.add(new Interval(1, 3));
		input.add(new Interval(5, 7));
		input.add(new Interval(8, 12));
		System.out.print("Intervals after inserting the new interval: ");
		for (Interval interval : L02_InsertInterval.insert(input, new Interval(4, 6)))
			System.out.print("[" + interval.start + "," + interval.end + "] ");
		System.out.println();

		input = new ArrayList<Interval>();
		input.add(new Interval(1, 3));
		input.add(new Interval(5, 7));
		input.add(new Interval(8, 12));
		System.out.print("Intervals after inserting the new interval: ");
		for (Interval interval : L02_InsertInterval.insert(input, new Interval(4, 10)))
			System.out.print("[" + interval.start + "," + interval.end + "] ");
		System.out.println();

		input = new ArrayList<Interval>();
		input.add(new Interval(2, 3));
		input.add(new Interval(5, 7));
		System.out.print("Intervals after inserting the new interval: ");
		for (Interval interval : L02_InsertInterval.insert(input, new Interval(1, 4)))
			System.out.print("[" + interval.start + "," + interval.end + "] ");
		System.out.println();
	}

	/*
	 * Time complexity # As we are iterating through all the intervals only once,
	 * the time complexity of the above algorithm is O(N), where ‘N’ is the total
	 * number of intervals.
	 * 
	 * Space complexity # The space complexity of the above algorithm will be O(N)
	 * as we need to return a list containing all the merged intervals.
	 */
}
