/**
 * 
 */
package home.ak.algo.topologicalsort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author kundu
 * 
 *         There are ‘N’ tasks, labeled from ‘0’ to ‘N-1’. Each task can have
 *         some prerequisite tasks which need to be completed before it can be
 *         scheduled. Given the number of tasks and a list of prerequisite
 *         pairs, find out if it is possible to schedule all the tasks.
 * 
 *         Example 1: Input: Tasks=3, Prerequisites=[0, 1], [1, 2] Output: true.
 *         Explanation: To execute task '1', task '0' needs to finish first.
 *         Similarly, task '1' needs to finish before '2' can be scheduled. A
 *         possible scheduling of tasks is: [0, 1, 2]
 * 
 *         Example 2: Input: Tasks=3, Prerequisites=[0, 1], [1, 2], [2, 0]
 *         Output: false. Explanation: The tasks have cyclic dependency,
 *         therefore they cannot be scheduled.
 *
 */
public class TaskScheduling {

	public static boolean isSchedulingPossible(int tasks, int[][] prerequisites) {

		List<Integer> taskExecutionOrder = new ArrayList<>();

		// a. Initialize the graph
		Map<Integer, List<Integer>> adjList = new HashMap<>();
		Map<Integer, Integer> inDegree = new HashMap<>();
		for (int i = 0; i < tasks; i++) {
			adjList.put(i, new ArrayList<Integer>());
			inDegree.put(i, 0);
		}

		// b. Build the graph
		for (int i = 0; i < prerequisites.length; i++) {
			int parentTask = prerequisites[i][0], childTask = prerequisites[i][1];
			adjList.get(parentTask).add(childTask);
			inDegree.put(childTask, inDegree.get(childTask) + 1);
		}

		// c. Identify sources - nodes with 0 in-degree
		Queue<Integer> sources = new LinkedList<>();
		for (Map.Entry<Integer, Integer> map : inDegree.entrySet()) {
			if (map.getValue() == 0) {
				sources.offer(map.getKey());
			}
		}

		// d. Using BFS identify if we can build the dependency graph
		while (!sources.isEmpty()) {
			int task = sources.poll();
			taskExecutionOrder.add(task);
			// Get the node's children to decrement their in-degrees
			List<Integer> childTasks = adjList.get(task);
			for (int child: childTasks) {
				inDegree.put(child, inDegree.get(child) - 1);
				if (inDegree.get(child) == 0) {
					sources.add(child);
				}
			}
		}
		return taskExecutionOrder.size() == tasks;
	}

	public static void main(String[] args) {

		boolean result = TaskScheduling.isSchedulingPossible(3, new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 } });
		System.out.println("Tasks execution possible: " + result);

		result = TaskScheduling.isSchedulingPossible(3,
				new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 2, 0 } });
		System.out.println("Tasks execution possible: " + result);

		result = TaskScheduling.isSchedulingPossible(6, new int[][] { new int[] { 2, 5 }, new int[] { 0, 5 },
				new int[] { 0, 4 }, new int[] { 1, 4 }, new int[] { 3, 2 }, new int[] { 1, 3 } });
		System.out.println("Tasks execution possible: " + result);
	}

}
