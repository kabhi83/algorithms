package home.ak.algo.intervals;

import java.util.Arrays;

/**
 * @author kundu
 * 
 *         Given an array of intervals representing ‘N’ appointments, find out
 *         if a person can attend all the appointments.
 * 
 *         Example: Appointments: [[1,4], [2,5], [7,9]] Output: false
 * 
 *         Explanation: Since [1,4] and [2,5] overlap, a person cannot attend
 *         both of these appointments.
 *
 */
public class L04_ConflictingAppointments {

	static class Interval {
		int start, end;

		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static boolean canAttendAllAppointments(Interval[] intervals) {

		// Sort the intervals by the start time
		Arrays.sort(intervals, (a, b) -> a.start - b.start);

		for (int i = 0; i < intervals.length - 1; i++) {
			if (intervals[i].end > intervals[i + 1].start) {
				return false;
			}
		}
		return true;
	}

	/*
	 * Time complexity # The time complexity of the above algorithm is O(N*logN),
	 * where ‘N’ is the total number of appointments. Though we are iterating the
	 * intervals only once, our algorithm will take O(N * logN) since we need to
	 * sort them in the beginning.
	 * 
	 * Space complexity # The space complexity of the above algorithm will be O(N),
	 * which we need for sorting. For Java, Arrays.sort() uses Timsort, which needs
	 * O(N) space.
	 */

	public static void main(String[] args) {
		Interval[] intervals = { new Interval(1, 4), new Interval(2, 5), new Interval(7, 9) };
		boolean result = L04_ConflictingAppointments.canAttendAllAppointments(intervals);
		System.out.println("Can attend all appointments: " + result);

		Interval[] intervals1 = { new Interval(6, 7), new Interval(2, 4), new Interval(8, 12) };
		result = L04_ConflictingAppointments.canAttendAllAppointments(intervals1);
		System.out.println("Can attend all appointments: " + result);

		Interval[] intervals2 = { new Interval(4, 5), new Interval(2, 3), new Interval(3, 6) };
		result = L04_ConflictingAppointments.canAttendAllAppointments(intervals2);
		System.out.println("Can attend all appointments: " + result);
	}

}
