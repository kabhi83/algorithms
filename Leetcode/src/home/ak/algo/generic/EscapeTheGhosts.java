/**
 * 
 */
package home.ak.algo.generic;

/**
 * @author kundu
 * 
 *         You are playing a simplified PAC-MAN game on an infinite 2-D grid.
 *         You start at the point [0, 0], and you are given a destination point
 *         target = [xtarget, ytarget] that you are trying to get to. There are
 *         several ghosts on the map with their starting positions given as a 2D
 *         array ghosts, where ghosts[i] = [xi, yi] represents the starting
 *         position of the ith ghost. All inputs are integral coordinates.
 * 
 *         Each turn, you and all the ghosts may independently choose to either
 *         move 1 unit in any of the four cardinal directions: north, east,
 *         south, or west, or stay still. All actions happen simultaneously.
 * 
 *         You escape if and only if you can reach the target before any ghost
 *         reaches you. If you reach any square (including the target) at the
 *         same time as a ghost, it does not count as an escape.
 * 
 *         Return true if it is possible to escape regardless of how the ghosts
 *         move, otherwise return false.
 *
 */
public class EscapeTheGhosts {

	/**
	 * This problem can be solved with Manhattan Distance solution where we have to
	 * detect distance between the starting point of the player to the target and
	 * also the distance of any ghost from to the target. If any ghost can reach the
	 * target before the player, then the the player cannot reach the target.
	 */
	public static boolean escapeGhosts(int[][] ghosts, int[] target) {

		// First compute the distance of the player to the target
		int distance = Math.abs(target[0]) + Math.abs(target[1]);

		// Compute the distance of the ghosts from the target
		for (int[] ghost : ghosts) {
			int ghostDist = Math.abs(ghost[0] - target[0]) + Math.abs(ghost[1] - target[1]);
			// Validate
			if (ghostDist < distance) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[][] ghosts = { { 5, 0 }, { -10, -2 }, { 0, -5 }, { -2, -2 }, { -7, 1 } };
		int[] target = { 7, 7 };
		System.out.println(escapeGhosts(ghosts, target));

		ghosts = new int[][] { { -1, 0 }, { 0, 1 }, { -1, 0 }, { 0, 1 }, { -1, 0 } };
		target = new int[] { 0, 0 };
		System.out.println(escapeGhosts(ghosts, target));
	}

}
