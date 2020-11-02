/**
 * 
 */
package home.ak.algo;

/**
 * @author user
 *
 */
public class WordMatrix {

	private int[][] solution;
	private int N;
	private int path = 1;

	/**
	 * @param n
	 */
	public WordMatrix(int n) {
		N = n;
		solution = new int[N][N];
	}

	/**
	 * Method to search the word in the matrix
	 * 
	 * @param matrix
	 * @param word
	 * @return
	 */
	public boolean searchWord(char[][] matrix, String word) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (search(matrix, word, i, j, 0, N)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Search the word recursively
	 * 
	 * @param matrix
	 * @param word
	 * @param row
	 * @param col
	 * @param index
	 * @param N
	 * @return
	 */
	private boolean search(char[][] matrix, String word, int row, int col, int index, int N) {
		// Match the current cell in the matrix and the word index
		if (solution[row][col] != 0 || word.charAt(index) != matrix[row][col]) {
			return false;
		}

		// Check for the word completion
		if (index == word.length() - 1) {
			solution[row][col] = path++;
			return true;
		}

		// Mark the current cell
		solution[row][col] = path++;

		// Now check the other cell - recursively
		// 1- Go down
		if (row + 1 < N && search(matrix, word, row + 1, col, index + 1, N)) {
			return true;
		}

		// 2-Go up
		if (row - 1 >= 0 && search(matrix, word, row - 1, col, index + 1, N)) {
			return true;
		}

		// 3-Go right
		if (col + 1 < N && search(matrix, word, row, col + 1, index + 1, N)) {
			return true;
		}

		// 4-Go left
		if (col - 1 >= 0 && search(matrix, word, row, col - 1, index + 1, N)) {
			return true;
		}

		// 5-Go diagonally up-right
		if (row - 1 >= 0 && col + 1 < N && search(matrix, word, row - 1, col + 1, index + 1, N)) {
			return true;
		}

		// 6-Go diagonally up-left
		if (row - 1 >= 0 && col - 1 >= 0 && search(matrix, word, row - 1, col - 1, index + 1, N)) {
			return true;
		}

		// 7-Go diagonally down-right
		if (row + 1 < N && col + 1 < N && search(matrix, word, row + 1, col + 1, index + 1, N)) {
			return true;
		}

		// 8-Go diagonally down-left
		if (row + 1 < N && col - 1 >= 0 && search(matrix, word, row, col - 1, index + 1, N)) {
			return true;
		}
		// If none, BACKTRACK
		solution[row][col] = 0;
		path--;
		return false;
	}

	/**
	 * Utility function to print an array/maze
	 * 
	 * @param solution
	 * @param N
	 */
	public void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(" " + solution[i][j]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		char[][] matrix = { { 't', 'z', 'x', 'c', 'd' }, 
							{ 'a', 'h', 'n', 'z', 'x' }, 
							{ 'h', 'w', 'o', 'i', 'o' },
							{ 'o', 'r', 'n', 'r', 'n' }, 
							{ 'a', 'b', 'r', 'i', 'n' } };

		WordMatrix wordMatrix = new WordMatrix(matrix.length);
		if (wordMatrix.searchWord(matrix, "horizon")) {
			wordMatrix.print();
		} else {
			System.out.println("NO MATCH FOUND");
		}
	}

}
