/**
 * 
 */
package home.ak.algo.graph;

/**
 * @author kundu
 * 
 *         N couples sit in 2N seats arranged in a row and want to hold hands.
 *         We want to know the minimum number of swaps so that every couple is
 *         sitting side by side. A swap consists of choosing any two people,
 *         then they stand up and switch seats.
 * 
 *         The people and seats are represented by an integer from 0 to 2N-1,
 *         the couples are numbered in order, the first couple being (0, 1), the
 *         second couple being (2, 3), and so on with the last couple being
 *         (2N-2, 2N-1).
 * 
 *         The couples' initial seating is given by row[i] being the value of
 *         the person who is initially sitting in the i-th seat.
 * 
 *         Example 1: Input: row = [0, 2, 1, 3] Output: 1 Explanation: We only
 *         need to swap the second (row[1]) and third (row[2]) person.
 * 
 *         Example 2: Input: row = [3, 2, 0, 1] Output: 0 Explanation: All
 *         couples are already seated side by side.
 *
 */
public class CoupleHoldingHands {

	static class DisjointSet {
		int count;
		int[] size;
		int[] root;

		public DisjointSet(int n) {
			count = n;
			size = new int[n];
			root = new int[n];
			// Make each element as root to itself
			for (int i = 0; i < n; i++) {
				root[i] = i;
			}
		}

		public int find(int x) {
			if (root[x] != x) {
				root[x] = find(root[x]);
			}
			return root[x];
		}

		/**
		 * Union by rank
		 */
		public void union(int x, int y) {
			int rootX = find(root[x]);
			int rootY = find(root[y]);

			if (rootX == rootY)
				return;

			// Check by ranks
			if (size[rootX] < size[rootY]) {
				root[rootX] = rootY;
				size[rootY] += size[rootX];
			} else {
				root[rootY] = rootX;
				size[rootX] += size[rootY];
			}
			//Decrement the connected components
			count--;
		}
	}

	/**
	 * The goal is to get N/2 connected components. For 3 couples or 6 people we
	 * should have 3 connected components [0,0,1,1,2,2]
	 */
	public int minSwapsCouples(int[] row) {
		// No. of couples
		int N = row.length / 2;
		DisjointSet ds = new DisjointSet(N);

		// For each pair, if they are in two groups, we union the two groups together.
		// Every time we do a union, we have one less connected components.
		// The maximum number of connected components we can have is the number of
		// couples, which is row.size() / 2.
		for (int i = 0; i < N; i++) {
			int x = row[i * 2]; // first member
			int y = row[i * 2 + 1]; // second member
			// x/2 gives the group of x and y/2 gives the group of y
			if (x / 2 != y / 2) //x and y belongs to different groups
				ds.union(x / 2, y / 2);
		}

		return N - ds.count;
	}

	public static void main(String[] args) {
		int[] row1 = { 0, 2, 1, 3 };
		System.out.println(new CoupleHoldingHands().minSwapsCouples(row1));
		
		int[] row2 = {2, 1, 5, 0, 3, 4};
		System.out.println(new CoupleHoldingHands().minSwapsCouples(row2));
	}

}
