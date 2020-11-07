/**
 * 
 */
package home.ak.algo.generic;

import java.util.Arrays;

/**
 * @author kundu
 * 
 *         Given an array of meeting time intervals consisting of start and end
 *         times [[s1, e1], [s2, e2], ...] (si < ei), determine if a person
 *         could attend all meetings.
 * 
 *         For example, Given [ [0, 30], [5, 10], [15, 20] ], return false.
 *
 */
public class MeetingRooms {

	static class Interval {
		int start, end;

		Interval() {
			start = 0;
			end = 0;
		}

		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public boolean canAttendMeetings(Interval[] intervals) {
		// Sort the intervals by the starting time
		Arrays.sort(intervals, (a, b) -> a.start - b.start);

		// If current interval's end is greater than the start of the next
		for (int i = 0; i < intervals.length - 1; i++) {
			if (intervals[i].end > intervals[i + 1].start) {
				return false;
			}
		}

		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Interval intv1 = new Interval(0, 30);
		Interval intv2 = new Interval(5, 10);
		Interval intv3 = new Interval(15, 20);

		Interval[] intervals = { intv1, intv2, intv3 };

		boolean result = new MeetingRooms().canAttendMeetings(intervals);
		System.out.println(result);
	}

}
