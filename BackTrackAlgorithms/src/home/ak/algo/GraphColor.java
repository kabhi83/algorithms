/**
 * 
 */
package home.ak.algo;

/**
 * @author user
 *
 */
public class GraphColor {

	private enum Color {
		RED(1), GREEN(2), BLUE(3);
		int color;

		private Color(int color) {
			this.color = color;
		}
	}

	private int[][] adjMatrix;
	private int[] colorMatrix;
	private int colors = 3;
	private int vertices;

	/**
	 * @param adjMatrix
	 */
	public GraphColor(int[][] adjMatrix) {
		this.adjMatrix = adjMatrix;
		colorMatrix = new int[adjMatrix.length];
		vertices = adjMatrix.length;
	}

	/**
	 * Color the graph
	 * 
	 * @param k
	 */
	public void graphColor(int k) {
		for (int c = 1; c <= colors; c++) {
			if (isSafe(k, c)) {
				colorMatrix[k] = c;
				if ((k + 1) < vertices) {
					graphColor(k + 1);
				} else {
					// print colorMatrix
				}
			}
		}
	}

	/**
	 * Method to check if the color c is safe for node k
	 * 
	 * @param k
	 * @param c
	 * @return
	 */
	private boolean isSafe(int k, int c) {
		for (int i = 0; i < vertices; i++) {
			if (adjMatrix[k][i] == 1 && c == colorMatrix[i]) {
				return false;
			}
		}
		return true;
	}

}
