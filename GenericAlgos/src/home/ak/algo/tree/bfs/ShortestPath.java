/**
 * 
 */
package home.ak.algo.tree.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author kundu
 * 
 *         Given a 2D array with values as ‘1’ and ‘0’, find the shortest
 *         distance from top left to bottom right avoiding all the obstacles.
 *
 */
public class ShortestPath {

	static class Node {
		int x, y;
		int distanceFromSource;

		Node(int x, int y, int dis) {
			this.x = x;
			this.y = y;
			this.distanceFromSource = dis;
		}
	}

	public static int shortestPath(int[][] matrix) {
		int m = matrix.length, n = matrix[0].length;
		// Visited array
		boolean[][] visited = new boolean[m][n];
		int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(0, 0, 0));
		visited[0][0] = true;
		while (!queue.isEmpty()) {
			Node curr = queue.poll();
			if (curr.x == m - 1 && curr.y == n - 1) {
				return curr.distanceFromSource;
			}
			for (int[] dir : directions) {
				int x = curr.x + dir[0];
				int y = curr.y + dir[1];
				if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y] && matrix[x][y] == 1) {
					visited[x][y] = true;
					queue.offer(new Node(x, y, curr.distanceFromSource + 1));
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int matrix[][] = { { 1, 1, 1, 0, 1 }, { 0, 0, 1, 1, 1 }, { 1, 1, 1, 0, 1 }, { 0, 0, 1, 1, 1 } };
		System.out.println(shortestPath(matrix));
	}

}
