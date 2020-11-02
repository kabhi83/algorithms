/**
 * 
 */
package home.ak.algo;

/**
 * @author user
 * 
 *         Hamilton cycle is a round trip path along n edges that visits every
 *         vertex exactly once and returns to its starting position.
 *
 */
public class HamiltonCycle {

	static int V; // total vertices

	public static boolean hamiltomCycle(int[][] adjMatrix) {
		V = adjMatrix.length;
		int[] path = new int[V];
		for (int i = 0; i < V; i++) {
			path[i] = -1;
		}

		// Let 0 be the starting position
		path[0] = 0;
		return false;
	}

	public static boolean hamiltonCycleUtil(int[][] adjMatrix, int[] path, int pos) {
		// Check if all the vertices are covered
		if (pos == V) {
			// Check if a path exist from the last added vertex to start vertex
			if (adjMatrix[path[pos - 1]][path[0]] == 1) {
				return true;
			}
			return false;
		}

		// All vertices are yet to be covered
		for (int v = 1; v < V; v++) {
			// Started from 1 as 0 is already considered in the path
			if (isSafe(adjMatrix, path, pos, v)) {
				path[pos] = v;

				// Recur to construct rest of the path
				if (hamiltonCycleUtil(adjMatrix, path, pos + 1)) {
					return true;
				}

				// If it does not lead to any solution
				path[pos] = -1;
			}
		}
		return false;
	}

	/**
	 * @param adjMatrix
	 * @param path
	 * @param pos
	 * @param v
	 * @return
	 */
	private static boolean isSafe(int[][] adjMatrix, int[] path, int pos, int v) {
		// Check if v is adjacent to previously added vertex
		if (adjMatrix[path[pos - 1]][v] == 0) {
			return false;
		}

		// Check if the v is already added in the path
		for (int i = 0; i < pos; i++) {
			if (path[i] == v) {
				return false;
			}
		}
		return true;
	}
}
