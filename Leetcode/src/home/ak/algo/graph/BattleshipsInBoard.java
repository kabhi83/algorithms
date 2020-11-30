/**
 * 
 */
package home.ak.algo.graph;

/**
 * @author kundu
 * 
 *         Given an 2D board, count how many battleships are in it. The
 *         battleships are represented with 'X's, empty slots are represented
 *         with '.'s.
 * 
 *         You may assume the following rules: You receive a valid board, made
 *         of only battleships or empty slots. Battleships can only be placed
 *         horizontally or vertically. In other words, they can only be made of
 *         the shape 1xN (1 row, N columns) or Nx1 (N rows, 1 column), where N
 *         can be of any size.
 * 
 *         At least one horizontal or vertical cell separates between two
 *         battleships - there are no adjacent battleships.
 * 
 *         Could you do it in one-pass, using only O(1) extra memory and without
 *         modifying the value of the board?
 *
 */
public class BattleshipsInBoard {

	/**
	 * Sink the battleship whenever we encounter one. This approach modifies the
	 * board and is and N*M solution.
	 */
	public int countBattleships(char[][] board) {
		int numBattleShips = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 'X') {
					numBattleShips++;
					// Sink the battleship whenever we see an 'X'
					sink(board, i, j);
				}
			}
		}
		return numBattleShips;
	}

	private void sink(char[][] board, int i, int j) {
		// Boundary checks
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'X') {
			return;
		}
		// Mark as sink in the board
		board[i][j] = '.';
		// Sink the neighbors
		sink(board, i - 1, j);
		sink(board, i + 1, j);
		sink(board, i, j - 1);
		sink(board, i, j + 1);
	}
	
	public int countBattleshipsOptimized(char[][] board) {
		int numBattleships = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				// Not a ship
				if (board[i][j] == '.') {
					continue;
				}
				// Still in the same ship - vertically aligned
				if (i > 0 && board[i - 1][j] == 'X') {
					continue;
				}
				// Still in the same ship - horizontally aligned
				if (j > 0 && board[i][j - 1] == 'X') {
					continue;
				}

				// found a new ship
				numBattleships++;
			}
		}
		return numBattleships;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		char[][] board = { 	{ 'X', '.', '.', 'X' }, 
							{ '.', '.', '.', 'X' }, 
							{ '.', '.', '.', 'X' },
							{ '.', '.', '.', 'X' } };

		BattleshipsInBoard battleshipsInBoard = new BattleshipsInBoard();
		//int result1 = battleshipsInBoard.countBattleships(board);
		//System.out.println(result1);
		int result2 = battleshipsInBoard.countBattleshipsOptimized(board);
		System.out.println(result2);
		
		char[][] board1 = { { '.', '.', '.', 'X' }, 
							{ 'X', 'X', 'X', 'X' }, 
							{ '.', '.', '.', 'X' },
							{ '.', '.', '.', 'X' } };
		
		//result1 = battleshipsInBoard.countBattleships(board1);
		//System.out.println(result1);
		result2 = battleshipsInBoard.countBattleshipsOptimized(board1);
		System.out.println(result2);
	}

}
