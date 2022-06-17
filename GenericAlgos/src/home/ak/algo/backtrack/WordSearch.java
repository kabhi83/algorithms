/**
 * 
 */
package home.ak.algo.backtrack;

/**
 * @author kundu
 *
 */
public class WordSearch {

	public static boolean search(char[][] grid, String word) {
		// base case check
		if (null == grid || null == word || word.length() == 0) {
			return false;
		}

		char[] wordArr = word.toCharArray();
		int[][] visited = new int[grid.length][grid[0].length];

		boolean found = false;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (dfs(grid, visited, i, j, wordArr, 0, word.length())) {
					found = true;
					return found;
				}
			}
		}

		return false;

	}

	public static boolean dfs(char[][] grid, int[][] visited, int i, int j, char[] wordArr, int idx, int n) {
		// Boundary check
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j] != 0
				|| grid[i][j] != wordArr[idx]) {
			return false;
		}

		if (idx == n - 1) {
			return true;
		}

		// Mark as visited
		visited[i][j] = 1;

		// All the directions possible to move
		int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

		// check for all direction
		for (int[] direction : directions) {
			if (dfs(grid, visited, i + direction[0], j + direction[1], wordArr, idx + 1, n)) {
				return true;
			}
		}
		//Backtrack
		visited[i][j] = 0;
		return false;
	}

	public static void main(String[] args) {
		char[][] grid = { { 'd', 'e', 'e', 'd', 'l' }, { 'a', 'q', 'd', 'a', 'w' }, { 'v', 't', 'e', 'b', 'w' } };
		String word = "z";
		System.out.println(search(grid, word));
	}

}
