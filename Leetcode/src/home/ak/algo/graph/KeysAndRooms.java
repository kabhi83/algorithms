/**
 * 
 */
package home.ak.algo.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * @author kundu
 * 
 *         There are N rooms and you start in room 0. Each room has a distinct
 *         number in 0, 1, 2, ..., N-1, and each room may have some keys to
 *         access the next room.
 * 
 *         Formally, each room i has a list of keys rooms[i], and each key
 *         rooms[i][j] is an integer in [0, 1, ..., N-1] where N = rooms.length.
 *         A key rooms[i][j] = v opens the room with number v.
 * 
 *         Initially, all the rooms start locked (except for room 0).
 * 
 *         You can walk back and forth between rooms freely.
 * 
 *         Return true if and only if you can enter every room.
 * 
 *         Example 1: Input: [[1],[2],[3],[]] Output: true Explanation: We start
 *         in room 0, and pick up key 1. We then go to room 1, and pick up key
 *         2. We then go to room 2, and pick up key 3. We then go to room 3.
 *         Since we were able to go to every room, we return true.
 * 
 *         Example 2: Input: [[1,3],[3,0,1],[2],[0]] Output: false Explanation:
 *         We can't enter the room with number 2.
 */
public class KeysAndRooms {

	/**
	 * We will be using dfs to solve this problem
	 */
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {

		// Initialize a set to keep the track of visited rooms
		Set<Integer> visited = new HashSet<>();
		// Since starting from 0, mark it visited
		visited.add(0);

		Stack<Integer> stack = new Stack<>();
		// Add the 1st room to stack to start with
		stack.add(0);
		while (!stack.isEmpty()) {
			int room = stack.pop();
			// get all the keys from the popped room
			List<Integer> keys = rooms.get(room);
			for (Integer key : keys) {
				// mark the rooms which can be visited if not visited, by the keys
				if (!visited.contains(key)) {
					visited.add(key);
					stack.push(key);
				}
			}
		}

		return visited.size() == rooms.size();
	}

	public static void main(String[] args) {
		List<List<Integer>> rooms = new ArrayList<>();
		List<Integer> room0 = Arrays.asList(1, 3);
		List<Integer> room1 = Arrays.asList(3, 0, 1);
		List<Integer> room2 = Arrays.asList(2);
		List<Integer> room3 = Arrays.asList(0);
		rooms.add(room0);
		rooms.add(room1);
		rooms.add(room2);
		rooms.add(room3);

		boolean result = new KeysAndRooms().canVisitAllRooms(rooms);
		System.out.println(result);

	}

}
