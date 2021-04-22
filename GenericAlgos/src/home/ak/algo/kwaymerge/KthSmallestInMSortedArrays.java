/**
 * 
 */
package home.ak.algo.kwaymerge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author kundu
 * 
 *         Given ‘M’ sorted arrays, find the K’th smallest number among all the
 *         arrays.
 *
 */
public class KthSmallestInMSortedArrays {

	public static int findKthSmallest(List<Integer[]> lists, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
		for (Integer[] intArr : lists) {
			pq.addAll(Arrays.asList(intArr));
		}
		while (k > 1) {
			pq.remove();
			k--;
		}
		return pq.remove();
	}

	public static void main(String[] args) {
		Integer[] l1 = new Integer[] { 2, 6, 8 };
		Integer[] l2 = new Integer[] { 3, 6, 7 };
		Integer[] l3 = new Integer[] { 1, 3, 4 };
		List<Integer[]> lists = new ArrayList<Integer[]>();
		lists.add(l1);
		lists.add(l2);
		lists.add(l3);
		int result = KthSmallestInMSortedArrays.findKthSmallest(lists, 5);
		System.out.print("Kth smallest number is: " + result);
	}

}
