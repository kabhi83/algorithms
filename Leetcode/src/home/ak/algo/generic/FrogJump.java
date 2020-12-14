/**
 * 
 */
package home.ak.algo.generic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author kundu
 * 
 *         A frog is crossing a river. The river is divided into x units and at
 *         each unit there may or may not exist a stone. The frog can jump on a
 *         stone, but it must not jump into the water.
 * 
 *         Given a list of stones' positions (in units) in sorted ascending
 *         order, determine if the frog is able to cross the river by landing on
 *         the last stone. Initially, the frog is on the first stone and assume
 *         the first jump must be 1 unit.
 * 
 *         If the frog's last jump was k units, then its next jump must be
 *         either k - 1, k, or k + 1 units. Note that the frog can only jump in
 *         the forward direction.
 * 
 *         Example 1: [0,1,3,5,6,8,12,17]
 * 
 *         There are a total of 8 stones. The first stone at the 0th unit,
 *         second stone at the 1st unit, third stone at the 3rd unit, and so
 *         on... The last stone at the 17th unit.
 * 
 *         Return true. The frog can jump to the last stone by jumping 1 unit to
 *         the 2nd stone, then 2 units to the 3rd stone, then 2 units to the 4th
 *         stone, then 3 units to the 6th stone, 4 units to the 7th stone, and 5
 *         units to the 8th stone.
 *
 */
public class FrogJump {

	public boolean canCross(int[] stones) {

		// Create a map of all the stones and the set of jump positions to arrive at
		// that stone
		Map<Integer, HashSet<Integer>> map = new HashMap<>();
		for (int stone : stones) {
			map.put(stone, new HashSet<Integer>());
		}
		// Base case
		map.get(stones[0]).add(0);
		map.get(stones[1]).add(1);

		int lastPosition = stones[stones.length - 1];

		for (int i = 1; i < stones.length; i++) {
			// retrieve the set to find the next jump positions
			int stone = stones[i];
			for (int jump : map.get(stone)) {
				for (int j = jump - 1; j <= jump + 1; j++) {
					if (j <= 0) { // Only applicable for jump of 1 length
						continue; // 0 -> jumping in same position and -1 going back not allowed
					}
					int nextPosition = stone + j;
					if (nextPosition == lastPosition) {
						return true;
					} else if (map.containsKey(nextPosition)) {
						map.get(nextPosition).add(j);
					}
				}
			}
		}

		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// int[] stones = { 0, 1, 3, 5, 6, 8, 12, 17 };
		int[] stones = { 0, 1, 2, 3, 4, 8, 9, 11 };
		FrogJump frog = new FrogJump();
		boolean result = frog.canCross(stones);
		System.out.println(result);
	}

}
