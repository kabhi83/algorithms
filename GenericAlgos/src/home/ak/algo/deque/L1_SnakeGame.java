/**
 * 
 */
package home.ak.algo.deque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * @author kundu
 * 
 *         Design a Snake game that is played on a device with screen size =
 *         width x height. Play the game online if you are not familiar with the
 *         game.
 * 
 *         The snake is initially positioned at the top left corner (0,0) with
 *         length = 1 unit.
 * 
 *         You are given a list of food's positions in row-column order. When a
 *         snake eats the food, its length and the game's score both increase by
 *         1.
 * 
 *         Each food appears one by one on the screen. For example, the second
 *         food will not appear until the first food was eaten by the snake.
 * 
 *         When a food does appear on the screen, it is guaranteed that it will
 *         not appear on a block occupied by the snake.
 *
 */
public class L1_SnakeGame {

	int width;
	int height;
	int[][] food;
	int foodIdx;
	int score;
	Deque<Integer> snake = new ArrayDeque<>();
	Set<Integer> visited = new HashSet<>();

	public L1_SnakeGame(int width, int height, int[][] food) {
		this.width = width;
		this.height = height;
		this.food = food;
		this.score = 0;
		// Add the snake in the top left corner (0,0)
		snake.offer(0);
		visited.add(0);
	}

	public int move(String direction) {
		int head = snake.peekFirst();
		int row = head / width;
		int col = head % width;
		int newRow = row;
		int newCol = col;

		// Update the direction
		switch (direction) {
		case "U" -> newRow--;
		case "D" -> newRow++;
		case "L" -> newCol--;
		case "R" -> newCol++;
		}

		if (newRow < 0 || newRow >= height || newCol < 0 || newCol >= width) {
			return -1;
		}

		// Check the food condition
		if (foodIdx < food.length && newRow == food[foodIdx][0] && newCol == food[foodIdx][1]) {
			// Encountered a food
			score++;
			foodIdx++;
		} else {
			// Snake need to move forward
			int tail = snake.pollLast();
			visited.remove(tail);
		}

		// For the both the above cases, the head will be a new position
		int newHead = flatten2DPosition(newRow, newCol);

		if (visited.contains(newHead)) {
			// Snake collided with itself
			return -1;
		}

		// Successful case
		snake.offerFirst(newHead);
		visited.add(newHead);

		return score;

	}

	public int flatten2DPosition(int row, int col) {
		return row * width + col;
	}

	// The space complexity of the SnakeGame is O(N + M) where N is the length of
	// the snake and M is the total number of food items.
}
