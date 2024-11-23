/**
 * 
 */
package home.ak.algo.heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author kundu
 * 
 *         Given an unsorted array of numbers, find the top ‘K’ frequently
 *         occurring numbers in it.
 * 
 *         Example 1: Input: [1, 3, 5, 12, 11, 12, 11], K = 2 Output: [12, 11]
 *         Explanation: Both '11' and '12' appeared twice.
 * 
 *         Example 2:Input: [5, 12, 11, 3, 11], K = 2 Output: [11, 5] or [11,
 *         12] or [11, 3] Explanation: Only '11' appeared twice, all other
 *         numbers appeared once.
 *
 */
public class L5_TopKFrequentNumbers {

	public static List<Integer> findTopKFrequentNumbers(int[] nums, int k) {
		List<Integer> topNumbers = new ArrayList<>(k);

		//Build the frequency map
		Map<Integer, Integer> freqMap = new HashMap<>();
		for (int i : nums) {
			freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);
		}

		PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
				(e1, e2) -> e1.getValue() - e2.getValue());

		for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
			minHeap.offer(entry);
			if (minHeap.size() > k) {
				minHeap.poll();
			}
		}

		// Add to the list
		while (!minHeap.isEmpty()) {
			topNumbers.add(minHeap.poll().getKey());
		}

		return topNumbers;
	}

	public static void main(String[] args) {
		List<Integer> result = L5_TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 1, 3, 5, 12, 11, 12, 11 }, 2);
		System.out.println("Here are the K frequent numbers: " + result);

		result = L5_TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 5, 12, 11, 3, 11 }, 2);
		System.out.println("Here are the K frequent numbers: " + result);
	}

}
