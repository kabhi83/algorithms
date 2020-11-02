/**
 * 
 */
package home.ak.algo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author user
 *
 */
public class MaxValuePath {

	static int[][] arr;
	static int height;
	static int width;
	static int stopIndex;
	static int[][] solution;
	static boolean[][] visited;

	static int[] move_x = { -1, 1, 0, 0 };
	static int[] move_y = { 0, 0, 1, -1 };

	private static boolean isValid(int x, int y) {
		return (x >= 0 && x < height && y >= 0 && y < width && !visited[x][y]);
	}

	public static void dfs(int x, int y, int index, int value) {
		if (isValid(x, y)) {
			// Define the stop condition
			if (index == stopIndex) {
				if (solution[x][y] < value + arr[x][y])
					solution[x][y] = value + arr[x][y];
				return;
			}

			// Continue to check and Mark the cell visited
			visited[x][y] = true;

			// Change only if solution value is less
			if (solution[x][y] < value + arr[x][y])
				solution[x][y] = value + arr[x][y];

			for (int i = 0; i < 4; i++) {
				dfs(x + move_x[i], y + move_y[i], index + 1, value + arr[x][y]);
			}

			// Mark the cell unvisited to track all the path
			visited[x][y] = false;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		height = sc.nextInt();
		width = sc.nextInt();
		stopIndex = sc.nextInt();

		// Initialization
		arr = new int[height][width];
		solution = new int[height][width];
		visited = new boolean[height][width];

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		dfs(0, 0, 0, 0);

		System.out.println(Arrays.deepToString(solution));
		sc.close();
	}
}
