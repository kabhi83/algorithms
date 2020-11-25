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
 */
public class TopKFrequentNumbers {

	public static List<Integer> findTopKFrequentNumbers(int[] nums, int k) {
		List<Integer> topNumbers = new ArrayList<>(k);

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
		List<Integer> result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 1, 3, 5, 12, 11, 12, 11 }, 2);
		System.out.println("Here are the K frequent numbers: " + result);

		result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 5, 12, 11, 3, 11 }, 2);
		System.out.println("Here are the K frequent numbers: " + result);
	}

}
