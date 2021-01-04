/**
 * 
 */
package home.ak.algo.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author kundu
 * 
 * 
 *         The activity selection problem is a combinatorial optimization
 *         problem concerning the selection of non-conflicting activities to
 *         perform within a given time frame, given a set of activities each
 *         marked by a start time (si) and finish time (fi). The problem is to
 *         select the maximum number of activities that can be performed by a
 *         single person or machine, assuming that a person can only work on a
 *         single activity at a time. The activity selection problem is also
 *         known as the Interval scheduling maximization problem (ISMP), which
 *         is a special type of the more general Interval Scheduling problem.
 *
 */
public class ActivitySelectionProblem {

	static class Activity {
		int start;
		int finish;
		int index;

		public Activity(int start, int finish, int index) {
			this.start = start;
			this.finish = finish;
			this.index = index;
		}
	}

	public static List<Integer> selectActivity(int[] start, int[] end) {
		// int maxEndTime = Arrays.stream(end).max().getAsInt();
		int n = start.length;
		List<Activity> activityList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			activityList.add(new Activity(start[i], end[i], i));
		}

		// Sort the list in the ascending order of the finish time
		Collections.sort(activityList, (a, b) -> (a.finish - b.finish));

		// Perform the selection
		List<Integer> result = new ArrayList<>();
		// add the first element
		result.add(activityList.get(0).index);
		Activity prev = activityList.get(0);
		for (int i = 1; i < n; i++) {
			Activity current = activityList.get(i);
			if (prev.finish < current.start) {
				// Include the activity
				result.add(current.index);
				prev = current;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		// Activitiy arr[] = {{5, 9}, {1, 2}, {3, 4}, {0, 6}, {5, 7}, {8, 9}}; 
		int[] start = {5, 1, 3, 0, 5, 8};
		int[] end = {9, 2, 4, 6, 7, 9};
		System.out.println(selectActivity(start, end));
	}
}
