/**
 * 
 */
package home.ak.algo.greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author kundu
 * 
 *         Huffman Coding is a technique of compressing data to reduce its size
 *         without losing any of the details. It was first developed by David
 *         Huffman.
 * 
 *         Huffman Coding is generally useful to compress the data in which
 *         there are frequently occurring characters.
 * 
 *         Similar Problems: Optimal Merge Pattern
 *
 */
public class HuffmanCodingProblem {

	static class HuffmanNode {
		char data;
		int frequency;
		HuffmanNode left;
		HuffmanNode right;

		public HuffmanNode(char data, int frequency) {
			this.data = data;
			this.frequency = frequency;
		}
	}

	public static HuffmanNode huffmanTree(String S) {
		// Determine the character frequency
		Map<Character, Integer> freqMap = new HashMap<>();

		for (char c : S.toCharArray()) {
			freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
		}

		// Create min heap to the track the character occurences by frequencies
		PriorityQueue<HuffmanNode> minHeap = new PriorityQueue<>((a, b) -> a.frequency - b.frequency);
		for (Map.Entry<Character, Integer> map : freqMap.entrySet()) {
			minHeap.offer(new HuffmanNode(map.getKey(), map.getValue()));
		}

		HuffmanNode root = null;
		while (minHeap.size() != 1) {
			HuffmanNode node1 = minHeap.poll();
			HuffmanNode node2 = minHeap.poll();
			root = new HuffmanNode('c', node1.frequency + node2.frequency);
			root.left = node1;
			root.right = node2;
			minHeap.offer(root);
		}
		return minHeap.poll();
	}

	public static void printCode(HuffmanNode root, String s) {
		if (root.left == null && root.right == null && Character.isLetter(root.data)) {
			System.out.println(root.data + "   |  " + s);
			return;
		}
		printCode(root.left, s + "0");
		printCode(root.right, s + "1");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String S = "BCCDACCBDABCCDEAEDDA";
		HuffmanNode root = huffmanTree(S);
		printCode(root, "");

	}

}
