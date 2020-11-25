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
 */
public class ConnectRopes {

	public static int minimumCostToConnectRopes(int[] ropeLengths) {

		if (null != ropeLengths && ropeLengths.length < 2) {
			return ropeLengths[0];
		}
		// Create min heap
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
		int result = ConnectRopes.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5 });
		System.out.println("Minimum cost to connect ropes: " + result);
		result = ConnectRopes.minimumCostToConnectRopes(new int[] { 3, 4, 5, 6 });
		System.out.println("Minimum cost to connect ropes: " + result);
		result = ConnectRopes.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5, 2 });
		System.out.println("Minimum cost to connect ropes: " + result);
	}

}
