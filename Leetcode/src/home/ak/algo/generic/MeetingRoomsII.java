/**
 * 
 */
package home.ak.algo.generic;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author kundu
 * 
 *         Given an array of meeting time intervals consisting of start and end
 *         times [[s1,e1],[s2,e2],...] find the minimum number of conference
 *         rooms required.
 *
 */
public class MeetingRoomsII {

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

	public int minMeetingRooms(Interval[] intervals) {

		// Sort the intervals by the start time
		Arrays.sort(intervals, (a, b) -> (a.start - b.start));

		// Create a min heap sorted by the meeting end time
		PriorityQueue<Interval> minHeap = new PriorityQueue<>((a, b) -> (a.end - b.end));
		// Add the first interval
		minHeap.add(intervals[0]);

		for (int i = 1; i < intervals.length; i++) {
			Interval earlist = minHeap.remove();
			Interval current = intervals[i];

			if (current.start >= earlist.end) {
				earlist.end = current.end;
			} else {
				minHeap.add(current);
			}
			// Need to add back the earliest in either of the case
			minHeap.add(earlist);
		}

		// Number of entries in the minHeap determines the no. of meeting rooms
		return minHeap.size();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Interval intv1 = new Interval(2, 15);
		Interval intv2 = new Interval(36, 45);
		Interval intv3 = new Interval(9, 29);
		Interval intv4 = new Interval(16, 23);
		Interval intv5 = new Interval(4, 9);

		Interval[] intervals = { intv1, intv2, intv3, intv4, intv5 };

		int result = new MeetingRoomsII().minMeetingRooms(intervals);
		System.out.println(result);
	}

}
