/**
 * 
 */
package home.ak.algo;

/**
 * @author user
 *
 */
public class IslandCount {

	private static enum Direction {
		NW(-1, -1), N(-1, 0), NE(-1, 1), E(0, 1), SE(1, 1), S(1, 0), SW(1, -1), W(0, -1);

		int rowDelta;
		int colDelta;

		Direction(int rowDelta, int colDelta) {
			this.rowDelta = rowDelta;
			this.colDelta = colDelta;
		}

		public int getRowDelta() {
			return rowDelta;
		}

		public int getColDelta() {
			return colDelta;
		}
	}

	
	private static void dfs(int row, int col, int[][] m, boolean[][] visited) {
	    // check recursion state... and expect it to have failures.
	    if (row < 0 || row >= m.length || col < 0 || col >= m[0].length) {
	        // invalid state, index-out-of-bounds
	        return;
	    }
	    // OK, row/column are valid... more checks
	    if (visited[row][col]) {
	        // already seen this valid position.
	        return;
	    }
	    // mark the position seen
	    visited[row][col] = true;
	    // if it's not an island....
	    if (0 == m[row][col]) {
	       return;
	    }
	    // OK, we are still on the island, let's optimistically search around....
	    for (Direction direction : Direction.values()) {
	        dfs(row + direction.getRowDelta(), col + direction.getColDelta(), m, visited);
	    }
	}

	/**
	 * Returns the number of 1 islands.
	 * 
	 * @param matrix
	 *            the input matrix
	 * @return the number of 1 islands.
	 */
	public static int count(int[][] matrix) {
		final boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		int count = 0;

		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[0].length; col++) {
				if (matrix[row][col] == 1 && !visited[row][col]) {
					dfs(row, col, matrix, visited);
					count++;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 1, 0, 0 }, { 0, 0, 0, 1 }, { 0, 0, 1, 1 } };

		System.out.println("Expected 2, Actual " + count(matrix));

		int[][] matrix1 = { { 1, 1, 0, 0 }, { 0, 0, 1, 1 }, { 0, 0, 1, 1 } };

		System.out.println("Expected 1, Actual " + count(matrix1));

	}
}
