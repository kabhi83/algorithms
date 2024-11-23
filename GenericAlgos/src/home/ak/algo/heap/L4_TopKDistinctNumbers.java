/**
 * 
 */
package home.ak.algo.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * @author kundu
 * 
 *         Given an unsorted array of numbers, find the top ‘K’ distinct
 *         occurring numbers in it.
 * 
 *         Input: [1, 3, 5, 12, 11, 12, 11], K = 2 Output: [12, 11] Explanation:
 *         Both '11' and '12' top K distinct numbers.
 *
 */
public class L4_TopKDistinctNumbers {

	public static List<Integer> findTopKDistinctNumbers(int[] nums, int k) {
		List<Integer> topNumbers = new ArrayList<>(k);
		if (nums == null || nums.length == 0) {
			return topNumbers;
		}

		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
		maxHeap.addAll(Arrays.stream(nums).boxed().collect(Collectors.toList()));

		int i = 0;
		while (i < k) {
			int topElement = maxHeap.poll();
			if (topElement != maxHeap.peek()) {
				topNumbers.add(topElement);
				i++;
			} else {
				continue;
			}
		}

		return topNumbers;
	}

	public static void main(String[] args) {
		List<Integer> result = L4_TopKDistinctNumbers.findTopKDistinctNumbers(new int[] { 1, 3, 5, 12, 11, 12, 11 }, 2);
		System.out.println("Here are the K frequent numbers: " + result);

		result = L4_TopKDistinctNumbers.findTopKDistinctNumbers(new int[] { 5, 12, 11, 3, 11 }, 2);
		System.out.println("Here are the K frequent numbers: " + result);
	}

}
