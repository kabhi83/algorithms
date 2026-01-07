/**
 * 
 */
package home.ak.algo.heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * @author kundu
 * 
 *         Given ‘N’ ropes with different lengths, we need to connect these
 *         ropes into one big rope with minimum cost. The cost of connecting two
 *         ropes is equal to the sum of their lengths.
 * 
 *         Example 1: Input: [1, 3, 11, 5] Output: 33 Explanation: First connect
 *         1+3(=4), then 4+5(=9), and then 9+11(=20). So the total cost is 33
 *         (4+9+20)
 * 
 *         Example 2: Input: [3, 4, 5, 6] Output: 36 Explanation: First connect
 *         3+4(=7), then 5+6(=11), 7+11(=18). Total cost is 36 (7+11+18)
 *
 */
public class L7_ConnectRopes {

	public static int minimumCostToConnectRopes(int[] ropeLengths) {

		if (null != ropeLengths && ropeLengths.length < 2) {
			return ropeLengths[0];
		}
		// Create min heap from the items of the array
		PriorityQueue<Integer> minHeap = new PriorityQueue<>(
				Arrays.stream(ropeLengths).boxed().collect(Collectors.toList()));

		int minCost = 0;

		while (minHeap.size() >= 2) {
			int rope1 = minHeap.poll();
			int rope2 = minHeap.poll();
			int connectCost = rope1 + rope2;
			minCost += connectCost;
			minHeap.add(connectCost);
		}

		return minCost;
	}

	public static void main(String[] args) {
		int result = L7_ConnectRopes.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5 });
		System.out.println("Minimum cost to connect ropes: " + result);
		result = L7_ConnectRopes.minimumCostToConnectRopes(new int[] { 3, 4, 5, 6 });
		System.out.println("Minimum cost to connect ropes: " + result);
		result = L7_ConnectRopes.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5, 2 });
		System.out.println("Minimum cost to connect ropes: " + result);
	}

}
