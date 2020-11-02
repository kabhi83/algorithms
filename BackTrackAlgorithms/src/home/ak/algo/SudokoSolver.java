/**
 * 
 */
package home.ak.algo;

import java.util.Arrays;

/**
 * @author user
 *
 */
public class SudokoSolver {

	private int[] findUnAssignedLocation(int[][] grid) {
		int[] coordinates = new int[2];
		Arrays.fill(coordinates, -1);
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[0].length; col++) {
				if (grid[row][col] == 0) {
					coordinates[0] = row;
					coordinates[1] = col;
					return coordinates;
				}
			}
		}
		return coordinates;
	}

	/*
	 * Returns a boolean which indicates whether any assigned entry in the
	 * specified row matches the given number.
	 */
	private boolean usedInRow(int[][] grid, int row, int num) {
		for (int col = 0; col < grid[0].length; col++) {
			if (grid[row][col] == num) {
				return true;
			}
		}
		return false;
	}

	/*
	 * Returns a boolean which indicates whether any assigned entry in the
	 * specified column matches the given number.
	 */
	private boolean usedInCol(int[][] grid, int col, int num) {
		for (int row = 0; row < grid.length; row++) {
			if (grid[row][col] == num) {
				return true;
			}
		}
		return false;
	}

	/*
	 * Returns a boolean which indicates whether any assigned entry within the
	 * specified 3x3 box matches the given number.
	 */
	private boolean usedInBox(int[][] grid, int boxRowStart, int boxColStart, int num) {
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				if (grid[row + boxRowStart][col + boxColStart] == num) {
					return true;
				}
			}
		}
		return false;
	}

	/*
	 * Returns a boolean which indicates whether it will be legal to assign num
	 * to the given row,col location.
	 */
	private boolean isSafe(int[][] grid, int row, int col, int num) {
		if (!usedInRow(grid, row, num) && !usedInCol(grid, col, num)
				&& !usedInBox(grid, row - row % 3, col - col % 3, num)) {
			return true;
		}
		return false;
	}

	/*
	 * Takes a partially filled-in grid and attempts to assign values to all
	 * unassigned locations in such a way to meet the requirements for Sudoku
	 * solution (non-duplication across rows, columns, and boxes)
	 */
	public boolean solveSudoko(int[][] grid) {
		int[] coordinates = findUnAssignedLocation(grid);
		int row = coordinates[0];
		int col = coordinates[1];

		if (row == -1 || col == -1) {
			return true;
		}
		for (int num = 1; num <= 9; num++) {
			if (isSafe(grid, row, col, num)) {
				grid[row][col] = num;

				if (solveSudoko(grid)) {
					return true;
				}

				grid[row][col] = 0;
			}
		}
		return false;
	}

	public void printGrid(int[][] grid) {
		System.out.println(Arrays.deepToString(grid));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int grid[][] = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};
		SudokoSolver solver = new SudokoSolver();
		solver.solveSudoko(grid);
		solver.printGrid(grid);

	}

}
