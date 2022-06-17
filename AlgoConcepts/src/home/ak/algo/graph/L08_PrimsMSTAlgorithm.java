/**
 * 
 */
package home.ak.algo.graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @author kundu
 *
 */
public class L08_PrimsMSTAlgorithm {

	static class Node {
		int vertex;
		int weight;

		public Node(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}

		public int getVertex() {
			return vertex;
		}

		public int getWeight() {
			return weight;
		}
	}

	public static void primsAlgo(ArrayList<ArrayList<Node>> adj, int N) {
		int key[] = new int[N];
		int parent[] = new int[N];
		boolean mstSet[] = new boolean[N];
		for (int i = 0; i < N; i++) {
			key[i] = 100000000;
			mstSet[i] = false;
		}

		// Initialize min heap for always returning the edge with minimum weight
		PriorityQueue<Node> pq = new PriorityQueue<Node>((a, b) -> a.weight - b.weight);

		key[0] = 0;
		parent[0] = -1;
		pq.add(new Node(key[0], 0));

		while (!pq.isEmpty()) {
			int currVtx = pq.poll().getVertex();
			mstSet[currVtx] = true;

			// Search the adjacent nodes of current vertex
			for (Node it : adj.get(currVtx)) {
				if (mstSet[it.getVertex()] == false && it.getWeight() < key[it.getVertex()]) {
					parent[it.getVertex()] = currVtx;
					key[it.getVertex()] = it.getWeight();
					pq.add(new Node(it.getVertex(), key[it.getVertex()]));
				}
			}
		}

		for (int i = 1; i < N; i++) {
			System.out.println(parent[i] + " - " + i);
		}
	}

	public static void main(String[] args) {
		int N = 5;
		ArrayList<ArrayList<Node>> adj = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			adj.add(new ArrayList<Node>());
		}

		adj.get(0).add(new Node(1, 2));
		adj.get(1).add(new Node(0, 2));

		adj.get(1).add(new Node(2, 3));
		adj.get(2).add(new Node(1, 3));

		adj.get(0).add(new Node(3, 6));
		adj.get(3).add(new Node(0, 6));

		adj.get(1).add(new Node(3, 8));
		adj.get(3).add(new Node(1, 8));

		adj.get(1).add(new Node(4, 5));
		adj.get(4).add(new Node(1, 5));

		adj.get(2).add(new Node(4, 7));
		adj.get(4).add(new Node(2, 7));

		primsAlgo(adj, N);
	}

}
