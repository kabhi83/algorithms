/**
 * 
 */
package home.ak.algo.topologicalsort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kundu
 * 
 *         Topological Sort of a directed graph (a graph with unidirectional
 *         edges) is a linear ordering of its vertices such that for every
 *         directed edge (U, V) from vertex U to vertex V, U comes before V in
 *         the ordering.
 * 
 *         Given a directed graph, find the topological ordering of its
 *         vertices.
 * 
 *         Example: Input: Vertices=4, Edges=[3, 2], [3, 0], [2, 0], [2, 1]
 *         Output: Following are the two valid topological sorts for the given
 *         graph:
 * 
 *         1) 3, 2, 0, 1
 * 
 *         2) 3, 2, 1, 0
 */
public class TopologicalSort {

	public static List<Integer> sort(int vertices, int[][] edges) {
		List<Integer> sortedOrder = new ArrayList<>();
		// TODO: Write your code here
		return sortedOrder;
	}

	public static void main(String[] args) {
		List<Integer> result = TopologicalSort.sort(4,
				new int[][] { new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } });
		System.out.println(result);

		result = TopologicalSort.sort(5, new int[][] { new int[] { 4, 2 }, new int[] { 4, 3 }, new int[] { 2, 0 },
				new int[] { 2, 1 }, new int[] { 3, 1 } });
		System.out.println(result);

		result = TopologicalSort.sort(7, new int[][] { new int[] { 6, 4 }, new int[] { 6, 2 }, new int[] { 5, 3 },
				new int[] { 5, 4 }, new int[] { 3, 0 }, new int[] { 3, 1 }, new int[] { 3, 2 }, new int[] { 4, 1 } });
		System.out.println(result);
	}
}
