/**
 * 
 */
package home.ak.algo.matrix;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * @author kundu
 * 
 *         Design a Snake game that is played on a device with screen size
 *         height x width. Play the game online if you are not familiar with the
 *         game.
 * 
 *         The snake is initially positioned at the top left corner (0, 0) with
 *         a length of 1 unit.
 * 
 *         You are given an array food where food[i] = (ri, ci) is the row and
 *         column position of a piece of food that the snake can eat. When a
 *         snake eats a piece of food, its length and the game's score both
 *         increase by 1.
 * 
 *         Each piece of food appears one by one on the screen, meaning the
 *         second piece of food will not appear until the snake eats the first
 *         piece of food.
 * 
 *         When a piece of food appears on the screen, it is guaranteed that it
 *         will not appear on a block occupied by the snake.
 * 
 *         The game is over if the snake goes out of bounds (hits a wall) or if
 *         its head occupies a space that its body occupies after moving (i.e. a
 *         snake of length 4 cannot run into itself).
 *
 */
public class SnakeGame {

	private int height;
	private int width;
	private int[][] food;
	private int score;
	private int foodIndex;
	private Deque<Integer> snakeBody = new ArrayDeque<>();
	private Set<Integer> visited = new HashSet<>();

	public SnakeGame(int width, int height, int[][] food) {
		this.width = width;
		this.height = height;
		this.food = food;
		snakeBody.offer(0); // Initial position of the snake is (0,0)
		visited.add(0);
	}

	int move(String direction) {
		int snakeHead = snakeBody.peekFirst();
		int row = snakeHead / width;
		int col = snakeHead % width;
		int newRow = row, newCol = col;
		switch (direction) {
		case "U" -> newRow--;
		case "D" -> newRow++;
		case "L" -> newCol--;
		case "R" -> newCol++;
		}

		// Check the boundary condition
		if (newRow < 0 || newRow >= height || newCol < 0 || newCol >= width) {
			return -1;
		}

		// Check the food condition
		if (foodIndex < food.length && newRow == food[foodIndex][0] && newCol == food[foodIndex][1]) {
			// Snake is going to eat the food
			score++;
			foodIndex++;
		} else {
			// Snake just moves forward
			int tail = snakeBody.pollLast();
			visited.remove(tail);
		}

		// For the both the above cases, the head will be a new position
		int newHead = flatten2DPosition(newRow, newCol);

		// Check if the snake bites itself.
		if (visited.contains(newHead)) {
			return -1;
		}

		snakeBody.offerFirst(newHead);
		visited.add(newHead);

		return score;
	}

	// Converts 2D grid coordinates to a single integer.
	private int flatten2DPosition(int row, int col) {
		return row * width + col;
	}

	// The space complexity of the SnakeGame is O(N + M) where N is the length of
	// the snake and M is the total number of food items.

}
